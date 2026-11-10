import { Discovery } from '../types';

export function renderWebReaderHtml(discovery: Discovery): string {
  const principlesHtml = (discovery.core_principles || [])
    .map((p, idx) => `
      <div class="principle-item">
        <span class="principle-number">${idx + 1}</span>
        <p class="principle-text">${escapeHtml(p)}</p>
      </div>
    `)
    .join('');

  const keyPeopleHtml = (discovery.key_people || [])
    .map(person => `
      <div class="person-card">
        <div class="person-header">
          <strong class="person-name">${escapeHtml(person.name)}</strong>
          ${person.era ? `<span class="person-era">${escapeHtml(person.era)}</span>` : ''}
        </div>
        ${person.role ? `<div class="person-role">${escapeHtml(person.role)}</div>` : ''}
        ${person.quote ? `<blockquote class="person-quote">"${escapeHtml(person.quote)}"</blockquote>` : ''}
      </div>
    `)
    .join('');

  const typeLabel = (discovery.type || 'idea').replace(/_/g, ' ').toUpperCase();

  return `<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${escapeHtml(discovery.title)} - Phils</title>
  <meta name="description" content="${escapeHtml(discovery.hook)}">
  
  <!-- Open Graph & Social Cards -->
  <meta property="og:title" content="${escapeHtml(discovery.title)} - Phils">
  <meta property="og:description" content="${escapeHtml(discovery.hook)}">
  <meta property="og:type" content="article">
  <meta property="og:site_name" content="Phils">
  <meta name="twitter:card" content="summary">
  <meta name="twitter:title" content="${escapeHtml(discovery.title)} - Phils">
  <meta name="twitter:description" content="${escapeHtml(discovery.hook)}">

  <style>
    :root {
      --bg: #0B0E14;
      --card-bg: #141A23;
      --card-border: rgba(255, 255, 255, 0.08);
      --accent: #E5A93C;
      --accent-soft: rgba(229, 169, 60, 0.12);
      --text-primary: #F0F4F8;
      --text-secondary: #94A3B8;
      --text-muted: #64748B;
      --font-serif: "Georgia", "Cambria", "Times New Roman", serif;
      --font-sans: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
    }

    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
      background-color: var(--bg);
      color: var(--text-primary);
      font-family: var(--font-sans);
      line-height: 1.65;
      padding: 0 16px 60px 16px;
      -webkit-font-smoothing: antialiased;
    }

    .container {
      max-width: 680px;
      margin: 0 auto;
    }

    /* Top Navigation */
    .nav-bar {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 20px 0 24px 0;
      border-bottom: 1px solid var(--card-border);
      margin-bottom: 32px;
    }

    .brand {
      font-family: var(--font-serif);
      font-size: 26px;
      font-style: italic;
      color: var(--text-primary);
      text-decoration: none;
      letter-spacing: -0.5px;
    }

    .open-app-btn {
      display: inline-flex;
      align-items: center;
      background-color: var(--accent);
      color: #0B0E14;
      font-size: 13px;
      font-weight: 600;
      padding: 8px 16px;
      border-radius: 999px;
      text-decoration: none;
      transition: opacity 0.2s ease;
    }

    .open-app-btn:hover {
      opacity: 0.9;
    }

    /* Hero Card Section */
    .hero-card {
      background: var(--card-bg);
      border: 1px solid var(--card-border);
      border-radius: 20px;
      padding: 32px 28px;
      margin-bottom: 36px;
      position: relative;
    }

    .eyebrow {
      font-size: 11px;
      font-family: monospace;
      font-weight: 600;
      letter-spacing: 2px;
      color: var(--accent);
      text-transform: uppercase;
      margin-bottom: 16px;
      display: block;
    }

    .hook {
      font-family: var(--font-serif);
      font-size: 26px;
      line-height: 1.35;
      color: var(--text-primary);
      font-weight: 700;
      margin-bottom: 20px;
    }

    .title {
      font-family: var(--font-serif);
      font-size: 20px;
      color: var(--accent);
      font-weight: 600;
      margin-bottom: 14px;
    }

    .short-desc {
      font-size: 16px;
      line-height: 1.6;
      color: var(--text-secondary);
    }

    /* Content Sections */
    .section-title {
      font-family: var(--font-serif);
      font-size: 20px;
      font-weight: 700;
      color: var(--text-primary);
      margin: 36px 0 16px 0;
      letter-spacing: -0.3px;
    }

    .paragraph {
      font-size: 15.5px;
      line-height: 1.7;
      color: var(--text-secondary);
      margin-bottom: 16px;
    }

    /* Principles List */
    .principles-list {
      display: flex;
      flex-direction: column;
      gap: 12px;
      margin-top: 14px;
    }

    .principle-item {
      display: flex;
      align-items: flex-start;
      gap: 14px;
      background: rgba(255, 255, 255, 0.02);
      border: 1px solid var(--card-border);
      border-radius: 12px;
      padding: 14px 16px;
    }

    .principle-number {
      font-family: monospace;
      font-size: 12px;
      font-weight: 700;
      color: var(--accent);
      background: var(--accent-soft);
      padding: 4px 8px;
      border-radius: 6px;
      flex-shrink: 0;
    }

    .principle-text {
      font-size: 14.5px;
      color: var(--text-secondary);
      line-height: 1.55;
    }

    /* Everyday Example Box */
    .example-box {
      background: rgba(229, 169, 60, 0.06);
      border-left: 3px solid var(--accent);
      border-radius: 0 12px 12px 0;
      padding: 18px 20px;
      margin: 18px 0;
    }

    .example-box p {
      font-size: 15px;
      color: var(--text-primary);
      font-style: italic;
      line-height: 1.6;
    }

    /* Key People */
    .people-grid {
      display: grid;
      grid-template-columns: 1fr;
      gap: 14px;
      margin-top: 14px;
    }

    @media (min-width: 540px) {
      .people-grid {
        grid-template-columns: 1fr 1fr;
      }
    }

    .person-card {
      background: var(--card-bg);
      border: 1px solid var(--card-border);
      border-radius: 14px;
      padding: 18px;
    }

    .person-header {
      display: flex;
      justify-content: space-between;
      align-items: baseline;
      margin-bottom: 4px;
    }

    .person-name {
      font-size: 15px;
      color: var(--text-primary);
      font-weight: 600;
    }

    .person-era {
      font-size: 12px;
      color: var(--text-muted);
      font-family: monospace;
    }

    .person-role {
      font-size: 12.5px;
      color: var(--accent);
      margin-bottom: 10px;
    }

    .person-quote {
      font-family: var(--font-serif);
      font-size: 13.5px;
      font-style: italic;
      color: var(--text-secondary);
      line-height: 1.45;
      border-left: 2px solid rgba(255, 255, 255, 0.1);
      padding-left: 10px;
      margin-top: 8px;
    }

    /* Footer */
    .footer {
      text-align: center;
      margin-top: 50px;
      padding-top: 30px;
      border-top: 1px solid var(--card-border);
      color: var(--text-muted);
      font-size: 13px;
    }

    .footer a {
      color: var(--accent);
      text-decoration: none;
    }
  </style>
</head>
<body>
  <div class="container">
    <header class="nav-bar">
      <a href="/" class="brand">Phils</a>
      <a href="phils://discovery/${escapeHtml(discovery.id)}" class="open-app-btn">Open in Phils App</a>
    </header>

    <main>
      <div class="hero-card">
        <span class="eyebrow">${escapeHtml(typeLabel)}</span>
        <h1 class="hook">"${escapeHtml(discovery.hook)}"</h1>
        <h2 class="title">${escapeHtml(discovery.title)}</h2>
        <p class="short-desc">${escapeHtml(discovery.short_description || '')}</p>
      </div>

      ${discovery.section_what_is_this ? `
        ${discovery.section_what_is_this.central_question ? `
          <div class="example-box" style="margin-bottom: 28px; border-left-color: var(--accent);">
            <div style="font-family: monospace; font-size: 11px; font-weight: 700; color: var(--accent); letter-spacing: 1px; margin-bottom: 6px;">CENTRAL QUESTION</div>
            <p style="font-size: 17px; font-family: var(--font-serif); font-style: italic; color: var(--text-primary);">${escapeHtml(discovery.section_what_is_this.central_question)}</p>
          </div>
        ` : ''}

        <h3 class="section-title">What is ${escapeHtml(discovery.title)}?</h3>
        <p class="paragraph">${escapeHtml(discovery.section_what_is_this.summary)}</p>

        ${discovery.section_what_is_this.how_it_works ? `
          <h4 style="font-size: 16px; color: var(--text-primary); margin: 20px 0 8px 0; font-family: var(--font-serif);">How It Works</h4>
          <p class="paragraph">${escapeHtml(discovery.section_what_is_this.how_it_works)}</p>
        ` : ''}

        ${discovery.section_what_is_this.introductory_example ? `
          <div class="example-box">
            <div style="font-family: monospace; font-size: 10.5px; font-weight: 700; color: var(--accent); margin-bottom: 4px;">INTRODUCTORY EXAMPLE</div>
            <p>${escapeHtml(discovery.section_what_is_this.introductory_example)}</p>
          </div>
        ` : ''}

        ${discovery.section_what_is_this.misconceptions && discovery.section_what_is_this.misconceptions.length > 0 ? `
          <div style="background: rgba(255,255,255,0.02); border: 1px solid var(--card-border); border-radius: 12px; padding: 16px 20px; margin: 20px 0;">
            <div style="font-family: monospace; font-size: 11px; font-weight: 700; color: var(--accent); letter-spacing: 1px; margin-bottom: 8px;">COMMON MISCONCEPTIONS</div>
            ${discovery.section_what_is_this.misconceptions.map(m => `
              <div style="font-size: 13.5px; color: var(--text-secondary); margin-bottom: 6px;">✕ ${escapeHtml(m)}</div>
            `).join('')}
          </div>
        ` : ''}
      ` : (discovery.detailed_description ? `
        <h3 class="section-title">The Core Idea</h3>
        <p class="paragraph">${escapeHtml(discovery.detailed_description)}</p>
      ` : '')}

      ${discovery.section_origin_context ? `
        <h3 class="section-title">Origin & Historical Context</h3>
        ${discovery.section_origin_context.era_and_location ? `
          <div style="display: inline-block; font-family: monospace; font-size: 11px; background: rgba(255,255,255,0.04); border: 1px solid var(--card-border); border-radius: 999px; padding: 4px 12px; margin-bottom: 12px; color: var(--accent);">📍 ${escapeHtml(discovery.section_origin_context.era_and_location)}</div>
        ` : ''}
        <p class="paragraph">${escapeHtml(discovery.section_origin_context.summary)}</p>

        ${discovery.section_origin_context.historical_circumstances ? `
          <h4 style="font-size: 16px; color: var(--text-primary); margin: 18px 0 8px 0; font-family: var(--font-serif);">Historical Circumstances</h4>
          <p class="paragraph">${escapeHtml(discovery.section_origin_context.historical_circumstances)}</p>
        ` : ''}

        ${discovery.section_origin_context.motivating_problem ? `
          <div class="example-box">
            <div style="font-family: monospace; font-size: 10.5px; font-weight: 700; color: var(--accent); margin-bottom: 4px;">THE MOTIVATING CRISIS</div>
            <p>${escapeHtml(discovery.section_origin_context.motivating_problem)}</p>
          </div>
        ` : ''}

        ${discovery.section_origin_context.historical_legacy ? `
          <h4 style="font-size: 16px; color: var(--text-primary); margin: 18px 0 8px 0; font-family: var(--font-serif);">Legacy & Influence Today</h4>
          <p class="paragraph">${escapeHtml(discovery.section_origin_context.historical_legacy)}</p>
        ` : ''}
      ` : (discovery.origin_context ? `
        <h3 class="section-title">Historical Origin & Context</h3>
        <p class="paragraph">${escapeHtml(discovery.origin_context)}</p>
      ` : '')}

      ${discovery.section_core_principles && discovery.section_core_principles.length > 0 ? `
        <h3 class="section-title">Core Principles</h3>
        <div class="principles-list">
          ${discovery.section_core_principles.map((p, idx) => `
            <div class="principle-item" style="flex-direction: column; gap: 8px;">
              <div style="display: flex; align-items: center; gap: 10px;">
                <span class="principle-number">${idx + 1}</span>
                <strong style="font-size: 16px; font-family: var(--font-serif); color: var(--text-primary);">${escapeHtml(p.name)}</strong>
              </div>
              <p class="principle-text" style="margin-top: 4px;">${escapeHtml(p.explanation)}</p>
              ${p.reasoning ? `<div style="font-size: 13px; color: var(--text-secondary); line-height: 1.5;"><strong>Reasoning:</strong> ${escapeHtml(p.reasoning)}</div>` : ''}
              ${p.example ? `<div style="background: rgba(229,169,60,0.06); padding: 8px 12px; border-radius: 8px; font-size: 13px; color: var(--text-primary); margin-top: 4px;"><strong>Example:</strong> ${escapeHtml(p.example)}</div>` : ''}
            </div>
          `).join('')}
        </div>
      ` : (discovery.core_principles && discovery.core_principles.length > 0 ? `
        <h3 class="section-title">Core Principles</h3>
        <div class="principles-list">
          ${principlesHtml}
        </div>
      ` : '')}

      ${discovery.section_critical_perspectives ? `
        <h3 class="section-title">Critical Perspectives & Debates</h3>
        <div style="background: var(--card-bg); border: 1px solid var(--card-border); border-radius: 14px; padding: 20px; margin: 16px 0;">
          ${discovery.section_critical_perspectives.proponent_arguments ? `
            <div style="margin-bottom: 16px;">
              <div style="font-family: monospace; font-size: 11px; font-weight: 700; color: var(--accent); letter-spacing: 1px; margin-bottom: 4px;">WHAT PROPONENTS ARGUE</div>
              <p style="font-size: 14px; color: var(--text-secondary); line-height: 1.6;">${escapeHtml(discovery.section_critical_perspectives.proponent_arguments)}</p>
            </div>
          ` : ''}
          ${discovery.section_critical_perspectives.critic_arguments ? `
            <div style="border-top: 1px solid var(--card-border); padding-top: 14px;">
              <div style="font-family: monospace; font-size: 11px; font-weight: 700; color: var(--text-muted); letter-spacing: 1px; margin-bottom: 4px;">WHAT CRITICS ARGUE</div>
              <p style="font-size: 14px; color: var(--text-secondary); line-height: 1.6;">${escapeHtml(discovery.section_critical_perspectives.critic_arguments)}</p>
            </div>
          ` : ''}
        </div>
      ` : ''}

      ${discovery.section_key_thinkers && discovery.section_key_thinkers.length > 0 ? `
        <h3 class="section-title">Key Thinkers & Figures</h3>
        <div class="people-grid">
          ${discovery.section_key_thinkers.map(t => `
            <div class="person-card">
              <div class="person-header">
                <strong class="person-name">${escapeHtml(t.name)}</strong>
                ${t.era ? `<span class="person-era">${escapeHtml(t.era)}</span>` : ''}
              </div>
              ${t.role ? `<div class="person-role">${escapeHtml(t.role)}</div>` : ''}
              ${t.biographical_context ? `<div style="font-size: 13px; color: var(--text-secondary); margin-bottom: 8px;">${escapeHtml(t.biographical_context)}</div>` : ''}
              ${t.specific_contribution ? `<div style="font-size: 12.5px; color: var(--text-primary); margin-bottom: 8px;"><strong>Contribution:</strong> ${escapeHtml(t.specific_contribution)}</div>` : ''}
              ${t.quote ? `<blockquote class="person-quote">"${escapeHtml(t.quote)}"</blockquote>` : ''}
            </div>
          `).join('')}
        </div>
      ` : (discovery.key_people && discovery.key_people.length > 0 ? `
        <h3 class="section-title">Key Thinkers & Figures</h3>
        <div class="people-grid">
          ${keyPeopleHtml}
        </div>
      ` : '')}

      ${discovery.section_everyday_life ? `
        <h3 class="section-title">In Everyday Life</h3>
        <p class="paragraph">${escapeHtml(discovery.section_everyday_life.summary)}</p>
        ${(discovery.section_everyday_life.scenarios || []).map(sc => `
          <div style="background: var(--card-bg); border: 1px solid var(--card-border); border-radius: 14px; padding: 18px; margin: 14px 0;">
            <strong style="font-size: 15.5px; font-family: var(--font-serif); color: var(--text-primary); display: block; margin-bottom: 6px;">${escapeHtml(sc.title)}</strong>
            <p style="font-size: 13.5px; color: var(--text-secondary); font-style: italic; margin-bottom: 12px;">${escapeHtml(sc.context)}</p>
            ${(sc.application_steps || []).map((step, sIdx) => `
              <div style="display: flex; gap: 8px; font-size: 13px; color: var(--text-secondary); margin-bottom: 6px;">
                <span style="font-family: monospace; color: var(--accent); font-weight: 700;">${sIdx + 1}.</span>
                <span>${escapeHtml(step)}</span>
              </div>
            `).join('')}
          </div>
        `).join('')}
      ` : (discovery.everyday_example ? `
        <h3 class="section-title">In Everyday Life</h3>
        <div class="example-box">
          <p>"${escapeHtml(discovery.everyday_example)}"</p>
        </div>
      ` : '')}

      ${discovery.section_connected_ideas && discovery.section_connected_ideas.length > 0 ? `
        <h3 class="section-title">Connected Ideas</h3>
        <div style="display: flex; flex-direction: column; gap: 12px; margin-top: 14px;">
          ${discovery.section_connected_ideas.map(ci => `
            <div style="background: var(--card-bg); border: 1px solid var(--card-border); border-radius: 12px; padding: 16px;">
              <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 6px;">
                <span style="font-family: monospace; font-size: 10.5px; color: var(--accent); letter-spacing: 1px;">${escapeHtml(ci.type)}</span>
                ${ci.relationship_type ? `<span style="font-size: 11px; background: rgba(229,169,60,0.1); color: var(--accent); padding: 2px 8px; border-radius: 999px;">${escapeHtml(ci.relationship_type)}</span>` : ''}
              </div>
              <strong style="font-size: 16px; font-family: var(--font-serif); color: var(--text-primary); display: block; margin-bottom: 4px;">${escapeHtml(ci.title)}</strong>
              <p style="font-size: 13.5px; color: var(--text-secondary); line-height: 1.5;">${escapeHtml(ci.explanation)}</p>
            </div>
          `).join('')}
        </div>
      ` : ''}
    </main>

    <footer class="footer">
      <p>Discover ideas worth thinking about on <strong>Phils</strong>.</p>
    </footer>
  </div>
</body>
</html>`;
}

function escapeHtml(text: string): string {
  if (!text) return '';
  return text
    .replace(/&/g, '&amp;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;')
    .replace(/"/g, '&quot;')
    .replace(/'/g, '&#039;');
}
