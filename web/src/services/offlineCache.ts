import { Discovery, UserProfile } from '../types';
import { fallbackDiscoveries } from '../data/discoveries';

const CACHE_KEY_DISCOVERIES = 'phils_cached_discoveries';
const CACHE_KEY_SAVED = 'phils_cached_saved_ids';
const CACHE_KEY_VIEWS = 'phils_cached_view_history';

export class OfflineCache {
  public static init() {
    const existing = this.getDiscoveries();
    if (existing.length === 0) {
      this.saveDiscoveries(fallbackDiscoveries);
    }
  }

  public static getDiscoveries(): Discovery[] {
    try {
      const raw = localStorage.getItem(CACHE_KEY_DISCOVERIES);
      return raw ? JSON.parse(raw) : [];
    } catch {
      return fallbackDiscoveries;
    }
  }

  public static saveDiscoveries(items: Discovery[]) {
    try {
      const current = this.getDiscoveries();
      const map = new Map<string, Discovery>(current.map(d => [d.id, d]));
      for (const item of items) {
        map.set(item.id, item);
      }
      localStorage.setItem(CACHE_KEY_DISCOVERIES, JSON.stringify(Array.from(map.values())));
    } catch (e) {
      console.warn('LocalStorage error caching discoveries:', e);
    }
  }

  public static getSavedIds(): Set<string> {
    try {
      const raw = localStorage.getItem(CACHE_KEY_SAVED);
      return raw ? new Set(JSON.parse(raw)) : new Set();
    } catch {
      return new Set();
    }
  }

  public static toggleSaved(discoveryId: string): boolean {
    const saved = this.getSavedIds();
    const isSaved = saved.has(discoveryId);
    if (isSaved) {
      saved.delete(discoveryId);
    } else {
      saved.add(discoveryId);
    }
    localStorage.setItem(CACHE_KEY_SAVED, JSON.stringify(Array.from(saved)));
    return !isSaved;
  }

  public static isSaved(discoveryId: string): boolean {
    return this.getSavedIds().has(discoveryId);
  }

  public static recordView(discoveryId: string) {
    try {
      const raw = localStorage.getItem(CACHE_KEY_VIEWS);
      const views: Array<{ discovery_id: string; viewed_at: string }> = raw ? JSON.parse(raw) : [];
      views.push({
        discovery_id: discoveryId,
        viewed_at: new Date().toISOString(),
      });
      localStorage.setItem(CACHE_KEY_VIEWS, JSON.stringify(views));
    } catch (e) {
      console.warn('LocalStorage error recording view:', e);
    }
  }

  public static getProfile(): UserProfile {
    const discoveries = this.getDiscoveries();
    const savedIds = this.getSavedIds();
    let views: Array<{ discovery_id: string; viewed_at: string }> = [];
    try {
      const raw = localStorage.getItem(CACHE_KEY_VIEWS);
      if (raw) views = JSON.parse(raw);
    } catch {
      views = [];
    }

    const uniqueViewedIds = new Set(views.map(v => v.discovery_id));
    const discoveryMap = new Map(discoveries.map(d => [d.id, d]));

    let philosophiesCount = 0;
    for (const id of uniqueViewedIds) {
      const d = discoveryMap.get(id);
      if (d && (d.type === 'philosophy' || d.type === 'philosopher')) {
        philosophiesCount++;
      }
    }

    const recentHistory = views
      .slice(-15)
      .reverse()
      .map(v => {
        const d = discoveryMap.get(v.discovery_id);
        return {
          discovery_id: v.discovery_id,
          title: d?.title || 'Unknown Idea',
          type: d?.type || 'concept',
          viewed_at: v.viewed_at,
        };
      });

    return {
      user_id: 'default_user',
      ideas_discovered_count: uniqueViewedIds.size,
      philosophies_explored_count: philosophiesCount,
      saved_count: savedIds.size,
      recent_history: recentHistory,
    };
  }
}
