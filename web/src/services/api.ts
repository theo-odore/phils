import { Discovery, UserProfile } from '../types';
import { OfflineCache } from './offlineCache';

const API_BASE = '/api/v1';

export class ApiClient {
  public static isOnline: boolean = true;

  public static async getFeed(limit: number = 15): Promise<Discovery[]> {
    try {
      const res = await fetch(`${API_BASE}/feed?limit=${limit}`);
      if (!res.ok) throw new Error(`HTTP ${res.status}`);
      const json = await res.json();
      if (json.success && Array.isArray(json.data.discoveries)) {
        this.isOnline = true;
        OfflineCache.saveDiscoveries(json.data.discoveries);
        return json.data.discoveries;
      }
    } catch (err) {
      console.warn('[ApiClient] Backend unreachable, serving from offline cache:', err);
      this.isOnline = false;
    }

    // Offline fallback
    const cached = OfflineCache.getDiscoveries();
    const saved = OfflineCache.getSavedIds();
    return cached.map(d => ({
      ...d,
      saved: saved.has(d.id),
      why_reason: d.why_reason || `Recommended for discovery diversity in ${d.type}.`,
    }));
  }

  public static async getDiscovery(id: string): Promise<Discovery | null> {
    try {
      const res = await fetch(`${API_BASE}/discoveries/${id}`);
      if (res.ok) {
        const json = await res.json();
        if (json.success) return json.data;
      }
    } catch {
      this.isOnline = false;
    }

    // Offline fallback
    const cached = OfflineCache.getDiscoveries().find(d => d.id === id);
    if (cached) {
      return {
        ...cached,
        saved: OfflineCache.isSaved(cached.id),
      };
    }
    return null;
  }

  public static async search(query: string): Promise<Discovery[]> {
    if (!query.trim()) return [];

    try {
      const res = await fetch(`${API_BASE}/search?q=${encodeURIComponent(query)}`);
      if (res.ok) {
        const json = await res.json();
        if (json.success) return json.data;
      }
    } catch {
      this.isOnline = false;
    }

    // Offline search fallback
    const cached = OfflineCache.getDiscoveries();
    const qLower = query.toLowerCase();
    return cached.filter(
      d =>
        d.title.toLowerCase().includes(qLower) ||
        d.hook.toLowerCase().includes(qLower) ||
        d.short_description.toLowerCase().includes(qLower)
    );
  }

  public static async toggleSave(discoveryId: string): Promise<boolean> {
    const newStatus = OfflineCache.toggleSaved(discoveryId);

    try {
      if (newStatus) {
        await fetch(`${API_BASE}/saved/${discoveryId}`, { method: 'POST' });
      } else {
        await fetch(`${API_BASE}/saved/${discoveryId}`, { method: 'DELETE' });
      }
    } catch {
      // Offline: state is saved locally in OfflineCache
    }

    return newStatus;
  }

  public static async getSaved(): Promise<Discovery[]> {
    try {
      const res = await fetch(`${API_BASE}/saved`);
      if (res.ok) {
        const json = await res.json();
        if (json.success) return json.data;
      }
    } catch {
      this.isOnline = false;
    }

    const savedIds = OfflineCache.getSavedIds();
    const cached = OfflineCache.getDiscoveries();
    return cached.filter(d => savedIds.has(d.id)).map(d => ({ ...d, saved: true }));
  }

  public static async recordView(discoveryId: string) {
    OfflineCache.recordView(discoveryId);

    try {
      await fetch(`${API_BASE}/history/view`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ discovery_id: discoveryId }),
      });
    } catch {
      // Offline fallback
    }
  }

  public static async getProfile(): Promise<UserProfile> {
    try {
      const res = await fetch(`${API_BASE}/profile`);
      if (res.ok) {
        const json = await res.json();
        if (json.success) return json.data;
      }
    } catch {
      this.isOnline = false;
    }

    return OfflineCache.getProfile();
  }
}
