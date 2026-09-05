import React, { useRef, useEffect } from 'react';
import { Discovery } from '../../types';
import { FeedCard } from './FeedCard';
import { triggerHaptic } from '../../services/haptics';

interface FeedContainerProps {
  discoveries: Discovery[];
  onExplore: (discovery: Discovery) => void;
  onToggleSave: (discovery: Discovery) => void;
  onShowWhy: (discovery: Discovery) => void;
  onViewRecord: (discoveryId: string) => void;
}

export const FeedContainer: React.FC<FeedContainerProps> = ({
  discoveries,
  onExplore,
  onToggleSave,
  onShowWhy,
  onViewRecord,
}) => {
  const containerRef = useRef<HTMLDivElement>(null);
  const recordedViewsRef = useRef<Set<string>>(new Set());

  // IntersectionObserver to record view events when a card is 70% visible
  useEffect(() => {
    const container = containerRef.current;
    if (!container) return;

    const cards = container.querySelectorAll('.feed-card-item');

    const observer = new IntersectionObserver(
      entries => {
        entries.forEach(entry => {
          if (entry.isIntersecting) {
            const index = Number(entry.target.getAttribute('data-index'));
            const item = discoveries[index];
            if (item && !recordedViewsRef.current.has(item.id)) {
              recordedViewsRef.current.add(item.id);
              onViewRecord(item.id);
              triggerHaptic('light');
            }
          }
        });
      },
      {
        root: container,
        threshold: 0.7,
      }
    );

    cards.forEach(card => observer.observe(card));

    return () => {
      observer.disconnect();
    };
  }, [discoveries, onViewRecord]);

  // Keyboard navigation support
  useEffect(() => {
    const handleKeyDown = (e: KeyboardEvent) => {
      const container = containerRef.current;
      if (!container) return;

      const cardHeight = container.clientHeight;
      if (e.key === 'ArrowDown' || e.key === 'PageDown' || e.key === 'j') {
        container.scrollBy({ top: cardHeight, behavior: 'smooth' });
      } else if (e.key === 'ArrowUp' || e.key === 'PageUp' || e.key === 'k') {
        container.scrollBy({ top: -cardHeight, behavior: 'smooth' });
      }
    };

    window.addEventListener('keydown', handleKeyDown);
    return () => window.removeEventListener('keydown', handleKeyDown);
  }, []);

  return (
    <div className="feed-scroller" ref={containerRef}>
      {discoveries.map((discovery, index) => (
        <div key={discovery.id} data-index={index} style={{ height: '100%' }}>
          <FeedCard
            discovery={discovery}
            onExplore={onExplore}
            onToggleSave={onToggleSave}
            onShowWhy={onShowWhy}
          />
        </div>
      ))}
    </div>
  );
};
