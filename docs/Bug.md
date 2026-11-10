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
