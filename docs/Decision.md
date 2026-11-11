# Architectural Decision Records (ADRs)

## ADR 1: Progressive Reading Progression (Quick Overview vs Deep Dive)

### Context
Users open cards from a fast-paced vertical card stack. Pushing a 1,500+ word monolithic article without progression risks cognitive fatigue, while providing only a 15-second snippet fails to satisfy genuine intellectual curiosity.

### Decision
Implement a dual-tier progressive reading model in [`DetailScreen.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt):
1. **Level 2 (Quick Overview)**: ~200-word synthesis containing the central dilemma, core claim, introductory example, key thinkers, and 1 practical scenario.
2. **Level 3/4 (Deep Dive)**: Multi-thousand-word deep exposition with structured principles, counter-cases, critical dialectics, full thinker biographies, and step-by-step decision frameworks.
3. Provide an intuitive toggle `[ Quick Overview | Deep Dive ]` allowing users to choose their level of reading commitment instantly.

### Consequences
* Eliminates wall-of-text fatigue.
* Allows casual scrollers to digest the core insight in under 2 minutes while satisfying deep thinkers seeking a rich 6-8 minute study session.

---

## ADR 2: Non-Destructive, Backward-Compatible DTO Extension

### Context
The application is pre-seeded with dozens of classical discoveries, and new cards may be synced over time. Modifying the data contract must not break existing cards or require a destructive database reset.

### Decision
Extend [`Discovery`](file:///D:/projects/phils/server/src/types.ts) and [`DiscoveryDetail`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/model/Discovery.kt) by keeping all existing string fields (`whatIsThis`, `origin`, `coreIdeas`, `example`, `quote`) intact and adding optional rich objects (`richWhatIsThis`, `richOriginContext`, `corePrinciplesRich`, `keyThinkersRich`, `everydayLifeRich`, `criticalPerspectives`, `connectedIdeasRich`).

### Consequences
* Existing simpler cards render without error using graceful UI fallbacks.
* Enhanced cards immediately display full rich depth across Android and the SSR web reader.

---

## ADR 3: Self-Hosted Docker Deployment on Homeserver (Port 3010)

### Context
The user requested navigating to `homeserver` `/projects` (accessible via Windows network share `F:\projects`) and running the containerized backend. Port 3000 on `homeserver` is already occupied by the `dashboard` container.

### Decision
Configure `F:\projects\phils\docker-compose.yml` to bind port `3010:3000` on the host, build via multi-stage Alpine Dockerfile, and launch the service as a self-healing daemon (`restart: unless-stopped`).

### Consequences
* No port collision with existing homeserver containers.
* The API and SSR web reader are fully operational and reachable across the local/Tailscale network at `http://homeserver:3010` and `http://localhost:3010`.


---

## ADR 4: Standalone PWA Web Client (`web/`) with APK Parity & Offline Support

### Context
Users requested a Progressive Web App (PWA) in a new sub-directory `web/` replicating the exact UI, 3D card gesture physics, editorial typography, and progressive reading experience of the Android APK.

### Decision
1. Scaffold a standalone React + Vite + TypeScript PWA inside `web/` with `@tailwindcss/vite` and `vite-plugin-pwa`.
2. Port the 3D card physics (`CardStack.tsx`) using Pointer/Touch events and 3D CSS transforms (`translate3d`, `rotate`, `scale`) that mirror Android Compose's `graphicsLayer` interpolation.
3. Pre-seed the PWA with the complete rich corpus (`SeedDiscoveries`) so it functions 100% offline via Workbox service worker caching without requiring a backend connection.
4. Support installability (`manifest.webmanifest`, `pwa-192x192.png`, `pwa-512x512.png`), responsive desktop mobile frame, hash routing deep links (`#discovery/:id`), and localStorage persistence for shelf and history.

### Consequences
* Users on iOS, desktop browsers, or Android without sideloading APKs can install and use Phils with full visual and interaction fidelity.
* The PWA is completely self-contained and buildable independently via `npm --prefix web run build`.

---

## ADR 5: Decoupled Product Showcase Website (`website/`) vs PWA App (`web/`)

### Context
Following the PWA implementation, the user requested an editorial product showcase website using `/impeccable` (Mode: Persuade). Placing this landing page inside `web/index.html` would overwrite the Vite PWA application entry point (which mounts `<div id="root"></div>`, module scripts, and service worker registration), breaking the app's client-side router and mobile shell.

### Decision
1. Decouple the product showcase marketing website into a dedicated directory: [`website/index.html`](file:///D:/projects/phils/website/index.html).
2. Author the site with zero runtime dependencies (vanilla modern HTML5, CSS custom properties, and lightweight vanilla JavaScript) so it requires no compilation and loads with zero millisecond hydration overhead.
3. Mirror the file into [`web/public/landing.html`](file:///D:/projects/phils/web/public/landing.html) so Vite's dev and preview servers can serve the marketing landing page alongside the PWA.
4. Wire mutual cross-links: the showcase website features a prominent "Launch App" CTA linking to the PWA (`http://localhost:5173`), while the PWA can route or link users back to the product story.
5. Provide dedicated automation scripts in root `package.json`: `"website:dev"` (spins up a static server on port 4000) and `"website:open"` (opens the site directly in the default browser).

### Consequences
* **Preserved PWA Integrity**: The Vite PWA remains clean and uncorrupted, continuing to pass all builds (`npm run web:build`).
* **Zero Overhead**: The marketing site has no heavy React/node dependencies to run or deploy; it can be hosted on GitHub Pages, Cloudflare Pages, S3/CloudFront, or served locally with zero build step.
* **Dual Serving**: The site can be accessed independently via port 4000 or through the PWA server at `/landing.html`.

---

## ADR 6: Transition to API-First Architecture with Dynamic Caching (Option A)

### Context
Previously, the Android APK bundled ~150 KB of hardcoded Kotlin objects (`SeedData.kt`) containing 62 static discoveries. This prevented dynamic discovery updates, server-driven recommendation refreshes, or editorial fixes without building and distributing a brand new APK.

### Decision
1. Eliminate hardcoded `SeedData.kt` entirely from the Android client.
2. Establish the self-hosted Express API (`/api/v1/feed`) as the primary source of truth.
3. Retain an **Ever-Growing Local Dynamic Cache** in Android DataStore (`dynamic_discoveries_json`):
   - On app launch, instantly load cached discoveries from DataStore into memory.
   - Concurrently fetch new discoveries from the API and append new unique items.
   - If the network fails or is offline, continue running on the locally cached discoveries.
   - If the cache is completely empty and the server is unreachable, show an editorial Error Card with a retry mechanism instead of crashing or showing an empty screen.
4. Decouple UI components (`SearchScreen`, `DetailScreen`, `WhySheet`) from static data maps using dependency injection and lambdas (`lookupDiscovery`, `getWhyReasonFor`).

### Consequences
* **Smaller Binary Size**: APK no longer carries 150 KB of redundant compiled static data structures.
* **Instant Content Updates**: Editorial teams and NVIDIA NIM generation can update or introduce new theories on the server without client app updates.
* **Network Resilience**: Cached discoveries remain locally accessible, preventing UI lockups on flaky connections.

---

## ADR 7: Cellular Access via Cloudflare Tunnel & Dynamic Host Failover

### Context
When mobile devices disconnect from the home Wi-Fi and switch to cellular data (4G/5G), private LAN IP addresses (`192.168.0.x`) are unroutable across public telecommunication carriers. The user required full mobile access on cellular networks without being restricted to home Wi-Fi or forced to run third-party VPN apps.

### Decision
1. Deploy a companion `cloudflared` container (`phils-tunnel`) alongside `phils-api` on `homeserver` (`/mnt/data/projects/phils/docker-compose.yml`), establishing a secure outbound-only TLS tunnel to Cloudflare Edge.
2. Upgrade Android `NetworkClient.kt` to support dynamic multi-endpoint resolution across protocols (`https://` and `http://`):
   - Priority 1: Cloudflare Tunnel Public HTTPS (`https://advice-parliamentary-revenues-cloth.trycloudflare.com/`) for global zero-config cellular access.
   - Priority 2: Local Wi-Fi LAN (`http://192.168.0.106:3010/`) for ultra-low latency home network access.
   - Priority 3: Tailscale Mesh VPN (`http://100.108.115.4:3010/`).
   - Priority 4: Android Emulator loopback (`http://10.0.2.2:3010/`).
3. Handle failover transparently via `ResilientHostInterceptor` in OkHttp, automatically latching onto the working endpoint.

### Consequences
* The app works smoothly on 4G/5G cellular data with zero manual configuration on the phone.
* No open inbound ports or port forwarding required on the home router.
* Preserves high-speed local LAN connectivity when back on home Wi-Fi.


---

## ADR 7: Pruning Dead Code, Speculative Synthesizers, and Redundant DTOs (Ponytail)

### Context
An audit for over-engineering revealed a 376-line NVIDIA NIM synthetic LLM generator and uncalled endpoints never invoked by client apps, along with 10 duplicate DTO classes and a 140-line manual mapper reproducing domain models.

### Decision
1. Delete 
vidiaNimGenerator.ts and remove /api/v1/feed/generate from Express.
2. Share domain models directly in Retrofit DTOs using Moshi @Json(name = ...) annotations and default field initializers.
3. Replace stateful multi-threaded failover in NetworkClient.kt with a lean, stateless OkHttp interceptor.

### Consequences
* Reduced repository size by over 620 net lines.
* Eliminated double-maintenance of parallel data classes.
* Guaranteed backward-compatible cache deserialization without JsonDataException.

---

## ADR 8: Universal Deep-Dive Synthesis & Full Corpus Pagination

### Context
1. Feed pagination previously locked after 10 discoveries because client requests omitted cursors while requesting small limits (`limit = 10`), causing the server to return identical elements that local deduplication discarded.
2. In the detail screen, deep-dive exploration was arbitrarily hidden for 29 out of 31 cards because rich sections (`section_*`) existed only for 2 hardcoded items in the server database.

### Decision
1. **Server Feed Cursor Rotation**: Upgrade `store.ts` `getFeed` to locate the cursor in the corpus and return a rotated forward slice, and elevate default API limits to 50 discoveries.
2. **Deterministic Domain Synthesizer**: Enhance `ServerDiscoveryDto.toDomain()` in `NetworkModels.kt` to synthesize rich deep-dive sections from raw discovery attributes (`whatIsThis`, `origin`, `coreIdeas`, `keyPeople`, `example`, `quote`, `related`) whenever raw `section_*` payloads are null.
3. **Bundled Asset Seeding**: Ship all 31 curated discoveries inside `assets/default_discoveries.json` loaded at startup via `DefaultDiscoveries.load(context)`, ensuring zero-network cold-start resilience without tripping JVM 65,535-byte constant pool limits.
4. **Unconditional Depth Selector**: Remove `hasRichContent` gating in `DetailScreen.kt` so every philosophical discovery in the library offers both a fast 2-minute overview and a 6-minute deep dive.

### Consequences
* All 31 discoveries are immediately available in the card deck offline and online.
* Every discovery provides consistent, rich, multi-tiered reading depth.
* Zero regressions in offline caching, local DataStore persistence, or unit test performance.
