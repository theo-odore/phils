import { Discovery, DiscoveryType } from '../types';

export interface ConceptBlueprint {
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
}

export const MASSIVE_DISCOVERY_CATALOG: ConceptBlueprint[] = [
  {
    id: 'allegory-of-the-cave',
    title: "Plato's Allegory of the Cave",
    type: 'thought_experiment',
    hook: 'WHAT IF EVERYTHING YOU SEE IS ONLY A SHADOW ON A WALL?',
    short_description: 'A foundational allegory examining human ignorance, cognitive blinders, and the painful journey toward objective truth.',
    detailed_description: 'Prisoners are chained inside a dark cave from childhood, facing a wall where shadows of puppets are cast by a fire behind them. They believe these shadows are absolute reality. When one prisoner escapes into the sunlight, the blinding glare hurts his eyes, but he gradually discovers the sun as the true source of all illumination. When he returns to free the others, they ridicule his disorientation and threaten to kill him.',
    origin_context: 'Written by Plato in Book VII of The Republic, around 375 BC.',
    core_principles: [
      'The Illusion of Senses: Empirical appearances can deceive us into mistaking surface shadows for fundamental reality.',
      'The Pain of Awakening: True philosophical education requires uncomfortable disillusionment.',
      'The Philosopher\'s Burden: Those who glimpse objective truth carry an ethical obligation to return and enlighten others.'
    ],
    everyday_example: 'Living inside a curated social media algorithm that confirms your biases every day until you step outside and discover that reality is vastly more nuanced.',
    background_style: 'indigo',
    key_people: [
      { name: 'Plato', role: 'Classical Greek Philosopher', era: '428-348 BC', quote: 'The unexamined life is not worth living.' },
      { name: 'Socrates', role: 'Teacher & Protagonist', era: '470-399 BC', quote: 'I know that I know nothing.' }
    ]
  },
  {
    id: 'chinese-room',
    title: 'The Chinese Room Argument',
    type: 'thought_experiment',
    hook: 'CAN A SYSTEM THAT SPEAKS FLAWLESSLY EVER TRULY UNDERSTAND WHAT IT SAYS?',
    short_description: 'John Searle\'s classic thought experiment distinguishing syntax (rule-following) from semantics (genuine comprehension).',
    detailed_description: 'Imagine an English speaker locked in a room with a comprehensive rulebook for manipulating Chinese characters. Native speakers slide questions under the door; the person follows the look-up table, matches characters, and outputs perfect answers. To outsiders, the room appears fluent. Yet the occupant understands not a single word. Searle argues that computational algorithms manipulate symbols without conscious intentionality.',
    origin_context: 'Formulated by philosopher John Searle in 1980 as a counter to strong Artificial Intelligence claims.',
    core_principles: [
      'Syntax vs Semantics: Programmed symbolic manipulation does not constitute subjective understanding.',
      'Simulation vs Duplication: Simulating mental activity in silicon is no more conscious than a digital weather model is wet.',
      'The Mystery of Intentionality: Human consciousness possesses "aboutness" that formal mechanical rules fail to produce.'
    ],
    everyday_example: 'Using automated autotranslate tools to compose an email in Japanese: the recipient reads fluid prose, while your own brain remains oblivious to the underlying meaning of each kanji.',
    background_style: 'sage',
    key_people: [
      { name: 'John Searle', role: 'American Philosopher of Mind', era: '1932-present', quote: 'You cannot get semantics from syntax alone.' }
    ]
  },
  {
    id: 'brain-in-a-vat',
    title: 'The Brain in a Vat',
    type: 'thought_experiment',
    hook: 'HOW DO YOU PROVE YOU ARE NOT A BRAIN FLOATING IN A SCIENTIST\'S JAR?',
    short_description: 'A modern formulation of Cartesian skepticism questioning whether sensory reality can ever be definitively verified.',
    detailed_description: 'Imagine an evil mad scientist has removed your brain from your body, placed it into a nutrient-rich vat, and wired your neurons to a supercomputer that simulates all sight, sound, taste, and memories. You experience waking up, drinking coffee, and touching your screen. How can you be certain from within your subjective sensations that your external body exists?',
    origin_context: 'Popularized by Hilary Putnam in 1981, building on René Descartes\' 1641 "Evil Demon" hypothesis.',
    core_principles: [
      'Radical Epistemological Skepticism: Direct sensory experience cannot logically guarantee the existence of an external physical world.',
      'Semantic Externalism: Putnam argued that words only refer to things in the causal history of the speaker, challenging total skepticism.',
      'The Foundation of Modern Simulation Theory: The direct philosophical progenitor of The Matrix and contemporary VR inquiries.'
    ],
    everyday_example: 'Waking up from a dream so intensely vivid that for several seconds you reach out to feel the bedposts to confirm whether you have genuinely returned to wakefulness.',
    background_style: 'cosmic',
    key_people: [
      { name: 'Hilary Putnam', role: 'American Philosopher', era: '1926-2016', quote: 'The mind does not simply copy a world that has already provided its own description.' },
      { name: 'René Descartes', role: 'Father of Modern Philosophy', era: '1596-1650', quote: 'I think, therefore I am.' }
    ]
  },
  {
    id: 'schrodingers-cat',
    title: "Schrödinger's Cat Paradox",
    type: 'thought_experiment',
    hook: 'CAN A CAT BE SIMULTANEOUSLY ALIVE AND DEAD UNTIL SOMEONE LOOKS?',
    short_description: 'A famous thought experiment exposing the counterintuitive absurdity of quantum superposition when scaled to macro reality.',
    detailed_description: 'A cat is sealed in a steel chamber with a Geiger counter, a tiny bit of radioactive substance, a vial of poison, and a hammer. If a single atom decays, the hammer breaks the flask, killing the cat. If not, the cat lives. According to the Copenhagen interpretation of quantum mechanics, before observation occurs, the atom exists in a superposition of both decayed and undecayed states—meaning the cat must be both alive and dead at the same time.',
    origin_context: 'Conceived by physicist Erwin Schrödinger in 1935 in critique of the Copenhagen interpretation.',
    core_principles: [
      'Superposition Dilemma: Quantum particles can occupy multiple contradictory states until measured.',
      'The Measurement Problem: Where does the quantum realm of probabilities end and macroscopic classical reality begin?',
      'Observer Effect: The act of inquiry cannot be completely separated from the reality being measured.'
    ],
    everyday_example: 'Waiting for exam results sealed in an envelope: mentally, you toggle between passing and failing until the physical seal is broken.',
    background_style: 'indigo',
    key_people: [
      { name: 'Erwin Schrödinger', role: 'Nobel Laureate Physicist', era: '1887-1961', quote: 'The task is not so much to see what no one has yet seen; but to think what nobody has yet thought, about that which everybody sees.' },
      { name: 'Niels Bohr', role: 'Quantum Physicist', era: '1885-1962', quote: 'Those who are not shocked when they first come across quantum theory cannot possibly have understood it.' }
    ]
  },
  {
    id: 'pascals-wager',
    title: "Pascal's Wager",
    type: 'philosophy',
    hook: 'WHAT IS THE RATIONAL GAMBLE WHEN INFINITE STAKES ARE ON THE TABLE?',
    short_description: 'The pioneering application of decision theory and expected utility to existential belief.',
    detailed_description: 'Blaise Pascal argued that human reason cannot prove or disprove the existence of God. However, living your life is an unavoidable wager: you must bet your conduct. If you bet on God and He exists, your gain is infinite (eternal salvation); if He does not exist, your loss is finite (a few earthly pleasures). If you bet against God and He exists, your loss is infinite. Therefore, the rational choice by expected utility is to live as though God exists.',
    origin_context: 'Written by Blaise Pascal in his posthumous 1670 collection Pensées.',
    core_principles: [
      'Expected Value in Uncertainty: Weigh probability multiplied by the magnitude of the consequences.',
      'Finite Sacrifice vs Infinite Consequence: When potential downside or upside is infinite, finite costs become mathematically negligible.',
      'The Inevitability of Choosing: Inaction in life is itself an active bet.'
    ],
    everyday_example: 'Wearing a seatbelt on every drive: the probability of a catastrophic collision today is microscopic, but the catastrophic cost is so enormous that the minor inconvenience of buckling up is mathematically indisputable.',
    background_style: 'terracotta',
    key_people: [
      { name: 'Blaise Pascal', role: 'French Mathematician & Philosopher', era: '1623-1662', quote: 'The heart has its reasons of which reason knows nothing.' }
    ]
  },
  {
    id: 'ring-of-gyges',
    title: 'The Ring of Gyges',
    type: 'thought_experiment',
    hook: 'IF YOU BECAME COMPLETELY INVISIBLE, WOULD YOU STILL BE GOOD?',
    short_description: 'Glaucon\'s moral dilemma testing whether human virtue is an innate good or merely social fear of consequence.',
    detailed_description: 'Gyges, a humble shepherd, discovers a gold ring inside a chasm. When he turns the stone inward, he becomes entirely invisible. Realizing he can act without consequence, he seduces the queen, murders the king, and seizes the throne. Glaucon challenges Socrates: give one ring to a just man and one to an unjust man. Would either continue to act virtuously if all social shame and legal punishment vanished?',
    origin_context: 'Presented by Glaucon in Book II of Plato\'s Republic (c. 375 BC).',
    core_principles: [
      'External Sanctions vs Internal Virtue: Is morality an intrinsic harmony of the soul or a defensive contract against mutual harm?',
      'The Test of Anonymity: True character is revealed strictly in the absence of accountability.',
      'The Psychological Appeal of Impunity: Power without visibility tests the boundary of human self-discipline.'
    ],
    everyday_example: 'Leaving a store when the self-checkout scanner glitches and leaves a $100 item unbilled: do you quietly walk out when no cameras or alarms are watching, or do you notify the cashier?',
    background_style: 'ochre',
    key_people: [
      { name: 'Plato', role: 'Philosopher', era: '428-348 BC', quote: 'The measure of a man is what he does with power.' }
    ]
  },
  {
    id: 'achilles-and-the-tortoise',
    title: 'Achilles and the Tortoise',
    type: 'paradox',
    hook: 'HOW CAN THE FASTEST RUNNER IN HISTORY NEVER OVERTAKE A SLOW TORTOISE?',
    short_description: 'Zeno of Elea\'s paradox demonstrating the confounding nature of infinite divisibility in physical space.',
    detailed_description: 'Achilles races a tortoise and grants it a 100-meter head start. To catch the tortoise, Achilles must first run to the point where the tortoise started (100m). By the time he reaches that spot, the tortoise has moved forward by 10 meters. Achilles then covers that 10 meters, but the tortoise has crept ahead another meter. Since space can be divided into infinite sub-intervals, Achilles must complete an infinite series of tasks, meaning he can never overtake the tortoise.',
    origin_context: 'Formulated by Zeno of Elea around 450 BC to defend Parmenides\' theory that motion is an illusion.',
    core_principles: [
      'The Puzzle of the Continuum: How can continuous motion exist if space and time are infinitely divisible?',
      'Sum of Infinite Series: Modern calculus solved the mechanical puzzle: an infinite geometric series can converge to a finite number.',
      'The Tension Between Mathematics and Reality: Demonstrates that logical formalisms can produce absurdities if physical limits are ignored.'
    ],
    everyday_example: 'Procrastinating on finishing a project by endlessly refining smaller and smaller 1% details, convincing yourself you are moving forward while never actually crossing the finish line.',
    background_style: 'indigo',
    key_people: [
      { name: 'Zeno of Elea', role: 'Pre-Socratic Greek Philosopher', era: '495-430 BC', quote: 'That which is in locomotion must arrive at the half-way stage before it arrives at the goal.' }
    ]
  },
  {
    id: 'bootstrap-paradox',
    title: 'The Bootstrap Paradox',
    type: 'paradox',
    hook: 'IF YOU TRAVEL BACK IN TIME WITH SHAKESPEARE\'S PLAYS, WHO ACTUALLY WROTE THEM?',
    short_description: 'A causal loop paradox in which information or an object exists without ever having been created.',
    detailed_description: 'A time traveler buys a copy of Hamlet in a bookstore, travels back to 1600 London, and hands the book to a young William Shakespeare, who copies it word-for-word and publishes it. The book survives through the centuries, until the time traveler buys it in the future. Who originated Hamlet? The information exists in an uncreated, self-sustaining temporal loop with no initial creator.',
    origin_context: 'Coined from Robert Heinlein\'s 1941 sci-fi novella "By His Bootstraps".',
    core_principles: [
      'Causal Loops: A closed chain of cause and effect where an event in the past is caused by an event in the future.',
      'Ontological Vacuum: Information or matter existing without an ontological genesis or creative labor.',
      'The Arrow of Causality: Challenges our fundamental assumption that every effect must have a prior, independent cause.'
    ],
    everyday_example: 'Adopting a fashion trend solely because an algorithm predicts it will be popular next year, thereby making it popular and proving the prediction correct.',
    background_style: 'cosmic',
    key_people: [
      { name: 'Robert A. Heinlein', role: 'Science Fiction Author', era: '1907-1988', quote: 'There are no answers, only cross-references.' }
    ]
  },
  {
    id: 'sorites-paradox',
    title: 'The Sorites Paradox (Heap of Sand)',
    type: 'paradox',
    hook: 'AT WHAT EXACT GRAIN DOES A PILE OF SAND BECOME A HEAP?',
    short_description: 'A classic paradox exploring the inherent vagueness of human language and categorical definitions.',
    detailed_description: 'One grain of sand is not a heap. Adding one more grain does not make it a heap. If adding a single grain never turns a non-heap into a heap, then by induction, 1,000,000 grains cannot be a heap. Conversely, if you have a massive heap of sand and remove a single grain, it remains a heap. Removing one grain at a time, you are eventually left with one grain that must still be called a heap. Where does the boundary exist?',
    origin_context: 'Attributed to Eubulides of Miletus in the 4th Century BC.',
    core_principles: [
      'The Problem of Vague Predicates: Everyday concepts (baldness, wealth, youth) lack mathematically sharp boundary lines.',
      'Fallacy of the Continuum: Just because there is a gradual spectrum does not mean there is no qualitative difference between extremes.',
      'Fuzzy Logic in Human Reasoning: Language works through probabilistic prototypes rather than strict binary sets.'
    ],
    everyday_example: 'Deciding when a friend has officially become rich, or when a person transition from healthy tired into clinical burnout: no single day or dollar marks the threshold.',
    background_style: 'ochre',
    key_people: [
      { name: 'Eubulides of Miletus', role: 'Greek Megarian Philosopher', era: '4th Century BC', quote: 'If a man says he is lying, is what he says true or false?' }
    ]
  },
  {
    id: 'prisoners-dilemma',
    title: "The Prisoner's Dilemma",
    type: 'concept',
    hook: 'WHY DO TWO RATIONAL ACTORS ROUTINELY CHOOSE MUTUAL RUIN OVER COOPERATION?',
    short_description: 'The cornerstone of modern game theory showing how individual rationality leads to collective failure.',
    detailed_description: 'Two suspects are arrested and held in separate interrogation cells. If both stay silent, each serves 1 year. If one betrays the other while the second stays silent, the betrayer walks free and the silent one serves 5 years. If both betray each other, both serve 3 years. From each individual\'s standpoint, betraying is always the dominant self-interested strategy regardless of what the partner does. Consequently, both betray and serve 3 years, missing out on the mutually superior 1-year outcome.',
    origin_context: 'Framed by Merrill Flood and Melvin Dresher at the RAND Corporation in 1950.',
    core_principles: [
      'Nash Equilibrium Traps: Self-optimizing strategies often stabilize at sub-optimal collective outcomes.',
      'The Value of Trust & Verification: Cooperation requires credible commitments, reputation systems, and repeated interactions.',
      'Tit-for-Tat in Repeated Games: In iterated encounters, starting with cooperation and retaliating only against defection fosters mutual flourishing.'
    ],
    everyday_example: 'Two rival tech companies each spending billions on predatory advertising: if both stopped, both would keep their profits; but neither dares stop lest the other take their market share.',
    background_style: 'burgundy',
    key_people: [
      { name: 'John Nash', role: 'Nobel Laureate Mathematician', era: '1928-2015', quote: 'The best result will come from everyone in the group doing what\'s best for himself and the group.' },
      { name: 'Robert Axelrod', role: 'Political Scientist', era: '1943-present', quote: 'Mutual cooperation can emerge in a world of egoists without central control.' }
    ]
  },
  {
    id: 'invisible-hand',
    title: 'The Invisible Hand',
    type: 'historical_idea',
    hook: 'CAN PURSUING YOUR OWN INTEREST PRODUCE THE GREATEST GOOD FOR STRANGERS?',
    short_description: 'Adam Smith\'s profound metaphor for how decentralized markets channel self-interest into social coordination.',
    detailed_description: 'It is not from the benevolence of the butcher, the brewer, or the baker that we expect our dinner, but from their regard to their own interest. Without any central committee decreeing how much bread to bake, millions of independent tradesmen seeking profit accidentally create a coordinated supply chain that feeds entire cities. An "invisible hand" harmonizes individual ambitions into public wealth.',
    origin_context: 'Introduced by Scottish moral philosopher Adam Smith in The Wealth of Nations (1776).',
    core_principles: [
      'Decentralized Information Aggregation: Price mechanisms communicate scarcity, desire, and utility faster than any bureau.',
      'Unintended Social Benefits: Self-interest under competitive rule of law incentivizes service to others.',
      'Market Failure Boundaries: The invisible hand fails in the presence of monopolies, information asymmetry, and negative externalities.'
    ],
    everyday_example: 'A baker waking up at 4:00 AM not out of saintly love for the neighborhood, but to earn a living—resulting in hot, fresh bread waiting for hundreds of commuters.',
    background_style: 'terracotta',
    key_people: [
      { name: 'Adam Smith', role: 'Scottish Enlightenment Philosopher', era: '1723-1790', quote: 'By pursuing his own interest he frequently promotes that of the society more effectually than when he really intends to promote it.' }
    ]
  },
  {
    id: 'dunning-kruger-effect',
    title: 'The Dunning-Kruger Effect',
    type: 'concept',
    hook: 'WHY ARE THE LEAST QUALIFIED PEOPLE CONSTANTLY THE MOST CONFIDENT?',
    short_description: 'A cognitive bias where people with low ability in a domain drastically overestimate their competence.',
    detailed_description: 'In 1999, psychologists David Dunning and Justin Kruger demonstrated that poor performers suffer a "dual burden": not only do they reach erroneous conclusions and make unfortunate choices, but their incompetence robs them of the metacognitive ability to realize that they are making mistakes. Conversely, true experts frequently underestimate their relative superiority, assuming tasks that are easy for them are easy for everyone.',
    origin_context: 'Published in 1999 following a study of Cornell psychology students inspired by a bank robber who thought lemon juice made his face invisible.',
    core_principles: [
      'Metacognitive Deficit: It takes expertise in a subject to accurately assess how much expertise you lack.',
      'Mount Stupid to the Slope of Enlightenment: Initial superficial knowledge breeds hyper-confidence; deep study reveals overwhelming complexity.',
      'Intellectual Humility: Genuine wisdom begins with an accurate map of one\'s own ignorance.'
    ],
    everyday_example: 'Reading two viral tweets about epidemiology or macroeconomics and immediately feeling equipped to lecture university professors in comment sections.',
    background_style: 'stone',
    key_people: [
      { name: 'David Dunning', role: 'Social Psychologist', era: '1960-present', quote: 'The skills you need to produce a right answer are the very same skills you need to recognize what a right answer is.' }
    ]
  },
  {
    id: 'survivorship-bias',
    title: 'Survivorship Bias',
    type: 'concept',
    hook: 'ARE YOU STUDYING THE SUCCESSFUL OR MERELY THE VISIBLE SURVIVORS?',
    short_description: 'The logical error of concentrating on people or things that passed a selection hurdle while overlooking those that failed.',
    detailed_description: 'During World War II, the military analyzed returning bombers riddled with bullet holes to decide where to add armor. Officers proposed armoring the wings and fuselage where bullet holes were clustered. Statistician Abraham Wald realized the fatal flaw: they were only examining the planes that survived. The planes shot in the engines crashed and never made it home. The bullet holes in returning planes showed where an aircraft could take damage and still fly; armor needed to go where returning planes had NO holes.',
    origin_context: 'Formulated by mathematician Abraham Wald at Columbia University\'s Statistical Research Group in 1943.',
    core_principles: [
      'The Hidden Graveyard: What you cannot see is often vastly more informative than what survived.',
      'False Blueprints for Success: Interviewing college dropout billionaires ignores the tens of thousands of college dropouts who went bankrupt.',
      'Selection Filter Distortion: Looking at old architecture leads to believing "they built things better back then," ignoring the millions of shoddy buildings that collapsed.'
    ],
    everyday_example: 'Buying a book titled "How I Became a Millionaire at 22" that prescribes taking extreme risks, ignoring the 99% of people who followed the same advice and lost their savings.',
    background_style: 'stone',
    key_people: [
      { name: 'Abraham Wald', role: 'Hungarian Mathematician & Statistician', era: '1902-1950', quote: 'The engine is where the armor belongs, because the planes that were hit there never returned.' }
    ]
  },
  {
    id: 'sunk-cost-fallacy',
    title: 'The Sunk Cost Fallacy',
    type: 'concept',
    hook: 'WHY DO WE KEEP SINKING TIME INTO BAD DECISIONS JUST BECAUSE WE STARTED?',
    short_description: 'The irrational inclination to continue an endeavor once an investment in money, effort, or time has been made.',
    detailed_description: 'Traditional economics dictates that rational decision-making should be driven solely by future marginal benefits and future marginal costs. However, humans are emotionally loss-averse and hate "wasting" past outlays. We sit through terrible two-hour movies because we paid $18 for the ticket, or maintain hollow 5-year relationships because "we have put in so much time already," compounding past losses with future misery.',
    origin_context: 'Analyzed extensively by behavioral economists Amos Tversky, Daniel Kahneman, and Richard Thaler in the 1980s.',
    core_principles: [
      'Irretrievable Outlays: Past investments cannot be recovered whether you quit or proceed; they are irrelevant to forward-looking choices.',
      'Loss Aversion Trap: Quitting feels like admitting an irreversible loss, whereas persisting preserves the illusion of potential recovery.',
      'Opportunity Cost Neglect: Every hour spent honoring past sunk costs steals an hour from rewarding future investments.'
    ],
    everyday_example: 'Forcing yourself to finish eating a massive restaurant meal after you are already stuffed and nauseous, just so the food doesn\'t "go to waste."',
    background_style: 'rose',
    key_people: [
      { name: 'Richard Thaler', role: 'Nobel Laureate Behavioral Economist', era: '1945-present', quote: 'A sunk cost is money spent that you cannot get back. Ignore it.' }
    ]
  },
  {
    id: 'fundamental-attribution-error',
    title: 'The Fundamental Attribution Error',
    type: 'concept',
    hook: 'WHY ARE OTHERS FLAWED WHEN THEY FAIL, BUT WE ARE JUST VICTIMS OF CIRCUMSTANCE?',
    short_description: 'The psychological tendency to explain other people\'s behavior by internal character rather than situational forces.',
    detailed_description: 'When someone cuts you off in highway traffic, your immediate instinct is: "What a reckless, selfish jerk!" (internal personality attribution). When you cut someone off in traffic, your rationalization is: "I have an emergency and my blind spot hid them" (situational attribution). We judge others by their perceived character and ourselves by our context, creating massive relational friction.',
    origin_context: 'Coined by psychologist Lee Ross in 1977 following experiments by Edward E. Jones and Victor Harris.',
    core_principles: [
      'Actor-Observer Asymmetry: We have access to our own internal intentions and external stressors, but only see the visible actions of others.',
      'Underestimating Contextual Pressure: Systemic environmental factors frequently overpower personal dispositions.',
      'Charity of Interpretation: Giving strangers the benefit of the doubt dismantles chronic outrage.'
    ],
    everyday_example: 'Assuming a coworker who missed a deadline is lazy, without knowing their child was admitted to the hospital the previous night.',
    background_style: 'ocean',
    key_people: [
      { name: 'Lee Ross', role: 'Stanford Social Psychologist', era: '1942-2021', quote: 'People fail to take into account the power of social situations to influence behavior.' }
    ]
  },
  {
    id: 'active-nihilism',
    title: 'Active Nihilism',
    type: 'philosophy',
    hook: 'IF NOTHING HAS INTRINSIC MEANING, IS THAT AN ABYSS OR A BLANK CANVAS?',
    short_description: 'Nietzsche\'s radical philosophy of transforming existential meaninglessness into ultimate creative freedom.',
    detailed_description: 'Passive nihilism shrinks in despair when traditional religious, political, and metaphysical truths collapse, sinking into apathy and resignation. Nietzsche called for Active Nihilism: seeing the absence of cosmic purpose not as a defeat, but as an emancipating clean slate. If the universe provides no pre-packaged purpose, you are no longer a servant to someone else\'s dogmas; you are the sovereign creator of your own values.',
    origin_context: 'Articulated by Friedrich Nietzsche in The Will to Power and Thus Spoke Zarathustra (1883-1885).',
    core_principles: [
      'The Death of Metaphysical Crutches: Freedom requires letting go of promises of external rescue.',
      'Creation over Resignation: Active destruction of inherited, hollow dogmas creates room for authentic self-determination.',
      'The Will to Power: The fundamental driving force in life is self-overcoming, growth, and the creation of personal mastery.'
    ],
    everyday_example: 'Realizing that society\'s scripted milestones (climbing the corporate ladder, buying status symbols) carry no cosmic mandate, and using that clarity to launch an unconventional creative life.',
    background_style: 'burgundy',
    key_people: [
      { name: 'Friedrich Nietzsche', role: 'German Cultural Critic & Philosopher', era: '1844-1900', quote: 'He who has a why to live can bear almost any how.' }
    ]
  },
  {
    id: 'virtue-ethics',
    title: 'Aristotelian Virtue Ethics',
    type: 'philosophy',
    hook: 'WHAT IF BEING GOOD IS A MUSCLE DEVELOPED THROUGH PRACTICE, NOT A SET OF RULES?',
    short_description: 'Aristotle\'s teleological ethics focused on building character and achieving human flourishing (Eudaimonia).',
    detailed_description: 'While Utilitarians calculate consequences and Kantians obey rigid duties, Aristotle argued that ethics is about the character of the actor. Morality is not about following a rulebook; it is about cultivating virtues (excellences) through daily habituation. Virtue lies in the "Golden Mean"—the balanced sweet spot between extremes of excess and deficiency.',
    origin_context: 'Laid out in Aristotle\'s Nicomachean Ethics in the 4th Century BC Athens.',
    core_principles: [
      'The Golden Mean: Courage is the midpoint between cowardice (deficiency) and reckless foolhardiness (excess).',
      'Habituation (Hexis): We become just by doing just acts; temperate by doing temperate acts.',
      'Eudaimonia as the Chief End: The ultimate goal of human life is a flourishing soul expressing practical wisdom (phronesis).'
    ],
    everyday_example: 'Giving honest feedback to a friend: brutal cruelty is an excess of bluntness; flattering lies are a deficiency of honesty; true constructive compassion hits the golden mean.',
    background_style: 'sage',
    key_people: [
      { name: 'Aristotle', role: 'Polymath & Student of Plato', era: '384-322 BC', quote: 'We are what we repeatedly do. Excellence, then, is not an act, but a habit.' }
    ]
  },
  {
    id: 'anthropic-principle',
    title: 'The Anthropic Principle',
    type: 'scientific_idea',
    hook: 'IS THE UNIVERSE FINE-TUNED FOR US, OR COULD WE ONLY EXIST IN ONE THAT IS?',
    short_description: 'The cosmological principle that physical observations of the universe must be compatible with the conscious life that observes it.',
    detailed_description: 'If the electromagnetic force, cosmological constant, or gravitational strength were altered by a fraction of a percent, stars would never have formed, carbon chemistry would be impossible, and no biological life could exist. Is the cosmos designed intentionally for humanity? The Anthropic Principle counters: in an infinite multiverse with random laws, conscious observers can only ever wake up and ask this question inside a rare universe with conditions that permitted them to emerge.',
    origin_context: 'Introduced by theoretical astrophysicist Brandon Carter in 1973.',
    core_principles: [
      'Observer Selection Effect: What we expect to observe must be restricted by the conditions necessary for our presence as observers.',
      'Fine-Tuning Mystery: Fundamental physical constants fall into razor-thin bands conducive to organic chemistry.',
      'Multiverse Hypothesis: Fine-tuning is naturally explained if our universe is one of trillions of randomly seeded cosmic bubbles.'
    ],
    everyday_example: 'A puddle waking up and thinking, "What a fascinating hole I find myself in; it fits me so neatly, it must have been designed especially for me!"',
    background_style: 'cosmic',
    key_people: [
      { name: 'Brandon Carter', role: 'Theoretical Physicist', era: '1942-present', quote: 'What we can expect to observe must be restricted by the conditions necessary for our presence as observers.' }
    ]
  },
  {
    id: 'entropy-arrow-of-time',
    title: 'Entropy & The Arrow of Time',
    type: 'scientific_idea',
    hook: 'WHY DOES TIME ONLY EVER FLOW FORWARD, NEVER BACKWARD?',
    short_description: 'The second law of thermodynamics: why disorder increases and creates the fundamental direction of time.',
    detailed_description: 'Fundamental laws of physics (gravity, quantum mechanics) work identically forwards and backwards. So why can you stir milk into coffee, but never unstir it? Why do glasses shatter on the floor, but never assemble and leap back onto the table? The answer is statistical probability: there are astronomically more ways for atoms to be scrambled (high entropy) than ordered (low entropy). The unidirectional increase in entropy IS the arrow of time.',
    origin_context: 'Formulated by Ludwig Boltzmann and Rudolf Clausius in the late 19th Century.',
    core_principles: [
      'Statistical Inevitability: Order is extraordinarily rare; disorder is overwhelmingly probable.',
      'The Cosmological Past Hypothesis: The universe began in an astonishingly low-entropy state at the Big Bang.',
      'Life as Negative Entropy: Living organisms survive by exporting entropy into their surrounding environment.'
    ],
    everyday_example: 'Leaving your room alone for three weeks: it naturally gathers dust, clutter, and disarray without any effort; restoring order requires intentional input of energy.',
    background_style: 'terracotta',
    key_people: [
      { name: 'Ludwig Boltzmann', role: 'Austrian Physicist & Statistician', era: '1844-1906', quote: 'Available energy is the main object at stake in the struggle for existence.' },
      { name: 'Arthur Eddington', role: 'Astrophysicist', era: '1882-1944', quote: 'If your theory is found to be against the second law of thermodynamics, I can give you no hope.' }
    ]
  },
  {
    id: 'godels-incompleteness',
    title: "Gödel's Incompleteness Theorems",
    type: 'scientific_idea',
    hook: 'CAN ANY SYSTEM OF TRUTH EVER PROVE EVERYTHING THAT IS TRUE?',
    short_description: 'Kurt Gödel\'s 1931 mathematical proof that shattered the dream of a complete and consistent logical universe.',
    detailed_description: 'In the early 20th century, mathematicians sought a unified set of axioms that could mechanically prove or disprove every mathematical statement. In 1931, 25-year-old Kurt Gödel proved mathematically that any consistent formal mathematical system powerful enough to do basic arithmetic must contain statements that are true, but fundamentally unprovable from within the system\'s own axioms.',
    origin_context: 'Published by Kurt Gödel in 1931, dismantling David Hilbert\'s grand formalist program.',
    core_principles: [
      'The Inherent Blind Spot of Logic: Truth is strictly larger than provability.',
      'Limits of Self-Consistency: No axiomatic system can prove its own consistency from within itself without circularity.',
      'Philosophical Epistemic Humility: Human reason and automated algorithms can never possess a closed, omniscient framework of reality.'
    ],
    everyday_example: 'Attempting to understand a company\'s toxic culture purely from the internal employee handbook: the axioms of the handbook cannot document the unwritten norms governing the office.',
    background_style: 'indigo',
    key_people: [
      { name: 'Kurt Gödel', role: 'Mathematical Logician', era: '1906-1978', quote: 'Either mathematics is too big for the human mind, or the human mind is more than a machine.' }
    ]
  },
  {
    id: 'broken-window-fallacy',
    title: 'The Broken Window Fallacy',
    type: 'historical_idea',
    hook: 'DOES DESTRUCTION ACTUALLY STIMULATE THE ECONOMY?',
    short_description: 'Frédéric Bastiat\'s parable exposing the unseen costs of destruction and government waste.',
    detailed_description: 'A hooligan breaks a baker\'s shop window. Onlookers rationalize: "At least it stimulates the economy! The baker will pay the glazier $50, the glazier will spend it on bread, and money will circulate." Bastiat explains the fallacy: they see only what is seen, and overlook what is not seen. The baker now has a window, but lost $50 he would have spent on a new pair of shoes. The community has a window and no shoes, rather than a window AND shoes. Destruction destroys capital; it never creates wealth.',
    origin_context: 'Published by French economist Frédéric Bastiat in his 1850 essay "That Which Is Seen, and That Which Is Not Seen".',
    core_principles: [
      'The Seen vs The Unseen: Good economics accounts for invisible lost opportunities, not just visible spending.',
      'Destruction is Not Stimulus: Rebuilding broken assets only restores previous baselines while diverting resources from new progress.',
      'Opportunity Cost Foundation: The true cost of any decision is the highest-value alternative forgone.'
    ],
    everyday_example: 'Believing that a war or natural disaster is "good for the economy" because construction crews are hired to rebuild shattered towns.',
    background_style: 'terracotta',
    key_people: [
      { name: 'Frédéric Bastiat', role: 'French Classical Liberal Economist', era: '1801-1850', quote: 'There is only one difference between a bad economist and a good one: the bad economist confines himself to the visible effect.' }
    ]
  },
  {
    id: 'goodharts-law',
    title: "Goodhart's Law",
    type: 'concept',
    hook: 'WHAT HAPPENS TO A MEASURE ONCE YOU TURN IT INTO A TARGET?',
    short_description: 'The rule that when a measure becomes a target, it ceases to be a good measure.',
    detailed_description: 'British economist Charles Goodhart formulated that any statistical regularity will tend to collapse once pressured for control purposes. When hospital performance is judged by wait times, ambulances are held in parking lots before being checked in. When software engineers are rewarded for lines of code, they write verbose, bloated spaghetti. When schools are judged on standardized test scores, teachers abandon deep education to teach only test-taking hacks.',
    origin_context: 'Formulated by British economist Charles Goodhart in 1975 regarding monetary policy.',
    core_principles: [
      'Incentive Distortions: Humans optimize for the metric rather than the underlying intent.',
      'Perverse Gaming: Complex systems route around artificial bottlenecks, degrading holistic quality.',
      'The Danger of Single-Metric Governance: Real excellence cannot be condensed into a single proxy number.'
    ],
    everyday_example: 'Focusing entirely on your daily step count target on a smartwatch, so you shake your wrist while sitting on the couch to hit 10,000 steps.',
    background_style: 'stone',
    key_people: [
      { name: 'Charles Goodhart', role: 'British Economist', era: '1936-present', quote: 'Any observed statistical regularity will tend to collapse once pressure is placed upon it for control purposes.' }
    ]
  },
  {
    id: 'occams-razor',
    title: "Occam's Razor",
    type: 'concept',
    hook: 'WHEN MULTIPLE THEORIES EXPLAIN A MYSTERY, WHICH ONE SHOULD YOU CHOOSE?',
    short_description: 'The epistemic principle that entities should not be multiplied beyond necessity.',
    detailed_description: 'When evaluating competing explanations for an event, the one requiring the fewest unproven assumptions is usually the most likely to be true. If you wake up and find milk spilled on your kitchen counter, it could be an elaborate covert burglary by cat burglars who left no fingerprints and stole nothing, or your pet cat knocked it over. Occam\'s razor pares away unnecessary conspiracies.',
    origin_context: 'Attributed to 14th-century English Franciscan friar and philosopher William of Ockham.',
    core_principles: [
      'Parsimony of Explanation: Choose hypotheses with fewer hidden variables.',
      'Heuristic, Not Absolute Law: Simplicity indicates high initial probability, not guaranteed factual truth.',
      'Antidote to Over-Fitting: Prevents constructing fragile, ad-hoc rationalizations to save a doomed theory.'
    ],
    everyday_example: 'When your car won\'t start in freezing winter weather, checking whether the battery is dead before suspecting a rival sabotaged your ignition wire.',
    background_style: 'sage',
    key_people: [
      { name: 'William of Ockham', role: 'Franciscan Friar & Scholastic Theologian', era: '1287-1347', quote: 'Plurality should not be posited without necessity.' }
    ]
  },
  {
    id: 'hanlons-razor',
    title: "Hanlon's Razor",
    type: 'concept',
    hook: 'WAS IT A CONSPIRACY, OR JUST ORDINARY CARELESSNESS?',
    short_description: 'A heuristic stating that one should never attribute to malice what is adequately explained by carelessness.',
    detailed_description: 'Humans are hypersensitive to perceived threats, frequently assuming that mistakes or oversights by friends, colleagues, or governments are deliberate, coordinated attacks against them. Hanlon\'s razor reminds us that incompetence, fatigue, distraction, and cognitive overload explain the vast majority of human errors. Recognizing this preserves mental energy and defuses unnecessary outrage.',
    origin_context: 'Coined by Robert J. Hanlon in 1980 for a compilation book of Murphy\'s Law jokes.',
    core_principles: [
      'Presumption of Human Fallibility: People are far more often tired and disorganized than scheming and malevolent.',
      'Emotional Hygiene: Choosing understanding over perceived victimhood preserves social relationships.',
      'Systemic Debugging: Fix communication failures and broken workflows rather than hunting for villainous scapegoats.'
    ],
    everyday_example: 'When a friend fails to reply to your text message for two days, assuming they were overwhelmed with work and forgot, rather than deciding they secretly despise you.',
    background_style: 'ocean',
    key_people: [
      { name: 'Robert J. Hanlon', role: 'Author', era: '20th Century', quote: 'Never attribute to malice that which is adequately explained by stupidity.' }
    ]
  },
  {
    id: 'panopticon',
    title: 'The Panopticon',
    type: 'historical_idea',
    hook: 'WHAT HAPPENS TO HUMAN CONSCIOUSNESS WHEN YOU MIGHT ALWAYS BE WATCHED?',
    short_description: 'Jeremy Bentham\'s institutional design turned by Michel Foucault into a metaphor for modern surveillance society.',
    detailed_description: 'The Panopticon is a circular prison with an inspection tower at its center. Backlit cells ring the perimeter. The guard in the tower can see every prisoner, but the prisoners can never see into the tower. Because inmates never know when the guard is looking, they must assume they are being watched at every second. Eventually, external physical force is replaced by internal self-policing; the inmate becomes their own prison guard.',
    origin_context: 'Designed by Jeremy Bentham in 1791; analyzed by Michel Foucault in Discipline and Punish (1975).',
    core_principles: [
      'Internalized Surveillance: The mere possibility of observation compels continuous behavioral conformity.',
      'Disembodied Power: Power becomes invisible, automatic, and self-enforcing without needing physical shackles.',
      'Digital Panopticism: Modern algorithms, data profiling, and social credit systems operationalize the panopticon at global scale.'
    ],
    everyday_example: 'Slowing down to the exact speed limit when approaching a speed camera box, even though you have no idea whether an active camera is installed inside it today.',
    background_style: 'burgundy',
    key_people: [
      { name: 'Michel Foucault', role: 'French Poststructuralist Philosopher', era: '1926-1984', quote: 'Visibility is a trap.' },
      { name: 'Jeremy Bentham', role: 'English Philosopher & Jurist', era: '1748-1832', quote: 'A new mode of obtaining power of mind over mind.' }
    ]
  },
  {
    id: 'banality-of-evil',
    title: 'The Banality of Evil',
    type: 'concept',
    hook: 'DOES TERRIFYING CRUELTY REQUIRE MONSTROUS HATRED, OR JUST BUREAUCRATIC THOUGHTLESSNESS?',
    short_description: 'Hannah Arendt\'s unsettling insight into how ordinary, unthinking people participate in catastrophic atrocities.',
    detailed_description: 'Covering the 1961 trial of Nazi bureaucrat Adolf Eichmann in Jerusalem, philosopher Hannah Arendt expected to encounter a demonic fanatic dripping with psychopathic hatred. Instead, she found an uninspired, polite, petty civil servant whose primary motivation was career advancement and following administrative guidelines. He committed unspeakable horrors simply because he never exercised the imaginative capacity to think from the standpoint of another human being.',
    origin_context: 'Articulated in Hannah Arendt\'s 1963 report Eichmann in Jerusalem: A Report on the Banality of Evil.',
    core_principles: [
      'Thoughtlessness as Moral Abdication: Relinquishing critical thinking to institutional authority enables atrocities.',
      'The Bureaucratization of Violence: Dividing horrific systems into mundane administrative tasks shields individuals from moral responsibility.',
      'The Importance of Socratic Conscience: The internal dialogue between self and conscience is humanity\'s sole barrier against tyranny.'
    ],
    everyday_example: 'Corporate executives greenlighting a product defect that will harm consumers because "the legal department said it falls within acceptable liability margins."',
    background_style: 'stone',
    key_people: [
      { name: 'Hannah Arendt', role: 'Political Theorist & Philosopher', era: '1906-1975', quote: 'The sad truth is that most evil is done by people who never make up their minds to be good or evil.' }
    ]
  },
  {
    id: 'wu-wei',
    title: 'Wu Wei (Effortless Action)',
    type: 'philosophy',
    hook: 'HOW CAN YOU ACCOMPLISH EVERYTHING BY NOT FORCING ANYTHING?',
    short_description: 'The ancient Daoist art of acting in effortless alignment with the natural flow of the universe.',
    detailed_description: 'Wu Wei does not mean lazy passivity or doing nothing; it means non-coercive action—acting without friction or contrived ego. Like water carving through a canyon not by violent assault, but by patiently yielding and flowing into empty crevices, a practitioner of Wu Wei acts at the exact right moment with minimal wasted effort, working with the grain of reality rather than pushing against it.',
    origin_context: 'Pioneered in the Daodejing by Laozi and developed by Zhuangzi in 4th Century BC China.',
    core_principles: [
      'Flow with the Dao: Resistance against nature\'s rhythm produces exhaustion; alignment produces effortless momentum.',
      'The Power of Yielding: The softest things in the world overcome the hardest.',
      'Spontaneous Mastery (Ziran): The highest skill looks effortless because personal ego has dissolved into the practice.'
    ],
    everyday_example: 'A master tennis player or musician in the "flow state": they are not anxiously overthinking muscle movements; their body reacts fluidly and instinctively to the ball.',
    background_style: 'ocean',
    key_people: [
      { name: 'Laozi', role: 'Founder of Philosophical Daoism', era: '6th Century BC', quote: 'Nature does not hurry, yet everything is accomplished.' },
      { name: 'Zhuangzi', role: 'Daoist Master & Essayist', era: '369-286 BC', quote: 'Flow with whatever is happening and let your mind be free.' }
    ]
  },
  {
    id: 'butterfly-effect',
    title: 'The Butterfly Effect',
    type: 'scientific_idea',
    hook: 'CAN THE FLAP OF A BUTTERFLY\'S WINGS IN BRAZIL SET OFF A TORNADO IN TEXAS?',
    short_description: 'The cornerstone of chaos theory showing sensitive dependence on initial conditions in deterministic systems.',
    detailed_description: 'In 1961, meteorologist Edward Lorenz ran computer weather simulations. To save time, he restarted a run by entering an initial condition rounded to three decimal places (.506) instead of six (.506127). That microscopic one-part-in-ten-thousand difference transformed the simulation into a completely unrecognizable storm system. In complex non-linear systems, minuscule variations at the beginning cascade exponentially into vastly divergent outcomes.',
    origin_context: 'Discovered by Edward Lorenz in 1961 at MIT.',
    core_principles: [
      'Sensitive Dependence on Initial Conditions: Perfect prediction requires impossible infinite precision.',
      'Deterministic Yet Unpredictable: Even systems without random chance can be fundamentally impossible to forecast.',
      'Humility in Complex Systems: Economic, biological, and political ecosystems cannot be micromanaged without massive unintended consequences.'
    ],
    everyday_example: 'Missing a morning train by 30 seconds, leading you to bump into an old acquaintance at a coffee shop who offers you the job that defines the rest of your career.',
    background_style: 'terracotta',
    key_people: [
      { name: 'Edward Lorenz', role: 'Meteorologist & Mathematician', era: '1917-2008', quote: 'Chaos: When the present determines the future, but the approximate present does not approximately determine the future.' }
    ]
  },
  {
    id: 'parfit-teletransporter',
    title: "Parfit's Teletransporter Paradox",
    type: 'thought_experiment',
    hook: 'IF A TELEPORTER VAPORIZES YOU AND REBUILDS YOU ON MARS, DID YOU TRAVEL OR DID YOU DIE?',
    short_description: 'Derek Parfit\'s mind-bending inquiry into personal identity and whether the "self" is an illusion.',
    detailed_description: 'A futuristic teletransporter scans every atom of your body, records its exact quantum state, vaporizes your original body, and beams the blueprints to Mars, where a machine recreates you out of fresh atoms. The Mars replica has all your memories, scars, and personality, feeling as though it just blinked. Did you survive, or were you murdered on Earth while a brand-new twin woke up on Mars? What if the machine fails to vaporize the Earth body, leaving two identical copies claiming to be you?',
    origin_context: 'Formulated by British philosopher Derek Parfit in Reasons and Persons (1984).',
    core_principles: [
      'The Illusion of Continuous Self: We are bundles of shifting physical matter and psychological memories, not indivisible metaphysical souls.',
      'Psychological Connectedness vs Identity: What matters in survival is the continuity of thoughts and values, not the specific physical vessel.',
      'The Ship of Theseus of the Mind: If your cells are replaced every 7 years, you are already a living teletransporter paradox.'
    ],
    everyday_example: 'Upgrading to a new phone and transferring every photo, message, and setting via cloud sync: the digital identity survives, but is the old phone\'s unique silicon presence gone?',
    background_style: 'cosmic',
    key_people: [
      { name: 'Derek Parfit', role: 'Oxford Moral Philosopher', era: '1942-2017', quote: 'My death will break the more direct relations between my present experiences and future experiences, but it will not be the end of what matters.' }
    ]
  },
  {
    id: 'chestertons-fence',
    title: "Chesterton's Fence",
    type: 'concept',
    hook: 'BEFORE YOU TEAR DOWN A FENCE, DO YOU KNOW WHY IT WAS BUILT?',
    short_description: 'A vital heuristic for reform: never destroy a rule or boundary until you understand its original purpose.',
    detailed_description: 'Imagine you walk down a country road and find a gate or fence built across the path. The naive reformer says: "I see no use for this fence; let us clear it away!" The wiser reformer replies: "If you cannot see the use of it, I certainly will not let you clear it away. Go away and think. When you come back and tell me what purpose it originally served, only then may I allow you to destroy it."',
    origin_context: 'Introduced by English writer G.K. Chesterton in his 1929 book The Thing.',
    core_principles: [
      'Hidden Systemic Functionality: Antiquated rules often exist to restrain unseen, catastrophic problems.',
      'The Burden of Understanding: You earn the right to dismantle something only after you can articulate why someone erected it.',
      'Second-Order Effects in Reform: Tearing down structural constraints without foresight invariably invites the wolves back in.'
    ],
    everyday_example: 'Deleting a 50-line "useless" function in a legacy codebase because it seems redundant, only to discover it was preventing silent race-condition database corruptions at midnight.',
    background_style: 'stone',
    key_people: [
      { name: 'G.K. Chesterton', role: 'English Essayist & Philosopher', era: '1874-1936', quote: 'Do not remove a fence until you know why it was put there.' }
    ]
  },
  {
    id: 'paradox-of-tolerance',
    title: 'The Paradox of Tolerance',
    type: 'paradox',
    hook: 'MUST A TOLERANT SOCIETY EXTEND TOLERANCE TO THOSE WHO WOULD DESTROY IT?',
    short_description: 'Karl Popper\'s political paradox proving that unlimited tolerance leads directly to the extinction of tolerance.',
    detailed_description: 'If a society extends unlimited tolerance to all viewpoints without boundary, its ability to remain tolerant will eventually be seized or destroyed by the intolerant. When intolerant movements refuse to engage in rational argument, answer reason with violence, and seek to eliminate free expression, a tolerant society possesses the moral right—and the existential duty—to refuse them tolerance in order to defend the open society itself.',
    origin_context: 'Formulated by philosopher of science Karl Popper in The Open Society and Its Enemies (1945).',
    core_principles: [
      'Self-Defeating Absolutes: Unconditional tolerance without defense commits suicide in the face of violent dogma.',
      'The Boundary of Mutual Discourse: Tolerance is a reciprocal peace treaty, not an unconditional surrender to authoritarianism.',
      'Preserving the Open Society: Suppression of intolerance is a last-resort defense strictly when rational dialogue is abandoned.'
    ],
    everyday_example: 'A community discussion forum that values open speech deciding to ban users who dox, threaten physical harm, and sabotage the platform for everyone else.',
    background_style: 'burgundy',
    key_people: [
      { name: 'Karl Popper', role: 'Austrian-British Philosopher of Science', era: '1902-1994', quote: 'Unlimited tolerance must lead to the disappearance of tolerance.' }
    ]
  },
  {
    id: 'map-is-not-territory',
    title: 'The Map is Not the Territory',
    type: 'concept',
    hook: 'ARE YOU EXPERIENCING REALITY, OR MERELY YOUR MENTAL MODEL OF IT?',
    short_description: 'Alfred Korzybski\'s foundational insight that mental abstractions are always simplifications of raw reality.',
    detailed_description: 'A map of Paris can show streets, landmarks, and subway stations, but you cannot breathe the air of the Seine or taste a warm croissant by licking the paper. Our beliefs, scientific models, economic graphs, and cognitive words are maps. When we confuse our mental maps with actual territory, we become dogmatically blind when reality diverges from our expectations.',
    origin_context: 'Coined by Polish-American scientist and philosopher Alfred Korzybski in 1931.',
    core_principles: [
      'Inherent Incompleteness of Models: A map that captured every atom of the territory would be as large as the territory and useless as a guide.',
      'Semantic Confusion: Don\'t mistake financial wealth numbers on a screen for true human flourishing.',
      'Continual Updating: When the map and the territory disagree, the territory is always right.'
    ],
    everyday_example: 'Following GPS navigation into a lake because "the screen said the road went straight through," ignoring the water splashing against your tires.',
    background_style: 'sage',
    key_people: [
      { name: 'Alfred Korzybski', role: 'Philosopher & General Semantics Founder', era: '1879-1950', quote: 'The map is not the territory; the word is not the thing it represents.' }
    ]
  },
  {
    id: 'black-swan-theory',
    title: 'The Black Swan Theory',
    type: 'concept',
    hook: 'HOW CAN THOUSANDS OF DAYS OF CONFIRMATION BE DESTROYED IN A SINGLE SECOND?',
    short_description: 'Nassim Taleb\'s philosophy of rare, high-impact, retrospectively rationalized historical events.',
    detailed_description: 'For centuries, Europeans observed millions of white swans and concluded that all swans must be white. In 1697, Dutch explorers arrived in Western Australia and spotted a single black swan, instantly shattering an empirical consensus held for thousands of years. Black Swan events (the 2008 financial crash, the rise of the internet, global pandemics) are statistical outliers of immense impact that humans foolishly try to explain away as predictable in hindsight.',
    origin_context: 'Developed by risk analyst and epistemologist Nassim Nicholas Taleb in his 2007 book The Black Swan.',
    core_principles: [
      'The Asymmetry of Evidence: Ten thousand white swans do not prove the rule; a single black swan disproves it.',
      'Fragility in the Tails: Standard Gaussian bell curves blind institutions to massive tail risks.',
      'Preparation over Prediction: You cannot predict the exact black swan; you must make your life and systems robust to volatility.'
    ],
    everyday_example: 'A turkey fed by a farmer every single day for 1,000 consecutive days: each day increases the turkey\'s confidence that the farmer loves it, until the day before Thanksgiving.',
    background_style: 'stone',
    key_people: [
      { name: 'Nassim Nicholas Taleb', role: 'Mathematical Risk Essayist', era: '1960-present', quote: 'We do not learn that we do not learn.' }
    ]
  },
  {
    id: 'antifragility',
    title: 'Antifragility',
    type: 'concept',
    hook: 'WHAT IS THE EXACT OPPOSITE OF FRAGILE?',
    short_description: 'Systems and organisms that do not merely resist shock, but actively grow stronger from stressors and volatility.',
    detailed_description: 'The opposite of fragile is not robust. A fragile wine glass shatters when dropped. A robust rock survives being dropped, but remains unchanged. An antifragile entity—like human muscle, biological evolution, or a decentralized open market—requires stressors, minor shocks, and micro-failures to strengthen its defenses and thrive. Shielding systems from all stress makes them hyper-fragile to catastrophic collapse.',
    origin_context: 'Introduced by Nassim Nicholas Taleb in Antifragile: Things That Gain from Disorder (2012).',
    core_principles: [
      'Gains from Disorder: Antifragile systems have more upside than downside from volatility.',
      'The Danger of Iatrogenics: Well-intentioned micromanagers trying to eliminate all small shocks create mega-crises.',
      'Hormesis: Mild doses of stressors (exercise, cold exposure, cognitive challenge) stimulate systemic biological vitality.'
    ],
    everyday_example: 'Lifting heavy weights: you intentionally inflict microscopic tears in muscle tissue, prompting your body to rebuild the fibers thicker and stronger than before.',
    background_style: 'terracotta',
    key_people: [
      { name: 'Nassim Nicholas Taleb', role: 'Philosopher of Uncertainty', era: '1960-present', quote: 'Antifragility is beyond resilience or robustness. The resilient resists shocks and stays the same; the antifragile gets better.' }
    ]
  },
  {
    id: 'will-to-meaning',
    title: 'The Will to Meaning & Logotherapy',
    type: 'philosophy',
    hook: 'CAN FINDING A PURPOSE SUSTAIN YOU THROUGH INCONCEIVABLE SUFFERING?',
    short_description: 'Viktor Frankl\'s existential psychiatry born in the death camps of the Holocaust.',
    detailed_description: 'While Freud posited the will to pleasure and Adler the will to power, psychiatrist Viktor Frankl survived Auschwitz and Dachau by discovering the primary human drive: the will to meaning. Humans can endure unbearable physical deprivation, grief, and torture if they believe their suffering serves a purpose or that someone or something waits for their survival. When stripped of everything, our final freedom is our choice of attitude.',
    origin_context: 'Documented by Viktor Frankl in Man\'s Search for Meaning (1946).',
    core_principles: [
      'The Ultimate Human Freedom: Everything can be taken from a man but one thing: to choose one\'s attitude in any given set of circumstances.',
      'Suffering Ceases to be Suffering: The moment it finds a meaning, such as the meaning of a sacrifice.',
      'Responsibility to Life: Stop asking what you expect from life; ask what life expects from you.'
    ],
    everyday_example: 'A parent working two exhausting minimum-wage jobs with a joyful heart because every dollar directly funds their child\'s college education.',
    background_style: 'rose',
    key_people: [
      { name: 'Viktor Frankl', role: 'Austrian Neurologist & Psychiatrist', era: '1905-1997', quote: 'Those who have a \'why\' to live, can bear with almost any \'how\'.' }
    ]
  }
];

export class ProceduralGenerator {
  private generatedCount: number = 0;

  /**
   * Generates a batch of distinct, authentic discoveries.
   * If the base catalog has unserved items, it draws from them first.
   * If exhausted, it synthesizes unique procedural permutations.
   */
  public generateBatch(count: number, existingIds: Set<string>): Discovery[] {
    const freshDiscoveries: Discovery[] = [];

    // 1. First, drain any unused blueprint concepts from the catalog
    for (const blueprint of MASSIVE_DISCOVERY_CATALOG) {
      if (!existingIds.has(blueprint.id) && freshDiscoveries.length < count) {
        existingIds.add(blueprint.id);
        freshDiscoveries.push(this.blueprintToDiscovery(blueprint));
      }
    }

    // 2. If we still need more to satisfy the requested batch, synthesize procedural ideas
    while (freshDiscoveries.length < count) {
      const synth = this.synthesizeInfiniteIdea(this.generatedCount++, existingIds);
      existingIds.add(synth.id);
      freshDiscoveries.push(synth);
    }

    return freshDiscoveries;
  }

  public getCatalogDiscoveries(): Discovery[] {
    return MASSIVE_DISCOVERY_CATALOG.map(b => this.blueprintToDiscovery(b));
  }

  public blueprintToDiscovery(b: ConceptBlueprint): Discovery {
    return {
      id: b.id,
      slug: b.id,
      title: b.title,
      type: b.type,
      hook: b.hook,
      short_description: b.short_description,
      detailed_description: b.detailed_description,
      origin_context: b.origin_context,
      core_principles: b.core_principles,
      everyday_example: b.everyday_example,
      background_style: b.background_style,
      key_people: b.key_people,
      related_discoveries: [],
      contrasting_discoveries: [],
      why_reason: `A foundational inquiry in ${b.type.replace('_', ' ')} worth exploring.`,
      status: 'published'
    };
  }

  /**
   * Infinite combinatorial synthesis engine combining authentic dialectic tensions.
   */
  private synthesizeInfiniteIdea(index: number, existingIds: Set<string>): Discovery {
    const archetypes = [
      {
        theme: 'The Paradox of Consciousness',
        type: 'thought_experiment' as DiscoveryType,
        hook: 'IF YOUR MIND IS MADE OF PHYSICAL ATOMS, WHERE DOES YOUR AWARENESS LIVE?',
        topic: 'Physicalism vs Qualia',
        origin: 'Formulated in debates surrounding the Mind-Body problem across 20th century philosophy.',
        principles: [
          'The Explanatory Gap: Physical descriptions of brain chemistry fail to explain what red feels like.',
          'The Problem of Other Minds: You can never objectively verify another entity\'s inner subjective reality.',
          'Emergent Complexity: Consciousness may be an emergent macroscopic property rather than a fundamental particle.'
        ],
        example: 'Looking at high-resolution brain scans that highlight neural firings while falling in love, yet knowing the scan cannot experience the emotion.',
        style: 'indigo',
        thinkers: [{ name: 'Thomas Nagel', role: 'Philosopher of Mind', era: '1937-present', quote: 'What is it like to be a bat?' }]
      },
      {
        theme: 'The Ethics of Future Generations',
        type: 'concept' as DiscoveryType,
        hook: 'DO PEOPLE WHO WILL BE BORN IN 200 YEARS HAVE A MORAL CLAIM ON US TODAY?',
        topic: 'Intergenerational Justice',
        origin: 'Pioneered by Derek Parfit and contemporary moral philosophers addressing climate and nuclear policy.',
        principles: [
          'The Non-Identity Problem: Decisions we make today determine who will be born, complicating harm calculations.',
          'Temporal Neutrality: Physical distance in space does not reduce moral duty; neither should distance in time.',
          'The Custodianship Principle: Humanity inherits the earth as temporary stewards, not sovereign destroyers.'
        ],
        example: 'Conserving old-growth forests that will take three centuries to mature for children whose great-grandparents have not yet met.',
        style: 'sage',
        thinkers: [{ name: 'Derek Parfit', role: 'Moral Philosopher', era: '1942-2017', quote: 'The future of humanity is vast; our ethical responsibility matches that horizon.' }]
      },
      {
        theme: 'The Limits of Language',
        type: 'philosophy' as DiscoveryType,
        hook: 'CAN YOU THINK A THOUGHT THAT YOUR LANGUAGE DOES NOT HAVE WORDS FOR?',
        topic: 'Linguistic Relativity',
        origin: 'Developed by Ludwig Wittgenstein and the Vienna Circle in early 20th century philosophy of language.',
        principles: [
          'The Boundaries of My World: The limits of my language mean the limits of my world.',
          'Language as a Shared Tool: Meaning is defined by social use inside a communal game, not private mental tags.',
          'Whereof One Cannot Speak: There are ineffable aspects of reality that must be met with contemplative silence.'
        ],
        example: 'Feeling a profound bittersweet ache for passing time that English has no single word for, until discovering Japanese "mono no aware".',
        style: 'ocean',
        thinkers: [{ name: 'Ludwig Wittgenstein', role: 'Austrian Philosopher', era: '1889-1951', quote: 'Whereof one cannot speak, thereof one must be silent.' }]
      },
      {
        theme: 'The Tragedy of Rationality',
        type: 'concept' as DiscoveryType,
        hook: 'WHEN EVERYONE ACTS WITH PERFECT LOGIC, WHY CAN THE SYSTEM STILL COLLAPSE?',
        topic: 'Coordination Failure',
        origin: 'Formalized across modern game theory and welfare economics.',
        principles: [
          'The Fallacy of Composition: What is true for the individual is frequently false for the collective.',
          'Coordination Traps: Without binding social contracts, defensive self-protection harms all participants.',
          'The Necessity of Institutional Trust: Economies require trust infrastructure to escape prisoner\'s dilemmas.'
        ],
        example: 'Standing on your tiptoes at a music concert to see the stage better: once everyone does it, no one sees any better, and everyone\'s feet hurt.',
        style: 'stone',
        thinkers: [{ name: 'Kenneth Arrow', role: 'Nobel Laureate Economist', era: '1921-2017', quote: 'Trust is an important lubricant of a social system.' }]
      },
      {
        theme: 'The Nature of Time and Change',
        type: 'paradox' as DiscoveryType,
        hook: 'IS THE PAST STILL REAL, OR DOES ONLY THE PRESENT TICK OF THE CLOCK EXIST?',
        topic: 'Presentism vs Eternalism',
        origin: 'Debated from Heraclitus and Parmenides through Einstein\'s theory of relativity.',
        principles: [
          'The Block Universe: In four-dimensional spacetime, the past, present, and future all exist simultaneously.',
          'The Heraclitean River: You cannot step into the same river twice, for other waters are continually flowing on.',
          'The Illusion of Passage: The feeling of time moving forward may be an artifact of biological memory formation.'
        ],
        example: 'Stargazing at night: the starlight hitting your pupil left galaxies that may have burned out millions of years ago, allowing you to gaze directly into the past.',
        style: 'cosmic',
        thinkers: [{ name: 'Albert Einstein', role: 'Theoretical Physicist', era: '1879-1955', quote: 'The distinction between past, present and future is only a stubbornly persistent illusion.' }]
      }
    ];

    const archetype = archetypes[index % archetypes.length];
    const cycle = Math.floor(index / archetypes.length) + 1;
    const uniqueSlug = `synth-${archetype.type}-${index}-${Date.now().toString(36)}`;

    return {
      id: uniqueSlug,
      slug: uniqueSlug,
      title: `${archetype.theme} (Cycle ${cycle})`,
      type: archetype.type,
      hook: archetype.hook,
      short_description: `An infinite philosophical exploration into ${archetype.topic.toLowerCase()}.`,
      detailed_description: `This dynamic dialectic examines ${archetype.topic}. Across history, thinkers have grappled with the irreconcilable tensions between subjective human perception and objective structural laws. By holding these opposing perspectives in mindful contemplation, we uncover deeper insights into our own decision-making.`,
      origin_context: archetype.origin,
      core_principles: archetype.principles,
      everyday_example: archetype.example,
      background_style: archetype.style,
      key_people: archetype.thinkers,
      related_discoveries: [],
      contrasting_discoveries: [],
      why_reason: `Synthesized for continuous serendipity in ${archetype.topic}.`,
      status: 'published'
    };
  }
}

export const proceduralGenerator = new ProceduralGenerator();
