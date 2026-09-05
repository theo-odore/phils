import React, { useState, useEffect } from 'react';
import { Bookmark, Compass, History, Moon, Sun, Trash2, ArrowRight, Server, Sparkles } from 'lucide-react';
import { Discovery, UserProfile } from '../../types';
import { ApiClient } from '../../services/api';
import { triggerHaptic } from '../../services/haptics';

interface ProfileViewProps {
  onSelectDiscovery: (discovery: Discovery) => void;
  isDarkTheme: boolean;
  onToggleTheme: () => void;
}

export const ProfileView: React.FC<ProfileViewProps> = ({
  onSelectDiscovery,
  isDarkTheme,
  onToggleTheme,
}) => {
  const [profile, setProfile] = useState<UserProfile | null>(null);
  const [savedItems, setSavedItems] = useState<Discovery[]>([]);
  const [activeSubTab, setActiveSubTab] = useState<'saved' | 'history'>('saved');

  const loadData = async () => {
    const p = await ApiClient.getProfile();
    setProfile(p);
    const saved = await ApiClient.getSaved();
    setSavedItems(saved);
  };

  useEffect(() => {
    loadData();
  }, []);

  const handleUnsave = async (e: React.MouseEvent, id: string) => {
    e.stopPropagation();
    triggerHaptic('medium');
    await ApiClient.toggleSave(id);
    loadData();
  };

  const handleItemClick = (d: Discovery) => {
    triggerHaptic('light');
    onSelectDiscovery(d);
  };

  return (
    <div className="profile-container">
      {/* Top Header */}
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 28 }}>
        <div>
          <h1
            className="font-display"
            style={{ fontSize: '1.9rem', fontWeight: 800, color: 'var(--text-primary)', marginBottom: 4 }}
          >
            Your Journey
          </h1>
          <div style={{ display: 'flex', alignItems: 'center', gap: 6, fontSize: '0.75rem', color: 'var(--text-muted)' }}>
            <Server size={12} color={ApiClient.isOnline ? '#10B981' : '#F59E0B'} />
            <span>{ApiClient.isOnline ? 'Self-Hosted Server Active' : 'Offline Storage Active'}</span>
          </div>
        </div>

        {/* Theme Toggle Button */}
        <button
          type="button"
          onClick={() => {
            triggerHaptic('light');
            onToggleTheme();
          }}
          style={{
            background: 'var(--bg-surface)',
            border: '1px solid var(--border-medium)',
            borderRadius: 'var(--radius-full)',
            width: 44,
            height: 44,
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            color: 'var(--text-secondary)',
            cursor: 'pointer',
            boxShadow: '0 4px 16px rgba(0, 0, 0, 0.2)',
          }}
          aria-label="Toggle theme"
        >
          {isDarkTheme ? <Sun size={19} color="var(--accent-gold)" /> : <Moon size={19} />}
        </button>
      </div>

      {/* Monumental Stats Grid */}
      <div className="journey-stat-grid">
        <div className="journey-stat-card">
          <div className="journey-stat-number">{profile?.ideas_discovered_count || 0}</div>
          <div className="journey-stat-label">Discovered</div>
        </div>

        <div className="journey-stat-card">
          <div className="journey-stat-number">{profile?.philosophies_explored_count || 0}</div>
          <div className="journey-stat-label">Schools</div>
        </div>

        <div className="journey-stat-card">
          <div className="journey-stat-number">{profile?.saved_count || savedItems.length}</div>
          <div className="journey-stat-label">Saved</div>
        </div>
      </div>

      {/* Sub Tabs Pill Selector */}
      <div
        style={{
          display: 'flex',
          background: 'var(--bg-surface)',
          padding: 5,
          borderRadius: 'var(--radius-full)',
          marginBottom: 24,
          border: '1px solid var(--border-subtle)',
        }}
      >
        <button
          type="button"
          onClick={() => {
            triggerHaptic('light');
            setActiveSubTab('saved');
          }}
          style={{
            flex: 1,
            padding: '11px 0',
            borderRadius: 'var(--radius-full)',
            border: 'none',
            background: activeSubTab === 'saved' ? 'var(--bg-surface-elevated)' : 'transparent',
            color: activeSubTab === 'saved' ? 'var(--accent-gold)' : 'var(--text-muted)',
            fontWeight: 700,
            fontSize: '0.85rem',
            cursor: 'pointer',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            gap: 7,
            boxShadow: activeSubTab === 'saved' ? '0 2px 8px rgba(0,0,0,0.3)' : 'none',
            transition: 'all 0.2s ease',
          }}
        >
          <Bookmark size={15} />
          <span>Saved Ideas ({savedItems.length})</span>
        </button>

        <button
          type="button"
          onClick={() => {
            triggerHaptic('light');
            setActiveSubTab('history');
          }}
          style={{
            flex: 1,
            padding: '11px 0',
            borderRadius: 'var(--radius-full)',
            border: 'none',
            background: activeSubTab === 'history' ? 'var(--bg-surface-elevated)' : 'transparent',
            color: activeSubTab === 'history' ? 'var(--accent-gold)' : 'var(--text-muted)',
            fontWeight: 700,
            fontSize: '0.85rem',
            cursor: 'pointer',
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            gap: 7,
            boxShadow: activeSubTab === 'history' ? '0 2px 8px rgba(0,0,0,0.3)' : 'none',
            transition: 'all 0.2s ease',
          }}
        >
          <History size={15} />
          <span>Recent History</span>
        </button>
      </div>

      {/* Tab 1: Saved Collection */}
      {activeSubTab === 'saved' && (
        <div>
          {savedItems.length === 0 ? (
            <div style={{ textAlign: 'center', padding: '50px 20px', color: 'var(--text-muted)' }}>
              <Bookmark size={36} style={{ margin: '0 auto 14px', opacity: 0.3 }} />
              <p style={{ fontSize: '1rem', color: 'var(--text-primary)', marginBottom: 6 }}>No saved discoveries yet</p>
              <p style={{ fontSize: '0.84rem' }}>Tap the bookmark button on any card to save it to your personal library.</p>
            </div>
          ) : (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 12 }}>
              {savedItems.map(d => (
                <div
                  key={d.id}
                  onClick={() => handleItemClick(d)}
                  style={{
                    background: 'var(--bg-surface)',
                    border: '1px solid var(--border-medium)',
                    borderRadius: 'var(--radius-lg)',
                    padding: '18px 20px',
                    cursor: 'pointer',
                    boxShadow: '0 4px 16px rgba(0, 0, 0, 0.2)',
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
                        letterSpacing: '0.06em',
                      }}
                    >
                      {d.type.replace('_', ' ')}
                    </span>

                    <button
                      type="button"
                      onClick={e => handleUnsave(e, d.id)}
                      style={{
                        background: 'rgba(255, 255, 255, 0.05)',
                        border: 'none',
                        borderRadius: '50%',
                        width: 30,
                        height: 30,
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center',
                        color: 'var(--text-muted)',
                        cursor: 'pointer',
                      }}
                      title="Remove from saved"
                    >
                      <Trash2 size={14} />
                    </button>
                  </div>

                  <h3
                    className="font-display"
                    style={{ fontSize: '1.25rem', fontWeight: 700, color: 'var(--text-primary)', marginBottom: 6 }}
                  >
                    {d.title}
                  </h3>

                  <p style={{ fontSize: '0.88rem', color: 'var(--text-secondary)', lineHeight: 1.5 }}>
                    {d.short_description}
                  </p>
                </div>
              ))}
            </div>
          )}
        </div>
      )}

      {/* Tab 2: History Timeline */}
      {activeSubTab === 'history' && (
        <div>
          {(!profile?.recent_history || profile.recent_history.length === 0) ? (
            <div style={{ textAlign: 'center', padding: '50px 20px', color: 'var(--text-muted)' }}>
              <History size={36} style={{ margin: '0 auto 14px', opacity: 0.3 }} />
              <p style={{ fontSize: '1rem', color: 'var(--text-primary)' }}>No recent history recorded yet</p>
            </div>
          ) : (
            <div style={{ display: 'flex', flexDirection: 'column', gap: 10 }}>
              {profile.recent_history.map((h, idx) => (
                <div
                  key={idx}
                  onClick={async () => {
                    const d = await ApiClient.getDiscovery(h.discovery_id);
                    if (d) handleItemClick(d);
                  }}
                  style={{
                    display: 'flex',
                    alignItems: 'center',
                    justifyContent: 'space-between',
                    padding: '14px 18px',
                    background: 'var(--bg-surface)',
                    border: '1px solid var(--border-subtle)',
                    borderRadius: 'var(--radius-md)',
                    cursor: 'pointer',
                    transition: 'all 0.2s ease',
                  }}
                >
                  <div>
                    <div style={{ fontWeight: 600, fontSize: '0.96rem', color: 'var(--text-primary)' }}>
                      {h.title}
                    </div>
                    <div className="font-mono" style={{ fontSize: '0.72rem', color: 'var(--text-muted)', textTransform: 'capitalize' }}>
                      {h.type.replace('_', ' ')}
                    </div>
                  </div>
                  <ArrowRight size={15} color="var(--accent-gold)" />
                </div>
              ))}
            </div>
          )}
        </div>
      )}
    </div>
  );
};
