import { Discovery } from '../types';

export const curatedDiscoveries: Discovery[] = [
  // ================= PHILOSOPHIES =================
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
    id: 'existentialism',
    slug: 'existentialism',
    title: 'Existentialism',
    type: 'philosophy',
    hook: 'WHAT IF THERE IS NO PRE-MADE PURPOSE WAITING FOR YOU?',
    short_description: 'The belief that existence precedes essence: you are born first, and you must define your own meaning through choices.',
    detailed_description: 'Existentialism argues that humans are not born with a predetermined blueprint, destiny, or nature. We exist first in a world without inherent meaning, and through our authentic choices and actions, we forge our identity. This freedom brings immense anxiety (angst), but also absolute responsibility.',
    origin_context: 'Developed in 19th and 20th century Europe, gaining worldwide momentum in post-WWII Paris through literature, plays, and philosophy.',
    core_principles: [
      'Existence Precedes Essence: You are what you make of yourself through deliberate action.',
      'Radical Freedom: You are entirely condemned to be free; refusing to choose is still a choice.',
      'Bad Faith (Mauvaise Foi): Living dishonestly by pretending you had no choice is living inauthentically.',
      'Angst & Dread: The dizzying feeling that accompanies the realization of endless possibilities.'
    ],
    everyday_example: 'Instead of staying in a miserable corporate career just because "that is what society or parents expected," the existentialist recognizes that staying is an active choice, takes responsibility, and dares to carve out their authentic vocation.',
    background_style: 'existential_shadow',
    key_people: [
      { name: 'Jean-Paul Sartre', role: 'French Philosopher & Novelist', era: '1905–1980', quote: 'Man is condemned to be free; because once thrown into the world, he is responsible for everything he does.' },
      { name: 'Simone de Beauvoir', role: 'French Philosopher & Feminist Theorist', era: '1908–1986', quote: 'Change your life today. Don\'t gamble on the future, act now, without delay.' },
      { name: 'Friedrich Nietzsche', role: 'German Cultural Critic', era: '1844–1900', quote: 'He who has a why to live can bear almost any how.' }
    ],
    related_discoveries: [
      { id: 'absurdism', title: 'Absurdism', type: 'philosophy', reason: 'A direct sister philosophy addressing the clash between human yearning and a silent universe' },
      { id: 'friedrich-nietzsche', title: 'Friedrich Nietzsche', type: 'philosopher', reason: 'Precursor thinker who proclaimed the self-creation of values' }
    ],
    contrasting_discoveries: [
      { id: 'determinism', title: 'Determinism', type: 'scientific_idea', reason: 'Determinism claims all human choices are predetermined by prior physical and psychological causes, leaving no room for radical existential free will.' },
      { id: 'nihilism', title: 'Nihilism', type: 'philosophy', reason: 'Nihilism stops at "nothing matters", while Existentialism insists that because nothing is pre-written, you must actively create meaning.' }
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
    id: 'epicureanism',
    slug: 'epicureanism',
    title: 'Epicureanism',
    type: 'philosophy',
    hook: 'WHAT IF LUXURY DOES NOT MAKE US HAPPY, BUT TRANQUILITY AND DEEP FRIENDSHIP DO?',
    short_description: 'A philosophy advocating for a simple life, free from mental anxiety and physical pain, surrounded by good friends.',
    detailed_description: 'Often mischaracterized as reckless hedonism, Epicurus actually taught that chasing endless luxuries, fame, and wealth creates anxiety. Instead, true pleasure (ataraxia & aponia) is the absence of mental disturbance and physical pain, achieved through simple food, philosophical conversation, and close community.',
    origin_context: 'Founded by Epicurus around 307 BC in Athens, where he purchased a house and walled garden (The Garden) welcoming all people.',
    core_principles: [
      'Pleasure as the Highest Good: Defined soberly as freedom from fear and bodily pain.',
      'Categorization of Desires: Natural & necessary (water, friends), natural & unnecessary (luxury food), unnatural (fame, power).',
      'Elimination of the Fear of Death: "When we exist, death is not; when death exists, we are not."'
    ],
    everyday_example: 'Instead of going into debt to buy an exotic sports car to impress strangers, an Epicurean shares homemade pasta in a cozy garden with three lifelong friends, laughing until midnight without financial stress.',
    background_style: 'epicurean_garden',
    key_people: [
      { name: 'Epicurus', role: 'Greek Philosopher', era: '341–270 BC', quote: 'Do not spoil what you have by desiring what you have not; remember that what you now have was once among the things you only hoped for.' },
      { name: 'Lucretius', role: 'Roman Poet & Philosopher', era: '99–55 BC', quote: 'From nothing, nothing can become.' }
    ],
    related_discoveries: [
      { id: 'hedonic-adaptation', title: 'Hedonic Adaptation', type: 'concept', reason: 'Psychological mechanism explaining why luxury fails to raise baseline happiness' },
      { id: 'experience-machine', title: 'The Experience Machine', type: 'thought_experiment', reason: 'Tests whether pure simulated pleasure is what humans truly value' }
    ],
    contrasting_discoveries: [
      { id: 'stoicism', title: 'Stoicism', type: 'philosophy', reason: 'Stoics view civic duty, hardship, and public endurance as moral imperatives, whereas Epicureans intentionally step back from politics to protect tranquility.' }
    ]
  },
  {
    id: 'cynicism',
    slug: 'cynicism',
    title: 'Ancient Cynicism',
    type: 'philosophy',
    hook: 'WHAT IF SOCIETY\'S SOCIAL STATUS AND WEALTH ARE JUST EXPENSIVE PRISONS?',
    short_description: 'Living radically free by rejecting artificial social conventions, consumerism, and vanity in favor of raw nature.',
    detailed_description: 'Unlike modern pessimism, ancient Cynicism was a radical ethical movement. The Cynics lived in public defiance of wealth, power, and manners, asserting that virtue and self-sufficiency (autarky) are all one needs. When Alexander the Great offered Diogenes any favor in the world, Diogenes famously replied: "Stand a little out of my sun."',
    origin_context: 'Ancient Greece, 5th Century BC, established by Antisthenes (a student of Socrates) and popularized by Diogenes of Sinope.',
    core_principles: [
      'Askēsis: Rigorous mental and physical training to shed dependency on comforts.',
      'Parrhesia: Outspoken, fearless truth-telling directly to kings and crowds.',
      'Cosmopolitanism: Proclaiming oneself a "citizen of the world" rather than beholden to any state.'
    ],
    everyday_example: 'Refusing to buy a high-end designer watch to impress coworkers at a dinner, choosing instead worn sneakers and speaking your honest mind without fearing social disapproval.',
    background_style: 'cynic_bark',
    key_people: [
      { name: 'Diogenes of Sinope', role: 'Greek Cynic Philosopher', era: '412–323 BC', quote: 'I am looking for an honest human.' },
      { name: 'Antisthenes', role: 'Founder of Cynicism', era: '445–365 BC', quote: 'Virtue is a matter of actions and does not require many words or extensive learning.' }
    ],
    related_discoveries: [
      { id: 'diogenes', title: 'Diogenes of Sinope', type: 'philosopher', reason: 'The living embodiment of Cynic philosophy' },
      { id: 'stoicism', title: 'Stoicism', type: 'philosophy', reason: 'Stoicism was directly born from Cynicism, softened for civic duty' }
    ],
    contrasting_discoveries: [
      { id: 'utilitarianism', title: 'Utilitarianism', type: 'philosophy', reason: 'Utilitarianism relies on institutional systemic calculation of social welfare, which Cynics mock as artificial bureaucracy.' }
    ]
  },
  {
    id: 'utilitarianism',
    slug: 'utilitarianism',
    title: 'Utilitarianism',
    type: 'philosophy',
    hook: 'SHOULD AN ACTION BE JUDGED ONLY BY ITS CONSEQUENCES?',
    short_description: 'An ethical theory holding that the most moral action is the one that produces the greatest happiness for the greatest number.',
    detailed_description: 'Utilitarianism is a consequentialist framework: motives and rigid rules matter less than measurable outcomes. An action is morally right if it maximizes overall wellbeing and minimizes net suffering for all sentient beings affected, counting every individual\'s happiness equally.',
    origin_context: 'Formulated in 18th and 19th century Britain by Jeremy Bentham and refined by John Stuart Mill.',
    core_principles: [
      'The Greatest Happiness Principle: Actions are right in proportion as they tend to promote happiness.',
      'Equal Consideration of Interests: Nobody\'s pleasure or pain is inherently superior to another\'s.',
      'Consequentialism: Outcomes determine moral worth, not intentions.'
    ],
    everyday_example: 'A government deciding whether to allocate public funds to build an opera house for 5,000 enthusiasts or clean water infrastructure for 200,000 people. A utilitarian unequivocally funds the water infrastructure.',
    background_style: 'utilitarian_scales',
    key_people: [
      { name: 'Jeremy Bentham', role: 'English Philosopher & Reformer', era: '1748–1832', quote: 'It is the greatest happiness of the greatest number that is the measure of right and wrong.' },
      { name: 'John Stuart Mill', role: 'Philosopher & Political Economist', era: '1806–1873', quote: 'Better to be Socrates dissatisfied than a fool satisfied.' }
    ],
    related_discoveries: [
      { id: 'trolley-problem', title: 'The Trolley Problem', type: 'thought_experiment', reason: 'The classic dilemma testing utilitarian calculation versus moral intuition' },
      { id: 'veil-of-ignorance', title: 'Veil of Ignorance', type: 'thought_experiment', reason: 'A contrasting thought experiment on designing a just society' }
    ],
    contrasting_discoveries: [
      { id: 'deontology', title: 'Kantian Deontology', type: 'philosophy', reason: 'Kant states that some actions (like lying or sacrificing an innocent) are inherently immoral regardless of how good the consequences are.' }
    ]
  },
  {
    id: 'deontology',
    slug: 'deontology',
    title: 'Kantian Deontology',
    type: 'philosophy',
    hook: 'WHAT IF SOME ACTIONS ARE ALWAYS WRONG, NO MATTER HOW GOOD THE OUTCOME?',
    short_description: 'Duty-based ethics asserting that moral laws are universal and people must never be treated merely as a means to an end.',
    detailed_description: 'Immanuel Kant argued that morality does not depend on consequences, feelings, or circumstances, but on duty derived from pure practical reason. Through the Categorical Imperative, you must act only according to principles that you could rationally wish to become universal laws for all humanity.',
    origin_context: 'Enlightenment Germany, 1785, introduced in Kant\'s "Groundwork of the Metaphysics of Morals".',
    core_principles: [
      'Categorical Imperative: Act only on maxims you would will to become universal law.',
      'The Humanity Principle: Treat humanity always as an end in itself, never merely as an instrument.',
      'Good Will: Pure moral duty is the only thing good without qualification.'
    ],
    everyday_example: 'If a friend asks you to lie to their boss to cover up an unexcused absence, deontology says lying is wrong because if everyone lied whenever convenient, trust and communication would collapse universally.',
    background_style: 'deontology_geometry',
    key_people: [
      { name: 'Immanuel Kant', role: 'German Enlightenment Philosopher', era: '1724–1804', quote: 'Act in such a way that you treat humanity, whether in your own person or in the person of any other, never merely as a means to an end, but always at the same time as an end.' }
    ],
    related_discoveries: [
      { id: 'trolley-problem', title: 'The Trolley Problem', type: 'thought_experiment', reason: 'Deontology refuses to push the fat man or actively murder one to save five' }
    ],
    contrasting_discoveries: [
      { id: 'utilitarianism', title: 'Utilitarianism', type: 'philosophy', reason: 'Utilitarianism happily breaks rules if the net outcome produces more happiness.' },
      { id: 'pragmatism', title: 'Pragmatism', type: 'philosophy', reason: 'Pragmatism evaluates truth and ethics based on what works in practical human experience.' }
    ]
  },

  // ================= PARADOXES =================
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
    id: 'grandfather-paradox',
    slug: 'grandfather-paradox',
    title: 'The Grandfather Paradox',
    type: 'paradox',
    hook: 'IF YOU TRAVEL BACK IN TIME AND PREVENT YOUR GRANDPARENTS FROM MEETING, HOW WERE YOU BORN TO TRAVEL BACK?',
    short_description: 'A logical time-travel paradox showing the causal impossibility of changing the past in a single timeline.',
    detailed_description: 'If backwards time travel is possible and you alter a past event essential to your own birth, you create a causal loop: you were never born, meaning you could never build the time machine, meaning your grandparents did meet, meaning you were born. Physics solutions suggest either the Novikov Self-Consistency principle (the timeline resists contradiction) or the Many-Worlds interpretation (branching parallel universes).',
    origin_context: 'Popularized in 1930s science fiction magazines and formally explored in theoretical relativity and quantum physics.',
    core_principles: [
      'Causal Loops: An effect preceding its own cause.',
      'Novikov Self-Consistency: Any action a time traveler takes in the past has already been part of history.',
      'Everett Many-Worlds: Altering the past simply branches into an alternative quantum reality.'
    ],
    everyday_example: 'Trying to delete the email account that you used to send yourself the login password to the server. If you succeed, you lose the password and can never delete the account.',
    background_style: 'temporal_loop',
    key_people: [
      { name: 'Igor Novikov', role: 'Russian Theoretical Physicist & Cosmologist', era: '1935–Present', quote: 'Proposed the principle of self-consistency in closed timelike curves.' }
    ],
    related_discoveries: [
      { id: 'quantum-superposition', title: 'Quantum Superposition', type: 'scientific_idea', reason: 'Quantum mechanics provides mathematical foundations for multiverse time branches' }
    ],
    contrasting_discoveries: [
      { id: 'determinism', title: 'Determinism', type: 'scientific_idea', reason: 'Classical determinism allows only one unalterable chronological chain of cause and effect.' }
    ]
  },

  // ================= THOUGHT EXPERIMENTS =================
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
    id: 'experience-machine',
    slug: 'experience-machine',
    title: 'The Experience Machine',
    type: 'thought_experiment',
    hook: 'IF A MACHINE COULD SIMULATE PERFECT HAPPINESS FOR THE REST OF YOUR LIFE, WOULD YOU PLUG IN?',
    short_description: 'A thought experiment challenging hedonism by asking if we care about reality more than synthetic pleasure.',
    detailed_description: 'Philosopher Robert Nozick asks: Suppose super-neuroscientists built a machine that could stimulate your brain so you would experience writing a great novel, scoring a winning goal, or falling in love, without ever knowing you are floating in a tank with electrodes. You can program any life you desire. Would you permanently plug in?',
    origin_context: 'Formulated by Robert Nozick in his 1974 book "Anarchy, State, and Utopia".',
    core_principles: [
      'Beyond Hedonism: Proves that humans value authentic contact with reality, not just internal neural sensations.',
      'Desire to Do, Not Just Experience: We want to actually achieve things and be a certain kind of person.',
      'Matrix Precursor: Directly inspired the central philosophical premise of the movie "The Matrix".'
    ],
    everyday_example: 'Choosing to spend months training and climbing a real mountain in freezing rain versus playing a hyper-realistic VR climbing video game in your living room.',
    background_style: 'cyber_grid',
    key_people: [
      { name: 'Robert Nozick', role: 'American Political Philosopher', era: '1938–2002', quote: 'We learn that something matters to us in addition to experience by imagining an experience machine and then realizing that we would not use it.' }
    ],
    related_discoveries: [
      { id: 'simulation-hypothesis', title: 'Simulation Hypothesis', type: 'scientific_idea', reason: 'Explores the cosmological version where we may already be plugged into a simulation' },
      { id: 'epicureanism', title: 'Epicureanism', type: 'philosophy', reason: 'Philosophical inquiry into the true nature of human pleasure and flourishing' }
    ],
    contrasting_discoveries: [
      { id: 'hedonic-adaptation', title: 'Hedonic Adaptation', type: 'concept', reason: 'Shows how human minds adapt to any state of pleasure, making permanent ecstasy neurologically impossible.' }
    ]
  },
  {
    id: 'veil-of-ignorance',
    slug: 'veil-of-ignorance',
    title: 'The Veil of Ignorance',
    type: 'thought_experiment',
    hook: 'HOW WOULD YOU DESIGN SOCIETY IF YOU HAD NO IDEA WHO YOU WOULD BE IN IT?',
    short_description: 'A method for determining justice by imagining creating rules without knowing your wealth, gender, or status.',
    detailed_description: 'John Rawls proposes an "Original Position": imagine you and others must agree on the fundamental laws of society behind a "Veil of Ignorance". You don\'t know if you will be born rich or poor, healthy or disabled, gifted or disadvantaged, majority or minority. Under this condition, self-interest forces you to design a genuinely fair society that protects the most vulnerable.',
    origin_context: 'Published by American philosopher John Rawls in "A Theory of Justice" in 1971.',
    core_principles: [
      'Fairness through Impartiality: Eliminates bias caused by personal privilege.',
      'The Difference Principle: Social and economic inequalities are permissible only if they benefit the least-advantaged members of society.',
      'Equal Basic Liberties: Everyone must have identical fundamental rights.'
    ],
    everyday_example: 'When two siblings are sharing the last slice of cake, one child cuts the slice and the other gets to choose which piece to take. The cutter naturally makes the cut 50/50 down the center to protect themselves.',
    background_style: 'veil_parchment',
    key_people: [
      { name: 'John Rawls', role: 'American Moral & Political Philosopher', era: '1921–2002', quote: 'Justice is the first virtue of social institutions, as truth is of systems of thought.' }
    ],
    related_discoveries: [
      { id: 'utilitarianism', title: 'Utilitarianism', type: 'philosophy', reason: 'Rawls developed the Veil of Ignorance specifically to counter utilitarianism\'s willingness to sacrifice minority interests' }
    ],
    contrasting_discoveries: [
      { id: 'machiavellianism', title: 'Machiavellian Realpolitik', type: 'historical_idea', reason: 'Views political power as ruthless conquest by the strong, rejecting idealized moral contracts.' }
    ]
  },

  // ================= CONCEPTS (PSYCHOLOGY & MIND) =================
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
    id: 'dichotomy-of-control',
    slug: 'dichotomy-of-control',
    title: 'The Dichotomy of Control',
    type: 'concept',
    hook: 'HOW MUCH OF YOUR ANXIETY COMES FROM TRYING TO CONTROL THINGS YOU SIMPLY CANNOT?',
    short_description: 'The practical division of all things in the universe into what is in your power and what is not.',
    detailed_description: 'Epictetus opened his Enchiridion with the rule: Some things are up to us, and some things are not. Up to us are opinion, desire, aversion, and our own actions. Not up to us are body, property, reputation, and the behavior of other people. If you desire things outside your control, you become an enslaved puppet of circumstances.',
    origin_context: 'Ancient Roman Stoicism, formalized by Epictetus in 108 AD in his Discourses.',
    core_principles: [
      'Internal Locus: Your effort, honesty, focus, and mindset belong to you.',
      'External Reality: The weather, stock market, elections, and other people belong to the world.',
      'Emotional Immunity: Ceasing to demand that reality conform to your private wishes.'
    ],
    everyday_example: 'Preparing thoroughly for a job interview (100% within your control), but remaining completely calm if the company promotes an internal candidate instead (0% within your control).',
    background_style: 'control_circle',
    key_people: [
      { name: 'Epictetus', role: 'Stoic Philosopher & Teacher', era: '50–135 AD', quote: 'Make the best use of what is in your power, and take the rest as it happens.' }
    ],
    related_discoveries: [
      { id: 'stoicism', title: 'Stoicism', type: 'philosophy', reason: 'The broader philosophical school built atop the Dichotomy of Control' },
      { id: 'amor-fati', title: 'Amor Fati', type: 'concept', reason: 'Taking the Dichotomy of Control a step further: loving whatever external fate brings' }
    ],
    contrasting_discoveries: [
      { id: 'determinism', title: 'Determinism', type: 'scientific_idea', reason: 'Hard determinism argues that even your internal decisions are products of prior physical brain states.' }
    ]
  },
  {
    id: 'hedonic-adaptation',
    slug: 'hedonic-adaptation',
    title: 'Hedonic Adaptation',
    type: 'concept',
    hook: 'WHY DOES WINNING THE LOTTERY OR BUYING A DREAM CAR ONLY MAKE US HAPPY FOR A FEW MONTHS?',
    short_description: 'The observed psychological tendency of humans to quickly return to a baseline level of happiness after major life changes.',
    detailed_description: 'Also known as the "hedonic treadmill," this psychological principle explains that whether you experience a massive positive event (lottery, promotion, dream home) or a negative one (breakup, injury), your psychological system rapidly habituates to the new baseline. Within months, your subjective happiness returns to its set point.',
    origin_context: 'Coined by Brickman and Campbell in 1971, reaffirmed by modern positive psychology researchers.',
    core_principles: [
      'The Set Point: Everyone has a baseline happiness temperament determined by biology and mindset.',
      'Diminishing Emotional Returns: Novel luxuries quickly become taken-for-granted expectations.',
      'Intentional Gratitude: Overcoming adaptation through negative visualization and active appreciation.'
    ],
    everyday_example: 'Upgrading your phone to the newest flagship model. On Day 1, you marvel at the screen and cameras; by Day 14, you scroll on it with the exact same emotional neutrality as your old phone.',
    background_style: 'treadmill_wave',
    key_people: [
      { name: 'Philip Brickman', role: 'American Social Psychologist', era: '1943–1982', quote: 'Conducted the landmark study comparing lottery winners and paraplegics.' }
    ],
    related_discoveries: [
      { id: 'epicureanism', title: 'Epicureanism', type: 'philosophy', reason: 'Ancient philosophy that predicted hedonic adaptation and advised against chasing luxury' },
      { id: 'experience-machine', title: 'The Experience Machine', type: 'thought_experiment', reason: 'Explores whether permanent synthetic pleasure could overcome hedonic adaptation' }
    ],
    contrasting_discoveries: [
      { id: 'hedonism', title: 'Hedonism', type: 'philosophy', reason: 'Hedonism assumes that stacking more physical pleasures directly yields a better life.' }
    ]
  },

  // ================= PHILOSOPHERS =================
  {
    id: 'marcus-aurelius',
    slug: 'marcus-aurelius',
    title: 'Marcus Aurelius',
    type: 'philosopher',
    hook: 'HOW DID THE MOST POWERFUL MAN IN THE WORLD STAY HUMBLE AND GROUNDED?',
    short_description: 'The Roman Emperor who governed an empire while secretly writing personal notes on duty, resilience, and mortality.',
    detailed_description: 'Marcus Aurelius ruled the Roman Empire during the Antonine Plague, foreign invasions, and betrayals. Yet every night by candlelight in his military tent, he wrote private reminders to himself—never meant for publication—on keeping his ego in check, serving humanity, and accepting the brevity of existence. These private writings became "Meditations".',
    origin_context: 'Rome, 161–180 AD, the last of the "Five Good Emperors".',
    core_principles: [
      'Duty to the Human Cosmopolis: We are made to cooperate like hands, feet, and rows of the upper and lower teeth.',
      'Inner Citadel: No person can harm your character unless you allow them to corrupt your integrity.',
      'Simplicity in Power: Resisting the poison of imperial hubris.'
    ],
    everyday_example: 'When confronted by rude or ungrateful colleagues, remembering Marcus\'s morning note: "When you wake up in the morning, tell yourself: the people I deal with today will be meddling, ungrateful, arrogant, dishonest, jealous, and surly. They are like this because they cannot distinguish good from evil. But I have seen the beauty of good."',
    background_style: 'roman_marble',
    key_people: [
      { name: 'Marcus Aurelius', role: 'Emperor of Rome & Author of Meditations', era: '121–180 AD', quote: 'Waste no more time arguing about what a good man should be. Be one.' }
    ],
    related_discoveries: [
      { id: 'stoicism', title: 'Stoicism', type: 'philosophy', reason: 'The philosophy that guided Marcus through pandemic, war, and betrayal' },
      { id: 'dichotomy-of-control', title: 'Dichotomy of Control', type: 'concept', reason: 'The mental discipline Marcus exercised daily' }
    ],
    contrasting_discoveries: [
      { id: 'machiavellianism', title: 'Machiavellian Realpolitik', type: 'historical_idea', reason: 'Machiavelli advises rulers to prioritize ruthlessness, deceit, and fear over Marcus\'s principled virtue.' }
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
    id: 'albert-camus',
    slug: 'albert-camus',
    title: 'Albert Camus',
    type: 'philosopher',
    hook: 'CAN ONE EMBRACE SUNSHINE, SEA, AND LAUGHTER IN A WORLD WITHOUT GOD OR DESTINY?',
    short_description: 'The Nobel prize-winning thinker who turned the absurdity of life into a passionate manifesto for freedom and rebellion.',
    detailed_description: 'Born into poverty in Algeria, Camus was an essayist, journalist, and French Resistance editor. He refused to join traditional political dogmas or religious faiths. Instead, he argued that recognizing life\'s lack of cosmic purpose is the beginning of true freedom: when you realize there is no afterlife or destiny, every minute in the sun becomes immensely precious.',
    origin_context: 'Algeria & France (1913–1960), awarded the Nobel Prize in Literature in 1957.',
    core_principles: [
      'The Myth of Sisyphus: The struggle toward the heights is enough to fill a human heart.',
      'The Rebel: Resisting tyranny without becoming a tyrant yourself.',
      'Mediterranean Sensuality: Finding profound meaning in physical existence, friendship, and art.'
    ],
    everyday_example: 'Refusing to waste your youth waiting for a future retirement paradise; choosing instead to work with honesty, swim in the sea, and love deeply today without illusions.',
    background_style: 'mediterranean_dusk',
    key_people: [
      { name: 'Albert Camus', role: 'Philosopher, Author & Resistance Editor', era: '1913–1960', quote: 'In the midst of winter, I found there was, within me, an invincible summer.' }
    ],
    related_discoveries: [
      { id: 'absurdism', title: 'Absurdism', type: 'philosophy', reason: 'The philosophy Camus created and articulated throughout his life' }
    ],
    contrasting_discoveries: [
      { id: 'existentialism', title: 'Existentialism', type: 'philosophy', reason: 'Camus famously rejected the label of Existentialist, arguing Sartre\'s system had become its own rigid political dogma.' }
    ]
  },
  {
    id: 'diogenes',
    slug: 'diogenes',
    title: 'Diogenes of Sinope',
    type: 'philosopher',
    hook: 'WHAT HAPPENS WHEN A MAN LIVES IN A WINE BARREL AND LAUGHS AT KINGS?',
    short_description: 'The original radical philosopher who owned only a wooden cloak and proved that wisdom requires zero luxury.',
    detailed_description: 'Diogenes took philosophy out of lecture halls into the marketplace. He slept in a large ceramic storage jar, discarded his only wooden drinking bowl when he saw a child drinking with cupped hands, and carried a lantern in broad daylight looking for "an honest human". He exposed the hypocrisy of Athens through razor-sharp wit and absolute fearlessness.',
    origin_context: 'Ancient Greece (412–323 BC), exile from Sinope who made Athens and Corinth his stage.',
    core_principles: [
      'Radical Self-Sufficiency: Needing almost nothing makes you untouchable by tyrants.',
      'Shedding Artificial Conventions: Social status, royal titles, and polite pretenses are illusions.',
      'Deeds Over Words: Practicing philosophy through bodily actions rather than abstract books.'
    ],
    everyday_example: 'When people try to shame you into buying status symbols to look wealthy, smiling contentedly in your simple clothes and asking them why they work 80 hours a week to impress people they don\'t like.',
    background_style: 'diogenes_barrel',
    key_people: [
      { name: 'Diogenes of Sinope', role: 'Cynic Sage', era: '412–323 BC', quote: 'Plato defined man as a featherless biped. Diogenes plucked a chicken and brought it into the academy: Behold, Plato\'s man!' }
    ],
    related_discoveries: [
      { id: 'cynicism', title: 'Ancient Cynicism', type: 'philosophy', reason: 'The school of thought founded on Diogenes\' fearless way of life' }
    ],
    contrasting_discoveries: [
      { id: 'epicureanism', title: 'Epicureanism', type: 'philosophy', reason: 'Epicurus preferred polite, peaceful garden retreats, while Diogenes chose provocative public defiance.' }
    ]
  },

  // ================= SCIENTIFIC IDEAS =================
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
    id: 'quantum-superposition',
    slug: 'quantum-superposition',
    title: 'Quantum Superposition',
    type: 'scientific_idea',
    hook: 'CAN A PARTICLE SIMULTANEOUSLY EXIST IN MULTIPLE MUTUALLY EXCLUSIVE STATES?',
    short_description: 'A fundamental principle of quantum physics where a system exists in all possible states until it is observed.',
    detailed_description: 'At the subatomic scale, particles such as electrons or photons do not possess single definite positions or states. Instead, their properties are described by a probability wave (wave function) encompassing all possible states simultaneously. Only when a measurement occurs does the wave function "collapse" into a single definite outcome.',
    origin_context: 'Developed during the 1920s by Niels Bohr, Werner Heisenberg, Erwin Schrödinger, and Max Born.',
    core_principles: [
      'Wave-Particle Duality: Matter behaves as both localized particles and spreading probability waves.',
      'The Measurement Problem: What constitutes an "observer" that collapses the wave function?',
      'Quantum Computing: Utilizing superposition (qubits) to perform calculations exponentially faster.'
    ],
    everyday_example: 'A coin spinning rapidly on a table is neither heads nor tails while in motion; it holds the potential for both until you slap your hand down to measure it.',
    background_style: 'quantum_wave',
    key_people: [
      { name: 'Erwin Schrödinger', role: 'Austrian Physicist & Nobel Laureate', era: '1887–1961', quote: 'Formulated the Schrödinger wave equation and the famous Cat thought experiment.' },
      { name: 'Niels Bohr', role: 'Danish Physicist', era: '1885–1962', quote: 'If quantum mechanics hasn\'t profoundly shocked you, you haven\'t understood it yet.' }
    ],
    related_discoveries: [
      { id: 'ship-of-theseus', title: 'Ship of Theseus', type: 'paradox', reason: 'Parallels the fundamental mystery of how physical identity persists' }
    ],
    contrasting_discoveries: [
      { id: 'determinism', title: 'Determinism', type: 'scientific_idea', reason: 'Classical determinism (Laplacian universe) asserts that every particle has exact, knowable, non-probabilistic trajectories.' }
    ]
  },
  {
    id: 'determinism',
    slug: 'determinism',
    title: 'Determinism',
    type: 'scientific_idea',
    hook: 'IF EVERY EVENT IS CAUSED BY A PRIOR PHYSICAL STATE, IS FREE WILL AN ILLUSION?',
    short_description: 'The philosophical and scientific thesis that every event, including human choice, is determined by prior causes and laws of nature.',
    detailed_description: 'Determinism states that the universe is governed by unbroken laws of physics. If an omniscient intellect (Laplace\'s Demon) knew the precise position and momentum of every atom in the universe at any single moment, it could calculate the entire past and future with absolute certainty. This poses profound questions for moral responsibility and legal culpability.',
    origin_context: 'Pioneered by Ancient Greek atomists (Democritus) and solidified in Newtonian classical mechanics in the 17th–18th centuries.',
    core_principles: [
      'Principle of Sufficient Reason: Everything that happens has an antecedent cause.',
      'Laplace\'s Demon: The theoretical predictability of the physical cosmos.',
      'Compatibilism vs Incompatibilism: Debate over whether moral agency can coexist with a deterministic universe.'
    ],
    everyday_example: 'A row of falling dominoes. The 100th domino does not "decide" to fall; its fall was guaranteed the moment the first domino was tipped.',
    background_style: 'clockwork_gears',
    key_people: [
      { name: 'Pierre-Simon Laplace', role: 'French Mathematician & Astronomer', era: '1749–1827', quote: 'We may regard the present state of the universe as the effect of its past and the cause of its future.' },
      { name: 'Baruch Spinoza', role: 'Dutch-Jewish Philosopher', era: '1632–1677', quote: 'Men think themselves free because they are conscious of their volitions, but ignorant of the causes that determine them.' }
    ],
    related_discoveries: [
      { id: 'quantum-superposition', title: 'Quantum Superposition', type: 'scientific_idea', reason: 'Introduces fundamental quantum indeterminacy into deterministic physics' }
    ],
    contrasting_discoveries: [
      { id: 'existentialism', title: 'Existentialism', type: 'philosophy', reason: 'Existentialism asserts radical free will: we are absolute authors of our choices and responsible for our lives.' }
    ]
  },

  // ================= HISTORICAL IDEAS =================
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
  },
  {
    id: 'the-great-filter',
    slug: 'the-great-filter',
    title: 'The Great Filter',
    type: 'historical_idea',
    hook: 'IS THE GREATEST BARRIER TO HUMAN SURVIVAL IN OUR PAST, OR WAITING IN OUR FUTURE?',
    short_description: 'The evolutionary barrier that prevents dead matter from evolving into an interstellar civilization.',
    detailed_description: 'To solve the Fermi Paradox, economist Robin Hanson proposed that somewhere between non-living chemistry and an advanced galaxy-spanning civilization, there is an evolutionary barrier that is nearly impossible to cross (The Great Filter). If the Filter is behind us (e.g. abiogenesis was a 1-in-a-trillion fluke), humanity has a bright future. If the Filter is ahead of us (e.g. all civilizations destroy themselves with advanced tech), our doom is near.',
    origin_context: 'Formulated by Robin Hanson in 1996 in his paper "The Great Filter - Are We Almost Past It?".',
    core_principles: [
      'Nine Evolutionary Steps: From habitable planets, reproductive molecules, and complex cells to tool-use and colonization.',
      'The Grim Discovery: Finding complex alien life (like fossils on Mars) would be terrible news, suggesting the Filter is ahead of us.',
      'Technological Existential Risks: AI, engineered bioweapons, and nuclear annihilation as candidate future filters.'
    ],
    everyday_example: 'Observing that billions of acorns fall from oak trees every autumn, but only one in ten million ever survives insects, drought, and shade to grow into a mature oak tree.',
    background_style: 'filter_cosmic',
    key_people: [
      { name: 'Robin Hanson', role: 'Associate Professor of Economics at George Mason University', era: '1959–Present', quote: 'The silence of the night sky suggests that an evolutionary bottleneck is extremely tight.' }
    ],
    related_discoveries: [
      { id: 'fermi-paradox', title: 'The Fermi Paradox', type: 'paradox', reason: 'The Great Filter is the principal scientific framework proposed to explain Fermi\'s silence' }
    ],
    contrasting_discoveries: [
      { id: 'simulation-hypothesis', title: 'Simulation Hypothesis', type: 'scientific_idea', reason: 'Proposes that space is silent not because aliens died, but because the simulation only generated Earth.' }
    ]
  },
  {
    id: 'machiavellianism',
    slug: 'machiavellianism',
    title: 'Machiavellian Realpolitik',
    type: 'historical_idea',
    hook: 'IS IT BETTER FOR A LEADER TO BE LOVED OR FEARED?',
    short_description: 'A pragmatic political philosophy separating statecraft from conventional morality, focusing on power as it is.',
    detailed_description: 'Niccolò Machiavelli broke with centuries of idealistic political philosophy by studying human behavior as it actually occurs rather than how it ought to be. In "The Prince", he argued that a ruler must know how to use both the cunning of the fox and the ferocity of the lion to maintain stability, because people are generally fickle, deceitful, and self-interested.',
    origin_context: 'Renaissance Florence, Italy (1513), written during Machiavelli\'s political exile.',
    core_principles: [
      'Virtù vs Fortuna: A ruler must have the bold cunning to master turbulent fortune.',
      'Better to be Feared than Loved: Love is held by a chain of obligation that men break when convenient; fear is held by dread of punishment.',
      'The Ends Justify the Means: A stable state excuses actions that would be immoral in private life.'
    ],
    everyday_example: 'A CEO undertaking painful corporate restructuring and layoffs in month one to guarantee company survival, rather than delaying out of sentimentality until the entire enterprise goes bankrupt.',
    background_style: 'renaissance_court',
    key_people: [
      { name: 'Niccolò Machiavelli', role: 'Florentine Diplomat, Historian & Writer', era: '1469–1527', quote: 'Everyone sees what you appear to be, few experience what you really are.' }
    ],
    related_discoveries: [
      { id: 'tragedy-of-the-commons', title: 'The Tragedy of the Commons', type: 'historical_idea', reason: 'Both examine how unrestrained self-interest operates in institutional settings' }
    ],
    contrasting_discoveries: [
      { id: 'marcus-aurelius', title: 'Marcus Aurelius', type: 'philosopher', reason: 'Marcus governed the Roman Empire through moral virtue and philosophical duty rather than cynical manipulation.' },
      { id: 'deontology', title: 'Kantian Deontology', type: 'philosophy', reason: 'Kant rejects calculating expediency and demands absolute adherence to ethical duty.' }
    ]
  },
  {
    id: 'amor-fati',
    slug: 'amor-fati',
    title: 'Amor Fati',
    type: 'concept',
    hook: 'WHAT IF YOU COULD NOT ONLY ENDURE YOUR WORST HARDSHIPS, BUT ACTUALLY LOVE THEM?',
    short_description: 'A mindset of radical acceptance where one loves everything that happens in life, good and bad, as necessary.',
    detailed_description: 'Amor Fati (Latin for "love of fate") is the psychological stance of not merely tolerating adversity, but embracing it with gratitude as an indispensable part of your existence. Rather than asking "why did this happen to me?" or wishing the past were different, one sees every triumph, heartbreak, and setback as essential fuel for personal growth.',
    origin_context: 'Rooted in Stoic philosophy (Epictetus, Marcus Aurelius) and formulated as a central life doctrine by Friedrich Nietzsche.',
    core_principles: [
      'Total Acceptance: Wanting nothing to be different, neither forward, nor backward, nor in all eternity.',
      'Obstacle as Fuel: Transforming grief and loss into profound strength and empathy.',
      'Eternal Recurrence Test: Would you be willing to relive every moment of your life over and over for eternity?'
    ],
    everyday_example: 'Looking back on a painful startup failure from 5 years ago and realizing that without that specific failure, you would never have developed the resilience, skills, or humility that made your current success possible.',
    background_style: 'golden_sunburst',
    key_people: [
      { name: 'Friedrich Nietzsche', role: 'German Philosopher', era: '1844–1900', quote: 'My formula for greatness in a human being is amor fati: that one wants nothing to be different.' },
      { name: 'Marcus Aurelius', role: 'Roman Emperor', era: '121–180 AD', quote: 'A blazing fire makes flame and brightness out of everything that is thrown into it.' }
    ],
    related_discoveries: [
      { id: 'stoicism', title: 'Stoicism', type: 'philosophy', reason: 'The ancient foundation of accepting fate with dignity' },
      { id: 'friedrich-nietzsche', title: 'Friedrich Nietzsche', type: 'philosopher', reason: 'The thinker who elevated Amor Fati into the supreme metric of psychological greatness' }
    ],
    contrasting_discoveries: [
      { id: 'existentialism', title: 'Existentialism', type: 'philosophy', reason: 'Existentialism emphasizes active defiance and changing your future through choices rather than fatalistic love of circumstances.' }
    ]
  },
  {
    id: 'confirmation-bias',
    slug: 'confirmation-bias',
    title: 'Confirmation Bias',
    type: 'concept',
    hook: 'WHY DO WE REMEMBER THE TIMES OUR HUNCH WAS RIGHT, AND CONVENIENTLY FORGET WHEN IT WAS WRONG?',
    short_description: 'The cognitive tendency to search for, interpret, and recall information in a way that confirms prior beliefs.',
    detailed_description: 'Confirmation bias is one of the most pervasive mental shortcuts in human cognition. Once an individual forms a hypothesis or emotional belief, their brain acts like a biased lawyer rather than an impartial scientist: it eagerly catalogues supporting evidence while ignoring or discrediting contradictory facts.',
    origin_context: 'Observed by Thucydides and Francis Bacon, and empirically demonstrated by psychologist Peter Wason in 1960.',
    core_principles: [
      'Selective Exposure: Only following news outlets or influencers who agree with you.',
      'Biased Interpretation: Interpreting ambiguous evidence as definitive proof of your stance.',
      'Selective Recall: Remembering coincidences that fit your theory and forgetting counterexamples.'
    ],
    everyday_example: 'Believing in horoscopes. When your horoscope says "you will face a financial decision today" and you buy a $4 coffee, you think "wow, it was right!", ignoring the 20 times the prediction was completely false.',
    background_style: 'bias_lens',
    key_people: [
      { name: 'Peter Wason', role: 'British Cognitive Psychologist', era: '1924–2003', quote: 'Designed the landmark 2-4-6 rule discovery and 4-card selection tasks.' },
      { name: 'Francis Bacon', role: 'Philosopher & Father of the Scientific Method', era: '1561–1626', quote: 'The human understanding when it has once adopted an opinion draws all things else to support and agree with it.' }
    ],
    related_discoveries: [
      { id: 'cognitive-dissonance', title: 'Cognitive Dissonance', type: 'concept', reason: 'The underlying discomfort that drives us to use confirmation bias as a shield' }
    ],
    contrasting_discoveries: [
      { id: 'socratic-irony', title: 'Socratic Method & Intellectual Humility', type: 'concept', reason: 'The deliberate method of rigorously questioning your own assumptions to uncover contradictions.' }
    ]
  },
  {
    id: 'socratic-irony',
    slug: 'socratic-irony',
    title: 'The Socratic Method',
    type: 'concept',
    hook: 'CAN ASKING THE RIGHT QUESTIONS DISPROVE WHAT EVERYONE THINKS IS COMMON SENSE?',
    short_description: 'A form of cooperative argumentative dialogue that stimulates critical thinking and exposes false certainties.',
    detailed_description: 'Socrates feigned ignorance ("I know that I know nothing") and asked seemingly simple questions to the arrogant scholars of Athens about justice, courage, or piety. Through step-by-step questioning (elenchus), he demonstrated that their confident definitions were riddled with self-contradictions, opening the door to genuine wisdom.',
    origin_context: 'Athens, 5th Century BC, immortalized in the dialogues of Plato.',
    core_principles: [
      'Intellectual Humility: Recognizing the limits of one\'s own understanding.',
      'Elenchus (Cross-Examination): Testing definitions by looking for counterexamples.',
      'Aporia: The state of productive confusion that precedes real learning.'
    ],
    everyday_example: 'Instead of aggressively arguing with a colleague holding an extreme opinion, you politely ask: "Help me understand: what would an example look like where that rule fails?" letting them discover the flaw themselves.',
    background_style: 'athenian_agora',
    key_people: [
      { name: 'Socrates', role: 'Classical Greek Athenian Philosopher', era: '470–399 BC', quote: 'The unexamined life is not worth living.' },
      { name: 'Plato', role: 'Student of Socrates & Founder of the Academy', era: '428–348 BC', quote: 'Recorded Socrates\' dialogues for posterity.' }
    ],
    related_discoveries: [
      { id: 'cynicism', title: 'Ancient Cynicism', type: 'philosophy', reason: 'Direct philosophical descendants of Socrates who took his public questioning to the streets' }
    ],
    contrasting_discoveries: [
      { id: 'confirmation-bias', title: 'Confirmation Bias', type: 'concept', reason: 'The mental trap the Socratic method is specifically designed to dismantle.' }
    ]
  },
  {
    id: 'wabi-sabi',
    slug: 'wabi-sabi',
    title: 'Wabi-Sabi',
    type: 'philosophy',
    hook: 'WHAT IF IMPERFECTION, ASYMMETRY, AND AGE ARE THE TRUEST FORMS OF BEAUTY?',
    short_description: 'A traditional Japanese aesthetic and worldview centered on the acceptance of transience and imperfection.',
    detailed_description: 'Rooted in Zen Buddhism and Taoism, Wabi-Sabi finds deep aesthetic and spiritual beauty in things that are flawed, weathered, cracked, and temporary. Instead of striving for sterile symmetry and eternal youth, it cherishes the patina of aged wood, cracked ceramics mended with gold (Kintsugi), and the fleeting blossom of cherry trees.',
    origin_context: 'Developed in Medieval Japan (15th–16th Century) through the Japanese Tea Ceremony (Chado) popularized by Sen no Rikyu.',
    core_principles: [
      'Nothing lasts, nothing is finished, nothing is perfect.',
      'Kintsugi: Mending broken pottery with gold lacquer, celebrating the fracture rather than hiding it.',
      'Mono no Aware: A gentle, bittersweet empathy toward the transience of all living things.'
    ],
    everyday_example: 'Appreciating the laugh lines around your eyes and the scratches on an old wooden dining table where family gathered for 20 years, rather than replacing it with plastic veneer.',
    background_style: 'wabi_sabi_ceramics',
    key_people: [
      { name: 'Sen no Rikyu', role: 'Japanese Tea Master', era: '1522–1591', quote: 'Tea is nothing other than this: Heat water, prepare tea, drink it with a calm heart.' }
    ],
    related_discoveries: [
      { id: 'taoism', title: 'Taoism (Daoism)', type: 'philosophy', reason: 'The foundational Eastern philosophy celebrating natural, uncarved simplicity' }
    ],
    contrasting_discoveries: [
      { id: 'rationalism', title: 'Rationalism', type: 'philosophy', reason: 'Rationalist aesthetics demand mathematical perfection, symmetry, and geometric exactness.' }
    ]
  }
];
