import React from 'react';
import { Bookmark, Sparkles, ArrowRight, Compass, Share2 } from 'lucide-react';
import { Discovery } from '../../types';
import { CardBackground } from './CardBackground';
import { triggerHaptic } from '../../services/haptics';

interface FeedCardProps {
  discovery: Discovery;
  onExplore: (discovery: Discovery) => void;
  onToggleSave: (discovery: Discovery) => void;
  onShowWhy: (discovery: Discovery) => void;
}

export const FeedCard: React.FC<FeedCardProps> = ({
  discovery,
  onExplore,
  onToggleSave,
  onShowWhy,
}) => {
  const getTypeName = (type: string) => {
    switch (type) {
      case 'philosophy':
        return 'World Philosophy';
      case 'philosopher':
        return 'Influential Thinker';
      case 'concept':
        return 'Mental Model';
      case 'paradox':
        return 'Classical Paradox';
      case 'thought_experiment':
        return 'Thought Experiment';
      case 'scientific_idea':
        return 'Scientific Theory';
      case 'historical_idea':
        return 'Historical Idea';
      default:
        return 'Idea';
    }
  };

  const handleSaveClick = (e: React.MouseEvent) => {
    e.stopPropagation();
    triggerHaptic('medium');
    onToggleSave(discovery);
  };

  const handleWhyClick = (e: React.MouseEvent) => {
    e.stopPropagation();
    triggerHaptic('light');
    onShowWhy(discovery);
  };

  const handleShareClick = async (e: React.MouseEvent) => {
    e.stopPropagation();
    triggerHaptic('light');
    if (navigator.share) {
      try {
        await navigator.share({
          title: `Phils — ${discovery.title}`,
          text: `"${discovery.hook}" — Discover ${discovery.title} on Phils`,
          url: window.location.href,
        });
      } catch {
        // User cancelled share
      }
    } else {
      navigator.clipboard.writeText(`"${discovery.hook}"\n\n${discovery.title}: ${discovery.short_description}`);
    }
  };

  const handleCardClick = () => {
    triggerHaptic('light');
    onExplore(discovery);
  };

  return (
    <div className="feed-card-item" onClick={handleCardClick}>
      {/* Dynamic Background Atmosphere */}
      <CardBackground styleName={discovery.background_style} />

      {/* Top Meta Area */}
      <div style={{ position: 'relative', zIndex: 5 }}>
        <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', marginBottom: 16 }}>
          <div className="card-type-badge">
            <Compass size={13} color="var(--accent-gold)" />
            <span>{getTypeName(discovery.type)}</span>
          </div>

          <button
            type="button"
            onClick={handleWhyClick}
            style={{
              background: 'rgba(255, 255, 255, 0.04)',
              border: '1px solid var(--border-subtle)',
              borderRadius: 'var(--radius-full)',
              padding: '5px 10px',
              color: 'var(--text-muted)',
              cursor: 'pointer',
              display: 'flex',
              alignItems: 'center',
              gap: 5,
              fontSize: '0.72rem',
              fontWeight: 600,
              letterSpacing: '0.04em',
              backdropFilter: 'blur(10px)',
            }}
            aria-label="Why this idea?"
          >
            <Sparkles size={12} color="var(--accent-gold)" />
            <span>Why this?</span>
          </button>
        </div>

        {/* Curiosity Hook */}
        <div className="card-hook">
          <span>{discovery.hook}</span>
        </div>
      </div>

      {/* Center & Bottom Discovery Content */}
      <div style={{ position: 'relative', zIndex: 5, marginTop: 'auto', marginBottom: 12 }}>
        {/* Title */}
        <h1 className="card-title">
          {discovery.title}
        </h1>

        {/* One-Line Essence */}
        <p className="card-short-desc">
          "{discovery.short_description}"
        </p>

        {/* Explore CTA */}
        <div className="card-explore-btn" onClick={handleCardClick}>
          <span>Explore idea</span>
          <ArrowRight size={16} />
        </div>
      </div>

      {/* Side Action Bar */}
      <div className="card-side-actions">
        <button
          type="button"
          className={`side-action-btn ${discovery.saved ? 'active-saved' : ''}`}
          onClick={handleSaveClick}
          aria-label={discovery.saved ? 'Unsave discovery' : 'Save discovery'}
        >
          <Bookmark
            size={20}
            fill={discovery.saved ? 'var(--accent-gold)' : 'none'}
            color={discovery.saved ? 'var(--accent-gold)' : 'currentColor'}
          />
        </button>

        <button
          type="button"
          className="side-action-btn"
          onClick={handleShareClick}
          aria-label="Share quote"
        >
          <Share2 size={18} />
        </button>
      </div>
    </div>
  );
};
