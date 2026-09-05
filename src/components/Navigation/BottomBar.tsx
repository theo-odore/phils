import React from 'react';
import { Compass, Search, User } from 'lucide-react';
import { TabType } from '../../types';
import { triggerHaptic } from '../../services/haptics';

interface BottomBarProps {
  currentTab: TabType;
  onChangeTab: (tab: TabType) => void;
}

export const BottomBar: React.FC<BottomBarProps> = ({ currentTab, onChangeTab }) => {
  const handleTabClick = (tab: TabType) => {
    triggerHaptic('light');
    onChangeTab(tab);
  };

  return (
    <div className="bottom-nav-wrapper">
      <nav className="bottom-nav">
        <button
          type="button"
          id="nav-tab-feed"
          className={`nav-tab-btn ${currentTab === 'feed' ? 'active' : ''}`}
          onClick={() => handleTabClick('feed')}
          aria-label="Discovery Feed"
        >
          <Compass size={21} color={currentTab === 'feed' ? 'var(--accent-gold)' : 'currentColor'} />
          <span>Feed</span>
        </button>

        <button
          type="button"
          id="nav-tab-search"
          className={`nav-tab-btn ${currentTab === 'search' ? 'active' : ''}`}
          onClick={() => handleTabClick('search')}
          aria-label="Search Ideas"
        >
          <Search size={21} color={currentTab === 'search' ? 'var(--accent-gold)' : 'currentColor'} />
          <span>Search</span>
        </button>

        <button
          type="button"
          id="nav-tab-profile"
          className={`nav-tab-btn ${currentTab === 'profile' ? 'active' : ''}`}
          onClick={() => handleTabClick('profile')}
          aria-label="Journey and Saved"
        >
          <User size={21} color={currentTab === 'profile' ? 'var(--accent-gold)' : 'currentColor'} />
          <span>Journey</span>
        </button>
      </nav>
    </div>
  );
};
