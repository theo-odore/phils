import React from 'react';
import { X, Sparkles } from 'lucide-react';
import { Discovery } from '../../types';

interface WhyReasonModalProps {
  discovery: Discovery | null;
  onClose: () => void;
}

export const WhyReasonModal: React.FC<WhyReasonModalProps> = ({ discovery, onClose }) => {
  if (!discovery) return null;

  return (
    <div className="modal-backdrop" onClick={onClose}>
      <div className="modal-sheet" onClick={e => e.stopPropagation()}>
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 20 }}>
          <div style={{ display: 'flex', alignItems: 'center', gap: 8 }}>
            <Sparkles size={18} color="var(--accent-gold)" />
            <h3 className="font-display" style={{ fontSize: '1rem', fontWeight: 600, color: 'var(--text-primary)' }}>
              Why this idea?
            </h3>
          </div>
          <button
            onClick={onClose}
            style={{
              background: 'rgba(255,255,255,0.08)',
              border: 'none',
              borderRadius: '50%',
              width: 32,
              height: 32,
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              color: 'var(--text-secondary)',
              cursor: 'pointer',
            }}
          >
            <X size={16} />
          </button>
        </div>

        <div style={{ marginBottom: 20 }}>
          <div
            style={{
              fontFamily: 'var(--font-display)',
              fontSize: '1.25rem',
              fontWeight: 700,
              color: 'var(--accent-gold)',
              marginBottom: 8,
            }}
          >
            {discovery.title}
          </div>
          <p
            style={{
              fontSize: '0.95rem',
              lineHeight: 1.6,
              color: 'var(--text-secondary)',
            }}
          >
            {discovery.why_reason ||
              `Recommended for exploration diversity to introduce a foundational idea in ${discovery.type.replace('_', ' ')}.`}
          </p>
        </div>

        <div
          style={{
            padding: '12px 16px',
            borderRadius: '12px',
            background: 'rgba(255,255,255,0.04)',
            border: '1px solid var(--border-subtle)',
            fontSize: '0.78rem',
            color: 'var(--text-muted)',
            lineHeight: 1.5,
          }}
        >
          Phils intelligently mixes related concepts, contrasting perspectives, and unexpected discoveries to keep your feed serendipitous.
        </div>
      </div>
    </div>
  );
};
