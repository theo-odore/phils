import React, { useState, useEffect } from 'react';
import { Search as SearchIcon, X, Compass, ArrowRight, Sparkles } from 'lucide-react';
import { Discovery } from '../../types';
import { ApiClient } from '../../services/api';
import { triggerHaptic } from '../../services/haptics';

interface SearchViewProps {
  onSelectDiscovery: (discovery: Discovery) => void;
}

export const SearchView: React.FC<SearchViewProps> = ({ onSelectDiscovery }) => {
  const [query, setQuery] = useState('');
  const [results, setResults] = useState<Discovery[]>([]);
  const [loading, setLoading] = useState(false);

  const sampleQueries = [
    'Meaning of life',
    'Dichotomy of control',
    'Ship of Theseus',
    'Identity',
    'Morality & ethics',
    'Free will vs determinism',
    'Happiness & anxiety',
  ];

  useEffect(() => {
    if (!query.trim()) {
      setResults([]);
      return;
    }

    const timer = setTimeout(async () => {
      setLoading(true);
      const res = await ApiClient.search(query);
      setResults(res);
      setLoading(false);
    }, 180);

    return () => clearTimeout(timer);
  }, [query]);

  const handleChipClick = (q: string) => {
    triggerHaptic('light');
    setQuery(q);
  };

  const handleSelect = (d: Discovery) => {
    triggerHaptic('light');
    onSelectDiscovery(d);
  };

  return (
    <div className="search-container">
      {/* Header */}
      <div style={{ marginBottom: 24 }}>
        <h1
          className="font-display"
          style={{ fontSize: '1.9rem', fontWeight: 800, color: 'var(--text-primary)', marginBottom: 6 }}
        >
          Search Ideas
        </h1>
        <p style={{ fontSize: '0.88rem', color: 'var(--text-muted)' }}>
          Discover philosophies, paradoxes, thought experiments & thinkers.
        </p>
      </div>

      {/* Input */}
      <div className="search-input-wrapper">
        <SearchIcon
          size={20}
          color="var(--accent-gold)"
          style={{ position: 'absolute', left: 18, top: '50%', transform: 'translateY(-50%)' }}
        />
        <input
          type="text"
          className="search-input"
          placeholder="Search questions, concepts, or thinkers..."
          value={query}
          onChange={e => setQuery(e.target.value)}
          autoFocus
        />
        {query && (
          <button
            type="button"
            onClick={() => setQuery('')}
            style={{
              position: 'absolute',
              right: 14,
              top: '50%',
              transform: 'translateY(-50%)',
              background: 'rgba(255, 255, 255, 0.08)',
              border: 'none',
              borderRadius: '50%',
              width: 28,
              height: 28,
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              color: 'var(--text-secondary)',
              cursor: 'pointer',
            }}
          >
            <X size={15} />
          </button>
        )}
      </div>

      {/* Query Suggestions Chips */}
      {!query && (
        <div style={{ marginBottom: 32 }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: 6, fontSize: '0.75rem', textTransform: 'uppercase', color: 'var(--accent-gold)', fontWeight: 700, letterSpacing: '0.08em', marginBottom: 14 }}>
            <Sparkles size={14} />
            <span>Suggested Inquiries</span>
          </div>
          <div style={{ display: 'flex', flexWrap: 'wrap', gap: 8 }}>
            {sampleQueries.map(sample => (
              <button
                type="button"
                key={sample}
                onClick={() => handleChipClick(sample)}
                style={{
                  background: 'var(--bg-surface)',
                  border: '1px solid var(--border-subtle)',
                  borderRadius: 'var(--radius-full)',
                  padding: '9px 16px',
                  color: 'var(--text-secondary)',
                  fontSize: '0.84rem',
                  fontWeight: 500,
                  cursor: 'pointer',
                  transition: 'all 0.2s ease',
                  boxShadow: '0 2px 8px rgba(0,0,0,0.2)',
                }}
              >
                {sample}
              </button>
            ))}
          </div>
        </div>
      )}

      {/* Results State */}
      {loading && (
        <div style={{ textAlign: 'center', padding: '40px 0', color: 'var(--text-muted)', fontSize: '0.9rem' }}>
          Searching the philosophical codex...
        </div>
      )}

      {!loading && query && results.length === 0 && (
        <div style={{ textAlign: 'center', padding: '48px 20px', color: 'var(--text-muted)' }}>
          <p style={{ fontSize: '1rem', color: 'var(--text-primary)', marginBottom: 6 }}>No discoveries found matching "{query}"</p>
          <p style={{ fontSize: '0.82rem' }}>Try searching by question, philosopher name, or broad concept.</p>
        </div>
      )}

      <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
        {results.map(d => (
          <div
            key={d.id}
            onClick={() => handleSelect(d)}
            style={{
              background: 'var(--bg-surface)',
              border: '1px solid var(--border-medium)',
              borderRadius: 'var(--radius-lg)',
              padding: '18px 20px',
              cursor: 'pointer',
              boxShadow: '0 4px 16px rgba(0, 0, 0, 0.2), inset 0 1px 0 rgba(255, 255, 255, 0.05)',
              transition: 'all 0.2s ease',
            }}
          >
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 8 }}>
              <span
                className="font-mono"
                style={{
                  fontSize: '0.7rem',
                  fontWeight: 600,
                  textTransform: 'uppercase',
                  color: 'var(--accent-gold)',
                  letterSpacing: '0.08em',
                }}
              >
                {d.type.replace('_', ' ')}
              </span>
              <ArrowRight size={15} color="var(--accent-gold)" />
            </div>

            <h3
              className="font-display"
              style={{ fontSize: '1.25rem', fontWeight: 700, color: 'var(--text-primary)', marginBottom: 6 }}
            >
              {d.title}
            </h3>

            <p style={{ fontSize: '0.9rem', color: 'var(--text-secondary)', lineHeight: 1.5 }}>
              {d.short_description}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
};
