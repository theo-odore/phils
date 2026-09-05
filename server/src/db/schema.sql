-- Phils PostgreSQL Database Schema (PRD v1.0)

CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(64) PRIMARY KEY,
    username VARCHAR(100) UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS discovery_types (
    slug VARCHAR(50) PRIMARY KEY,
    label VARCHAR(100) NOT NULL,
    description TEXT
);

INSERT INTO discovery_types (slug, label, description) VALUES
    ('philosophy', 'Philosophy', 'Comprehensive worldviews and schools of thought'),
    ('philosopher', 'Philosopher', 'Historical thinkers, sages, and authors'),
    ('concept', 'Psychological & Cognitive Concept', 'Mental models and human behaviors'),
    ('paradox', 'Paradox', 'Counterintuitive logical and physical puzzles'),
    ('thought_experiment', 'Thought Experiment', 'Hypothetical scenarios testing ethics and reality'),
    ('scientific_idea', 'Scientific Idea', 'Theories in physics, cosmology, and biology'),
    ('historical_idea', 'Historical Idea', 'Socio-economic models and civilizational dynamics')
ON CONFLICT (slug) DO NOTHING;

CREATE TABLE IF NOT EXISTS discoveries (
    id VARCHAR(100) PRIMARY KEY,
    slug VARCHAR(120) UNIQUE NOT NULL,
    title VARCHAR(200) NOT NULL,
    type_slug VARCHAR(50) REFERENCES discovery_types(slug),
    hook TEXT NOT NULL,
    short_description TEXT NOT NULL,
    detailed_description TEXT NOT NULL,
    origin_context TEXT,
    core_principles JSONB DEFAULT '[]'::jsonb,
    everyday_example TEXT,
    background_style VARCHAR(50) DEFAULT 'stoic_stone',
    status VARCHAR(20) DEFAULT 'published',
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS discovery_people (
    id SERIAL PRIMARY KEY,
    discovery_id VARCHAR(100) REFERENCES discoveries(id) ON DELETE CASCADE,
    name VARCHAR(150) NOT NULL,
    role VARCHAR(150),
    era VARCHAR(100),
    quote TEXT
);

CREATE TABLE IF NOT EXISTS discovery_relationships (
    id SERIAL PRIMARY KEY,
    source_id VARCHAR(100) REFERENCES discoveries(id) ON DELETE CASCADE,
    target_id VARCHAR(100) REFERENCES discoveries(id) ON DELETE CASCADE,
    relation_type VARCHAR(50) NOT NULL, -- 'related', 'contrasting', 'influenced_by', 'influences', 'example_of'
    reason TEXT,
    UNIQUE(source_id, target_id, relation_type)
);

CREATE TABLE IF NOT EXISTS saved_discoveries (
    user_id VARCHAR(64) REFERENCES users(id) ON DELETE CASCADE,
    discovery_id VARCHAR(100) REFERENCES discoveries(id) ON DELETE CASCADE,
    saved_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, discovery_id)
);

CREATE TABLE IF NOT EXISTS view_history (
    id SERIAL PRIMARY KEY,
    user_id VARCHAR(64) REFERENCES users(id) ON DELETE CASCADE,
    discovery_id VARCHAR(100) REFERENCES discoveries(id) ON DELETE CASCADE,
    duration_ms INTEGER DEFAULT 0,
    viewed_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Full text search index
CREATE INDEX IF NOT EXISTS idx_discoveries_type ON discoveries(type_slug);
CREATE INDEX IF NOT EXISTS idx_discoveries_title ON discoveries(title);
CREATE INDEX IF NOT EXISTS idx_view_history_user ON view_history(user_id, viewed_at DESC);
CREATE INDEX IF NOT EXISTS idx_saved_discoveries_user ON saved_discoveries(user_id, saved_at DESC);
