import { Discovery, DiscoveryType } from '../types';

export interface RecommendationContext {
  userId: string;
  viewHistory: Array<{ discoveryId: string; viewedAt: Date }>;
  savedIds: Set<string>;
  allDiscoveries: Discovery[];
}

export class RecommendationEngine {
  /**
   * Generates a deterministic, serendipitous feed based on user history and PRD rules:
   * 1. Balance: Familiarity + Novelty + Diversity + Relationships (Related & Contrasting).
   * 2. Anti-clustering: Never show the same type or topic consecutively.
   * 3. Serendipity: Intentionally mix philosophies, paradoxes, thought experiments, science, etc.
   * 4. Transparency: Attach a "why_reason" to every item.
   */
  public static generateFeed(context: RecommendationContext, limit: number = 10): Discovery[] {
    const { viewHistory, savedIds, allDiscoveries } = context;
    const discoveryMap = new Map<string, Discovery>(allDiscoveries.map(d => [d.id, d]));
    const viewedIdsSet = new Set(viewHistory.map(v => v.discoveryId));
    
    // Recent 5 viewed items (most recent first)
    const recentViewedIds = viewHistory
      .slice(-5)
      .reverse()
      .map(v => v.discoveryId);

    const candidates: Array<{ discovery: Discovery; why_reason: string; score: number }> = [];
    const usedIds = new Set<string>();

    // 1. Contrasting perspective candidates from recent views (High priority for intellectual tension)
    for (const recentId of recentViewedIds) {
      const recentDisc = discoveryMap.get(recentId);
      if (recentDisc && recentDisc.contrasting_discoveries) {
        for (const contrast of recentDisc.contrasting_discoveries) {
          const target = discoveryMap.get(contrast.id);
          if (target && !usedIds.has(target.id)) {
            usedIds.add(target.id);
            candidates.push({
              discovery: target,
              why_reason: `You recently explored ${recentDisc.title}. This offers a contrasting perspective from another school of thought.`,
              score: 95,
            });
          }
        }
      }
    }

    // 2. Related discoveries from recent views & saved items
    for (const recentId of recentViewedIds) {
      const recentDisc = discoveryMap.get(recentId);
      if (recentDisc && recentDisc.related_discoveries) {
        for (const rel of recentDisc.related_discoveries) {
          const target = discoveryMap.get(rel.id);
          if (target && !usedIds.has(target.id)) {
            usedIds.add(target.id);
            candidates.push({
              discovery: target,
              why_reason: `Connected to your exploration of ${recentDisc.title}: ${rel.reason}.`,
              score: 85,
            });
          }
        }
      }
    }

    // 3. Saved items connections
    for (const savedId of savedIds) {
      const savedDisc = discoveryMap.get(savedId);
      if (savedDisc && savedDisc.related_discoveries) {
        for (const rel of savedDisc.related_discoveries) {
          const target = discoveryMap.get(rel.id);
          if (target && !usedIds.has(target.id)) {
            usedIds.add(target.id);
            candidates.push({
              discovery: target,
              why_reason: `Connected to your saved idea "${savedDisc.title}".`,
              score: 80,
            });
          }
        }
      }
    }

    // 4. Unseen discoveries across all distinct types for novelty & diversity
    const unseen = allDiscoveries.filter(d => !viewedIdsSet.has(d.id) && !usedIds.has(d.id));
    for (const d of unseen) {
      usedIds.add(d.id);
      candidates.push({
        discovery: d,
        why_reason: `Recommended for discovery diversity in ${this.formatTypeName(d.type)}.`,
        score: 70,
      });
    }

    // 5. If candidates pool is smaller than requested limit, add remaining discoveries with cycled reason
    for (const d of allDiscoveries) {
      if (!usedIds.has(d.id)) {
        usedIds.add(d.id);
        candidates.push({
          discovery: d,
          why_reason: `A foundational idea in ${this.formatTypeName(d.type)} worth revisiting.`,
          score: 50,
        });
      }
    }

    // Anti-repetition & Diversity Sorter:
    // Ensure that consecutive items DO NOT share the same `type` whenever possible
    const finalFeed: Discovery[] = [];
    const remainingPool = [...candidates];
    let lastType: DiscoveryType | null = null;

    while (remainingPool.length > 0 && finalFeed.length < limit) {
      // Find the highest-scored candidate with a different type than `lastType`
      let bestIndex = remainingPool.findIndex(c => c.discovery.type !== lastType);
      if (bestIndex === -1) {
        bestIndex = 0; // Fallback if all remaining are same type
      }

      const [selected] = remainingPool.splice(bestIndex, 1);
      lastType = selected.discovery.type;

      finalFeed.push({
        ...selected.discovery,
        why_reason: selected.why_reason,
        saved: savedIds.has(selected.discovery.id),
      });
    }

    return finalFeed;
  }

  private static formatTypeName(type: DiscoveryType): string {
    switch (type) {
      case 'philosophy':
        return 'World Philosophy';
      case 'philosopher':
        return 'Influential Thinkers';
      case 'concept':
        return 'Psychological & Cognitive Concepts';
      case 'paradox':
        return 'Classical Paradoxes';
      case 'thought_experiment':
        return 'Moral & Mind Thought Experiments';
      case 'scientific_idea':
        return 'Scientific & Physics Ideas';
      case 'historical_idea':
        return 'Historical & Economic Models';
      default:
        return 'Ideas';
    }
  }
}
