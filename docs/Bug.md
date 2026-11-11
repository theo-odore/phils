# Bug Record: Key Thinkers Vertical Text Wrap & Void Space in Quick Overview

## Bug Summary
In the **Quick Overview** reading tab of [`DetailScreen.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt), when a discovery had 3 or more key thinkers (e.g. *Existentialism* with Jean-Paul Sartre, Simone de Beauvoir, and Soren Kierkegaard), a massive empty dark space appeared between the *Key Thinkers* chips and *In Everyday Practice*, accompanied by a tall, narrow vertical pill bar along the right edge of the screen.

## Root Cause
1. **Unwrapped `Row` Constraint**: The key thinker chips were rendered inside a standard `Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth())`.
2. **Horizontal Overflow & Vertical Character Wrap**:
   - Chip 1 (`"Jean-Paul Sartre →"`) took ~160dp.
   - Chip 2 (`"Simone de Beauvoir →"`) took ~180dp.
   - The total width of the first two chips exceeded ~340dp, leaving only ~15–20dp of remaining horizontal width on a standard 360–390dp phone screen (with 20dp edge padding).
   - Chip 3 (`"Soren Kierkegaard →"`) was forced into this narrow sliver. Because Compose's `Text` defaults to `softWrap = true`, each character wrapped onto a new line (`S \n o \n r \n e \n n ...`).
   - With 19 characters wrapping vertically, Chip 3 expanded to ~450px tall!
3. **Row Expansion & Empty Space**: In Jetpack Compose, a `Row` expands to match the height of its tallest child. The `Row` stretched to 450px, placing the first two chips at the top and leaving the rest of the 450px area as a huge blank void, with the third chip appearing as a narrow, tall vertical bar on the right.

## Resolution
1. **Replaced `Row` with `FlowRow`**:
   - Migrated the key thinker chips in [`DetailScreen.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt#L398-L435) to `@OptIn(ExperimentalLayoutApi::class) FlowRow(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalArrangement = Arrangement.spacedBy(10.dp))`.
   - Updated both `QuickOverviewContent` and the fallback in `DeepDiveContent`.
2. **Guarded Chip Text Wrap**:
   - Added `maxLines = 1, softWrap = false` to the chip `Text` composable, ensuring that chip names never break or wrap vertically under any width constraint.
3. **Natural Multi-Line Flow**:
   - Any thinkers that do not fit on the first line now gracefully wrap to line 2 with standard 10.dp vertical spacing, eliminating the vertical void entirely.

## Verification
- Unit test suite passed: `./gradlew testDebugUnitTest` (22/22 unit tests passing).
- APK assembled cleanly: `./gradlew assembleDebug`.
- Deployed and installed on device `RZCX60GHR8A` (`adb install -r --user 0`).

---

# Bug Record: Feed Capped at 10 Cards & Missing Deep-Dive Option Across Corpus

## Bug Summary
1. Users reported being able to swipe through only a small initial set of 10 cards before the card stack prematurely looped or stopped providing fresh discoveries, despite 31 rich discoveries existing in the corpus.
2. In the card detail view, the `[ Quick Overview | Deep Dive ]` depth selector and rich deep-dive sections were missing on 29 out of the 31 cards, appearing only on Stoicism and Existentialism.

## Root Causes
1. **Feed Pagination & Local Deduplication Deadlock**:
   - `PhilsApiService.kt` and `MainScreen.kt` defaulted query requests to `limit = 10` (or `limit = 6`) without passing an initial pagination cursor.
   - `server/src/db/store.ts` returned the same initial 10 cards on uncursored requests.
   - `DiscoveryRepository.kt` deduplicated incoming items against `_dynamicDiscoveries.value`. Since all 10 incoming cards were already present in the local deck, 0 new cards were appended, locking the stack permanently at 10.
   - Server updates had not been rebuilt and deployed inside Docker on the host.
2. **Conditional Gating on Incomplete Hand-Crafted JSON**:
   - Only Stoicism and Existentialism had hardcoded `section_what_is_this`, `section_origin_context`, etc., in `discoveriesData.ts`.
   - `DetailScreen.kt` wrapped the reading depth selector inside `if (hasRichContent)`, where `hasRichContent = detail.richWhatIsThis != null || detail.corePrinciplesRich.isNotEmpty()`.
   - The remaining 29 cards had null rich section fields, causing `hasRichContent` to evaluate to `false` and hiding the entire deep-dive navigation and presentation layers.

## Resolutions
1. **Server Feed Cursor Rotation & Higher Default Limit**:
   - Updated `server/src/index.ts` default limit to 50.
   - Updated `server/src/db/store.ts` `getFeed` to calculate pagination offsets by finding the cursor index and returning a contiguous slice through the remaining corpus (`feedSlice = [...fullFeed.slice(idx + 1), ...fullFeed.slice(0, idx + 1)]`).
   - Synced `server/src` to `homeserver:/mnt/data/projects/phils/server/src` and ran `docker compose up -d --build phils-api`.
2. **Client-Side Synthesis & Bundled Corpus Asset**:
   - Generated `android/app/src/main/assets/default_discoveries.json` containing all 31 curated discoveries, avoiding JVM 65KB string constant bytecode limits while ensuring instantaneous cold-start offline seeding via `DefaultDiscoveries.load(context)`.
   - Upgraded `ServerDiscoveryDto.toDomain()` in `NetworkModels.kt` to synthesize rich deep-dive sections (`richWhatIsThis`, `richOriginContext`, `corePrinciplesRich`, `keyThinkersRich`, `everydayLifeRich`, `criticalPerspectives`, `connectedIdeasRich`, `readingDepth`) from raw discovery attributes whenever dedicated `section_*` fields are omitted.
   - Removed `if (hasRichContent)` gating in `DetailScreen.kt`, making the `[ Quick Overview | Deep Dive ]` selector and deep dive view unconditionally available on all cards.

## Verification
- Unit test suite: `./gradlew testDebugUnitTest` passed (22/22 tests passing).
- Device verification on `RZCX60GHR8A`:
  - Verified Logcat: `Merged 21 missing bundled discoveries into deck (total: 31)`.
  - Tested cards (Absurdism, Taoism, Stoicism): UI hierarchy and live screencaps confirmed `[ Quick Overview | Deep Dive ]` rendered with full multi-section content and clean chip wrapping.

---

# Bug Record: Fixed Initial Card (Stoicism) on App Launch

## Bug Summary
Every time the application was launched, the discovery card stack deterministically opened to the exact same card (*Stoicism*), eliminating curiosity and serendipity for returning users.

## Root Cause
1. In `default_discoveries.json` and `curatedDiscoveries`, *Stoicism* was placed at array index 0.
2. In `DiscoveryRepository.kt`, both DataStore cache hydration and default asset seeding populated `_dynamicDiscoveries.value` without shuffling.
3. In `RecommendationEngine.generateFeed()`, candidates in the `unseen` pool were iterated in static array index order without randomizing tied scores, making *Stoicism* the deterministic first pick.
4. `MainScreen.kt` defaulted `currentDiscoverIndex` to 0, which always resolved to index 0 (*Stoicism*).

## Resolution
1. **Client Startup Randomization**:
   - In [`DiscoveryRepository.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/data/DiscoveryRepository.kt), applied `.shuffled()` when loading cached discoveries from DataStore and when seeding from bundled assets on app startup.
   - Added `shuffleDeck()` to re-randomize the in-memory deck dynamically.
2. **Server Serendipity Optimization**:
   - In [`RecommendationEngine.ts`](file:///D:/projects/phils/server/src/services/recommendationEngine.ts), randomized the unseen discovery pool and randomly sampled among highest-scoring candidates across alternating categories, preserving anti-repetition while eliminating deterministic starting cards.
3. **Verification**:
   - Unit tests: 23/23 tests passing (`ApiFirstArchitectureTest.kt`).
   - Device testing: Performed multiple cold starts on `RZCX60GHR8A` via `am force-stop` and verified fresh random openers (*Utilitarianism*, *Hedonic Adaptation*).
