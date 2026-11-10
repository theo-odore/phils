# Execution Flow & Active Mutation Targets

## Overview
This document details the execution flow path and mutations applied to transform Phils from a brief idea introduction feed into a deep, multi-level intellectual reading platform.

## Active Mutation Targets

### 1. Backend Data Schema & DTO Contracts
* **Target**: [`server/src/types.ts`](file:///D:/projects/phils/server/src/types.ts)
  * **Additions**: Added `RichSectionWhatIsThis`, `RichSectionOriginContext`, `RichCorePrinciple`, `RichKeyThinker`, `RichPracticalScenario`, `RichSectionEverydayLife`, `RichCriticalPerspectives`, `RichConnectedIdea`, and `ReadingDepthMetadata`.
  * **Why**: Establishes typed contracts for progressive reading depth while keeping all new fields optional for 100% backward compatibility.

### 2. Backend Seed Knowledge Base
* **Target**: [`server/src/db/discoveriesData.ts`](file:///D:/projects/phils/server/src/db/discoveriesData.ts)
  * **Additions**: Enriched canonical reference entries (**Stoicism** and **Existentialism**) with deep, multi-section structured articles containing central questions, mechanisms, historical genesis, detailed principles (with reasoning, examples, counter-cases, common misunderstandings), critical dialectic debates (proponents vs critics), multi-step practical scenarios, and relational connected ideas.

### 3. Server-Side Rendered (SSR) Web Reader
* **Target**: [`server/src/services/webReader.ts`](file:///D:/projects/phils/server/src/services/webReader.ts)
  * **Mutations**: Enhanced `renderWebReaderHtml` to render full rich article sections (central questions, historical badges, numbered structured principles, critical debates, thinker cards, and scenario steps) when available, falling back gracefully for legacy cards.

### 4. Android Domain Model
* **Target**: [`android/app/src/main/java/com/phils/app/model/Discovery.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/model/Discovery.kt)
  * **Additions**: Added domain classes `CorePrinciple`, `KeyThinker`, `PracticalScenario`, `CriticalPerspectives`, `ConnectedIdea`, `RichWhatIsThis`, `RichOriginContext`, `RichEverydayLife`, and `ReadingDepth`.
  * **Why**: Allows Jetpack Compose UI to render structured subsections cleanly without parsing raw text strings.

### 5. Android API DTOs & Mapping
* **Target**: [`android/app/src/main/java/com/phils/app/data/api/NetworkModels.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/data/api/NetworkModels.kt)
  * **Additions**: Added Moshi `@JsonClass` DTOs corresponding to the server API and updated `ServerDiscoveryDto.toDomain()` to map the deep structure into the Android domain models.

### 6. Android Seed Data [DEPRECATED & REMOVED]
* **Target**: `android/app/src/main/java/com/phils/app/model/SeedData.kt`
  * **Mutation**: Deleted. Replaced by server-driven feed (`/api/v1/feed`) and dynamic DataStore caching.

### 7. Android Editorial Detail Screen UI
* **Target**: [`android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt)
  * **Mutations**: Completely overhauled the long-form reading UI:
    * Implemented progressive reading selector: `[ Quick Overview ]` vs `[ Deep Dive ]` with reading time estimates.
    * Level 2 **Quick Overview**: Highlights central question, core takeaway, quick thinkers, and 1 practical scenario with a direct CTA to expand into Deep Dive.
    * Level 3/4 **Deep Dive**: Full 6-section breakdown (What Is This?, Origin & Context, Core Principles with expandable edge-case cards, Critical Perspectives & Debates, Key Thinkers with biographies and navigable links, In Everyday Life with step-by-step decision frameworks and limitations, and Connected Ideas with explicit relationship rationale).
    * Backward-compatible fallback: Automatically renders legacy cards seamlessly if rich sections are absent.
    * Decoupled cross-card resolution via `onLookupDiscovery` lambda.

### 8. Android Discovery Repository & UI State Architecture
* **Target**: [`android/app/src/main/java/com/phils/app/data/DiscoveryRepository.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/data/DiscoveryRepository.kt)
  * **Mutations**: Migrated from hybrid seed-deck to API-first dynamic caching. Added `isCacheLoaded` and `errorMessage` StateFlows. Handles cold start cache hydration, background fetching, dynamic deduplication, and persistence.
* **Target**: [`android/app/src/main/java/com/phils/app/ui/feed/DiscoverScreen.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/feed/DiscoverScreen.kt)
  * **Mutations**: Added editorial loading card with progress indicator, error card with retry button, and empty state resilience.
* **Target**: [`android/app/src/main/java/com/phils/app/ui/components/WhySheet.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/components/WhySheet.kt) & [`android/app/src/main/java/com/phils/app/ui/search/SearchScreen.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/ui/search/SearchScreen.kt)
  * **Mutations**: Isolated recommendation reasoning into `getWhyReasonFor(discovery)` and localized search suggestion tokens.

### 8. Self-Hosted Container Deployment
* **Target**: `F:\projects\phils\docker-compose.yml` (`/projects/phils` on `homeserver`)
  * **Mutations**: Deployed `phils-api` to `homeserver` mapping host port `3010:3000` to avoid conflict with existing services. Verified healthy running container.


### 8. PWA Web Subproject (`web/`) [REMOVED]
* **Status**: Deprecated & removed per user request. Directory `web/` deleted, and PWA convenience scripts removed from `package.json`.

### 9. Phils Product Showcase Website
* **Target**: [`website/index.html`](file:///D:/projects/phils/website/index.html)
  * **Additions**: Standalone marketing and showcase landing page designed under `/impeccable` (Persuade mode).
  * **Features**: Dynamic Sól/Máni dual theme toggle, interactive 3D phone stage simulation, 10-palette chromatic spectrum switcher, dialectic recommendation engine score telemetry, and direct links to the Web PWA and GitHub repo.
* **Target**: [`package.json`](file:///D:/projects/phils/package.json)
  * **Additions**: Added `"website:dev"` and `"website:open"` npm scripts.

### 10. Cellular Access & Cloudflare Tunnel Infrastructure
* **Target**: `homeserver:/mnt/data/projects/phils/docker-compose.yml`
  * **Additions**: Added `phils-tunnel` container service (`cloudflare/cloudflared:latest`) running `tunnel --no-autoupdate run --url http://phils-api:3000`. Exposes backend via public outbound-only TLS tunnel: `https://advice-parliamentary-revenues-cloth.trycloudflare.com`.
* **Target**: [`android/app/src/main/java/com/phils/app/data/api/NetworkClient.kt`](file:///D:/projects/phils/android/app/src/main/java/com/phils/app/data/api/NetworkClient.kt)
  * **Mutations**: Upgraded `CANDIDATE_URLS` and `ResilientHostInterceptor` to support cross-protocol URL rewriting (`https://` and `http://`), prioritizing the Cloudflare Tunnel public endpoint for seamless mobile data (4G/5G) operation with automatic fallback to local LAN Wi-Fi, Tailscale, and emulator loopback.
