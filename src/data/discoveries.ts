import { Discovery } from '../types';

export const fallbackDiscoveries: Discovery[] = [
  {
    id: 'stoicism',
    slug: 'stoicism',
    title: 'Stoicism',
    type: 'philosophy',
    hook: 'WHAT IF YOU COULD CONTROL YOUR REACTION, BUT NOT THE EVENT?',
    short_description: 'A philosophy built around mastering your response to life rather than controlling life itself.',
    detailed_description: 'Stoicism asserts that true freedom and peace of mind (ataraxia) come from distinguishing between what is within our power (our thoughts, decisions, virtues) and what is not (external events, other people, reputation, death). By aligning with reason and accepting fate, one becomes unshakable in adversity.',
    origin_context: 'Founded in Athens by Zeno of Citium around 300 BC, and later flourished in Ancient Rome through emperors, statesmen, and freed slaves.',
    core_principles: [
      'The Dichotomy of Control: Focus solely on internal actions, let go of external outcomes.',
      'Virtue is the Sole Good: Wisdom, Courage, Justice, and Temperance are sufficient for flourishing.',
      'Amor Fati: Love fate and embrace every obstacle as fuel for virtue.',
      'Memento Mori: Keep your mortality in mind to stay humble and present.'
    ],
    everyday_example: 'When you get stuck in a massive traffic jam before an important meeting, getting furious changes nothing about the road. The Stoic takes a breath, accepts the delay, and uses the time to listen to an audiobook or mentally prepare.',
    background_style: 'stoic_stone',
    key_people: [
      { name: 'Marcus Aurelius', role: 'Roman Emperor & Philosopher', era: '121–180 AD', quote: 'You have power over your mind - not outside events. Realize this, and you will find strength.' },
      { name: 'Epictetus', role: 'Greek Stoic & Former Slave', era: '50–135 AD', quote: 'It is not what happens to you, but how you react to it that matters.' },
      { name: 'Seneca', role: 'Roman Statesman & Essayist', era: '4 BC–65 AD', quote: 'We suffer more often in imagination than in reality.' }
    ],
    related_discoveries: [
      { id: 'dichotomy-of-control', title: 'Dichotomy of Control', type: 'concept', reason: 'The foundational mental model of Stoic practice' },
      { id: 'marcus-aurelius', title: 'Marcus Aurelius', type: 'philosopher', reason: 'The emperor who practiced Stoicism while leading Rome' },
      { id: 'amor-fati', title: 'Amor Fati', type: 'concept', reason: 'The Stoic attitude of embracing and loving one\'s fate' }
    ],
    contrasting_discoveries: [
      { id: 'epicureanism', title: 'Epicureanism', type: 'philosophy', reason: 'While Stoics endure public duty and fate, Epicureans withdraw to peaceful gardens and prioritize the elimination of physical/mental pain.' },
      { id: 'hedonism', title: 'Hedonism', type: 'philosophy', reason: 'Hedonism seeks maximizing immediate pleasure, whereas Stoicism insists pleasure is indifferent and virtue is the only good.' }
    ]
  },
  {
    id: 'ship-of-theseus',
    slug: 'ship-of-theseus',
    title: 'Ship of Theseus',
    type: 'paradox',
    hook: 'IF EVERY PLANK OF A SHIP IS GRADUALLY REPLACED OVER TIME, IS IT STILL THE SAME SHIP?',
    short_description: 'An ancient paradox questioning what constitutes identity: material components or continuous form.',
    detailed_description: 'Theseus sailed a legendary wooden ship. Over centuries of voyages, as individual wooden planks rotted, Athenians replaced them one by one with fresh timber until not a single original piece remained. Is it still the Ship of Theseus? Furthermore, if someone collected all the discarded old planks and rebuilt a ship, which one is the original?',
    origin_context: 'Recorded by Greek historian Plutarch in "Life of Theseus", late 1st century AD, discussed earlier by Heraclitus and Plato.',
    core_principles: [
      'Identity Over Time: What makes an entity persistent across changing material states?',
      'Constitution vs Continuity: Is something defined by its physical matter or by its continuous pattern?',
      'Human Analogy: Almost every cell in your human body is replaced every 7 to 10 years; what makes you "you"?'
    ],
    everyday_example: 'Your favorite rock band from 30 years ago has replaced the drummer, guitarist, bassist, and lead singer over time. If they perform on stage tomorrow with zero original members, are you watching the original band?',
    background_style: 'paradox_timber',
    key_people: [
      { name: 'Plutarch', role: 'Greek Historian & Biographer', era: '46–119 AD', quote: 'This ship became a standing example among the philosophers for the question of things that grow.' },
      { name: 'Thomas Hobbes', role: 'English Philosopher', era: '1588–1679', quote: 'Introduced the second puzzle of rebuilding the ship from the rotten planks.' }
    ],
    related_discoveries: [
      { id: 'quantum-superposition', title: 'Quantum Superposition', type: 'scientific_idea', reason: 'Challenges conventional assumptions about definite states and physical identity' },
      { id: 'cognitive-dissonance', title: 'Cognitive Dissonance', type: 'concept', reason: 'Mental friction when contradictory ideas about identity clash' }
    ],
    contrasting_discoveries: [
      { id: 'determinism', title: 'Determinism', type: 'scientific_idea', reason: 'Classical determinism views physical particles as strictly continuous trajectories without ambiguity.' }
    ]
  },
  {
    id: 'cognitive-dissonance',
    slug: 'cognitive-dissonance',
    title: 'Cognitive Dissonance',
    type: 'concept',
    hook: 'WHY DO WE RATIONALIZE OUR MISTAKES INSTEAD OF ADMITTING WE WERE WRONG?',
    short_description: 'The psychological discomfort felt when holding two contradictory beliefs, driving us to invent excuses.',
    detailed_description: 'When our actions conflict with our self-image or core beliefs (e.g. knowing smoking is deadly while smoking a pack a day), our brain experiences acute mental stress. Rather than changing the difficult behavior or admitting error, our subconscious quickly alters our beliefs or invents rationalizations to restore internal harmony.',
    origin_context: 'Formulated in 1957 by social psychologist Leon Festinger after studying an apocalyptic cult whose prophecy failed.',
    core_principles: [
      'Mental Friction: Contradictions between actions and values cause measurable emotional distress.',
      'Three Modes of Reduction: Change behavior, change belief, or add justifying rationalizations.',
      'Confirmation Bias Link: We selectively consume news that validates our existing choices to avoid dissonance.'
    ],
    everyday_example: 'Buying an expensive gym membership that you never use. Instead of admitting you wasted $1,000, you tell yourself: "Well, having the membership motivates me mentally, so it was worth the investment."',
    background_style: 'dissonance_fracture',
    key_people: [
      { name: 'Leon Festinger', role: 'American Social Psychologist', era: '1919–1989', quote: 'A man with a conviction is a hard man to change. Tell him you disagree and he turns away.' }
    ],
    related_discoveries: [
      { id: 'confirmation-bias', title: 'Confirmation Bias', type: 'concept', reason: 'The mental filter we use to preserve our comforting cognitive bubble' },
      { id: 'hedonic-adaptation', title: 'Hedonic Adaptation', type: 'concept', reason: 'Another fundamental psychological reset mechanism of the human mind' }
    ],
    contrasting_discoveries: [
      { id: 'socratic-irony', title: 'Socratic Method & Intellectual Humility', type: 'concept', reason: 'Socrates actively embraced cognitive contradictions to purge false knowledge and find truth.' }
    ]
  },
  {
    id: 'friedrich-nietzsche',
    slug: 'friedrich-nietzsche',
    title: 'Friedrich Nietzsche',
    type: 'philosopher',
    hook: 'WHAT IF SUFFERING IS NOT AN OBSTACLE, BUT THE ESSENTIAL RAW MATERIAL FOR GREATNESS?',
    short_description: 'A revolutionary thinker who diagnosed modern nihilism and called on humanity to create higher values.',
    detailed_description: 'Nietzsche foresaw the collapse of traditional religious certainty in the West ("God is dead") and warned that without replacement values, humanity would sink into passive nihilism. His solution was not despair, but radical life-affirmation: the Übermensch, Will to Power, and Amor Fati (loving one\'s fate without wishing a single second were different).',
    origin_context: '19th Century Germany & Switzerland (1844–1900), writing in intense lyrical aphorisms.',
    core_principles: [
      'Amor Fati: Enthusiastic love of all life events, including pain and catastrophe.',
      'Will to Power: The fundamental human drive toward self-mastery, growth, and creation.',
      'Master vs Slave Morality: Questioning inherited moral doctrines born from resentment.'
    ],
    everyday_example: 'Viewing a grueling career failure or painful breakup not as an unfair tragedy, but as the necessary crucible that toughens your character and inspires your greatest creative work.',
    background_style: 'alpine_abyss',
    key_people: [
      { name: 'Friedrich Nietzsche', role: 'Philosopher, Poet & Philologist', era: '1844–1900', quote: 'What does not kill me makes me stronger.' }
    ],
    related_discoveries: [
      { id: 'existentialism', title: 'Existentialism', type: 'philosophy', reason: 'Nietzsche laid the intellectual groundwork for existentialist self-creation' },
      { id: 'amor-fati', title: 'Amor Fati', type: 'concept', reason: 'Nietzsche\'s ultimate formula for human greatness' }
    ],
    contrasting_discoveries: [
      { id: 'utilitarianism', title: 'Utilitarianism', type: 'philosophy', reason: 'Nietzsche despised utilitarianism for seeking merely "comfortable happiness" like cattle rather than creative excellence.' }
    ]
  },
  {
    id: 'fermi-paradox',
    slug: 'fermi-paradox',
    title: 'The Fermi Paradox',
    type: 'paradox',
    hook: 'IF BILLIONS OF STARS EXIST IN OUR GALAXY, WHERE IS EVERYBODY?',
    short_description: 'The striking contradiction between high probability estimates for extraterrestrial civilizations and the complete lack of evidence.',
    detailed_description: 'Our Milky Way galaxy has over 100 billion stars, many billions of years older than our Sun. Even at sub-light speeds, an interstellar civilization would need only a few million years to colonize the entire galaxy. Yet, our sky is completely silent. Physicist Enrico Fermi famously asked his colleagues at lunch: "Where is everybody?"',
    origin_context: 'Conceived casually by Nobel laureate Enrico Fermi during a lunch discussion at Los Alamos in 1950.',
    core_principles: [
      'Drake Equation vs Cosmic Silence: Probability math predicts abundance, yet observations yield zero.',
      'Candidate Hypotheses: The Great Filter (extinction barrier), Zoo Hypothesis (they observe in secret), Rare Earth (life is uniquely rare).'
    ],
    everyday_example: 'Imagine walking through a massive 10,000-room hotel with all lights on, elevators running, and kitchens stocked, but finding zero guests and zero footprints across all 100 floors.',
    background_style: 'cosmic_abyss',
    key_people: [
      { name: 'Enrico Fermi', role: 'Italian-American Physicist', era: '1901–1954', quote: 'Where is everybody?' },
      { name: 'Robin Hanson', role: 'Economist & Futurist', era: '1959–Present', quote: 'Coined "The Great Filter" hypothesis as a solution to Fermi\'s silence.' }
    ],
    related_discoveries: [
      { id: 'the-great-filter', title: 'The Great Filter', type: 'historical_idea', reason: 'The leading theoretical hurdle explaining why civilizations vanish before interstellar expansion' },
      { id: 'simulation-hypothesis', title: 'Simulation Hypothesis', type: 'scientific_idea', reason: 'Offers an alternative explanation: our reality is a local rendering without aliens' }
    ],
    contrasting_discoveries: [
      { id: 'anthropic-principle', title: 'Anthropic Principle', type: 'scientific_idea', reason: 'Argues our observations are conditioned on the specific conditions required for our own existence.' }
    ]
  },
  {
    id: 'absurdism',
    slug: 'absurdism',
    title: 'Absurdism',
    type: 'philosophy',
    hook: 'WHAT IF SEARCHING FOR LIFE\'S ULTIMATE MEANING IS IMPOSSIBLE, YET YOU MUST LIVE FULLY ANYWAY?',
    short_description: 'Living defiantly with joy and passion despite knowing the universe will never answer our search for ultimate meaning.',
    detailed_description: 'The "Absurd" is the irreconcilable conflict between humanity\'s deep craving for purpose and the cold, chaotic, indifferent silence of the universe. Camus argues against suicide (giving up) and against false religious or political dogma (philosophical surrender). Instead, he advocates revolt: embracing life with passionate freedom and defiance.',
    origin_context: 'Pioneered by Albert Camus in 1942 through his seminal philosophical essay "The Myth of Sisyphus" and novel "The Stranger".',
    core_principles: [
      'The Absurd Encounter: The collision between human desire for order and a meaningless universe.',
      'Three Responses: Physical suicide (escape), Philosophical suicide (blind faith), or Defiance (authentic life).',
      'The Absurd Hero: Rolling the boulder up the hill like Sisyphus, finding happiness in the struggle itself.'
    ],
    everyday_example: 'Knowing that in 5 billion years the sun will engulf the earth does not stop you from savoring a hot cup of coffee this morning, laughing with a friend, and painting a canvas today. You live richly without needing cosmic approval.',
    background_style: 'absurdist_vortex',
    key_people: [
      { name: 'Albert Camus', role: 'French-Algerian Author & Philosopher', era: '1913–1960', quote: 'One must imagine Sisyphus happy.' },
      { name: 'Franz Kafka', role: 'Bohemian Novelist', era: '1883–1924', quote: 'There is an infinite amount of hope in the universe... but not for us.' }
    ],
    related_discoveries: [
      { id: 'albert-camus', title: 'Albert Camus', type: 'philosopher', reason: 'The founder and principal voice of Absurdist revolt' },
      { id: 'existentialism', title: 'Existentialism', type: 'philosophy', reason: 'Shares the view that objective meaning is absent, but differs in response' }
    ],
    contrasting_discoveries: [
      { id: 'stoicism', title: 'Stoicism', type: 'philosophy', reason: 'Stoics believe the universe is governed by a rational cosmic order (Logos), whereas Absurdists believe the universe is fundamentally irrational.' },
      { id: 'rationalism', title: 'Rationalism', type: 'philosophy', reason: 'Rationalism claims human intellect can decipher the complete underlying order of reality.' }
    ]
  },
  {
    id: 'trolley-problem',
    slug: 'trolley-problem',
    title: 'The Trolley Problem',
    type: 'thought_experiment',
    hook: 'WOULD YOU ACTIVELY PULL A LEVER TO SACRIFICE ONE PERSON TO SAVE FIVE?',
    short_description: 'A famous moral thought experiment examining the tension between utilitarian calculation and ethical rules.',
    detailed_description: 'A runaway trolley is speeding down tracks toward five workers who cannot escape. You stand next to a lever. If you pull it, the trolley diverts to a side track where it will kill one worker. Do you pull the lever? Most people say yes. But if you must physically push a heavy stranger off a bridge to stop the train, most say no—even though the math (1 for 5) is identical.',
    origin_context: 'Introduced by British philosopher Philippa Foot in 1967 and expanded by Judith Jarvis Thomson.',
    core_principles: [
      'Consequentialism vs Deontology: Maximizing numbers versus respecting intrinsic moral rights.',
      'Action vs Inaction: Is allowing five to die worse than actively causing one death?',
      'Emotional Distance: How physical proximity alters human moral judgment.'
    ],
    everyday_example: 'Autonomous self-driving vehicle algorithms deciding how to steer in an unavoidable collision: protect the car\'s passengers or steer towards a single pedestrian to avoid hitting a school bus.',
    background_style: 'trolley_tracks',
    key_people: [
      { name: 'Philippa Foot', role: 'British Moral Philosopher', era: '1920–2010', quote: 'Invented the trolley problem to dissect the doctrine of double effect.' },
      { name: 'Judith Jarvis Thomson', role: 'American Philosopher', era: '1929–2020', quote: 'Introduced the "Fat Man" bridge variation.' }
    ],
    related_discoveries: [
      { id: 'utilitarianism', title: 'Utilitarianism', type: 'philosophy', reason: 'The moral philosophy that unambiguously prescribes pulling the lever' },
      { id: 'deontology', title: 'Kantian Deontology', type: 'philosophy', reason: 'The moral philosophy that forbids using a person merely as an instrument' }
    ],
    contrasting_discoveries: [
      { id: 'cynicism', title: 'Ancient Cynicism', type: 'philosophy', reason: 'Cynics mock academic dilemma puzzles as detached from real spontaneous virtuous living.' }
    ]
  },
  {
    id: 'taoism',
    slug: 'taoism',
    title: 'Taoism (Daoism)',
    type: 'philosophy',
    hook: 'WHAT IF TRYING TOO HARD TO CONTROL THINGS IS THE EXACT REASON THEY FAIL?',
    short_description: 'An ancient Eastern philosophy of aligning with the natural flow of the universe through effortless action (Wu Wei).',
    detailed_description: 'Taoism teaches that there is an underlying, nameless principle that animates the cosmos: the Tao (The Way). Human suffering emerges when we fight this natural current through rigid agendas, arrogance, and forced striving. By practicing Wu Wei (non-contrived, effortless action) and simplicity, one achieves harmony with nature.',
    origin_context: 'Ancient China, 4th–6th Century BC, codified primarily in the Tao Te Ching by Lao Tzu and writings of Zhuangzi.',
    core_principles: [
      'Wu Wei (Effortless Action): Acting in flow without force, like water wearing down jagged stone.',
      'Yin and Yang: Harmony through the balance of complementary opposites (light/dark, soft/hard).',
      'The Uncarved Block (Pu): Returning to a state of natural simplicity and unconditioned openness.'
    ],
    everyday_example: 'In sports or music, when you overthink every finger movement you stumble; when you enter a flow state, your hands move effortlessly in tune with the instrument. That is Wu Wei in action.',
    background_style: 'taoist_flow',
    key_people: [
      { name: 'Lao Tzu', role: 'Ancient Chinese Sage', era: '6th Century BC', quote: 'Nature does not hurry, yet everything is accomplished.' },
      { name: 'Zhuangzi', role: 'Chinese Philosopher & Storyteller', era: '369–286 BC', quote: 'Flow with whatever is happening and let your mind be free.' }
    ],
    related_discoveries: [
      { id: 'wabi-sabi', title: 'Wabi-Sabi', type: 'philosophy', reason: 'Japanese aesthetic rooted in Taoist/Zen reverence for impermanence and nature' },
      { id: 'chaos-theory', title: 'Chaos Theory', type: 'scientific_idea', reason: 'Scientific understanding that complex systems have natural currents that resist brute force control' }
    ],
    contrasting_discoveries: [
      { id: 'deontology', title: 'Kantian Deontology', type: 'philosophy', reason: 'Deontology governs life by strict, rigid, non-negotiable moral rules, whereas Taoism advocates flexible, spontaneous alignment with context.' }
    ]
  },
  {
    id: 'simulation-hypothesis',
    slug: 'simulation-hypothesis',
    title: 'The Simulation Hypothesis',
    type: 'scientific_idea',
    hook: 'WHAT IS THE MATHEMATICAL PROBABILITY THAT WE ARE LIVING INSIDE A COMPUTER SIMULATION?',
    short_description: 'The argument that advanced civilizations would run countless ancestor simulations, making it probable we live in one.',
    detailed_description: 'Philosopher Nick Bostrom established a rigorous trilemma: Either 1) human civilizations almost always go extinct before technological maturity; 2) advanced post-human species lose all interest in running ancestor simulations; or 3) we are almost certainly living in a computer simulation right now. Because simulated minds would vastly outnumber biological minds, the odds favor option 3.',
    origin_context: 'Formally proposed by Oxford philosopher Nick Bostrom in 2003 in his paper "Are You Living in a Computer Simulation?".',
    core_principles: [
      'Bostrom\'s Trilemma: At least one of the three propositions must be true.',
      'Computational Substrate Independence: Consciousness emerges from information processing, regardless of carbon or silicon.',
      'Pixelation of Physics: Planck length and speed-of-light limits as rendering constraints.'
    ],
    everyday_example: 'Considering video games: from Pong 50 years ago to photorealistic VR worlds today. In another 1,000 years, simulated worlds will feature conscious AI agents indistinguishable from physical reality.',
    background_style: 'matrix_digital',
    key_people: [
      { name: 'Nick Bostrom', role: 'Swedish Philosopher at Oxford University', era: '1973–Present', quote: 'Because they would run many millions of simulations, simulated inhabitants would outnumber real ancestors.' }
    ],
    related_discoveries: [
      { id: 'experience-machine', title: 'The Experience Machine', type: 'thought_experiment', reason: 'Nozick\'s earlier philosophical inquiry into artificial reality' },
      { id: 'fermi-paradox', title: 'The Fermi Paradox', type: 'paradox', reason: 'Simulation parameters might explain why we observe no other galactic civilizations' }
    ],
    contrasting_discoveries: [
      { id: 'existentialism', title: 'Existentialism', type: 'philosophy', reason: 'Existentialism grounds meaning in our immediate, direct bodily experience of reality.' }
    ]
  },
  {
    id: 'tragedy-of-the-commons',
    slug: 'tragedy-of-the-commons',
    title: 'The Tragedy of the Commons',
    type: 'historical_idea',
    hook: 'WHY DO INDIVIDUAL RATIONAL DECISIONS LEAD TO COLLECTIVE RUIN?',
    short_description: 'An economic concept where individual users acting independently according to self-interest deplete a shared resource.',
    detailed_description: 'Imagine a shared pasture open to all herdsmen. It is rational for each herdsman to add another cow to his herd, because he gains 100% of the profit from the cow while the grazing damage is shared equally by everyone. As every herdsman makes this rational calculation, the entire pasture is overgrazed and destroyed, ruining everyone.',
    origin_context: 'Described by William Forster Lloyd in 1833 and popularized by ecologist Garrett Hardin in Science in 1968.',
    core_principles: [
      'Shared Open-Access Resources: Lack of defined ownership or collective governance.',
      'Individual Incentive vs Collective Good: Short-term gain creates long-term destruction.',
      'Solutions: Elinor Ostrom\'s community governance rules, regulation, or property rights.'
    ],
    everyday_example: 'Traffic gridlock on public highways during rush hour, overfishing in international oceans, or climate change emissions from burning fossil fuels.',
    background_style: 'parchment_earth',
    key_people: [
      { name: 'Garrett Hardin', role: 'American Ecologist & Author', era: '1915–2003', quote: 'Ruin is the destination toward which all men rush, each pursuing his own best interest.' },
      { name: 'Elinor Ostrom', role: 'Nobel Memorial Prize in Economic Sciences', era: '1933–2012', quote: 'Demonstrated that local communities can successfully govern shared resources without centralized state control.' }
    ],
    related_discoveries: [
      { id: 'the-great-filter', title: 'The Great Filter', type: 'historical_idea', reason: 'A macro-civilizational version where resource depletion or nuclear tragedy ends civilizations' },
      { id: 'utilitarianism', title: 'Utilitarianism', type: 'philosophy', reason: 'Struggles with coordinating collective utility when individual incentives diverge' }
    ],
    contrasting_discoveries: [
      { id: 'cynicism', title: 'Ancient Cynicism', type: 'philosophy', reason: 'Cynics advocate radically shrinking personal consumption to zero so one never strains the commons.' }
    ]
  }
];
