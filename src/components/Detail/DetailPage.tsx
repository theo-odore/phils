import React from 'react';
import { ArrowLeft, Bookmark, Compass, Scale, Sparkles, Quote, ArrowRight, BookOpen, Clock } from 'lucide-react';
import { Discovery } from '../../types';
import { triggerHaptic } from '../../services/haptics';

interface DetailPageProps {
  discovery: Discovery;
  onBack: () => void;
  onNavigateToDiscovery: (id: string) => void;
  onToggleSave: (discovery: Discovery) => void;
}

export const DetailPage: React.FC<DetailPageProps> = ({
  discovery,
  onBack,
  onNavigateToDiscovery,
  onToggleSave,
}) => {
  const handleSave = () => {
    triggerHaptic('medium');
    onToggleSave(discovery);
  };

  const handleBack = () => {
    triggerHaptic('light');
    onBack();
  };

  return (
    <div className="detail-view">
      {/* Top Header Bar */}
      <div className="detail-top-bar">
        <button type="button" className="detail-back-btn" onClick={handleBack}>
          <ArrowLeft size={16} />
          <span>Feed</span>
        </button>

        <button
          type="button"
          onClick={handleSave}
          style={{
            background: discovery.saved ? 'rgba(229,169,60,0.22)' : 'var(--bg-surface)',
            border: `1px solid ${discovery.saved ? 'var(--border-gold-strong)' : 'var(--border-medium)'}`,
            borderRadius: 'var(--radius-full)',
            width: 44,
            height: 44,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            color: discovery.saved ? 'var(--accent-gold)' : 'var(--text-primary)',
            cursor: 'pointer',
            boxShadow: '0 4px 16px rgba(0, 0, 0, 0.3)',
            transition: 'all 0.2s ease',
          }}
          aria-label={discovery.saved ? 'Unsave idea' : 'Save idea'}
        >
          <Bookmark
            size={18}
            fill={discovery.saved ? 'var(--accent-gold)' : 'none'}
            color={discovery.saved ? 'var(--accent-gold)' : 'currentColor'}
          />
        </button>
      </div>

      {/* Discovery Hero Section */}
      <div style={{ marginBottom: 36 }}>
        <div className="card-type-badge" style={{ marginBottom: 16 }}>
          <Compass size={13} color="var(--accent-gold)" />
          <span>{discovery.type.replace('_', ' ').toUpperCase()}</span>
        </div>

        <h1
          className="font-display"
          style={{
            fontSize: 'clamp(2.3rem, 7vw, 2.9rem)',
            fontWeight: 800,
            lineHeight: 1.1,
            color: 'var(--text-primary)',
            marginBottom: 14,
            letterSpacing: '0.01em',
          }}
        >
          {discovery.title}
        </h1>

        <div className="card-hook" style={{ fontSize: '0.88rem', marginBottom: 20 }}>
          <span>{discovery.hook}</span>
        </div>

        {/* Lead Quote Paragraph */}
        <div
          style={{
            fontFamily: 'var(--font-editorial)',
            fontSize: '1.25rem',
            fontStyle: 'italic',
            lineHeight: 1.5,
            color: 'var(--text-primary)',
            borderLeft: '2px solid var(--accent-gold)',
            paddingLeft: '16px',
            margin: '20px 0',
          }}
        >
          "{discovery.short_description}"
        </div>
      </div>

      {/* 01. The Essence (What is it?) */}
      <div className="detail-section">
        <h2 className="detail-section-title">
          <BookOpen size={16} color="var(--accent-gold)" />
          <span>What is {discovery.title}?</span>
        </h2>
        <p className="detail-body-text">{discovery.detailed_description}</p>
      </div>

      {/* 02. Origins & Historical Context */}
      {discovery.origin_context && (
        <div className="detail-section">
          <h2 className="detail-section-title">
            <Clock size={16} color="var(--accent-gold)" />
            <span>Where did it originate?</span>
          </h2>
          <p className="detail-body-text">{discovery.origin_context}</p>
        </div>
      )}

      {/* 03. Core Principles (Numbered Tiles) */}
      {discovery.core_principles && discovery.core_principles.length > 0 && (
        <div className="detail-section">
          <h2 className="detail-section-title">
            <Sparkles size={16} color="var(--accent-gold)" />
            <span>Core Principles</span>
          </h2>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
            {discovery.core_principles.map((principle, idx) => (
              <div key={idx} className="principle-card">
                <div className="principle-number">
                  0{idx + 1}
                </div>
                <div style={{ fontSize: '0.96rem', lineHeight: 1.6, color: 'var(--text-secondary)' }}>
                  {principle}
                </div>
              </div>
            ))}
          </div>
        </div>
      )}

      {/* 04. Giant Thinkers (Thinker Profile Cards) */}
      {discovery.key_people && discovery.key_people.length > 0 && (
        <div className="detail-section">
          <h2 className="detail-section-title">
            <span>Key Thinkers</span>
          </h2>
          <div style={{ display: 'flex', flexDirection: 'column', gap: 14 }}>
            {discovery.key_people.map((person, idx) => (
              <div key={idx} className="thinker-card">
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'baseline', marginBottom: 6 }}>
                  <span style={{ fontWeight: 700, fontSize: '1.1rem', color: 'var(--text-primary)' }}>
                    {person.name}
                  </span>
                  {person.era && (
                    <span className="font-mono" style={{ fontSize: '0.74rem', color: 'var(--text-muted)' }}>
                      {person.era}
                    </span>
                  )}
                </div>
                {person.role && (
                  <div style={{ fontSize: '0.82rem', color: 'var(--accent-gold)', fontWeight: 500, marginBottom: 10 }}>
                    {person.role}
                  </div>
                )}
                {person.quote && (
                  <div
                    style={{
                      display: 'flex',
                      gap: 10,
                      fontFamily: 'var(--font-editorial)',
                      fontStyle: 'italic',
                      fontSize: '1.08rem',
                      color: 'var(--text-secondary)',
                      lineHeight: 1.5,
                      marginTop: 8,
                      background: 'rgba(0, 0, 0, 0.2)',
                      padding: '12px 14px',
                      borderRadius: 'var(--radius-sm)',
                    }}
                  >
                    <Quote size={18} style={{ flexShrink: 0, opacity: 0.5, marginTop: 3 }} />
                    <span>"{person.quote}"</span>
                  </div>
                )}
              </div>
            ))}
          </div>
        </div>
      )}

      {/* 05. Everyday Practical Scenario */}
      {discovery.everyday_example && (
        <div className="detail-section">
          <h2 className="detail-section-title">
            <span>Everyday Application</span>
          </h2>
          <div
            style={{
              background: 'linear-gradient(135deg, rgba(229,169,60,0.08) 0%, rgba(19,20,30,0.8) 100%)',
              border: '1px solid var(--border-gold)',
              borderRadius: 'var(--radius-lg)',
              padding: '20px 22px',
              color: 'var(--text-secondary)',
              fontSize: '0.98rem',
              lineHeight: 1.65,
              boxShadow: 'inset 0 1px 0 rgba(255, 255, 255, 0.1)',
            }}
          >
            {discovery.everyday_example}
          </div>
        </div>
      )}

      {/* 06. Contrasting Perspectives (Core PRD Experience) */}
      {discovery.contrasting_discoveries && discovery.contrasting_discoveries.length > 0 && (
        <div className="detail-section">
          <div style={{ display: 'flex', alignItems: 'center', gap: 8, marginBottom: 6 }}>
            <Scale size={18} color="#EF4444" />
            <h2 className="detail-section-title" style={{ color: '#F87171', margin: 0 }}>
              Want another perspective?
            </h2>
          </div>
          <p style={{ fontSize: '0.84rem', color: 'var(--text-muted)', marginBottom: 14 }}>
            Phils exposes competing schools of thought rather than deciding what you should believe.
          </p>

          {discovery.contrasting_discoveries.map(contrast => (
            <div
              key={contrast.id}
              className="contrasting-box"
              onClick={() => {
                triggerHaptic('light');
                onNavigateToDiscovery(contrast.id);
              }}
            >
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 8 }}>
                <span className="font-display" style={{ fontWeight: 700, fontSize: '1.2rem', color: 'var(--text-primary)' }}>
                  {contrast.title}
                </span>
                <span style={{ display: 'flex', alignItems: 'center', gap: 4, fontSize: '0.8rem', fontWeight: 600, color: '#F87171' }}>
                  <span>Explore</span>
                  <ArrowRight size={14} />
                </span>
              </div>
              <p style={{ fontSize: '0.9rem', color: 'var(--text-secondary)', lineHeight: 1.55 }}>
                {contrast.reason}
              </p>
            </div>
          ))}
        </div>
      )}

      {/* 07. Related Discoveries */}
      {discovery.related_discoveries && discovery.related_discoveries.length > 0 && (
        <div className="detail-section">
          <h2 className="detail-section-title">
            <Sparkles size={16} color="var(--accent-gold)" />
            <span>Related Ideas</span>
          </h2>

          {discovery.related_discoveries.map(rel => (
            <div
              key={rel.id}
              className="related-pill"
              onClick={() => {
                triggerHaptic('light');
                onNavigateToDiscovery(rel.id);
              }}
            >
              <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 4 }}>
                <span style={{ fontWeight: 700, fontSize: '1.02rem', color: 'var(--text-primary)' }}>
                  {rel.title}
                </span>
                <ArrowRight size={15} color="var(--accent-gold)" />
              </div>
              <p style={{ fontSize: '0.84rem', color: 'var(--text-muted)', lineHeight: 1.45 }}>
                {rel.reason}
              </p>
            </div>
          ))}
        </div>
      )}

      {/* Bottom Sticky Action */}
      <div style={{ marginTop: 44, marginBottom: 24 }}>
        <button
          type="button"
          onClick={handleBack}
          style={{
            width: '100%',
            padding: '16px',
            borderRadius: 'var(--radius-full)',
            background: 'var(--accent-gold-sheen)',
            color: '#07080C',
            fontFamily: 'var(--font-sans)',
            fontSize: '1rem',
            fontWeight: 800,
            letterSpacing: '0.04em',
            border: 'none',
            cursor: 'pointer',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            gap: 10,
            boxShadow: '0 8px 30px rgba(229, 169, 60, 0.35)',
            transition: 'transform 0.2s ease',
          }}
        >
          <span>Continue Discovering</span>
          <ArrowRight size={18} />
        </button>
      </div>
    </div>
  );
};
