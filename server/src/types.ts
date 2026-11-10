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

// ----------------------------------------------------
// Deep Intellectual Reading Sections (Progressive Depth)
// ----------------------------------------------------

export interface RichSectionWhatIsThis {
  summary: string;
  central_question?: string;
  main_argument?: string;
  how_it_works?: string;
  introductory_example?: string;
  importance?: string;
  misconceptions?: string[];
  questions_to_consider?: string[];
}

export interface RichSectionOriginContext {
  summary: string;
  era_and_location?: string;
  historical_circumstances?: string;
  motivating_problem?: string;
  earlier_influences?: string[];
  evolution_and_development?: string;
  historical_legacy?: string;
}

export interface RichCorePrinciple {
  name: string;
  explanation: string;
  why_it_matters: string;
  reasoning?: string;
  example?: string;
  counter_case?: string;
  common_misunderstanding?: string;
  relation_to_other_principles?: string;
}

export interface RichKeyThinker {
  name: string;
  link_id?: string;
  role?: string;
  era?: string;
  biographical_context?: string;
  specific_contribution?: string;
  major_works_or_arguments?: string;
  distinct_perspective?: string;
  quote?: string;
}

export interface RichPracticalScenario {
  title: string;
  context: string;
  application_steps: string[];
  reflection?: string;
}

export interface RichSectionEverydayLife {
  summary: string;
  scenarios?: RichPracticalScenario[];
  common_mistakes?: string[];
  limitations?: string;
}

export interface RichCriticalPerspectives {
  proponent_arguments?: string;
  critic_arguments?: string;
  limitations_and_objections?: string[];
  response_to_objections?: string;
  unresolved_debates?: string;
}

export interface RichConnectedIdea {
  id: string;
  title: string;
  type: DiscoveryType | string;
  relationship_type?: string;
  explanation: string;
}

export interface ReadingDepthMetadata {
  quick_intro_word_count?: number;
  deep_dive_word_count?: number;
  reading_time_minutes?: number;
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

  // Enriched Deep-Dive Sections
  section_what_is_this?: RichSectionWhatIsThis;
  section_origin_context?: RichSectionOriginContext;
  section_core_principles?: RichCorePrinciple[];
  section_key_thinkers?: RichKeyThinker[];
  section_everyday_life?: RichSectionEverydayLife;
  section_critical_perspectives?: RichCriticalPerspectives;
  section_connected_ideas?: RichConnectedIdea[];
  reading_depth?: ReadingDepthMetadata;
}

export interface FeedResponse {
  discoveries: Discovery[];
  next_cursor: string | null;
  has_more: boolean;
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
