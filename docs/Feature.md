# Feature: Deep Intellectual Reading Experience & Multi-Level Detail Architecture

## 1. Scope of Implementation
* **Domain & Schema**: Extended both TypeScript server types and Kotlin Android domain models to support rich structured subsections across the six canonical sections:
  1. What Is This? (Central question, mechanism, introductory example, importance, common misconceptions, reflective questions)
  2. Origin and Context (Historical era & location, motivating crisis, circumstances, earlier traditions, development, contemporary legacy)
  3. Core Principles (Expandable structured principle cards with plain-language explanation, reasoning, concrete example, counter-case / edge-case, and relation to other principles)
  4. Critical Perspectives & Debates (Dialectic balance: What proponents argue vs what critics argue, core objections, and unresolved debates)
  5. Key Thinkers (Biographical cards with contributions, major works, distinct perspectives, and clickable links to jump to related cards)
  6. In Everyday Life (Practical scenarios with step-by-step decision frameworks, common misapplications, and crucial limitations)
  7. Connected Ideas (Relational cards with explicit explanations of *why* ideas are connected)
* **Progressive Reading Progression**: Introduced `[ Quick Overview ]` vs `[ Deep Dive ]` toggle with reading time metadata.
* **Web Reader SSR**: Updated `/d/:id` and `/discovery/:id` to render the rich multi-section layout for shared links in any browser.
* **Homeserver Deployment**: Deployed the backend container to `homeserver` (`/projects/phils`) running on port `3010`.

---

## 2. Verification Results

| Target | Test Performed | Result | Status |
|---|---|---|---|
| **Server TypeScript** | `npm --prefix server run build` (`tsc`) | Clean compile, 0 type errors | ✅ PASS |
| **Android Unit Tests** | `.\gradlew.bat testDebugUnitTest` | 22 actionable tasks, 0 test failures, 0 warnings | ✅ PASS |
| **Android Debug APK** | `.\gradlew.bat assembleDebug` | Debug APK generated (`app-debug.apk`) in 51s | ✅ PASS |
| **Homeserver Container** | `docker compose up -d --build` on `/projects/phils` | Container `phils-api` built and running healthy on port `3010` | ✅ PASS |
| **API Endpoints** | `curl http://localhost:3010/health` & `/api/v1/discoveries/stoicism` | Returned HTTP 200 with complete rich JSON payload | ✅ PASS |
| **SSR Web Reader** | `curl http://localhost:3010/d/stoicism` | Generated responsive HTML with Central Question, Principles & Thinkers | ✅ PASS |


---

---

# Feature: Phils Product Showcase Website (`website/`)

## 1. Scope of Implementation
* **Design Director Craft (Mode: Persuade)**: Built an editorial marketing and showcase website for Phils adhering to `/impeccable` design principles.
* **Componentry & Interactive Sections**:
  1. Sticky navigation with glassmorphism blur, Greek mark (φ), and Sól/Máni dual-theme mode switch.
  2. Hero with asymmetric 3D phone stage simulation, auto-rotating card stack, and interactive touch tilt.
  3. Four key metric pillars (62+ curated discoveries, 10 mood palettes, 120 FPS zero-recomposition, 100% offline).
  4. Core architecture features: Asymmetric physics, dual-depth progressive reader, and native SSR web links.
  5. Interactive chromatic spectrum: 10 mood palette swatches (Cosmic, Ocean, Terracotta, Sage, Stone, Burgundy, Indigo, Rose, Ochre, Lavender) dynamically updating live card previews.
  6. Algorithmic transparency showcase: Dialectic tension (Score 95) telemetry bars explaining the recommendation philosophy.
  7. The Phils Manifesto quote block.
  8. Call to action with platform badges for Android APK, Web PWA, and self-hosted Docker.
* **Packaging & Integration**:
  * Standalone single-file deployment at `website/index.html`.
  * Mirrored into `web/public/landing.html` for direct serving alongside the PWA.
  * Added npm scripts in root `package.json` (`website:dev` and `website:open`).

## 2. Verification Results
| Target | Test Performed | Result | Status |
|---|---|---|---|
| **HTML5 & Scripts** | Node validation harness | All tags, responsive meta, and event listeners intact | ✅ PASS |
| **PWA Integrity** | `npm run web:build` | Built in 304ms, 16 precached assets, 0 errors | ✅ PASS |
| **Theme Toggle** | Sól (Light) / Máni (Dark) toggle | Seamless variable switching and state persistence | ✅ PASS |
| **Palette Swatches** | Clickable swatch event bindings | Dynamically updates preview box and typography colors | ✅ PASS |


---

# Feature: Phils PWA Web Client (`web/`)

## 1. Scope of Implementation Scaffolded Vite + React 19 + TypeScript 5.7 with `@tailwindcss/vite` and `vite-plugin-pwa`.
* **Visual & Interaction Parity with Android APK**:
  * Asymmetric 3D Card Stack (`CardStack.tsx`) with hardware-accelerated pointer/touch gestures, 3-card stack interpolation, and velocity-sensitive dismissal.
  * 10 Dynamic Mood Palettes (`colors.ts`) adapted for both Light (Sól) and Dark (Máni) themes.
  * Progressive Multi-Level Reader (`DetailScreen.tsx`): `[ Quick Overview ]` vs `[ Deep Dive ]` toggle with 7 rich structured sections (What is this, Origin, Expandable Principles, Critical Perspectives, Key Thinkers, Everyday Life, Connected Ideas).
  * Navigation Tabs: Discover, Search, Saved Shelf, and Your Journey with stats and theme toggles.
  * Catalog fold corner (`CatalogCorner.tsx`), Recommendation rationale modal (`WhySheet.tsx`), floating pill `BottomBar.tsx`, and toasts.
* **PWA & Offline-First Resilience**:
  * Workbox service worker precaching application shell and fonts (1,184 KiB precached).
  * Web app manifest (`manifest.webmanifest`) with standalone display mode, orientation, and high-resolution icons (192px and 512px).
  * Custom in-app installation banner (`PwaInstallBanner.tsx`) capturing `beforeinstallprompt`.
* **Corpus & Persistence**:
  * Pre-seeded with 31 rich canonical discoveries in `web/src/data/seedData.ts`.
  * Local persistence via `localStorage` for saved bookmarks, read history, and theme settings.
  * Deep link support via hash routes (`#discovery/:id`).

## 2. Verification Results

| Target | Test Performed | Result | Status |
|---|---|---|---|
| **PWA TypeScript Build** | `npm --prefix web run build` (`tsc -b && vite build`) | Clean compile, 0 type errors, PWA bundle & service worker generated | ✅ PASS |
| **Root Convenience Script** | `npm run web:build` | Built 15 precached entries (1,184 KiB), dist/ ready | ✅ PASS |
---

# Feature: API-First Architecture with Dynamic Caching (Option A)

## 1. Scope of Implementation
* **Removed Static Seed File**: Fully eliminated `SeedData.kt` (~150 KB hardcoded static Kotlin objects), making the backend API the sole authority for discovery content.
* **Dynamic DataStore Caching**:
  * On launch, `DiscoveryRepository` loads persisted discoveries from Android's DataStore (`dynamic_discoveries_json`).
  * Concurrently fetches fresh recommendations from `GET /api/v1/feed` and appends new unique discoveries.
  * Persists accumulated discoveries locally for instant offline availability on subsequent visits.
* **Resilient UI States**:
  * Implemented an editorial Loading Card with spinner and progressive feedback in `DiscoverScreen`.
  * Implemented an Error Card with an offline icon, connection status message, and "Retry Connection" action when the cache is empty and backend is unreachable.
* **Decoupled Components**:
  * Refactored `SearchScreen` with local keyword suggestions and delegated repository queries.
  * Refactored `WhySheet` with `getWhyReasonFor` recommendation reasoning helper.
  * Refactored `DetailScreen` with `onLookupDiscovery` lambda for cross-card resolution.
* **Unit Testing**:
  * Added `ApiFirstArchitectureTest` verifying type reason mappings, Moshi serialization, and dynamic deck search filtering.

## 2. Verification Results

| Target | Test Performed | Result | Status |
|---|---|---|---|
| **Android Unit Tests** | `.\gradlew.bat testDebugUnitTest` | 22 tasks executed, 0 failures (including `ApiFirstArchitectureTest`) | ✅ PASS |
| **Android Debug APK** | `.\gradlew.bat assembleDebug` | Debug APK generated (`app-debug.apk`) cleanly in 17s | ✅ PASS |
| **SeedData Removal** | `Test-Path "SeedData.kt"` | File completely removed (`False`), 0 references in `main` | ✅ PASS |

---

# Feature: Cellular Connectivity via Cloudflare Tunnel & Dynamic Multi-Endpoint Failover

## 1. Scope of Implementation
* **Cloudflare Tunnel Deployment (`phils-tunnel`)**:
  * Deployed `cloudflared` container on `homeserver` (`/mnt/data/projects/phils/docker-compose.yml`) routed directly to `http://phils-api:3000`.
  * Generated public HTTPS tunnel URL: `https://advice-parliamentary-revenues-cloth.trycloudflare.com`.
  * Outbound-only TLS connection requiring zero router port-forwarding or public IP exposure.
* **Android Cross-Protocol Failover (`NetworkClient.kt`)**:
  * Configured `CANDIDATE_URLS` ordered by priority:
    1. Cloudflare Public HTTPS Tunnel
    2. Homeserver Local Wi-Fi (`192.168.0.106:3010`)
    3. Homeserver Tailscale Mesh (`100.108.115.4:3010`)
    4. Emulator Loopback (`10.0.2.2:3010`)
  * Enhanced `ResilientHostInterceptor` to dynamically parse candidates with `toHttpUrl()` and re-target `scheme`, `host`, and `port` on the fly.
  * Added auto-failover on HTTP 502/503/504 gateway errors and socket IOExceptions.
* **Live Physical Device Deployment**:
  * Built updated debug APK and installed onto physical device `RZCX60GHR8A` (User 0).
  * Validated live behavior over cellular data by disabling device Wi-Fi.

## 2. Verification Results

| Target | Test Performed | Result | Status |
|---|---|---|---|
| **Tunnel Public Health** | `Invoke-RestMethod https://...trycloudflare.com/health` | HTTP 200 `{"status":"ok","product":"Phils API","version":"1.0"}` | ✅ PASS |
| **Android Unit Tests** | `.\gradlew.bat testDebugUnitTest` | 22 tasks executed, 0 errors | ✅ PASS |
| **APK Build** | `.\gradlew.bat assembleDebug` | Built in 14s | ✅ PASS |
| **Physical APK Install** | `adb -s RZCX60GHR8A install -r --user 0 ...` | Success | ✅ PASS |
| **Cellular-Only Verification** | Wi-Fi disabled via `svc wifi disable`, launched MainActivity | Logcat confirmed OkHttp `GET ...trycloudflare.com/api/v1/feed?limit=6` returned HTTP 200 in 1551ms | ✅ PASS |
