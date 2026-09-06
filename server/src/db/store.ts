import { Discovery, UserProfile, DiscoveryType } from '../types';
import { curatedDiscoveries } from './discoveriesData';
import { RecommendationEngine } from '../services/recommendationEngine';
import { nvidiaNimGenerator } from '../services/nvidiaNimGenerator';
import { Pool } from 'pg';

export class DataStore {
  private discoveries: Map<string, Discovery> = new Map();
  private userSaved: Map<string, Set<string>> = new Map();
  private userViews: Map<string, Array<{ discoveryId: string; viewedAt: Date; durationMs?: number }>> = new Map();
  private pgPool: Pool | null = null;

  constructor() {
    // Populate in-memory map from curated data
    for (const item of curatedDiscoveries) {
      this.discoveries.set(item.id, { ...item, status: 'published' });
    }

    // Initialize PostgreSQL pool if DATABASE_URL or POSTGRES_HOST is configured
    if (process.env.DATABASE_URL || process.env.POSTGRES_HOST) {
      try {
        this.pgPool = new Pool({
          connectionString: process.env.DATABASE_URL,
          host: process.env.POSTGRES_HOST || 'localhost',
          port: parseInt(process.env.POSTGRES_PORT || '5432'),
          user: process.env.POSTGRES_USER || 'phils',
          password: process.env.POSTGRES_PASSWORD || 'phils_secret',
          database: process.env.POSTGRES_DB || 'phils_db',
        });
        console.log('[DataStore] Connected to PostgreSQL');
      } catch (err) {
        console.warn('[DataStore] PostgreSQL connection failed, using fast embedded data store:', err);
        this.pgPool = null;
      }
    }
  }

  public async getAllDiscoveries(): Promise<Discovery[]> {
    return Array.from(this.discoveries.values());
  }

  public async getDiscoveryById(id: string, userId: string = 'default_user'): Promise<Discovery | null> {
    const item = this.discoveries.get(id);
    if (!item) return null;

    const savedSet = this.userSaved.get(userId) || new Set();
    return {
      ...item,
      saved: savedSet.has(item.id),
    };
  }

  public async getFeed(userId: string = 'default_user', limit: number = 15, cursor?: string): Promise<{ discoveries: Discovery[]; next_cursor: string | null; has_more: boolean }> {
    const all = Array.from(this.discoveries.values());
    const userViews = this.userViews.get(userId) || [];
    const savedIds = this.userSaved.get(userId) || new Set();

    let feed = RecommendationEngine.generateFeed({
      userId,
      viewHistory: userViews,
      savedIds,
      allDiscoveries: all,
    }, limit);

    // If feed has few unseen items remaining, dynamically synthesize additional theories
    if (feed.length < limit) {
      try {
        const existingTitles = all.map(d => d.title);
        const needed = Math.max(3, limit - feed.length);
        const generated = await nvidiaNimGenerator.generateBatch(needed, existingTitles);
        for (const item of generated) {
          this.discoveries.set(item.id, item);
          feed.push(item);
        }
      } catch (err) {
        console.error('[DataStore] Infinite synthesis fallback triggered:', err);
      }
    }

    return {
      discoveries: feed,
      next_cursor: feed.length > 0 ? feed[feed.length - 1].id : null,
      has_more: true,
    };
  }

  public async generateMore(count = 5): Promise<Discovery[]> {
    const all = Array.from(this.discoveries.values());
    const existingTitles = all.map(d => d.title);
    const newItems = await nvidiaNimGenerator.generateBatch(count, existingTitles);
    for (const item of newItems) {
      this.discoveries.set(item.id, item);
    }
    return newItems;
  }

  public async search(query: string, limit: number = 20): Promise<Discovery[]> {
    if (!query || !query.trim()) return [];

    const cleanQuery = query.toLowerCase().trim();
    const queryTerms = cleanQuery.split(/\s+/);
    const all = Array.from(this.discoveries.values());

    const scored = all.map(d => {
      let score = 0;
      const titleLower = d.title.toLowerCase();
      const hookLower = d.hook.toLowerCase();
      const descLower = d.short_description.toLowerCase();
      const detailLower = d.detailed_description.toLowerCase();
      const principlesLower = (d.core_principles || []).join(' ').toLowerCase();

      // Exact title match
      if (titleLower === cleanQuery) score += 100;
      else if (titleLower.includes(cleanQuery)) score += 50;

      // Hook match
      if (hookLower.includes(cleanQuery)) score += 30;

      // Term matches
      for (const term of queryTerms) {
        if (titleLower.includes(term)) score += 20;
        if (hookLower.includes(term)) score += 10;
        if (descLower.includes(term)) score += 8;
        if (detailLower.includes(term)) score += 4;
        if (principlesLower.includes(term)) score += 4;
      }

      // Semantic concept matching for common queries
      if (cleanQuery.includes('meaning of life') || cleanQuery.includes('purpose') || cleanQuery.includes('why are we here')) {
        if (['existentialism', 'absurdism', 'nihilism', 'stoicism', 'epicureanism', 'taoism'].includes(d.id)) {
          score += 45;
        }
      }
      if (cleanQuery.includes('identity') || cleanQuery.includes('who am i') || cleanQuery.includes('same person')) {
        if (['ship-of-theseus', 'quantum-superposition', 'cognitive-dissonance'].includes(d.id)) {
          score += 45;
        }
      }
      if (cleanQuery.includes('morality') || cleanQuery.includes('ethics') || cleanQuery.includes('right and wrong') || cleanQuery.includes('justice')) {
        if (['utilitarianism', 'deontology', 'trolley-problem', 'veil-of-ignorance', 'cynicism'].includes(d.id)) {
          score += 45;
        }
      }
      if (cleanQuery.includes('happiness') || cleanQuery.includes('peace') || cleanQuery.includes('anxiety') || cleanQuery.includes('stress')) {
        if (['stoicism', 'dichotomy-of-control', 'epicureanism', 'hedonic-adaptation', 'taoism', 'amor-fati'].includes(d.id)) {
          score += 45;
        }
      }

      return { discovery: d, score };
    });

    return scored
      .filter(item => item.score > 0)
      .sort((a, b) => b.score - a.score)
      .slice(0, limit)
      .map(item => item.discovery);
  }

  public async saveDiscovery(userId: string = 'default_user', discoveryId: string): Promise<boolean> {
    if (!this.discoveries.has(discoveryId)) return false;

    if (!this.userSaved.has(userId)) {
      this.userSaved.set(userId, new Set());
    }
    this.userSaved.get(userId)!.add(discoveryId);
    return true;
  }

  public async unsaveDiscovery(userId: string = 'default_user', discoveryId: string): Promise<boolean> {
    const saved = this.userSaved.get(userId);
    if (!saved) return false;
    saved.delete(discoveryId);
    return true;
  }

  public async getSavedDiscoveries(userId: string = 'default_user'): Promise<Discovery[]> {
    const savedIds = this.userSaved.get(userId) || new Set();
    const result: Discovery[] = [];

    for (const id of savedIds) {
      const item = this.discoveries.get(id);
      if (item) {
        result.push({ ...item, saved: true });
      }
    }
    return result;
  }

  public async recordView(userId: string = 'default_user', discoveryId: string, durationMs: number = 0): Promise<void> {
    if (!this.userViews.has(userId)) {
      this.userViews.set(userId, []);
    }
    this.userViews.get(userId)!.push({
      discoveryId,
      viewedAt: new Date(),
      durationMs,
    });
  }

  public async getUserProfile(userId: string = 'default_user'): Promise<UserProfile> {
    const views = this.userViews.get(userId) || [];
    const saved = this.userSaved.get(userId) || new Set();

    const uniqueViewedIds = new Set(views.map(v => v.discoveryId));
    let philosophiesExplored = 0;

    for (const id of uniqueViewedIds) {
      const disc = this.discoveries.get(id);
      if (disc && (disc.type === 'philosophy' || disc.type === 'philosopher')) {
        philosophiesExplored++;
      }
    }

    // Recent 10 history items
    const recentHistory = views
      .slice(-10)
      .reverse()
      .map(v => {
        const d = this.discoveries.get(v.discoveryId);
        return {
          discovery_id: v.discoveryId,
          title: d?.title || 'Unknown Discovery',
          type: d?.type || ('concept' as DiscoveryType),
          viewed_at: v.viewedAt.toISOString(),
        };
      });

    return {
      user_id: userId,
      ideas_discovered_count: uniqueViewedIds.size,
      philosophies_explored_count: philosophiesExplored,
      saved_count: saved.size,
      recent_history: recentHistory,
    };
  }
}

export const store = new DataStore();
