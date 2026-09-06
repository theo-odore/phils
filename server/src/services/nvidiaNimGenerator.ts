import { Discovery, DiscoveryType } from '../types';

const NVIDIA_API_URL = 'https://integrate.api.nvidia.com/v1/chat/completions';

// Procedural fallback topics to guarantee instantaneous responses if API is offline or rate-limited
const PROCEDURAL_CONCEPTS: Array<{
  id: string;
  title: string;
  type: DiscoveryType;
  hook: string;
  short_description: string;
  detailed_description: string;
  origin_context: string;
  core_principles: string[];
  everyday_example: string;
  background_style: string;
  key_people: Array<{ name: string; role: string; era: string; quote: string }>;
}> = [
  {
    id: 'allegory-of-the-cave',
    title: "Plato's Allegory of the Cave",
    type: 'thought_experiment',
    hook: 'WHAT IF EVERYTHING YOU SEE IS ONLY A SHADOW ON A WALL?',
    short_description: 'A foundational allegory examining human ignorance and the painful journey toward objective truth.',
    detailed_description: 'Prisoners are chained inside a dark cave from childhood, seeing only shadows of puppets cast by a fire behind them. They believe these shadows are absolute reality. When one prisoner escapes into the sunlight, the blinding light hurts his eyes, but he finally discovers the true source of all things. When he returns to free the others, they ridicule him and want to kill him.',
    origin_context: 'Written by Plato in Book VII of The Republic, around 375 BC.',
    core_principles: [
      'The Illusion of Senses: Physical sensations can deceive us into mistaking appearances for reality.',
      'The Pain of Awakening: True education and philosophical insight require painful disillusionment.',
      'The Philosopher’s Burden: Those who see the truth have an ethical obligation to return and enlighten others.'
    ],
    everyday_example: 'Living in an echo chamber on social media where outrage and memes form your entire view of the world, until you step outside and discover that reality is vastly more nuanced.',
    background_style: 'indigo_void',
    key_people: [
      { name: 'Plato', role: 'Classical Greek Philosopher', era: '428–348 BC', quote: 'We can easily forgive a child who is afraid of the dark; the real tragedy of life is when men are afraid of the light.' },
      { name: 'Socrates', role: 'Teacher & Protagonist', era: '470–399 BC', quote: 'The unexamined life is not worth living.' }
    ]
  },
  {
    id: 'chinese-room',
    title: 'The Chinese Room Argument',
    type: 'thought_experiment',
    hook: 'CAN A COMPUTER THAT SPEAKS PERFECTLY EVER ACTUALLY UNDERSTAND WHAT IT SAYS?',
    short_description: 'John Searle’s classic thought experiment distinguishing syntax (rule-following) from semantics (true understanding).',
    detailed_description: 'Imagine an English speaker locked in a room with an exhaustive rulebook for translating Chinese characters. Chinese questions slide under the door; the person follows the rulebook, matches characters, and outputs perfect Chinese answers. To people outside, the room appears fluent in Chinese. Yet the person inside does not understand a single word. Searle argues that computers operate the same way: manipulating symbols without conscious comprehension.',
    origin_context: 'Formulated by philosopher John Searle in 1980 to refute strong Artificial Intelligence claims.',
    core_principles: [
      'Syntax vs Semantics: Following formal symbolic rules is fundamentally different from understanding meaning.',
      'Simulation is Not Duplication: A computer simulation of a brain thinking is no more alive than a weather simulation is wet.',
      'Intentionality of Mind: Genuine consciousness requires subjective mental states, not just computational processing.'
    ],
    everyday_example: 'Copy-pasting phrases from a foreign translation app into an email: the recipient receives fluent text, but your brain remains completely oblivious to the meaning of the characters.',
    background_style: 'sage_paper',
    key_people: [
      { name: 'John Searle', role: 'American Philosopher of Mind', era: '1932–present', quote: 'You cannot get semantics from syntax alone.' }
    ]
  },
  {
    id: 'veil-of-ignorance',
    title: 'The Veil of Ignorance',
    type: 'concept',
    hook: 'WHAT RULES WOULD YOU CHOOSE IF YOU DID NOT KNOW WHO YOU WOULD BE BORN AS?',
    short_description: 'A revolutionary thought experiment in political justice designed by John Rawls.',
    detailed_description: 'To design a truly fair society, imagine you and others must agree on its fundamental economic and social rules behind a "veil of ignorance". You do not know your race, gender, intelligence, wealth, physical health, or social class in the upcoming society. Under this condition, self-interest compels everyone to design a world that protects the most vulnerable, because you might wake up as the poorest person.',
    origin_context: 'Proposed by American philosopher John Rawls in his 1971 landmark book A Theory of Justice.',
    core_principles: [
      'Impartiality as Fairness: Removing personal bias produces objectively moral principles of justice.',
      'The Difference Principle: Social inequalities are only permissible if they work to the maximum benefit of the least advantaged.',
      'Universal Equal Liberty: Every individual has an irrevocable right to the broadest system of equal basic liberties.'
    ],
    everyday_example: 'When two siblings split the last slice of cake: one cuts the slice, and the other gets first pick. The cutter is forced to make both halves exactly equal because they don’t know which piece they will receive.',
    background_style: 'terracotta_sun',
    key_people: [
      { name: 'John Rawls', role: 'Political Philosopher', era: '1921–2002', quote: 'Justice is the first virtue of social institutions, as truth is of systems of thought.' }
    ]
  },
  {
    id: 'buridans-ass',
    title: "Buridan's Ass",
    type: 'paradox',
    hook: 'CAN A PERFECTLY RATIONAL BEING STARVE TO DEATH FROM INDECISION?',
    short_description: 'A paradox exploring free will, decision paralysis, and the trap of equal rational choices.',
    detailed_description: 'A donkey that is equally hungry and thirsty is placed precisely halfway between a pile of fresh hay and a bucket of clean water. Since both choices are equally compelling and no rational reason exists to pick one before the other, a purely rational agent has no basis for deciding which way to turn first. Paralyzed by symmetry, the donkey dies of hunger and thirst.',
    origin_context: 'Attributed to 14th-century French philosopher Jean Buridan, satirizing strict rational determinism.',
    core_principles: [
      'Analysis Paralysis: Absolute rationality without arbitrary decision heuristics leads to catastrophic inaction.',
      'The Need for Randomness: Living agents require non-rational impulse or random symmetry-breaking to survive.',
      'Critique of Determinism: Demonstrates that humans possess will beyond strict mechanical cause-and-effect.'
    ],
    everyday_example: 'Spending 45 minutes scrolling through streaming movies unable to pick between two great films, until you end up too exhausted to watch anything at all and go to sleep.',
    background_style: 'amber_parchment',
    key_people: [
      { name: 'Jean Buridan', role: 'French Scholastic Philosopher', era: '1300–1358', quote: 'Should a rational agent hesitate indefinitely when two goods are equal?' }
    ]
  },
  {
    id: 'marys-room',
    title: "Mary's Room (The Knowledge Argument)",
    type: 'thought_experiment',
    hook: 'COULD YOU KNOW EVERYTHING SCIENTIFIC ABOUT COLOR WITHOUT EVER SEEING IT?',
    short_description: 'Frank Jackson\'s argument showing that physical knowledge cannot fully explain conscious experience.',
    detailed_description: 'Mary is a brilliant neuroscientist raised entirely in a black-and-white room. Through monitors, she learns every physical, physiological, and optical fact about color - the exact wavelengths of red, how light hits retinal cones, and how the brain processes color signals. One day, she is released from the room and looks at a red apple. Does she learn anything new? If yes, then physical facts do not capture the subjective quality of experience (qualia).',
    origin_context: 'Proposed by Australian philosopher Frank Jackson in 1982 to challenge physicalism.',
    core_principles: [
      'Qualia Exist: The felt, raw quality of conscious experience cannot be reduced to objective equations.',
      'Limits of Physicalism: Knowing every neurological fact about a creature is distinct from knowing what it feels like to be that creature.',
      'The Hard Problem of Consciousness: Why should physical brain states be accompanied by rich subjective inner lives?'
    ],
    everyday_example: 'Reading a thousand detailed medical articles about the biochemistry of falling in love versus experiencing heartbreak and romance firsthand for the first time.',
    background_style: 'crimson_existential',
    key_people: [
      { name: 'Frank Jackson', role: 'Philosopher of Mind', era: '1943-present', quote: 'Physicalism leaves something out: the taste of wine, the smell of roses, the redness of red.' },
      { name: 'Thomas Nagel', role: 'Philosopher & Author of "What Is It Like to Be a Bat?"', era: '1937-present', quote: 'Consciousness is what makes the mind-body problem really intractable.' }
    ]
  },
  {
    id: 'paradox-of-tolerance',
    title: 'The Paradox of Tolerance',
    type: 'paradox',
    hook: 'MUST A TOLERANT SOCIETY TOLERATE THOSE WHO WISH TO DESTROY TOLERANCE?',
    short_description: 'Karl Popper\'s insight that unlimited tolerance inevitably leads to the death of tolerance.',
    detailed_description: 'If a society extends unlimited tolerance to everyone, including those who are intolerant and advocate the violent suppression of others, the tolerant will eventually be destroyed and tolerance with them. Therefore, to preserve a tolerant society, the society must reserve the right to refuse tolerance to those who reject reason and open discussion in favor of intimidation and violence.',
    origin_context: 'Published by Karl Popper in 1945 in The Open Society and Its Enemies, written during World War II.',
    core_principles: [
      'Self-Preserving Limits: A virtue pushed to unconditional extremes can destroy the conditions that allow it to exist.',
      'Reason Over Force: Tolerance applies to any belief open to public argument; intolerance is triggered when groups resort to deception or violence.',
      'Vigilance of Free Institutions: Open societies require active defenses against authoritarian subversion.'
    ],
    everyday_example: 'A digital debate forum with no rules will quickly be overrun by spammers and abusive trolls, driving away reasonable participants until meaningful discussion ceases to exist.',
    background_style: 'forest_mist',
    key_people: [
      { name: 'Karl Popper', role: 'Philosopher of Science & Politics', era: '1902-1994', quote: 'In order to maintain a tolerant society, the society must be intolerant of intolerance.' }
    ]
  },
  {
    id: 'solipsism',
    title: 'Solipsism',
    type: 'philosophy',
    hook: 'HOW CAN YOU PROVE THAT ANY MIND EXISTS OTHER THAN YOUR OWN?',
    short_description: 'The philosophical position that only your own mind is sure to exist, and external reality may be a mental projection.',
    detailed_description: 'You can directly experience your own thoughts, pains, and sensations. But you can never directly experience another person\'s consciousness - you only perceive their physical bodies, words, and gestures. Solipsism takes this epistemological limit to its extreme: you cannot prove beyond all doubt that other people are conscious, or that the physical universe exists outside of your perception.',
    origin_context: 'Tracing from ancient Greek Skepticism and Gorgias, to Descartes\' radical doubt in 1641.',
    core_principles: [
      'The Privileged Access of Consciousness: Only first-person subjective experience is indisputably self-evident.',
      'The Problem of Other Minds: We infer other minds by analogy with our own, but direct proof is impossible.',
      'Radical Epistemological Humility: Acknowledging the gap between perception and external reality.'
    ],
    everyday_example: 'Waking up from a hyper-realistic dream where you had vivid conversations with friends, only to realize your mind generated every person, building, and dialogue entirely on its own.',
    background_style: 'obsidian_dark',
    key_people: [
      { name: 'René Descartes', role: 'French Philosopher & Mathematician', era: '1596-1650', quote: 'Cogito, ergo sum - I think, therefore I am.' },
      { name: 'George Berkeley', role: 'Anglo-Irish Philosopher', era: '1685-1753', quote: 'To be is to be perceived.' }
    ]
  },
  {
    id: 'occams-razor',
    title: "Occam's Razor",
    type: 'concept',
    hook: 'WHEN MULTIPLE EXPLANATIONS EXIST, WHY IS THE SIMPLEST USUALLY RIGHT?',
    short_description: 'The fundamental philosophical rule that unnecessary assumptions should be shaved away.',
    detailed_description: 'Also known as the principle of parsimony, Occam’s Razor states that entities should not be multiplied beyond necessity (non sunt multiplicanda entia sine necessitate). When faced with competing hypotheses that explain the observed data equally well, we should favor the one that makes the fewest assumptions and introduces the least complexity.',
    origin_context: 'Formulated by 14th-century English Franciscan friar and philosopher William of Ockham.',
    core_principles: [
      'Parsimony as a Guide: Simpler theories are easier to test, falsify, and build upon.',
      'Shaving Away Conspiracies: Theories requiring secret cabals and endless hidden steps are statistically far less probable.',
      'Heuristic, Not Dogma: It is a decision tool for guiding inquiry, not a physical law that nature must be simple.'
    ],
    everyday_example: 'If you hear hoofbeats in Central Park, assuming horses is vastly more rational than assuming an escaped herd of invisible zebras.',
    background_style: 'amber_parchment',
    key_people: [
      { name: 'William of Ockham', role: 'English Theologian & Logician', era: '1287–1347', quote: 'It is futile to do with more things that which can be done with fewer.' }
    ]
  }
];

export class NvidiaNimGenerator {
  private proceduralIndex = 0;

  private getApiKey(): string {
    return process.env.NVIDIA_API_KEY || '';
  }

  private getModel(): string {
    return process.env.NVIDIA_MODEL || 'openai/gpt-oss-20b';
  }

  /**
   * Generates a batch of unique, editorial-grade discoveries
   */
  async generateBatch(count = 3, existingTitles: string[] = []): Promise<Discovery[]> {
    const apiKey = this.getApiKey();
    if (!apiKey) {
      console.log('NVIDIA NIM: No API key found in environment. Using procedural synthesis engine.');
      return this.generateProceduralBatch(count, existingTitles);
    }

    try {
      return await this.callNvidiaNim(count, existingTitles);
    } catch (err: any) {
      console.error('NVIDIA NIM generation error, falling back to procedural synthesis:', err?.message || err);
      return this.generateProceduralBatch(count, existingTitles);
    }
  }

  private async callNvidiaNim(count: number, existingTitles: string[]): Promise<Discovery[]> {
    const existingListStr = existingTitles.slice(-25).join(', ');

    const prompt = `You are the editorial intelligence behind "Phils", a mobile app replacing mindless scrolling with curiosity-driven intellectual discoveries.
Generate ${count} brand-new, unique philosophical or intellectual discovery cards.

DO NOT repeat any of these already covered topics: [${existingListStr}].

Choose from:
- Classical philosophies (e.g. Taoism, Cynicism, Deontology, Pragmatism, Solipsism, Virtue Ethics)
- Thought experiments & paradoxes (e.g. Grandfather Paradox, Zeno, Newcomb's Problem, Ticking Time Bomb, Sorites Paradox)
- Famous historical thinkers (e.g. Spinoza, Kant, Kierkegaard, Diogenes, Lao Tzu, Hannah Arendt)
- Philosophy of mind, science, ethics, and epistemology.

CRITICAL EDITORIAL RULES:
1. "hook": MUST be an all-caps provocative dilemma or question (under 80 chars). No hyphens or em-dashes.
2. "short_description": EXACTLY 1 crisp sentence explaining the core idea.
3. "detailed_description": 2-3 engaging paragraphs explaining the concept without academic jargon.
4. "everyday_example": A relatable, modern scenario showing how this idea applies to daily life.
5. "core_principles": 3-4 bullet points with bold short titles.
6. "key_people": 1-2 key historical thinkers with name, role, era, and memorable quote.
7. "background_style": one of: "amber_parchment", "terracotta_sun", "sage_paper", "indigo_void", "crimson_existential", "obsidian_dark", "forest_mist", "slate_stone".
8. "type": one of: "philosophy", "philosopher", "concept", "paradox", "thought_experiment", "scientific_idea".

Respond with ONLY a valid JSON object matching this schema:
{
  "discoveries": [
    {
      "id": "slug-id",
      "slug": "slug-id",
      "title": "Title Here",
      "type": "philosophy",
      "hook": "PROVOCATIVE QUESTION HERE?",
      "short_description": "Single sentence explanation.",
      "detailed_description": "Full explanation...",
      "origin_context": "When and where it emerged.",
      "core_principles": ["Principle 1", "Principle 2", "Principle 3"],
      "everyday_example": "Everyday scenario...",
      "background_style": "amber_parchment",
      "why_reason": "Curated for deep philosophical inquiry",
      "key_people": [
        { "name": "Name", "role": "Role", "era": "Era", "quote": "Quote" }
      ],
      "related_discoveries": [],
      "contrasting_discoveries": []
    }
  ]
}`;

    const headers: Record<string, string> = {
      'Authorization': `Bearer ${this.getApiKey()}`,
      'Content-Type': 'application/json'
    };

    const payload = {
      model: this.getModel(),
      messages: [
        {
          role: 'system',
          content: 'You are the chief editorial director for Phils. Output only raw, valid JSON.'
        },
        {
          role: 'user',
          content: prompt
        }
      ],
      temperature: 0.7,
      max_tokens: 2500
    };

    const controller = new AbortController();
    const timeoutId = setTimeout(() => controller.abort(), 20000);

    let response: Response;
    try {
      response = await fetch(NVIDIA_API_URL, {
        method: 'POST',
        headers,
        body: JSON.stringify(payload),
        signal: controller.signal
      });
    } finally {
      clearTimeout(timeoutId);
    }

    if (!response.ok) {
      const errorText = await response.text();
      throw new Error(`NVIDIA NIM API returned ${response.status}: ${errorText}`);
    }

    const data: any = await response.json();
    const rawContent = data.choices?.[0]?.message?.content || '';

    // Clean potential markdown code fences and sanitize em-dashes/en-dashes
    const cleanRaw = rawContent
      .replace(/[\u2014\u2013]/g, '-')
      .replace(/```json\s*/gi, '')
      .replace(/```\s*$/gi, '')
      .trim();
    const parsed = JSON.parse(cleanRaw);

    const sanitize = (text: string) => (text || '').replace(/[\u2014\u2013]/g, '-').trim();

    if (Array.isArray(parsed.discoveries) && parsed.discoveries.length > 0) {
      return parsed.discoveries.map((d: any, index: number) => ({
        id: d.id || `nim-${Date.now()}-${index}`,
        slug: d.slug || d.id || `discovery-${Date.now()}-${index}`,
        title: sanitize(d.title || 'Untitled Discovery'),
        type: d.type || 'concept',
        hook: sanitize(d.hook || 'WHAT IF REALITY IS NOT WHAT IT SEEMS?'),
        short_description: sanitize(d.short_description || ''),
        detailed_description: sanitize(d.detailed_description || ''),
        origin_context: sanitize(d.origin_context || ''),
        core_principles: Array.isArray(d.core_principles) ? d.core_principles.map(sanitize) : [],
        everyday_example: sanitize(d.everyday_example || ''),
        background_style: d.background_style || 'amber_parchment',
        key_people: Array.isArray(d.key_people) ? d.key_people.map((p: any) => ({
          name: sanitize(p.name || ''),
          role: sanitize(p.role || ''),
          era: sanitize(p.era || ''),
          quote: sanitize(p.quote || '')
        })) : [],
        related_discoveries: Array.isArray(d.related_discoveries) ? d.related_discoveries : [],
        contrasting_discoveries: Array.isArray(d.contrasting_discoveries) ? d.contrasting_discoveries : [],
        why_reason: sanitize(d.why_reason || 'Synthesized by NVIDIA NIM intellectual engine')
      }));
    }

    throw new Error('NVIDIA NIM returned response without valid discoveries array');
  }

  private generateProceduralBatch(count: number, existingTitles: string[]): Discovery[] {
    const existingSet = new Set(existingTitles.map(t => t.toLowerCase()));
    const available = PROCEDURAL_CONCEPTS.filter(c => !existingSet.has(c.title.toLowerCase()));

    const list = available.length > 0 ? available : PROCEDURAL_CONCEPTS;
    const results: Discovery[] = [];

    for (let i = 0; i < count; i++) {
      const template = list[(this.proceduralIndex + i) % list.length];
      const uniqueId = `${template.id}-${Date.now()}-${i}`;
      results.push({
        ...template,
        id: uniqueId,
        slug: uniqueId,
        why_reason: 'Curated intellectual discovery for your feed',
        related_discoveries: [],
        contrasting_discoveries: []
      });
    }

    this.proceduralIndex = (this.proceduralIndex + count) % list.length;
    return results;
  }
}

export const nvidiaNimGenerator = new NvidiaNimGenerator();
