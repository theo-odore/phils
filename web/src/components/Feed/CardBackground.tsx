import React from 'react';

interface CardBackgroundProps {
  styleName: string;
}

export const CardBackground: React.FC<CardBackgroundProps> = ({ styleName }) => {
  return (
    <div className="absolute inset-0 pointer-events-none overflow-hidden" style={{ zIndex: 0 }}>
      {/* 1. Stoic Stone & Roman Architecture */}
      {styleName === 'stoic_stone' && (
        <>
          <div
            className="absolute -top-32 -right-32 w-[420px] h-[420px] rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(229, 169, 60, 0.22) 0%, rgba(229, 169, 60, 0) 70%)',
              filter: 'blur(40px)',
            }}
          />
          <div
            className="absolute bottom-1/4 -left-28 w-80 h-80 rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(160, 140, 100, 0.12) 0%, transparent 70%)',
              filter: 'blur(30px)',
            }}
          />
          {/* Subtle Roman Sundial Rings */}
          <div
            className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 w-[520px] h-[520px] rounded-full border border-white/5 opacity-40 pointer-events-none"
            style={{ transform: 'translate(-50%, -50%) rotate(45deg)' }}
          >
            <div className="absolute inset-10 rounded-full border border-dashed border-white/5" />
            <div className="absolute inset-24 rounded-full border border-white/5" />
          </div>
        </>
      )}

      {/* 2. Cosmic Abyss & Fermi Silence */}
      {(styleName === 'cosmic_abyss' || styleName === 'filter_cosmic' || styleName === 'alpine_abyss') && (
        <>
          <div
            className="absolute -top-20 -left-20 w-[440px] h-[440px] rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(96, 165, 250, 0.18) 0%, transparent 65%)',
              filter: 'blur(40px)',
            }}
          />
          <div
            className="absolute bottom-10 right-0 w-80 h-80 rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(168, 85, 247, 0.14) 0%, transparent 70%)',
              filter: 'blur(30px)',
            }}
          />
          {/* Subtle Constellation Grid */}
          <div
            className="absolute inset-0 opacity-25"
            style={{
              backgroundImage: 'radial-gradient(rgba(255, 255, 255, 0.25) 1px, transparent 1px)',
              backgroundSize: '36px 36px',
            }}
          />
        </>
      )}

      {/* 3. Absurdist Vortex & Existential Shadow */}
      {(styleName === 'absurdist_vortex' || styleName === 'existential_shadow') && (
        <>
          <div
            className="absolute top-1/3 -right-24 w-[420px] h-[420px] rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(239, 68, 68, 0.18) 0%, transparent 65%)',
              filter: 'blur(35px)',
            }}
          />
          <div
            className="absolute bottom-12 left-6 w-80 h-80 rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(245, 158, 11, 0.12) 0%, transparent 70%)',
              filter: 'blur(35px)',
            }}
          />
        </>
      )}

      {/* 4. Taoist Flow & Zen Garden */}
      {(styleName === 'taoist_flow' || styleName === 'wabi_sabi_ceramics' || styleName === 'epicurean_garden') && (
        <>
          <div
            className="absolute -top-14 right-4 w-[400px] h-[400px] rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(16, 185, 129, 0.18) 0%, transparent 65%)',
              filter: 'blur(40px)',
            }}
          />
          <div
            className="absolute -bottom-16 -left-16 w-[420px] h-[420px] rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(20, 184, 166, 0.12) 0%, transparent 70%)',
              filter: 'blur(40px)',
            }}
          />
        </>
      )}

      {/* 5. Paradox Timber & Trolley Tracks */}
      {(styleName === 'paradox_timber' || styleName === 'trolley_tracks' || styleName === 'clockwork_gears') && (
        <>
          <div
            className="absolute top-10 left-6 w-[380px] h-[380px] rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(168, 85, 247, 0.16) 0%, transparent 65%)',
              filter: 'blur(35px)',
            }}
          />
          <div
            className="absolute -bottom-10 right-4 w-80 h-80 rounded-full"
            style={{
              background: 'radial-gradient(circle, rgba(236, 72, 153, 0.12) 0%, transparent 70%)',
              filter: 'blur(35px)',
            }}
          />
        </>
      )}

      {/* Ambient Vignette & Scrims */}
      <div className="card-ambient-aura" />
      <div className="card-scrim-top" />
      <div className="card-scrim-bottom" />
    </div>
  );
};
