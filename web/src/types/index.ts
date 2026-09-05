export type DiscoveryType =
  | 'philosophy'
  | 'philosopher'
  | 'concept'
  | 'paradox'
  | 'thought_experiment'
  | 'scientific_idea'
  | 'historical_idea';

export interface KeyPerson {
  name: string;
  role?: string;
  era?: string;
  quote?: string;
}

export interface RelatedItem {
  id: string;
  title: string;
  type: DiscoveryType;
  relation_type?: 'related' | 'contrasting' | 'influenced_by' | 'influences' | 'example_of';
  reason: string;
}

export interface Discovery {
  id: string;
  slug: string;
  title: string;
  type: DiscoveryType;
  hook: string;
  short_description: string;
  detailed_description: string;
  origin_context: string;
  core_principles: string[];
  everyday_example: string;
  background_style: string;
  key_people: KeyPerson[];
  related_discoveries: RelatedItem[];
  contrasting_discoveries: RelatedItem[];
  status?: 'published' | 'draft' | 'archived';
  created_at?: string;
  updated_at?: string;
  why_reason?: string;
  saved?: boolean;
}

export interface UserProfile {
  user_id: string;
  ideas_discovered_count: number;
  philosophies_explored_count: number;
  saved_count: number;
  recent_history: Array<{
    discovery_id: string;
    title: string;
    type: DiscoveryType;
    viewed_at: string;
  }>;
}

export type TabType = 'feed' | 'search' | 'profile';
