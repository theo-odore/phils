import { Haptics, ImpactStyle } from '@capacitor/haptics';

export const triggerHaptic = async (style: 'light' | 'medium' | 'heavy' = 'light') => {
  try {
    const impact =
      style === 'heavy'
        ? ImpactStyle.Heavy
        : style === 'medium'
        ? ImpactStyle.Medium
        : ImpactStyle.Light;

    await Haptics.impact({ style: impact });
  } catch {
    // Fallback to web navigator vibration if on mobile browser
    if (typeof navigator !== 'undefined' && 'vibrate' in navigator) {
      navigator.vibrate(style === 'heavy' ? 25 : style === 'medium' ? 15 : 8);
    }
  }
};
