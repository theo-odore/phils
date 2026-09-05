import React, { useState, useEffect } from 'react';
import { Discovery, TabType } from './types';
import { ApiClient } from './services/api';
import { OfflineCache } from './services/offlineCache';
import { FeedContainer } from './components/Feed/FeedContainer';
import { DetailPage } from './components/Detail/DetailPage';
import { SearchView } from './components/Search/SearchView';
import { ProfileView } from './components/Profile/ProfileView';
import { BottomBar } from './components/Navigation/BottomBar';
import { WhyReasonModal } from './components/Feed/WhyReasonModal';

export const App: React.FC = () => {
  const [activeTab, setActiveTab] = useState<TabType>('feed');
  const [discoveries, setDiscoveries] = useState<Discovery[]>([]);
  const [selectedDiscovery, setSelectedDiscovery] = useState<Discovery | null>(null);
  const [whyDiscovery, setWhyDiscovery] = useState<Discovery | null>(null);
  const [isDarkTheme, setIsDarkTheme] = useState<boolean>(true);
  const [loading, setLoading] = useState<boolean>(true);

  // Initialize offline cache and fetch initial feed
  useEffect(() => {
    OfflineCache.init();

    const savedTheme = localStorage.getItem('phils_theme');
    if (savedTheme === 'light') {
      setIsDarkTheme(false);
      document.body.classList.add('light-theme');
    }

    const loadFeed = async () => {
      setLoading(true);
      const items = await ApiClient.getFeed(20);
      setDiscoveries(items);
      setLoading(false);
    };

    loadFeed();
  }, []);

  const handleToggleTheme = () => {
    setIsDarkTheme(prev => {
      const next = !prev;
      if (next) {
        document.body.classList.remove('light-theme');
        localStorage.setItem('phils_theme', 'dark');
      } else {
        document.body.classList.add('light-theme');
        localStorage.setItem('phils_theme', 'light');
      }
      return next;
    });
  };

  const handleToggleSave = async (d: Discovery) => {
    const isNowSaved = await ApiClient.toggleSave(d.id);
    setDiscoveries(prev =>
      prev.map(item => (item.id === d.id ? { ...item, saved: isNowSaved } : item))
    );
    if (selectedDiscovery && selectedDiscovery.id === d.id) {
      setSelectedDiscovery({ ...selectedDiscovery, saved: isNowSaved });
    }
  };

  const handleExplore = (d: Discovery) => {
    setSelectedDiscovery(d);
  };

  const handleNavigateToDiscovery = async (id: string) => {
    const d = await ApiClient.getDiscovery(id);
    if (d) {
      setSelectedDiscovery(d);
    }
  };

  const handleViewRecord = (id: string) => {
    ApiClient.recordView(id);
  };

  return (
    <div className="app-container">
      {/* 1. Detail Page Overlay */}
      {selectedDiscovery && (
        <DetailPage
          discovery={selectedDiscovery}
          onBack={() => setSelectedDiscovery(null)}
          onNavigateToDiscovery={handleNavigateToDiscovery}
          onToggleSave={handleToggleSave}
        />
      )}

      {/* 2. Main Tabs */}
      {!selectedDiscovery && (
        <>
          {activeTab === 'feed' && (
            loading ? (
              <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', justifyContent: 'center', height: '100%', color: 'var(--text-muted)' }}>
                <div className="font-display" style={{ fontSize: '1.25rem', color: 'var(--accent-gold)', marginBottom: 8 }}>
                  PHILS
                </div>
                <div style={{ fontSize: '0.85rem' }}>Discovering ideas...</div>
              </div>
            ) : (
              <FeedContainer
                discoveries={discoveries}
                onExplore={handleExplore}
                onToggleSave={handleToggleSave}
                onShowWhy={setWhyDiscovery}
                onViewRecord={handleViewRecord}
              />
            )
          )}

          {activeTab === 'search' && (
            <SearchView
              onSelectDiscovery={d => {
                setSelectedDiscovery(d);
              }}
            />
          )}

          {activeTab === 'profile' && (
            <ProfileView
              onSelectDiscovery={d => {
                setSelectedDiscovery(d);
              }}
              isDarkTheme={isDarkTheme}
              onToggleTheme={handleToggleTheme}
            />
          )}

          {/* 3. Bottom Navigation Bar */}
          <BottomBar currentTab={activeTab} onChangeTab={setActiveTab} />
        </>
      )}

      {/* 4. Why Am I Seeing This Modal */}
      <WhyReasonModal discovery={whyDiscovery} onClose={() => setWhyDiscovery(null)} />
    </div>
  );
};
export default App;
