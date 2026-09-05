export const triggerHaptic = (style: 'light' | 'medium' | 'heavy' = 'light') => {
  try {
    if (typeof navigator !== 'undefined' && 'vibrate' in navigator) {
      navigator.vibrate(style === 'heavy' ? 25 : style === 'medium' ? 15 : 8);
    }
  } catch {
    // Ignore vibration errors on unsupported environments
  }
};
