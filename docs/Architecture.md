# Architecture: Phils Deep Reading Platform

## System Architecture

```mermaid
graph TD
    subgraph Android["📱 Native Android App (Compose)"]
        Feed["DiscoverScreen (3D Card Stack)"]
        NavScaffold["MainScreen Navigation Scaffold"]
        Detail["DetailScreen (Progressive Reader)"]
        QuickView["Level 2: Quick Overview Card"]
        DeepDive["Level 3/4: Full Deep Dive Sections"]
        Repo["DiscoveryRepository"]
        Prefs["PreferencesManager (DataStore)"]
        NetClient["NetworkClient (Retrofit/Moshi)"]
    end

    subgraph Website["🌍 Product Showcase Website (website/)"]
        HeroStage["3D Phone Simulation & Card Deck"]
        ThemeEngine["Sól (Light) / Máni (Dark) Switcher"]
        PaletteGrid["10-Domain Chromatic Spectrum"]
        Telemetry["Dialectic Tension Scoring Breakdown"]
        Distro["Multi-Platform Badges (APK / Docker)"]
    end

    subgraph Backend["🚀 Self-Hosted Backend API"]
        API["Express Server"]
        Store["DataStore"]
        WebReader["SSR Web Reader (/d/:id)"]
        SeedDB["Curated Corpus (discoveriesData.ts)"]
        NIM["NVIDIA NIM Generator"]
    end

    Feed -->|Taps Card / Explore Idea| NavScaffold
    NavScaffold --> Detail
    Detail --> QuickView
    Detail --> DeepDive
    Detail --> Repo
    Repo --> Prefs
    Repo -.->|Fetch & Cache| NetClient
    NetClient --> API
    API --> Store
    Store --> SeedDB
    Store -.-> NIM
    API --> WebReader
```

## Module Boundaries & Contracts

1. **Android Client (`android/`)**:
   - `DetailScreen`: Reactive Compose layout with dual depth modes (`QUICK_READ`, `DEEP_DIVE`).
   - `CardStack`: Zero-recomposition `graphicsLayer` 3D card physics.
   - `DiscoveryRepository`: Manages API-driven discovery fetching, dynamic in-memory state flow, and local DataStore caching with graceful offline error recovery.

2. **Product Showcase Website (`website/`)**:
   - High-craft, zero-dependency static presentation layer built under `/impeccable` (Persuade mode).
   - Features interactive 3D phone stage simulation, chromatic spectrum selector, dialectic telemetry visualizer, and live theme switcher.
   - Standalone deployment at `website/index.html` with cross-links to the GitHub repository and APK release.

3. **Backend Engine (`server/`)**:
   - `DataStore`: Thread-safe in-memory store delivering enriched discoveries with scored semantic search.
   - `WebReader`: SSR HTML generator with Open Graph cards and responsive typography.
