package com.phils.app.model

object SeedData {
    val discoveries: List<Discovery> = listOf(
        // ==========================================
        // 1. CLASSICAL & MODERN PHILOSOPHIES
        // ==========================================
        Discovery(
            id = "stoicism",
            title = "Stoicism",
            type = "PHILOSOPHY",
            mood = "stone",
            hook = "WHAT IF YOU COULD CONTROL YOUR REACTION,\nBUT NOT THE EVENT?",
            short = "A philosophy built around mastering your response to life rather than trying to control everything around you.",
            tags = listOf("control", "emotion", "resilience", "virtue", "ethics", "calm", "anxiety"),
            detail = DiscoveryDetail(
                whatIsThis = "Stoicism separates the world into two categories: what you can control and what you can't. Peace comes from focusing your energy only on the first.",
                origin = "Founded in Athens around 300 BCE by Zeno of Citium, and later shaped into a practical daily guide by Roman writers.",
                coreIdeas = listOf(
                    "The dichotomy of control: separate what's yours to influence from what isn't.",
                    "Virtue - wisdom, courage, justice, and temperance - is the only true good.",
                    "Disturbance comes from judgment, not from events themselves."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Marcus Aurelius", linkId = "marcus-aurelius"),
                    KeyPerson(name = "Epictetus"),
                    KeyPerson(name = "Seneca")
                ),
                example = "A delayed flight can't be controlled. How you spend the two-hour wait can.",
                quote = "The event doesn't disturb you - your verdict on it does."
            ),
            related = listOf("dichotomy-of-control", "marcus-aurelius", "epicureanism", "existentialism"),
            contrast = "epicureanism"
        ),
        Discovery(
            id = "existentialism",
            title = "Existentialism",
            type = "PHILOSOPHY",
            mood = "indigo",
            hook = "NO ONE HANDS YOU A PURPOSE.\nYOU HAVE TO BUILD ONE.",
            short = "The idea that existence comes first, and meaning is something you create rather than discover.",
            tags = listOf("meaning", "freedom", "choice", "identity", "purpose", "authenticity"),
            detail = DiscoveryDetail(
                whatIsThis = "Existentialism holds that people aren't born with a fixed purpose - we exist first, then define ourselves through the choices we make.",
                origin = "Emerged across 19th and 20th century Europe, gaining momentum after two world wars stripped away easy answers.",
                coreIdeas = listOf(
                    "Existence precedes essence - you aren't born with a nature to fulfill.",
                    "Freedom is unavoidable, and so is the responsibility that comes with it.",
                    "Authenticity means owning your choices instead of drifting on autopilot."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Jean-Paul Sartre"),
                    KeyPerson(name = "Søren Kierkegaard", linkId = "kierkegaard"),
                    KeyPerson(name = "Albert Camus", linkId = "albert-camus")
                ),
                example = "Choosing a career not because it's expected of you, but because you've decided it's yours.",
                quote = "You are your choices, and little else."
            ),
            related = listOf("absurdism", "nihilism", "albert-camus"),
            contrast = "nihilism"
        ),
        Discovery(
            id = "absurdism",
            title = "Absurdism",
            type = "PHILOSOPHY",
            mood = "burgundy",
            hook = "THE UNIVERSE WON'T ANSWER YOU -\nKEEP ASKING ANYWAY.",
            short = "The clash between our search for meaning and a universe that offers none - and why that's a reason to live fully.",
            tags = listOf("meaning", "universe", "rebellion", "purpose", "freedom", "camus"),
            detail = DiscoveryDetail(
                whatIsThis = "Absurdism is the tension between human desire for inherent meaning and the silent, indifferent universe. Instead of despair, Camus argued for defiance through living passionately.",
                origin = "Developed primarily by Albert Camus in mid-20th century France, centered in 'The Myth of Sisyphus' (1942).",
                coreIdeas = listOf(
                    "The absurd is born of the confrontation between human longing and cosmic silence.",
                    "You can reject both surrender and false hope - and choose to keep living anyway.",
                    "Sisyphus rolling his boulder isn't tragic if he owns the effort."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Albert Camus", linkId = "albert-camus")
                ),
                example = "Working hard on a creative project that may never become famous, simply because the act itself matters to you.",
                quote = "The silence doesn't need an answer - it needs a response."
            ),
            related = listOf("existentialism", "nihilism", "albert-camus"),
            contrast = "stoicism"
        ),
        Discovery(
            id = "nihilism",
            title = "Nihilism",
            type = "PHILOSOPHY",
            mood = "cosmic",
            hook = "WHAT IF NOTHING MEANS ANYTHING -\nAND THAT'S FINE?",
            short = "The view that life has no inherent meaning, value, or purpose - and an invitation to sit with that.",
            tags = listOf("meaning", "purpose", "freedom", "truth", "reality", "cosmic"),
            detail = DiscoveryDetail(
                whatIsThis = "Nihilism argues that claims about objective meaning, morality, or purpose don't hold up - there's no built-in reason for anything, including us.",
                origin = "Gained traction in 19th-century Russia and was analyzed intensely by Nietzsche as a cultural crisis.",
                coreIdeas = listOf(
                    "No objective morality exists in the structure of the universe.",
                    "Meaning is a human invention, not an external fact waiting to be found.",
                    "This can be read as despair - or as total freedom from imposed rules."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Friedrich Nietzsche", linkId = "nietzsche")
                ),
                example = "Realizing a bad day at work doesn't matter to the stars, which takes the sting out of it.",
                quote = "When you look into the abyss, the abyss also looks into you."
            ),
            related = listOf("existentialism", "absurdism", "nietzsche"),
            contrast = "existentialism"
        ),
        Discovery(
            id = "epicureanism",
            title = "Epicureanism",
            type = "PHILOSOPHY",
            mood = "sage",
            hook = "PLEASURE ISN'T WILD LIVING.\nIT'S PEACE OF MIND.",
            short = "A philosophy that treats simple pleasures, good friends, and the absence of anxiety as the highest life.",
            tags = listOf("pleasure", "peace", "moderation", "friendship", "anxiety", "calm"),
            detail = DiscoveryDetail(
                whatIsThis = "Epicureanism is often misunderstood as pure hedonism, but it's really about minimizing pain and mental disturbance through modest, deliberate living.",
                origin = "Founded around 307 BCE in Athens by Epicurus, who taught in a garden open to all, including women and slaves.",
                coreIdeas = listOf(
                    "Ataraxia: untroubled, tranquil peace of mind is the true goal.",
                    "Fear of death and gods is the root of human unhappiness.",
                    "Simple pleasures - friendship, food, rest - outperform excess."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Epicurus"),
                    KeyPerson(name = "Lucretius")
                ),
                example = "Enjoying dinner with two close friends at home rather than stressing over a VIP guest list.",
                quote = "Do not spoil what you have by desiring what you have not."
            ),
            related = listOf("stoicism", "hedonism"),
            contrast = "hedonism"
        ),
        Discovery(
            id = "utilitarianism",
            title = "Utilitarianism",
            type = "PHILOSOPHY",
            mood = "terracotta",
            hook = "THE GREATEST GOOD FOR THE GREATEST NUMBER.\nNO EXCEPTIONS?",
            short = "The ethical system that measures moral rightness purely by the total happiness and suffering produced by actions.",
            tags = listOf("ethics", "morality", "happiness", "consequences", "trolley"),
            detail = DiscoveryDetail(
                whatIsThis = "Utilitarianism judges an action not by intentions, rules, or traditions, but strictly by its consequences: does it maximize overall well-being and minimize pain?",
                origin = "Systematized in 18th and 19th century Britain by Jeremy Bentham and John Stuart Mill.",
                coreIdeas = listOf(
                    "Consequentialism: Outcomes matter, not abstract moral dogmas.",
                    "Equal consideration of interests: Everyone's happiness counts equally.",
                    "Act vs Rule Utilitarianism: Following beneficial rules versus calculating each decision."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Jeremy Bentham"),
                    KeyPerson(name = "John Stuart Mill"),
                    KeyPerson(name = "Peter Singer")
                ),
                example = "Choosing to donate $100 to famine relief rather than buying a luxury watch, because it produces vastly more human flourishing.",
                quote = "The greatest happiness of the greatest number is the foundation of morals."
            ),
            related = listOf("trolley-problem", "deontology", "veil-of-ignorance"),
            contrast = "deontology"
        ),
        Discovery(
            id = "cynicism",
            title = "Cynicism",
            type = "PHILOSOPHY",
            mood = "ochre",
            hook = "LIVING IN A TUB WITH NOTHING TO LOSE.\nTRUE FREEDOM?",
            short = "An ancient school that rejected social conventions, wealth, and status to live in radical harmony with nature.",
            tags = listOf("freedom", "nature", "rebellion", "simplicity", "status"),
            detail = DiscoveryDetail(
                whatIsThis = "Classical Cynicism was not bitter pessimism, but a radical pursuit of virtue through shedding every artificial social norm, luxury, and illusion of prestige.",
                origin = "Founded in 4th-century BCE Greece by Antisthenes and made famous by Diogenes of Sinope.",
                coreIdeas = listOf(
                    "Virtue is the only requirement for happiness, completely independent of wealth.",
                    "Social conventions are artificial chains that make humans miserable.",
                    "Shameless authenticity: speak truth to power without seeking approval."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Diogenes of Sinope", linkId = "diogenes"),
                    KeyPerson(name = "Antisthenes")
                ),
                example = "Refusing to buy an expensive designer coat just to impress strangers at a networking event.",
                quote = "I am looking for an honest human being."
            ),
            related = listOf("diogenes", "stoicism", "epicureanism"),
            contrast = "hedonism"
        ),
        Discovery(
            id = "taoism",
            title = "Taoism",
            type = "PHILOSOPHY",
            mood = "ocean",
            hook = "THE WATER CONQUERS THE ROCK -\nNOT BY FORCE, BUT BY YIELDING.",
            short = "An ancient Chinese tradition centered on alignment with the Tao through effortless action (Wu Wei).",
            tags = listOf("flow", "nature", "balance", "wu-wei", "harmony", "peace"),
            detail = DiscoveryDetail(
                whatIsThis = "Taoism teaches that striving, forcing, and overthinking run counter to the natural rhythm of reality. Power comes from softness, patience, and moving with the flow.",
                origin = "Originated in Ancient China during the 6th century BCE, crystallized in the Tao Te Ching by Lao Tzu.",
                coreIdeas = listOf(
                    "Wu Wei (Effortless Action): Acting without forced contrivance or aggressive ego.",
                    "The Tao: The underlying source and order of the universe that cannot be named.",
                    "Harmony of Opposites: Yin and Yang are interdependent aspects of one whole."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Lao Tzu", linkId = "lao-tzu"),
                    KeyPerson(name = "Zhuangzi")
                ),
                example = "Letting muddy water sit undisturbed until it becomes clear, rather than splashing around trying to clean it.",
                quote = "Nature does not hurry, yet everything is accomplished."
            ),
            related = listOf("lao-tzu", "stoicism", "zen"),
            contrast = "determinism"
        ),
        Discovery(
            id = "determinism",
            title = "Hard Determinism",
            type = "PHILOSOPHY",
            mood = "slate",
            hook = "DID YOU CHOOSE TO READ THIS,\nOR WERE YOU BOUND TO?",
            short = "The philosophical doctrine that every event, decision, and thought is entirely dictated by prior causes.",
            tags = listOf("free-will", "causality", "physics", "fate", "choice"),
            detail = DiscoveryDetail(
                whatIsThis = "Determinism posits that the universe is governed by unbreakable causal laws. Given the initial state of the Big Bang and physical laws, your current action could not have occurred otherwise.",
                origin = "Rooted in early atomism and amplified by classical Newtonian mechanics and modern neuroscience.",
                coreIdeas = listOf(
                    "Universal Causality: No event happens without sufficient prior causes.",
                    "The Illusion of Free Will: We feel free only because we are blind to the thousands of neurochemical causes.",
                    "Moral Implications: If choices are predetermined, how can praise or punishment be justified?"
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Baruch Spinoza", linkId = "spinoza"),
                    KeyPerson(name = "Pierre-Simon Laplace")
                ),
                example = "Believing you picked coffee over tea freely, ignoring genetics, sleep debt, dopamine levels, and advertising exposures.",
                quote = "Men believe themselves free, merely because they are conscious of their actions, and ignorant of the causes."
            ),
            related = listOf("spinoza", "simulation-hypothesis", "compatibilism"),
            contrast = "existentialism"
        ),
        Discovery(
            id = "solipsism",
            title = "Solipsism",
            type = "PHILOSOPHY",
            mood = "cosmic",
            hook = "HOW CAN YOU PROVE THAT ANY MIND\nEXISTS EXCEPT YOUR OWN?",
            short = "The philosophical position that only your own mind is guaranteed to exist; everything else may be a simulation or dream.",
            tags = listOf("consciousness", "mind", "doubt", "epistemology", "reality"),
            detail = DiscoveryDetail(
                whatIsThis = "You have immediate access to your own thoughts, pains, and perceptions, but you can only ever observe the outer behavior of others. Solipsism notes the impossibility of proving other minds exist.",
                origin = "Traces from ancient Greek sophist Gorgias through Descartes' radical doubt in 1641.",
                coreIdeas = listOf(
                    "The Privileged Self: Direct subjective awareness is the only unshakeable certainty.",
                    "The Problem of Other Minds: We assume others have inner lives by analogy, but cannot prove it.",
                    "Radical Epistemological Humility: Acknowledging the frontier where certainty terminates."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "René Descartes", linkId = "descartes"),
                    KeyPerson(name = "Gorgias")
                ),
                example = "Having an intense dream where you spoke with friends for hours, only to wake up and discover your brain created every character.",
                quote = "I think, therefore I am."
            ),
            related = listOf("descartes", "simulation-hypothesis", "brain-in-a-vat"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "hedonism",
            title = "Hedonism",
            type = "PHILOSOPHY",
            mood = "rose",
            hook = "IF PLEASURE ISN'T THE POINT OF LIFE,\nTHEN WHAT IS?",
            short = "The philosophical stance that pleasure is the highest intrinsic good and proper aim of human life.",
            tags = listOf("pleasure", "desire", "good", "experience", "happiness"),
            detail = DiscoveryDetail(
                whatIsThis = "Hedonism claims that pleasure (broadly construed as joy, satisfaction, and flourishing) is the only thing valuable in itself, while pain is the only intrinsic evil.",
                origin = "Pioneered in Ancient Greece by Aristippus of Cyrene, who advocated chasing immediate, intense physical enjoyment.",
                coreIdeas = listOf(
                    "Intrinsic Value of Pleasure: All other goods (money, knowledge, status) are merely means to pleasure.",
                    "Cyrenaic vs Epicurean: Immediate sensory thrill versus long-term tranquil stability.",
                    "The Paradox of Hedonism: Chasing pleasure too aggressively often diminishes the pleasure received."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Aristippus of Cyrene"),
                    KeyPerson(name = "Jeremy Bentham")
                ),
                example = "Choosing a weekend relaxing at the beach with music instead of working overtime for a title upgrade you don't need.",
                quote = "Pleasure is the beginning and the end of living happily."
            ),
            related = listOf("epicureanism", "experience-machine"),
            contrast = "stoicism"
        ),
        Discovery(
            id = "pragmatism",
            title = "Pragmatism",
            type = "PHILOSOPHY",
            mood = "terracotta",
            hook = "DOES IT MATTER IF AN IDEA IS TRUE,\nIF IT WORKS IN PRACTICE?",
            short = "An American philosophical tradition assessing truth by the practical, observable difference an idea makes.",
            tags = listOf("truth", "action", "practical", "science", "usefulness"),
            detail = DiscoveryDetail(
                whatIsThis = "Pragmatism rejects abstract metaphysical debates about ultimate reality. Instead, it asks: What concrete difference does holding this belief make in the real world?",
                origin = "Developed in late 19th-century America by Charles Sanders Peirce, William James, and John Dewey.",
                coreIdeas = listOf(
                    "The Pragmatic Maxim: The meaning of an idea is found in its practical consequences.",
                    "Truth as What Works: Truth is dynamic and tested by experience, not fixed in stone.",
                    "Belief as a Habit of Action: What you truly believe is revealed by how you live, not what you say."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "William James"),
                    KeyPerson(name = "John Dewey")
                ),
                example = "Adopting a growth mindset because it improves your resilience, regardless of genetic determinism arguments.",
                quote = "Truth is what works in the way of belief."
            ),
            related = listOf("utilitarianism", "empiricism"),
            contrast = "rationalism"
        ),
        Discovery(
            id = "deontology",
            title = "Deontology (Kantian Ethics)",
            type = "PHILOSOPHY",
            mood = "stone",
            hook = "WOULD YOU LIE TO A MURDERER\nTO SAVE YOUR BEST FRIEND?",
            short = "Duty-based ethics asserting that certain actions are intrinsically right or wrong, regardless of the consequences.",
            tags = listOf("duty", "rules", "ethics", "kant", "morality", "truth"),
            detail = DiscoveryDetail(
                whatIsThis = "Deontology argues that morality is governed by absolute moral duties discovered by reason. If lying is wrong, it is wrong even if telling the truth causes disaster.",
                origin = "Formulated by Immanuel Kant in Groundwork of the Metaphysics of Morals (1785).",
                coreIdeas = listOf(
                    "The Categorical Imperative: Act only on maxims you could willingly turn into universal laws for all humans.",
                    "Treat Humans as Ends: Never use another human merely as a tool or means to an outcome.",
                    "Moral Autonomy: Doing right out of duty, not fear of punishment or hope of reward."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Immanuel Kant", linkId = "immanuel-kant")
                ),
                example = "Refusing to cheat on an exam even if you know you will never get caught and need the score to graduate.",
                quote = "Two things fill the mind with wonder: the starry sky above and the moral law within."
            ),
            related = listOf("immanuel-kant", "trolley-problem", "utilitarianism"),
            contrast = "utilitarianism"
        ),
        Discovery(
            id = "virtue-ethics",
            title = "Virtue Ethics",
            type = "PHILOSOPHY",
            mood = "sage",
            hook = "DON'T ASK WHAT RULES TO FOLLOW.\nASK WHO YOU WANT TO BECOME.",
            short = "An ethical framework focusing on cultivating noble character traits rather than calculating consequences or laws.",
            tags = listOf("virtue", "character", "excellence", "habits", "aristotle"),
            detail = DiscoveryDetail(
                whatIsThis = "Virtue ethics shifts focus from isolated actions to the person performing them. A good life (Eudaimonia) is achieved through habituating virtues like courage, wisdom, and fairness.",
                origin = "Pioneered by Aristotle in Ancient Greece through the Nicomachean Ethics.",
                coreIdeas = listOf(
                    "The Golden Mean: Every virtue is the balanced midpoint between excess and deficiency (courage lies between cowardice and rashness).",
                    "Character through Habit: We become just by doing just acts; character is muscle memory.",
                    "Eudaimonia: Human flourishing achieved through lifelong excellence of character."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Aristotle", linkId = "aristotle"),
                    KeyPerson(name = "Alasdair MacIntyre")
                ),
                example = "Practicing calm responses in small irritations so that when a crisis hits, composure is second nature.",
                quote = "We are what we repeatedly do. Excellence, then, is not an act, but a habit."
            ),
            related = listOf("aristotle", "stoicism", "deontology"),
            contrast = "utilitarianism"
        ),
        Discovery(
            id = "rationalism",
            title = "Rationalism",
            type = "PHILOSOPHY",
            mood = "indigo",
            hook = "CAN PURE REASON REVEAL THE UNIVERSE\nWITHOUT TOUCHING IT?",
            short = "The epistemological view that reason, rather than sensory experience, is the primary source of human knowledge.",
            tags = listOf("reason", "logic", "knowledge", "descartes", "epistemology"),
            detail = DiscoveryDetail(
                whatIsThis = "Rationalism argues that our senses are easily tricked and cannot provide foundational certainty. True knowledge is derived from innate ideas, deduction, and mathematical logic.",
                origin = "Flourished in 17th-century Continental Europe led by Descartes, Spinoza, and Leibniz.",
                coreIdeas = listOf(
                    "Innate Ideas: Concepts like mathematics, infinity, and causality are hardwired into intellect.",
                    "Deductive Certainty: Deriving universal truths from self-evident axioms.",
                    "Skepticism of the Senses: Optical illusions prove senses cannot be trusted unconditionally."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "René Descartes", linkId = "descartes"),
                    KeyPerson(name = "Baruch Spinoza", linkId = "spinoza"),
                    KeyPerson(name = "Gottfried Leibniz")
                ),
                example = "Knowing that 2 + 2 = 4 with absolute certainty without having to measure four apples in the physical world.",
                quote = "Reason is the sovereign light of the mind."
            ),
            related = listOf("descartes", "spinoza", "empiricism"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "empiricism",
            title = "Empiricism",
            type = "PHILOSOPHY",
            mood = "ocean",
            hook = "NOTHING IN THE INTELLECT\nTHAT WAS NOT FIRST IN THE SENSES.",
            short = "The foundational philosophy of science: all knowledge originates from sensory experience and observation.",
            tags = listOf("science", "senses", "evidence", "observation", "knowledge"),
            detail = DiscoveryDetail(
                whatIsThis = "Empiricism contends that humans are born as blank slates (tabula rasa). All ideas, concepts, and theories are constructed strictly from sensory observation and experiment.",
                origin = "Formulated in 17th and 18th century Britain by John Locke, George Berkeley, and David Hume.",
                coreIdeas = listOf(
                    "Tabula Rasa: The mind begins empty; experience paints all knowledge upon it.",
                    "Empirical Falsification: Hypotheses must be tested against real-world observations.",
                    "Skepticism of Metaphysics: Questions that cannot be observed or measured are meaningless."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "John Locke"),
                    KeyPerson(name = "David Hume")
                ),
                example = "Testing a vaccine across thousands of human trials rather than relying on theoretical deduction alone.",
                quote = "No man's knowledge here can go beyond his experience."
            ),
            related = listOf("rationalism", "pragmatism"),
            contrast = "rationalism"
        ),

        // ==========================================
        // 2. GREAT THINKERS & PHILOSOPHERS
        // ==========================================
        Discovery(
            id = "marcus-aurelius",
            title = "Marcus Aurelius",
            type = "THINKER",
            mood = "stone",
            hook = "HOW DID THE MOST POWERFUL MAN IN ROME\nSTAY HUMBLE AND GROUNDED?",
            short = "The Roman Emperor who ruled an empire while secretly writing private notes on duty, resilience, and mortality.",
            tags = listOf("stoicism", "leadership", "power", "humility", "duty", "rome"),
            detail = DiscoveryDetail(
                whatIsThis = "Marcus Aurelius ruled the Roman Empire for nearly two decades while keeping a private journal working through Stoic ideas - never intended for publication.",
                origin = "Born 121 CE in Rome; wrote his personal notes ('Meditations') during military campaigns in Germany.",
                coreIdeas = listOf(
                    "Duty to the human community: we are made to cooperate.",
                    "The inner citadel: external chaos can't reach your core without consent.",
                    "Resisting the poison of power: constantly reminding himself of his small place in time."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Marcus Aurelius")
                ),
                example = "Reminding himself before meetings that he will meet difficult, rude, and ungrateful people, and deciding in advance not to be infected by them.",
                quote = "You have power over your mind - not outside events. Realize this, and you will find strength."
            ),
            related = listOf("stoicism", "epictetus"),
            contrast = "nietzsche"
        ),
        Discovery(
            id = "nietzsche",
            title = "Friedrich Nietzsche",
            type = "THINKER",
            mood = "burgundy",
            hook = "WHAT IF HARDSHIP ISN'T A TRAGEDY,\nBUT THE ONLY SOURCE OF GREATNESS?",
            short = "The provocative philosopher who warned against herd conformity and urged humans to create their own values.",
            tags = listOf("overcoming", "values", "will-to-power", "strength", "nihilism"),
            detail = DiscoveryDetail(
                whatIsThis = "Nietzsche diagnosed modern nihilism and called on individuals to overcome societal mediocrity, embrace suffering as growth, and love their fate (Amor Fati).",
                origin = "Wrote across Germany, Switzerland, and Italy in the late 19th century.",
                coreIdeas = listOf(
                    "Will to power: life is driven by self-expansion, creative vitality, and overcoming limits.",
                    "Amor Fati: don't just endure your life - love every joy and tragedy of it.",
                    "The Übermensch: creating your own meaning rather than following inherited moral dogmas."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Friedrich Nietzsche")
                ),
                example = "Seeing a painful career setback not as proof of failure, but as the friction needed to build genuine mastery.",
                quote = "He who has a why to live can bear almost any how."
            ),
            related = listOf("nihilism", "existentialism"),
            contrast = "stoicism"
        ),
        Discovery(
            id = "socrates",
            title = "Socrates",
            type = "THINKER",
            mood = "amber",
            hook = "WHY WAS THE WISEST MAN IN GREECE\nCERTAIN HE KNEW NOTHING?",
            short = "The street philosopher who transformed thinking by questioning every assumption until only clarity remained.",
            tags = listOf("questioning", "wisdom", "dialogue", "humility", "greece"),
            detail = DiscoveryDetail(
                whatIsThis = "Socrates never wrote a book; he interrogated citizens in the marketplace, exposing how their deepest convictions were built on unexamined assumptions.",
                origin = "Lived in Classical Athens (470-399 BCE); executed by forced hemlock for 'corrupting the youth'.",
                coreIdeas = listOf(
                    "Socratic Irony: True wisdom begins with admitting you do not know.",
                    "The Elenchus: Testing beliefs by seeking contradictions through disciplined questioning.",
                    "The Unexamined Life: Living on societal autopilot is not worth the gift of consciousness."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Socrates"),
                    KeyPerson(name = "Plato", linkId = "plato")
                ),
                example = "Asking yourself five consecutive 'Why do I want this?' questions to discover if a goal is truly yours or just copied from others.",
                quote = "I know that I know nothing."
            ),
            related = listOf("plato", "allegory-of-the-cave"),
            contrast = "cynicism"
        ),
        Discovery(
            id = "plato",
            title = "Plato",
            type = "THINKER",
            mood = "indigo",
            hook = "WHAT IF THE PHYSICAL WORLD\nIS MERELY A FLAWED COPY?",
            short = "Socrates' student who founded the Western philosophical tradition with his Theory of Forms and political visions.",
            tags = listOf("forms", "idealism", "truth", "justice", "republic"),
            detail = DiscoveryDetail(
                whatIsThis = "Plato argued that behind the fleeting, imperfect physical things we see lies an eternal, immaterial realm of perfect Forms (Justice, Beauty, Truth, Geometry).",
                origin = "Founded the Academy in Athens around 387 BCE, the Western world's first university.",
                coreIdeas = listOf(
                    "Theory of Forms: True reality consists of timeless non-physical ideals.",
                    "Tripartite Soul: The human mind is in constant tension between Reason, Spirit (honor), and Appetite.",
                    "Philosopher Kings: Societies will suffer until rulers love truth more than power."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Plato"),
                    KeyPerson(name = "Socrates", linkId = "socrates"),
                    KeyPerson(name = "Aristotle", linkId = "aristotle")
                ),
                example = "You have never seen a geometrically perfect circle drawn with a pen, yet your mind recognizes the ideal concept of a circle instantly.",
                quote = "Reality is created by the mind, we can change our reality by changing our mind."
            ),
            related = listOf("socrates", "allegory-of-the-cave", "aristotle"),
            contrast = "aristotle"
        ),
        Discovery(
            id = "aristotle",
            title = "Aristotle",
            type = "THINKER",
            mood = "sage",
            hook = "WHY DID PLATO LOOK UP TO THE HEAVENS,\nWHILE ARISTOTLE LOOKED DOWN AT THE EARTH?",
            short = "The master of biology, logic, and ethics who grounded philosophy in empirical observation and teleology.",
            tags = listOf("logic", "ethics", "biology", "telos", "nature"),
            detail = DiscoveryDetail(
                whatIsThis = "Aristotle rejected Plato's separate world of Forms. He argued that the essence of a thing is embedded inside the physical thing itself, and everything in nature has a built-in purpose (telos).",
                origin = "Studied at Plato's Academy for 20 years, tutored Alexander the Great, and founded the Lyceum.",
                coreIdeas = listOf(
                    "Teleology: Everything in nature strives toward its natural flourishing purpose.",
                    "Formal Logic: Invented the categorical syllogism that shaped human reasoning for 2,000 years.",
                    "Practical Wisdom (Phronesis): Virtue is not abstract theory, but navigating real-world nuances."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Aristotle"),
                    KeyPerson(name = "Plato", linkId = "plato")
                ),
                example = "An acorn's purpose is to become an oak tree; a human's purpose is to realize their unique rational and communal potential.",
                quote = "Knowing yourself is the beginning of all wisdom."
            ),
            related = listOf("plato", "virtue-ethics"),
            contrast = "plato"
        ),
        Discovery(
            id = "immanuel-kant",
            title = "Immanuel Kant",
            type = "THINKER",
            mood = "stone",
            hook = "DO WE SEE THE WORLD AS IT IS,\nOR ONLY AS OUR BRAIN ALLOWS?",
            short = "The German giant who reconciled rationalism and empiricism with his Copernican revolution in philosophy.",
            tags = listOf("duty", "perception", "critique", "ethics", "reason"),
            detail = DiscoveryDetail(
                whatIsThis = "Kant proved that space, time, and causality are not external physical objects, but the mental lenses through which our minds organize sensory chaos. We can never know the 'thing-in-itself' directly.",
                origin = "Lived his entire life in Königsberg, Prussia (1724-1804), writing the Critique of Pure Reason.",
                coreIdeas = listOf(
                    "Phenomena vs Noumena: We only perceive appearances, not the ultimate hidden reality behind them.",
                    "Synthetic A Priori: Mathematical and causal knowledge exists independently of raw sensory experience.",
                    "Universal Moral Duty: Morality is a matter of strict rational principle, not feelings or convenience."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Immanuel Kant")
                ),
                example = "Wearing permanent blue-tinted glasses: you see everything as blue, not because reality is blue, but because of the structure of your lenses.",
                quote = "Dare to know! Have the courage to use your own understanding."
            ),
            related = listOf("deontology", "rationalism"),
            contrast = "david-hume"
        ),
        Discovery(
            id = "schopenhauer",
            title = "Arthur Schopenhauer",
            type = "THINKER",
            mood = "cosmic",
            hook = "WHY DOES GETTING WHAT YOU WANT\nONLY LEAD TO BOREDOM?",
            short = "The philosopher of cosmic pessimism who saw the universe driven by a blind, restless Will to live.",
            tags = listOf("pessimism", "will", "art", "desire", "boredom"),
            detail = DiscoveryDetail(
                whatIsThis = "Schopenhauer argued that all existence is driven by an aimless, insatiable metaphysical 'Will'. We oscillate constantly between the pain of wanting and the boredom of getting.",
                origin = "19th-century Germany; influenced heavily by the Upanishads and Buddhist philosophy.",
                coreIdeas = listOf(
                    "The World as Will and Representation: Physical objects are manifestations of one blind, relentless drive.",
                    "The Pendulum of Life: Swings between craving and boredom.",
                    "Solace in Art & Compassion: Aesthetic contemplation and selfless empathy offer temporary escape from the Will."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Arthur Schopenhauer"),
                    KeyPerson(name = "Friedrich Nietzsche", linkId = "nietzsche")
                ),
                example = "Obsessing over buying a new smartphone for weeks, feeling thrilled for two days after buying it, and then feeling empty again.",
                quote = "Life swings like a pendulum backward and forward between pain and boredom."
            ),
            related = listOf("nietzsche", "hedonic-treadmill", "buddhism"),
            contrast = "hedonism"
        ),
        Discovery(
            id = "descartes",
            title = "René Descartes",
            type = "THINKER",
            mood = "indigo",
            hook = "WHAT IF A MALICIOUS DEMON\nIS DECEIVING EVERY ONE OF YOUR SENSES?",
            short = "The father of modern philosophy who tore down all assumptions to find the one truth that cannot be doubted.",
            tags = listOf("doubt", "mind", "cogito", "certainty", "truth"),
            detail = DiscoveryDetail(
                whatIsThis = "Descartes resolved to doubt everything that could possibly be false: optical illusions, dreams, and even mathematics. He realized that the very act of doubting proves a thinking self must exist.",
                origin = "Published Meditations on First Philosophy in 1641 in France and the Netherlands.",
                coreIdeas = listOf(
                    "Method of Radical Doubt: Strip away every belief that holds the slightest uncertainty.",
                    "Cogito, Ergo Sum: 'I think, therefore I am' is the foundational bedrock of certainty.",
                    "Mind-Body Dualism (Cartesian Dualism): Mind and matter are two fundamentally different substances."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "René Descartes")
                ),
                example = "Double-checking whether you're awake when you experience sleep paralysis or a vivid lucid dream.",
                quote = "If you would be a real seeker after truth, it is necessary that at least once in your life you doubt all things."
            ),
            related = listOf("solipsism", "brain-in-a-vat", "simulation-hypothesis"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "spinoza",
            title = "Baruch Spinoza",
            type = "THINKER",
            mood = "ocean",
            hook = "WHAT IF GOD AND THE UNIVERSE\nARE THE EXACT SAME THING?",
            short = "The excommunicated lens-grinder who proved that God is not a king in the sky, but the infinite fabric of Nature.",
            tags = listOf("pantheism", "nature", "god", "ethics", "reason"),
            detail = DiscoveryDetail(
                whatIsThis = "Spinoza conceived a radical Pantheism (Deus sive Natura - 'God or Nature'). There is only one infinite substance, and humans, trees, stars, and thoughts are modes of this single divine system.",
                origin = "Excommunicated by the Jewish community of Amsterdam in 1656 for his revolutionary writings.",
                coreIdeas = listOf(
                    "Substance Monism: Reality is one unified, infinite, self-causing totality.",
                    "No Free Will in Nature: Everything happens by absolute mathematical necessity; regret is irrational.",
                    "Intellectual Love of God: Freedom comes from understanding the eternal laws of nature."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Baruch Spinoza"),
                    KeyPerson(name = "Albert Einstein")
                ),
                example = "Albert Einstein famously declared: 'I believe in Spinoza's God, who reveals Himself in the lawful harmony of the world.'",
                quote = "I have striven not to laugh at human actions, not to weep at them, nor to hate them, but to understand them."
            ),
            related = listOf("determinism", "pantheism"),
            contrast = "descartes"
        ),
        Discovery(
            id = "kierkegaard",
            title = "Søren Kierkegaard",
            type = "THINKER",
            mood = "ochre",
            hook = "ANXIETY IS THE DIZZINESS OF FREEDOM.\nARE YOU READY TO JUMP?",
            short = "The Danish melancholic who fathered existentialism by analyzing dread, individuality, and leaps of faith.",
            tags = listOf("anxiety", "faith", "dread", "individuality", "choice"),
            detail = DiscoveryDetail(
                whatIsThis = "Kierkegaard exposed the paralysis of human freedom. Unlike animals driven by instinct, humans must choose who to become, and the dizzying abyss of possibilities causes deep existential dread.",
                origin = "Wrote passionately under various pseudonyms in 19th-century Copenhagen, Denmark.",
                coreIdeas = listOf(
                    "Angst as Freedom: Dread is not sickness, but the realization of your infinite freedom to choose.",
                    "The Three Stages of Life: Aesthetic (seeking pleasure), Ethical (doing duty), and Religious (authentic leap).",
                    "Truth as Subjectivity: Personal commitment and passion matter more than cold academic abstraction."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Søren Kierkegaard")
                ),
                example = "Standing on the edge of a cliff feeling dizzy - not because the edge is weak, but because you realize you have the freedom to jump.",
                quote = "Life can only be understood backwards; but it must be lived forwards."
            ),
            related = listOf("existentialism", "absurdism"),
            contrast = "rationalism"
        ),
        Discovery(
            id = "albert-camus",
            title = "Albert Camus",
            type = "THINKER",
            mood = "burgundy",
            hook = "SHOULD ONE COMMIT SUICIDE,\nOR DRINK A CUP OF COFFEE?",
            short = "The Nobel-winning Algerian-French author who urged humanity to rebel against cosmic absurdity through joy.",
            tags = listOf("absurdism", "rebellion", "freedom", "sisyphus", "literature"),
            detail = DiscoveryDetail(
                whatIsThis = "Camus opened 'The Myth of Sisyphus' declaring that the only serious philosophical problem is suicide: deciding whether life is or is not worth living in an indifferent cosmos.",
                origin = "Algerian-French philosopher, journalist, and author; won the Nobel Prize in Literature in 1957.",
                coreIdeas = listOf(
                    "Revolt: Refusing to resign to nihilism or escape into religious delusion.",
                    "Freedom: Living intensely in the present moment without future guarantees.",
                    "Passion: Squeezing every drop of experience from this brief conscious life."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Albert Camus")
                ),
                example = "Swimming in the ocean on a hot summer afternoon and feeling overwhelming love for existence despite cosmic insignificance.",
                quote = "In the midst of winter, I found there was, within me, an invincible summer."
            ),
            related = listOf("absurdism", "existentialism", "sisyphus"),
            contrast = "nihilism"
        ),
        Discovery(
            id = "diogenes",
            title = "Diogenes of Sinope",
            type = "THINKER",
            mood = "terracotta",
            hook = "HE TOLD THE CONQUEROR OF THE WORLD:\n'STAND OUT OF MY SUNLIGHT.'",
            short = "The ultimate rebel who carried a lantern in daylight looking for an honest human and lived in a wine jar.",
            tags = listOf("cynicism", "simplicity", "freedom", "satire", "rebellion"),
            detail = DiscoveryDetail(
                whatIsThis = "When Alexander the Great approached Diogenes and offered to grant any wish on earth, the philosopher simply asked the emperor to move aside because he was blocking the sun.",
                origin = "4th-century BCE Greece; lived in Athens and Corinth practicing radical poverty.",
                coreIdeas = listOf(
                    "Despising Wealth: Possessions possess their owners and destroy spiritual independence.",
                    "Radical Honesty: Satirizing hypocrisy, pretensions of nobility, and academic pedantry.",
                    "Cosmopolitanism: First thinker to declare: 'I am a citizen of the world (cosmopolites).'"
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Diogenes of Sinope"),
                    KeyPerson(name = "Alexander the Great")
                ),
                example = "Watching someone stress over scratching their luxury car, while the person walking by with just a backpack smiles freely.",
                quote = "In a rich man's house there is no place to spit, except his face."
            ),
            related = listOf("cynicism", "stoicism"),
            contrast = "hedonism"
        ),

        // ==========================================
        // 3. MIND-BENDING PARADOXES
        // ==========================================
        Discovery(
            id = "ship-of-theseus",
            title = "The Ship of Theseus",
            type = "PARADOX",
            mood = "ocean",
            hook = "REPLACE EVERY PLANK OF A SHIP -\nIS IT STILL THE SAME SHIP?",
            short = "A 2,000-year-old paradox about identity, persistence, and what makes anything truly 'itself'.",
            tags = listOf("identity", "change", "philosophy-of-mind", "continuity", "matter"),
            detail = DiscoveryDetail(
                whatIsThis = "If a ship has its wooden planks gradually replaced one by one until not a single original piece remains, is it the same ship? And if you rebuild a ship with the old discarded planks, which is the real one?",
                origin = "Recorded by Greek historian Plutarch in Life of Theseus, around 75 CE.",
                coreIdeas = listOf(
                    "Material Identity: Are you defined by your physical molecules or your ongoing pattern?",
                    "Continuity over Time: Can identity survive complete molecular transformation?",
                    "The Illusion of Fixed Self: Identity is a mental label humans assign, not a physical atom."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Plutarch"),
                    KeyPerson(name = "Thomas Hobbes")
                ),
                example = "Almost every cell in your human body is replaced every 7 to 10 years, yet you consider yourself the same person.",
                quote = "Identity is not in the material, but in the continuity of the pattern."
            ),
            related = listOf("solipsism", "experience-machine"),
            contrast = "determinism"
        ),
        Discovery(
            id = "fermi-paradox",
            title = "The Fermi Paradox",
            type = "PARADOX",
            mood = "cosmic",
            hook = "THE UNIVERSE IS UNIMAGINABLY VAST -\nSO WHERE IS EVERYONE?",
            short = "The eerie contradiction between high statistical estimates for extraterrestrial life and the complete lack of evidence.",
            tags = listOf("space", "aliens", "cosmology", "probability", "great-filter"),
            detail = DiscoveryDetail(
                whatIsThis = "With billions of sun-like stars billions of years older than our sun, intelligent civilizations should have colonized the galaxy long ago. Yet the night sky is deafeningly silent.",
                origin = "Attributed to physicist Enrico Fermi during a lunch discussion at Los Alamos in 1950.",
                coreIdeas = listOf(
                    "The Drake Equation vs The Great Silence: High theoretical odds clash with zero radio signals.",
                    "The Great Filter: Does an evolutionary barrier prevent civilizations from reaching star travel, and is it behind us or ahead?",
                    "The Zoo Hypothesis: Advanced life may observe Earth quietly like a wildlife preserve."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Enrico Fermi"),
                    KeyPerson(name = "Robin Hanson")
                ),
                example = "Standing in a stadium that holds 100,000 people, shouting into the crowd, and hearing only dead silence.",
                quote = "Two possibilities exist: either we are alone in the Universe or we are not. Both are equally terrifying."
            ),
            related = listOf("simulation-hypothesis", "schrodingers-cat"),
            contrast = "solipsism"
        ),
        Discovery(
            id = "trolley-problem",
            title = "The Trolley Problem",
            type = "PARADOX",
            mood = "terracotta",
            hook = "WOULD YOU PULL A LEVER\nTO SACRIFICE ONE PERSON TO SAVE FIVE?",
            short = "The ultimate moral puzzle testing the clash between cold mathematical calculation and intrinsic ethical rules.",
            tags = listOf("ethics", "morality", "utilitarianism", "deontology", "decisions"),
            detail = DiscoveryDetail(
                whatIsThis = "A runaway trolley is speeding toward five workers. You can pull a lever to divert it onto a track where it kills one person instead. Most say yes. But if you must physically push a heavy stranger off a bridge to stop the train, most say no, despite the identical math (1 for 5).",
                origin = "Introduced by philosopher Philippa Foot in 1967 and expanded by Judith Jarvis Thomson.",
                coreIdeas = listOf(
                    "Consequentialism vs Deontology: Maximizing numbers versus respecting intrinsic moral rights.",
                    "Action vs Inaction: Is actively causing one death worse than passively allowing five deaths?",
                    "Doctrine of Double Effect: An intended harm versus an unintended side effect."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Philippa Foot"),
                    KeyPerson(name = "Judith Jarvis Thomson")
                ),
                example = "Programming self-driving cars to decide whether to crash into a wall or swerve into a pedestrian when brakes fail.",
                quote = "Same math, different lever - and suddenly it's not the same choice."
            ),
            related = listOf("utilitarianism", "deontology", "veil-of-ignorance"),
            contrast = "deontology"
        ),
        Discovery(
            id = "zeno-tortoise",
            title = "Zeno's Achilles and the Tortoise",
            type = "PARADOX",
            mood = "amber",
            hook = "CAN THE FASTEST RUNNER ON EARTH\nNEVER OVERTAKE A SLOW TORTOISE?",
            short = "An ancient paradox of motion proving that if space is infinitely divisible, movement should be impossible.",
            tags = listOf("infinity", "motion", "math", "space", "zeno"),
            detail = DiscoveryDetail(
                whatIsThis = "Achilles races a tortoise with a 100-meter head start. By the time Achilles covers the 100 meters, the tortoise has moved 10 meters. When Achilles covers that 10 meters, the tortoise has moved 1 meter. Achilles must complete an infinite number of tasks to catch up, so motion seems mathematically impossible.",
                origin = "Proposed by Zeno of Elea around 450 BCE to defend Parmenides' view that change is an illusion.",
                coreIdeas = listOf(
                    "Infinite Divisibility of Space: Can continuous distance be chopped into infinite sub-steps?",
                    "Convergent Infinite Series: Modern calculus shows an infinite sum can equal a finite number.",
                    "Illusion of Discrete Motion: Does nature move in discrete quantum Planck lengths?"
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Zeno of Elea"),
                    KeyPerson(name = "Aristotle", linkId = "aristotle")
                ),
                example = "Trying to reach the exit door by always walking half the remaining distance: mathematically you never touch the door.",
                quote = "That which is in motion must arrive at the half-way stage before it arrives at the goal."
            ),
            related = listOf("sorites-paradox", "quantum-superposition"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "sorites-paradox",
            title = "The Sorites Paradox (The Heap)",
            type = "PARADOX",
            mood = "ochre",
            hook = "WHEN DOES A GRAIN OF SAND\nBECOME A HEAP?",
            short = "A paradox of vagueness exposing how human words fail when reality exists on a smooth continuum.",
            tags = listOf("language", "vagueness", "logic", "boundaries", "definitions"),
            detail = DiscoveryDetail(
                whatIsThis = "One grain of sand is not a heap. Adding one grain to a non-heap cannot turn it into a heap. Yet repeating this step a million times produces a heap. At what exact grain did the transformation take place?",
                origin = "Attributed to Eubulides of Miletus in 4th-century BCE Greece.",
                coreIdeas = listOf(
                    "The Problem of Vagueness: Concepts in human language have blurry, subjective boundaries.",
                    "Continuum Fallacy: Falsely claiming that because there is no clear dividing line, no difference exists.",
                    "Fuzzy Logic: Real-world truths often have truth values between 0 and 1."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Eubulides of Miletus"),
                    KeyPerson(name = "Ludwig Wittgenstein")
                ),
                example = "Losing one hair does not make someone bald. But repeat that loss enough times, and they are bald. There is no single 'baldness' hair.",
                quote = "Language disguises thought so much that one cannot deduce the form of the thought beneath."
            ),
            related = listOf("zeno-tortoise", "ship-of-theseus"),
            contrast = "rationalism"
        ),
        Discovery(
            id = "paradox-of-tolerance",
            title = "The Paradox of Tolerance",
            type = "PARADOX",
            mood = "burgundy",
            hook = "MUST A TOLERANT SOCIETY TOLERATE\nTHOSE WHO WISH TO DESTROY TOLERANCE?",
            short = "Karl Popper's insight that unlimited tolerance inevitably leads to the destruction of tolerance itself.",
            tags = listOf("tolerance", "society", "democracy", "freedom", "popper"),
            detail = DiscoveryDetail(
                whatIsThis = "If a society extends unlimited tolerance to everyone, including violent intolerant movements that reject argument and reason, the tolerant will be destroyed and tolerance with them.",
                origin = "Formulated by philosopher Karl Popper in 1945 in The Open Society and Its Enemies.",
                coreIdeas = listOf(
                    "Self-Preserving Limits: A virtue pushed to unconditional extremes destroys its own foundation.",
                    "Reason Over Violence: Tolerance covers any idea open to debate; intolerance begins when groups use force and deceit.",
                    "Defending Open Society: Democratic institutions must actively defend the right to exist."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Karl Popper")
                ),
                example = "An online forum with zero rules is quickly ruined by spam and harassment, driving away all civil participants.",
                quote = "In order to maintain a tolerant society, the society must be intolerant of intolerance."
            ),
            related = listOf("veil-of-ignorance", "utilitarianism"),
            contrast = "cynicism"
        ),
        Discovery(
            id = "grandfather-paradox",
            title = "The Grandfather Paradox",
            type = "PARADOX",
            mood = "slate",
            hook = "IF YOU GO BACK AND PREVENT YOUR BIRTH,\nHOW DID YOU GO BACK AT ALL?",
            short = "The ultimate temporal paradox challenging backwards time travel and causal consistency in physics.",
            tags = listOf("time", "causality", "physics", "time-travel", "relativity"),
            detail = DiscoveryDetail(
                whatIsThis = "If a time traveler journeys into the past and accidentally kills their biological grandfather before their parents are conceived, the traveler is never born. But if never born, who traveled back in time?",
                origin = "First described in science fiction literature in the 1930s and formalized in general relativity studies.",
                coreIdeas = listOf(
                    "Novikov Self-Consistency Principle: The laws of physics will always conspire to prevent temporal contradictions.",
                    "Many-Worlds Interpretation: Traveling into the past splits reality into a brand-new parallel timeline.",
                    "Chronology Protection Conjecture: Physics forbids closed time-like curves that alter past history."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Igor Novikov"),
                    KeyPerson(name = "Hugh Everett III")
                ),
                example = "Trying to change a historical mistake in a company database, only to find the correction was the cause of the original error.",
                quote = "Time is what keeps everything from happening at once."
            ),
            related = listOf("bootstrap-paradox", "determinism"),
            contrast = "determinism"
        ),
        Discovery(
            id = "bootstrap-paradox",
            title = "The Bootstrap Paradox",
            type = "PARADOX",
            mood = "indigo",
            hook = "AN ARTIFACT FROM THE FUTURE SENT TO THE PAST -\nWHO CREATED IT IN THE FIRST PLACE?",
            short = "A causal loop paradox where information, objects, or ideas exist without ever having an original origin.",
            tags = listOf("time", "causality", "information", "loops", "ontology"),
            detail = DiscoveryDetail(
                whatIsThis = "A traveler brings a copy of Beethoven's symphonies to 1770 Vienna, where a young Beethoven simply copies them down note for note. The music exists in an unbroken loop, but who composed it?",
                origin = "Derived from Robert Heinlein's 1941 sci-fi novella 'By His Bootstraps'.",
                coreIdeas = listOf(
                    "Causal Loops: An effect becomes the cause of its own origin.",
                    "Information Without Entropy: Information exists in a closed loop without an author or creative genesis.",
                    "Ontological Paradox: An entity that requires its future self to create its past self."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Robert Heinlein")
                ),
                example = "Receiving a mysterious code that solves an equation, and decades later sending that same code back to your younger self.",
                quote = "The future has already written the past."
            ),
            related = listOf("grandfather-paradox", "determinism"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "omnipotence-paradox",
            title = "The Omnipotence Paradox",
            type = "PARADOX",
            mood = "cosmic",
            hook = "COULD AN ALL-POWERFUL BEING CREATE A STONE\nSO HEAVY THEY CANNOT LIFT IT?",
            short = "A theological and logical riddle probing whether unlimited power contains inherent logical contradictions.",
            tags = listOf("god", "power", "logic", "infinity", "theology"),
            detail = DiscoveryDetail(
                whatIsThis = "If an omnipotent being can create such a stone, they cannot lift it (hence not omnipotent). If they cannot create it, there is something they cannot do (hence not omnipotent).",
                origin = "Debated since medieval scholastic philosophy by thinkers like Thomas Aquinas and Averroes.",
                coreIdeas = listOf(
                    "Logical Impossibility: Does omnipotence mean doing what is logically contradictory (like a four-sided circle)?",
                    "Aquinas's Solution: Logical impossibilities are not actual things; they are meaningless arrangements of words.",
                    "Limits of Language: Human grammar can string words together that describe no possible state of affairs."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Thomas Aquinas"),
                    KeyPerson(name = "C.S. Lewis")
                ),
                example = "Asking a computer to calculate a number that is simultaneously greater than five and less than four.",
                quote = "Meaningless combinations of words do not suddenly acquire meaning simply because we prefix them with the two words 'God can'."
            ),
            related = listOf("buridans-ass", "rationalism"),
            contrast = "rationalism"
        ),
        Discovery(
            id = "barber-paradox",
            title = "The Barber Paradox",
            type = "PARADOX",
            mood = "stone",
            hook = "THE BARBER SHAVES ALL MEN WHO DON'T SHAVE THEMSELVES.\nDOES THE BARBER SHAVE HIMSELF?",
            short = "Bertrand Russell's accessible illustration of the fundamental crisis in set theory that shook mathematics.",
            tags = listOf("math", "logic", "russell", "sets", "contradiction"),
            detail = DiscoveryDetail(
                whatIsThis = "In a town, a male barber shaves all and only those men who do not shave themselves. If he shaves himself, he violates the rule. If he doesn't shave himself, he must shave himself.",
                origin = "Introduced by Bertrand Russell in 1901 to expose a flaw in naive set theory.",
                coreIdeas = listOf(
                    "Russell's Paradox: The set of all sets that do not contain themselves cannot logically exist.",
                    "Self-Reference Danger: Circular definitions inside a formal system can destroy consistency.",
                    "Foundation of Computing: Led directly to Gödel's incompleteness theorems and modern computer science."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Bertrand Russell"),
                    KeyPerson(name = "Kurt Gödel")
                ),
                example = "A sign that says 'Do not read this sign': obeying the instruction requires disobeying it.",
                quote = "The set of all sets that do not contain themselves cannot exist."
            ),
            related = listOf("epimenides-paradox", "rationalism"),
            contrast = "pragmatism"
        ),
        Discovery(
            id = "epimenides-paradox",
            title = "The Liar Paradox",
            type = "PARADOX",
            mood = "amber",
            hook = "'THIS STATEMENT IS FALSE.'\nIS THAT STATEMENT TRUE?",
            short = "The simplest and most vicious paradox in logic, showing how self-reference breaks truth values.",
            tags = listOf("logic", "truth", "language", "self-reference", "paradox"),
            detail = DiscoveryDetail(
                whatIsThis = "If the statement 'This statement is false' is true, then it must be false. If it is false, then what it asserts is true. It forever oscillates between truth and falsehood.",
                origin = "Attributed to 6th-century BCE Cretan philosopher Epimenides, who declared: 'All Cretans are liars.'",
                coreIdeas = listOf(
                    "Semantic Paradox: Natural language allows sentences to evaluate their own truth status.",
                    "Hierarchy of Languages: Tarski showed a language cannot define its own truth predicate without paradox.",
                    "Limits of Logic: Not every grammatically valid sentence possesses a clear truth value."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Alfred Tarski"),
                    KeyPerson(name = "Kurt Gödel")
                ),
                example = "A computer program in an infinite recursive loop trying to determine if it is currently finished running.",
                quote = "Every language has a structure concerning which, in the language itself, nothing can be said."
            ),
            related = listOf("barber-paradox", "sorites-paradox"),
            contrast = "rationalism"
        ),
        Discovery(
            id = "buridans-ass",
            title = "Buridan's Ass",
            type = "PARADOX",
            mood = "ochre",
            hook = "CAN A PERFECTLY RATIONAL BEING\nSTARVE TO DEATH FROM INDECISION?",
            short = "A paradox exploring free will, decision paralysis, and why pure rationality needs instinct to survive.",
            tags = listOf("decisions", "free-will", "rationality", "paralysis", "action"),
            detail = DiscoveryDetail(
                whatIsThis = "A donkey that is equally hungry and thirsty is placed exactly halfway between a pile of hay and a bucket of water. Because both choices are equally compelling and no rational reason favors one, it starves.",
                origin = "Named after 14th-century French philosopher Jean Buridan, satirizing strict rational determinism.",
                coreIdeas = listOf(
                    "Analysis Paralysis: Absolute symmetry without arbitrary decision rules causes catastrophic inaction.",
                    "Randomness as a Survival Tool: Living agents need instinct or randomness to break deadlocks.",
                    "Critique of Pure Logic: Action requires desire and impulse, not just cold calculation."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Jean Buridan"),
                    KeyPerson(name = "Baruch Spinoza", linkId = "spinoza")
                ),
                example = "Spending 40 minutes debating between two nearly identical restaurant menus until you're too exhausted to eat.",
                quote = "Should a rational agent hesitate indefinitely when two goods are equal?"
            ),
            related = listOf("determinism", "pragmatism"),
            contrast = "pragmatism"
        ),

        // ==========================================
        // 4. THOUGHT EXPERIMENTS & MENTAL MODELS
        // ==========================================
        Discovery(
            id = "allegory-of-the-cave",
            title = "Plato's Allegory of the Cave",
            type = "EXPERIMENT",
            mood = "indigo",
            hook = "WHAT IF EVERYTHING YOU SEE\nIS ONLY A SHADOW ON A WALL?",
            short = "Plato's foundational allegory on human ignorance, education, and the painful ascent toward truth.",
            tags = listOf("truth", "reality", "awakening", "plato", "epistemology"),
            detail = DiscoveryDetail(
                whatIsThis = "Prisoners are chained from birth inside a dark cave, seeing only shadows cast by a fire behind them. When one escapes into the blinding sunlight, he discovers true reality - but when he returns to tell others, they mock him.",
                origin = "Described by Plato in Book VII of The Republic around 375 BCE.",
                coreIdeas = listOf(
                    "The Illusion of Appearances: Physical senses alone deceive us into mistaking shadows for substance.",
                    "The Agony of Enlightenment: Genuine philosophical growth requires painful disillusionment.",
                    "Duty of the Enlightened: The philosopher must return to the cave to serve society."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Plato", linkId = "plato"),
                    KeyPerson(name = "Socrates", linkId = "socrates")
                ),
                example = "Getting your worldview exclusively from 15-second viral clips, until you read an entire book and realize how distorted the clips were.",
                quote = "We can easily forgive a child who is afraid of the dark; the real tragedy of life is when men are afraid of the light."
            ),
            related = listOf("plato", "simulation-hypothesis", "the-matrix"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "experience-machine",
            title = "The Experience Machine",
            type = "EXPERIMENT",
            mood = "rose",
            hook = "A MACHINE COULD GIVE YOU A PERFECT LIFE -\nWOULD YOU PLUG IN?",
            short = "Robert Nozick's challenge to hedonism: do we just want the feeling of a great life, or the real thing?",
            tags = listOf("pleasure", "reality", "truth", "authenticity", "ethics"),
            detail = DiscoveryDetail(
                whatIsThis = "Imagine a machine that stimulates your brain so you believe you are writing great novels, climbing Everest, and being loved. You would feel ecstatic 24/7 with zero pain. Would you plug in for life?",
                origin = "Devised by American philosopher Robert Nozick in 1974 in Anarchy, State, and Utopia.",
                coreIdeas = listOf(
                    "Beyond Hedonism: We want to actually do certain things, not just have the pleasant feeling of doing them.",
                    "Authenticity Matters: We want to be a certain kind of person in contact with genuine reality.",
                    "The Value of Real Pain: Struggles give authentic accomplishments their meaning."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Robert Nozick")
                ),
                example = "Preferring real, messy relationships with real friends over a perfectly flattering AI chatbot that always agrees with you.",
                quote = "We want to plug into a machine that will let us live the life we choose, not one that chooses the life for us."
            ),
            related = listOf("hedonism", "simulation-hypothesis"),
            contrast = "hedonism"
        ),
        Discovery(
            id = "simulation-hypothesis",
            title = "The Simulation Hypothesis",
            type = "EXPERIMENT",
            mood = "cosmic",
            hook = "ARE YOU LIVING IN REALITY,\nOR ON A SERVER OF AN ADVANCED SPECIES?",
            short = "The trilemma arguing that it is statistically probable we live in a computer simulation.",
            tags = listOf("simulation", "technology", "reality", "physics", "bostrom"),
            detail = DiscoveryDetail(
                whatIsThis = "Given technological exponential growth, civilizations will eventually run trillions of simulated universes. If simulated minds vastly outnumber biological minds, you are almost certainly in a simulation.",
                origin = "Formalized by Oxford philosopher Nick Bostrom in 2003.",
                coreIdeas = listOf(
                    "Bostrom's Trilemma: Either species go extinct before tech maturity, or they lose interest in sims, or we are in a sim.",
                    "Digital Physics: The pixelated quantum Planck length resembles processing resolution limits.",
                    "Cosmic Humility: Our entire universe may be a high school science project in another dimension."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Nick Bostrom"),
                    KeyPerson(name = "Elon Musk")
                ),
                example = "Looking at video games going from Pong in 1972 to photorealistic virtual reality today, and projecting forward 10,000 years.",
                quote = "If you assume any rate of improvement at all, games will be indistinguishable from reality."
            ),
            related = listOf("brain-in-a-vat", "allegory-of-the-cave", "solipsism"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "schrodingers-cat",
            title = "Schrödinger's Cat",
            type = "EXPERIMENT",
            mood = "slate",
            hook = "UNTIL YOU LOOK, IT'S BOTH DEAD AND ALIVE -\nNOT EITHER.",
            short = "Erwin Schrödinger's famous thought experiment exposing the counterintuitive weirdness of quantum superposition.",
            tags = listOf("quantum", "physics", "superposition", "science", "reality"),
            detail = DiscoveryDetail(
                whatIsThis = "A cat is locked in a box with a radioactive atom linked to poison. Until an observer opens the box, quantum mechanics dictates the atom is in a superposition of decayed and undecayed - meaning the cat is simultaneously dead and alive.",
                origin = "Devised by Austrian physicist Erwin Schrödinger in 1935 to highlight paradoxes in the Copenhagen interpretation.",
                coreIdeas = listOf(
                    "Quantum Superposition: Particles exist as waves of probabilities until a measurement forces an outcome.",
                    "The Measurement Problem: What constitutes an 'observer' that collapses wave functions?",
                    "Many-Worlds Alternative: The universe splits into two branches - one where the cat lives, one where it dies."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Erwin Schrödinger"),
                    KeyPerson(name = "Niels Bohr")
                ),
                example = "A coin spinning in the air isn't heads or tails while spinning - it's both possibilities until it lands.",
                quote = "I do not like it, and I am sorry I ever had anything to do with it."
            ),
            related = listOf("simulation-hypothesis", "quantum-superposition"),
            contrast = "determinism"
        ),
        Discovery(
            id = "chinese-room",
            title = "The Chinese Room Argument",
            type = "EXPERIMENT",
            mood = "sage",
            hook = "CAN A MACHINE THAT SPEAKS FLUENTLY\nEVER TRULY UNDERSTAND WHAT IT SAYS?",
            short = "John Searle's proof that syntax (symbol-shuffling) is not the same as semantics (conscious understanding).",
            tags = listOf("ai", "consciousness", "mind", "computation", "language"),
            detail = DiscoveryDetail(
                whatIsThis = "An English speaker in a closed room follows rulebooks to answer Chinese questions. To outsiders, the room speaks fluent Chinese. But the person inside understands zero Chinese. Computers manipulate code the same way - without true understanding.",
                origin = "Proposed by philosopher John Searle in 1980 against claims of Strong AI.",
                coreIdeas = listOf(
                    "Syntax vs Semantics: Following rules on symbols does not generate subjective comprehension.",
                    "Simulation vs Duplication: Simulating brain computations is no more alive than simulating a fire is hot.",
                    "Intentionality: Genuine minds have mental states about things, which algorithms lack."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "John Searle")
                ),
                example = "Using auto-complete to produce an email response without having any idea what the underlying topic means.",
                quote = "You cannot get semantics from syntax alone."
            ),
            related = listOf("marys-room", "brain-in-a-vat"),
            contrast = "functionalism"
        ),
        Discovery(
            id = "marys-room",
            title = "Mary's Room (The Knowledge Argument)",
            type = "EXPERIMENT",
            mood = "rose",
            hook = "COULD YOU KNOW EVERY PHYSICAL FACT ABOUT COLOR\nWITHOUT EVER SEEING IT?",
            short = "Frank Jackson's thought experiment proving that physical science cannot fully capture conscious experience (qualia).",
            tags = listOf("qualia", "consciousness", "mind", "physicalism", "color"),
            detail = DiscoveryDetail(
                whatIsThis = "Mary is a scientist raised in a black-and-white room who learns every physical, optical, and neurological fact about color vision. When she steps outside and sees a red rose, does she learn something new? If yes, physicalism is incomplete.",
                origin = "Introduced by Australian philosopher Frank Jackson in 1982.",
                coreIdeas = listOf(
                    "Qualia: The raw subjective 'what it is like' aspect of experience cannot be reduced to math.",
                    "The Explanatory Gap: Knowing brain chemistry is fundamentally different from feeling pain or seeing blue.",
                    "The Hard Problem of Consciousness: Why is physical brain processing accompanied by an inner movie?"
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Frank Jackson"),
                    KeyPerson(name = "Thomas Nagel")
                ),
                example = "Reading a medical treatise on the anatomy of heartbreak versus experiencing getting dumped for the first time.",
                quote = "Physicalism leaves something out: the redness of red."
            ),
            related = listOf("chinese-room", "solipsism"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "brain-in-a-vat",
            title = "The Brain in a Vat",
            type = "EXPERIMENT",
            mood = "cosmic",
            hook = "HOW DO YOU KNOW YOU AREN'T A BRAIN\nIN A JAR SUSPENDED IN NUTRIENT FLUID?",
            short = "A modernized Cartesian puzzle testing whether we can ever prove our experiences match external physical reality.",
            tags = listOf("skepticism", "matrix", "perception", "epistemology", "reality"),
            detail = DiscoveryDetail(
                whatIsThis = "A mad scientist has removed your brain, placed it in a vat of life-sustaining fluid, and wired its neurons to a supercomputer simulating your memories, sensations, and world.",
                origin = "Modernized by philosopher Gilbert Harman and analyzed extensively by Hilary Putnam in 1981.",
                coreIdeas = listOf(
                    "Epistemological Skepticism: All our beliefs about the external world could be systematic hallucinations.",
                    "Semantic Externalism: Putnam argued that a brain in a vat cannot even meaningfully state that it is in a vat.",
                    "The Matrix Precursor: Direct inspiration for the 1999 sci-fi classic."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Hilary Putnam"),
                    KeyPerson(name = "René Descartes", linkId = "descartes")
                ),
                example = "Putting on high-end VR goggles and feeling your stomach drop on a rollercoaster even though your feet never left the carpet.",
                quote = "You cannot step outside your own perceptions to check if they match reality."
            ),
            related = listOf("simulation-hypothesis", "solipsism", "descartes"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "pascals-wager",
            title = "Pascal's Wager",
            type = "EXPERIMENT",
            mood = "amber",
            hook = "BETWEEN FINITE LOSS AND INFINITE REWARD,\nWHAT IS THE RATIONAL GAMBLE?",
            short = "Blaise Pascal's application of game theory to faith: why believing in God is mathematically advantageous.",
            tags = listOf("game-theory", "faith", "probability", "decision-theory", "pascal"),
            detail = DiscoveryDetail(
                whatIsThis = "Reason cannot prove God's existence. But treat it as a bet: Believing costs finite worldly pleasure and gains infinite eternal bliss. Not believing risks infinite damnation for minor finite gain.",
                origin = "Published posthumously in Pensées (1670) by French mathematician Blaise Pascal.",
                coreIdeas = listOf(
                    "Expected Value Calculation: Multiplying outcomes by their infinite stakes dominates any finite calculation.",
                    "Pragmatic Belief: Acting as if you believe eventually shapes genuine inner faith.",
                    "The Many-Gods Objection: What if you wager on the wrong religion and anger another deity?"
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Blaise Pascal")
                ),
                example = "Buying affordable health insurance: the small monthly premium is worth avoiding potential bankruptcy.",
                quote = "The heart has its reasons of which reason knows nothing."
            ),
            related = listOf("pragmatism", "buridans-ass"),
            contrast = "rationalism"
        ),
        Discovery(
            id = "veil-of-ignorance",
            title = "The Veil of Ignorance",
            type = "EXPERIMENT",
            mood = "terracotta",
            hook = "WHAT RULES WOULD YOU SET FOR SOCIETY\nIF YOU DIDN'T KNOW WHO YOU'D BE BORN AS?",
            short = "John Rawls' landmark thought experiment for discovering perfectly objective principles of justice and fairness.",
            tags = listOf("justice", "fairness", "politics", "society", "equality"),
            detail = DiscoveryDetail(
                whatIsThis = "Imagine agreeing on constitutional and economic rules behind a veil: you do not know your race, gender, intelligence, wealth, or health in the upcoming society. Self-interest forces you to protect the most vulnerable.",
                origin = "Proposed by American philosopher John Rawls in A Theory of Justice (1971).",
                coreIdeas = listOf(
                    "Justice as Fairness: Objective justice emerges when selfish biases are stripped away.",
                    "Difference Principle: Inequalities are only fair if they improve the condition of the least advantaged.",
                    "Equal Liberty: Maximum basic freedoms for every citizen must be guaranteed unconditionally."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "John Rawls")
                ),
                example = "Splitting a cake between two kids: one child cuts the cake, the other gets to choose which piece to take.",
                quote = "Justice is the first virtue of social institutions, as truth is of systems of thought."
            ),
            related = listOf("utilitarianism", "trolley-problem"),
            contrast = "hedonism"
        ),
        Discovery(
            id = "occams-razor",
            title = "Occam's Razor",
            type = "EXPERIMENT",
            mood = "stone",
            hook = "AMONG COMPETING EXPLANATIONS,\nWHY IS THE SIMPLEST USUALLY RIGHT?",
            short = "The philosophical razor that unnecessary assumptions should be shaved away from theories.",
            tags = listOf("logic", "science", "simplicity", "thinking", "rules"),
            detail = DiscoveryDetail(
                whatIsThis = "When multiple competing hypotheses explain the evidence equally well, we should select the one that makes the fewest assumptions and introduces the least complexity.",
                origin = "Formulated by 14th-century English Franciscan friar William of Ockham.",
                coreIdeas = listOf(
                    "Principle of Parsimony: Do not multiply entities or assumptions beyond necessity.",
                    "Dismantling Conspiracy Theories: Explanations requiring 50 hidden conspirators are statistically vastly weaker.",
                    "A Heuristic, Not a Law: Simplicity is a tool for guiding scientific investigation, not a proof."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "William of Ockham")
                ),
                example = "If you wake up and the lawn is wet, assuming it rained overnight is vastly more probable than assuming aliens watered your grass.",
                quote = "It is futile to do with more things that which can be done with fewer."
            ),
            related = listOf("empiricism", "rationalism"),
            contrast = "conspiracy"
        ),
        Discovery(
            id = "prisoners-dilemma",
            title = "The Prisoner's Dilemma",
            type = "EXPERIMENT",
            mood = "ocean",
            hook = "RATIONAL SELF-INTEREST\nOFTEN DESTROYS BOTH PLAYERS.",
            short = "The game theory cornerstone showing why two rational people might fail to cooperate even when it is in their best interest.",
            tags = listOf("game-theory", "trust", "cooperation", "betrayal", "strategy"),
            detail = DiscoveryDetail(
                whatIsThis = "Two arrested accomplices are interrogated separately. If both stay silent, both get 1 year. If one confesses and betrays, they go free while the other gets 5 years. If both betray, both get 3 years. Pure self-interest leads both to betray.",
                origin = "Framed by Merrill Flood and Melvin Dresher at the RAND Corporation in 1950.",
                coreIdeas = listOf(
                    "Nash Equilibrium: Rational choices from individual perspectives can lead to mutually terrible outcomes.",
                    "Tit-for-Tat: In repeated games, starting with cooperation and retaliating only when betrayed wins long-term.",
                    "The Basis of Human Trust: Contracts, laws, and reputations exist to escape the prisoner's dilemma."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "John Nash"),
                    KeyPerson(name = "Robert Axelrod")
                ),
                example = "Countries entering an expensive arms race: neither wants nuclear war, but neither dares to disarm alone.",
                quote = "Trust is the currency that allows human cooperation to beat mathematical betrayal."
            ),
            related = listOf("tragedy-of-the-commons", "game-theory"),
            contrast = "utilitarianism"
        ),
        Discovery(
            id = "tragedy-of-the-commons",
            title = "Tragedy of the Commons",
            type = "EXPERIMENT",
            mood = "forest",
            hook = "WHEN EVERYONE ACTS IN THEIR OWN INTEREST,\nTHE WHOLE SYSTEM COLLAPSES.",
            short = "An economic dilemma where shared, unregulated resources are inevitably depleted by individuals acting rationally.",
            tags = listOf("economics", "environment", "resources", "society", "cooperation"),
            detail = DiscoveryDetail(
                whatIsThis = "If multiple cattle herders share a pasture, each herder gains 100% of the benefit by adding another cow, while the damage of overgrazing is split among all herders. Rational self-interest inevitably destroys the pasture for everyone.",
                origin = "Conceptualized in 1833 by William Forster Lloyd and popularized by Garrett Hardin in 1968.",
                coreIdeas = listOf(
                    "Externalized Costs: Individuals reap direct private gains while public costs are socialized.",
                    "Market Failures: Shared goods like clean air, ocean fisheries, and unpolluted rivers lack natural market pricing.",
                    "Governance Solutions: Elinor Ostrom won the Nobel Prize showing communities can manage commons through local norms."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Garrett Hardin"),
                    KeyPerson(name = "Elinor Ostrom")
                ),
                example = "Commercial fishing fleets overfishing the open oceans to near extinction because no single country owns the high seas.",
                quote = "Freedom in a commons brings ruin to all."
            ),
            related = listOf("prisoners-dilemma", "veil-of-ignorance"),
            contrast = "cynicism"
        ),

        // ==========================================
        // 5. COGNITIVE BIASES & PSYCHOLOGY
        // ==========================================
        Discovery(
            id = "cognitive-dissonance",
            title = "Cognitive Dissonance",
            type = "BIAS",
            mood = "amber",
            hook = "WHEN YOUR BELIEFS CLASH WITH YOUR ACTIONS,\nWHICH ONE GIVES FIRST?",
            short = "The uncomfortable mental tension that occurs when holding contradictory beliefs, and how the mind tricks itself.",
            tags = listOf("psychology", "bias", "rationalization", "mind", "tension"),
            detail = DiscoveryDetail(
                whatIsThis = "When two beliefs - or a belief and an action - contradict each other, it creates mental tension. The mind resolves it fast, often by changing what we believe rather than what we did.",
                origin = "Identified by Leon Festinger in 1957 after studying a doomsday cult whose prophecy failed.",
                coreIdeas = listOf(
                    "Psychological Discomfort: Contradictions feel deeply threatening to self-image.",
                    "Self-Justification: The brain will fabricate excuses rather than admit it made an error.",
                    "The Fox and the Grapes: If you can't reach the grapes, you convince yourself they were sour anyway."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Leon Festinger")
                ),
                example = "Knowing smoking is deadly, but telling yourself 'my grandfather smoked and lived to 90' to ease guilt.",
                quote = "A man with a conviction is a hard man to change. Tell him you disagree and he turns away."
            ),
            related = listOf("confirmation-bias", "sunk-cost"),
            contrast = "stoicism"
        ),
        Discovery(
            id = "hedonic-treadmill",
            title = "The Hedonic Treadmill",
            type = "BIAS",
            mood = "ochre",
            hook = "THE RAISE WILL FEEL AMAZING -\nFOR ABOUT THREE WEEKS.",
            short = "The tendency for humans to quickly return to a baseline level of happiness despite major positive or negative events.",
            tags = listOf("happiness", "adaptation", "psychology", "desire", "baseline"),
            detail = DiscoveryDetail(
                whatIsThis = "Humans adjust to new circumstances - good or bad - faster than expected, settling back near an emotional baseline. Winning the lottery or buying a dream house yields only a brief spike in satisfaction.",
                origin = "Coined by Brickman and Campbell in 1971 in 'Hedonic Relativism and Good Society'.",
                coreIdeas = listOf(
                    "Rapid Adaptation: The brain resets expectations to whatever state is current.",
                    "The Trap of Constant Chasing: Running faster on the treadmill without moving forward in net happiness.",
                    "Experiences Over Possessions: Shared memories resist hedonic adaptation far longer than physical goods."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Philip Brickman"),
                    KeyPerson(name = "Arthur Schopenhauer", linkId = "schopenhauer")
                ),
                example = "Getting a dream promotion and celebrating all weekend, then finding yourself just as stressed and wanting the next promotion six months later.",
                quote = "We treat what we once wished for as our minimum expectation."
            ),
            related = listOf("schopenhauer", "epicureanism"),
            contrast = "epicureanism"
        ),
        Discovery(
            id = "confirmation-bias",
            title = "Confirmation Bias",
            type = "BIAS",
            mood = "cosmic",
            hook = "YOU DON'T SEE THE EVIDENCE -\nYOU SEE WHAT AGREES WITH YOU.",
            short = "The instinctive habit of searching for, interpreting, and remembering information that confirms pre-existing beliefs.",
            tags = listOf("bias", "thinking", "reasoning", "psychology", "evidence"),
            detail = DiscoveryDetail(
                whatIsThis = "When faced with ambiguous data, we embrace facts that flatter our existing opinions while ignoring or explaining away facts that challenge our identity.",
                origin = "Noted by Thucydides in Ancient Greece and formalized experimentally by Peter Wason in 1960.",
                coreIdeas = listOf(
                    "Selective Exposure: Consuming only news sources that echo your ideological stance.",
                    "Motivated Reasoning: Applying fierce scrutiny to opposing arguments while giving friendly claims a free pass.",
                    "Falsification Discipline: Science advances only when researchers actively try to prove their own theories wrong."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Peter Wason"),
                    KeyPerson(name = "Francis Bacon")
                ),
                example = "Believing a full moon causes hospital craziness, remembering every crazy night during a full moon while forgetting fifty quiet ones.",
                quote = "What a man had rather were true he more readily believes."
            ),
            related = listOf("cognitive-dissonance", "dunning-kruger"),
            contrast = "socrates"
        ),
        Discovery(
            id = "dunning-kruger",
            title = "The Dunning-Kruger Effect",
            type = "BIAS",
            mood = "terracotta",
            hook = "THE LESS YOU KNOW ABOUT SOMETHING,\nTHE MORE EXPERT YOU FEEL.",
            short = "The cognitive bias where people with low competence in a domain vastly overestimate their own ability.",
            tags = listOf("competence", "humility", "psychology", "wisdom", "bias"),
            detail = DiscoveryDetail(
                whatIsThis = "When you know very little about a complex field, you lack the very knowledge required to recognize how complex it is. As you learn more, you descend into the 'Valley of Despair' realizing how much you don't know.",
                origin = "Demonstrated in 1999 by Cornell psychologists David Dunning and Justin Kruger.",
                coreIdeas = listOf(
                    "Metacognitive Inability: Incompetence blinds individuals to their own incompetence.",
                    "Mount Stupid: Confidence peaks early after reading just one article or watching one video.",
                    "Expert Self-Doubt: Genuine experts often underestimate their relative skill, assuming tasks easy for them are easy for everyone."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "David Dunning"),
                    KeyPerson(name = "Justin Kruger"),
                    KeyPerson(name = "Socrates", linkId = "socrates")
                ),
                example = "Watching an Olympic gymnast on TV and casually saying 'I could probably do that balance beam routine with a week of practice.'",
                quote = "Ignorance more frequently begets confidence than does knowledge."
            ),
            related = listOf("socrates", "confirmation-bias"),
            contrast = "socrates"
        ),
        Discovery(
            id = "sunk-cost-fallacy",
            title = "The Sunk Cost Fallacy",
            type = "BIAS",
            mood = "stone",
            hook = "YOU'VE INVESTED SO MUCH TIME ALREADY -\nWHY STOP NOW?",
            short = "The irrational tendency to continue an endeavor once an investment in money, effort, or time has been made.",
            tags = listOf("decisions", "economics", "loss", "psychology", "rationality"),
            detail = DiscoveryDetail(
                whatIsThis = "Money, time, and pain already spent are gone forever and cannot be recovered. Decisions should only be evaluated on future costs and future benefits, yet humans stay in failing projects to justify past costs.",
                origin = "First described in behavioral economics literature by Richard Thaler and Amos Tversky.",
                coreIdeas = listOf(
                    "Past Costs Are Irretrievable: What you spent yesterday is irrelevant to what you should choose today.",
                    "Fear of Admitting Waste: Cutting losses feels like an admission of personal failure.",
                    "Opportunity Cost: Every hour spent on a dead-end project is an hour stolen from a thriving opportunity."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Richard Thaler"),
                    KeyPerson(name = "Daniel Kahneman")
                ),
                example = "Sitting through all 3 hours of an awful movie at the cinema because 'I already paid $20 for the ticket.'",
                quote = "Don't cling to a mistake just because you spent a long time making it."
            ),
            related = listOf("loss-aversion", "cognitive-dissonance"),
            contrast = "pragmatism"
        ),
        Discovery(
            id = "baader-meinhof",
            title = "The Baader-Meinhof Phenomenon",
            type = "BIAS",
            mood = "indigo",
            hook = "ONCE YOU LEARN A NEW WORD,\nWHY DOES IT SUDDENLY APPEAR EVERYWHERE?",
            short = "The frequency illusion where something newly learned suddenly seems to appear with improbable frequency.",
            tags = listOf("attention", "perception", "psychology", "frequency", "illusion"),
            detail = DiscoveryDetail(
                whatIsThis = "Also known as the Frequency Illusion: Your brain has selective attention. When it marks a piece of information as novel or important, your subconscious actively scans the environment and alerts you every time it appears, creating the illusion of a sudden outbreak.",
                origin = "Coined in 1994 by a reader in the St. Paul Pioneer Press and formalized by Stanford linguist Arnold Zwicky in 2005.",
                coreIdeas = listOf(
                    "Selective Attention: Your brain filters out 99% of sensory data, highlighting only what you recently noticed.",
                    "Confirmation Bias Tag-Team: Each new encounter reinforces the mistaken belief that the thing is multiplying.",
                    "Subconscious Priming: What you prime your mind with determines what your eyes actually see."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Arnold Zwicky")
                ),
                example = "Deciding you want to buy a red vintage Vespa, and suddenly noticing twelve red Vespas driving past you on your commute that week.",
                quote = "The eye sees only what the mind is prepared to comprehend."
            ),
            related = listOf("confirmation-bias", "spotlight-effect"),
            contrast = "empiricism"
        ),
        Discovery(
            id = "fundamental-attribution-error",
            title = "Fundamental Attribution Error",
            type = "BIAS",
            mood = "burgundy",
            hook = "WHEN OTHERS MESS UP, THEY'RE MALICIOUS.\nWHEN YOU MESS UP, YOU WERE TIRED.",
            short = "The tendency to judge others by their personality, but judge ourselves by our circumstances.",
            tags = listOf("empathy", "judgment", "psychology", "bias", "fairness"),
            detail = DiscoveryDetail(
                whatIsThis = "When someone cuts you off in traffic, you assume they are an aggressive, terrible jerk. When you cut someone off, you excuse yourself because you're late for a crucial medical appointment.",
                origin = "Coined by social psychologist Lee Ross in 1977 following experiments by Jones and Harris.",
                coreIdeas = listOf(
                    "Internal vs External Attribution: Blaming other people's character while blaming your own environment.",
                    "Lack of Context: We cannot see what other people have experienced in the previous hour.",
                    "The Antidote: Generous interpretation and Hanlon's Razor ('Never attribute to malice what is explained by exhaustion')."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Lee Ross"),
                    KeyPerson(name = "Edward E. Jones")
                ),
                example = "Thinking a coworker who didn't smile in the hallway hates you, without knowing their parent was rushed to the hospital that morning.",
                quote = "Be kind, for everyone you meet is fighting a hard battle."
            ),
            related = listOf("cognitive-dissonance", "spotlight-effect"),
            contrast = "stoicism"
        ),
        Discovery(
            id = "bystander-effect",
            title = "The Bystander Effect",
            type = "BIAS",
            mood = "ocean",
            hook = "THE MORE PEOPLE WHO WITNESS AN EMERGENCY,\nTHE LESS LIKELY ANYONE IS TO HELP.",
            short = "The social psychological phenomenon where individuals are less likely to offer help if other bystanders are present.",
            tags = listOf("social", "responsibility", "emergency", "psychology", "action"),
            detail = DiscoveryDetail(
                whatIsThis = "In a crowd, personal responsibility is diffused across all witnesses. Each person looks around, sees others doing nothing, and concludes that someone else will step up or that it's not a real emergency.",
                origin = "Researched extensively by John Darley and Bibb Latané in 1968 following the Kitty Genovese murder in New York.",
                coreIdeas = listOf(
                    "Diffusion of Responsibility: 'Somebody else will call the police.'",
                    "Pluralistic Ignorance: Looking to the calm faces of others to gauge if a crisis is real.",
                    "How to Break It: Point directly at a specific person and give a command ('You in the blue shirt, call 911!')."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "John Darley"),
                    KeyPerson(name = "Bibb Latané")
                ),
                example = "Seeing an ambiguous security alert in a team channel of 400 engineers, and nobody answering because everyone assumes another engineer is fixing it.",
                quote = "When everyone is responsible, nobody is responsible."
            ),
            related = listOf("tragedy-of-the-commons", "fundamental-attribution-error"),
            contrast = "virtue-ethics"
        ),
        Discovery(
            id = "loss-aversion",
            title = "Loss Aversion",
            type = "BIAS",
            mood = "rose",
            hook = "LOSING $100 HURTS TWICE AS MUCH\nAS WINNING $100 FEELS GOOD.",
            short = "The cognitive bias showing human psychology is fundamentally asymmetric: pain of loss vastly outweighs thrill of gain.",
            tags = listOf("economics", "risk", "psychology", "kahneman", "decisions"),
            detail = DiscoveryDetail(
                whatIsThis = "Evolutionary psychology prioritized survival: losing food or shelter was fatal, while gaining extra food was merely pleasant. Consequently, humans avoid risks disproportionately to protect what they already hold.",
                origin = "Demonstrated by Nobel laureates Daniel Kahneman and Amos Tversky in their 1979 Prospect Theory.",
                coreIdeas = listOf(
                    "Asymmetric Valuation: The emotional toll of a loss is measured at roughly 2 to 2.5 times the joy of an equivalent gain.",
                    "Status Quo Bias: We overvalue our current possessions simply because we own them (the Endowment Effect).",
                    "Risk Irrationality: Taking massive desperate gambles to avoid a certain loss, but playing overly timid when chasing gains."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Daniel Kahneman"),
                    KeyPerson(name = "Amos Tversky")
                ),
                example = "Refusing to sell an underperforming stock that dropped 50%, hoping against all odds it will bounce back so you don't 'lock in' the loss.",
                quote = "Losses loom larger than gains."
            ),
            related = listOf("sunk-cost-fallacy", "hedonic-treadmill"),
            contrast = "pragmatism"
        ),
        Discovery(
            id = "survivorship-bias",
            title = "Survivorship Bias",
            type = "BIAS",
            mood = "stone",
            hook = "ARMOR THE PARTS OF THE PLANE\nWITHOUT ANY BULLET HOLES.",
            short = "The logical error of concentrating on the entities that passed a selection process while completely overlooking those that did not.",
            tags = listOf("data", "success", "statistics", "war", "mistakes"),
            detail = DiscoveryDetail(
                whatIsThis = "During WWII, the military analyzed bombers returning from combat and wanted to armor the areas covered in bullet holes. Statistician Abraham Wald stopped them: the planes that got shot in the engines never made it home to be analyzed. You must armor the spots with no holes.",
                origin = "Derived from Abraham Wald's work at the Statistical Research Group in New York (1943).",
                coreIdeas = listOf(
                    "The Silent Graveyard: Focusing only on successful survivors hides the thousands of identical failures.",
                    "Hero Worship: Reading advice from college dropouts who became billionaires while ignoring millions of college dropouts working minimum wage.",
                    "Data Asymmetry: Looking at the evidence that made it through the filter rather than the filter itself."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Abraham Wald")
                ),
                example = "Believing that buildings constructed in 1850 were built with better craftsmanship than today, forgetting that all the poorly built 1850 buildings collapsed or were demolished.",
                quote = "The most important data is often the data that didn't make it back."
            ),
            related = listOf("confirmation-bias", "dunning-kruger"),
            contrast = "empiricism"
        )
    )

    val discoveryMap: Map<String, Discovery> = discoveries.associateBy { it.id }

    val recommendationReasons = listOf(
        "Based on your interest in this domain",
        "A contrasting perspective to challenge your recent picks",
        "A foundational concept in classical thought",
        "Connected to ideas you previously explored",
        "Added for a bit of exploration diversity - a different type than your recent picks."
    )

    val searchSuggestions: List<String> = listOf(
        "Stoicism", "Free Will", "Existentialism", "Consciousness",
        "Ethics", "Paradox", "Time", "Logic", "Identity", "Knowledge"
    )

    fun search(query: String): List<Discovery> {
        if (query.isBlank()) return emptyList()
        val q = query.lowercase().trim()
        return discoveries.filter { d ->
            d.title.lowercase().contains(q) ||
            d.hook.lowercase().contains(q) ||
            d.short.lowercase().contains(q) ||
            d.tags.any { it.lowercase().contains(q) } ||
            d.detail.whatIsThis.lowercase().contains(q) ||
            d.detail.keyPeople.any { it.name.lowercase().contains(q) }
        }
    }

    fun whyReasonFor(discovery: Discovery): String {
        return when (discovery.type.uppercase()) {
            "PHILOSOPHY" -> "Curated because philosophical systems give you mental operating frameworks for life's toughest uncertainties."
            "PHILOSOPHER" -> "Curated because studying the thinkers themselves illuminates how lived experience shapes radical original thought."
            "PARADOX" -> "Curated because paradoxes break rigid assumptions and force intellectual humility."
            "THOUGHT EXPERIMENT" -> "Curated because hypothetical scenarios isolate moral and scientific principles from everyday emotional bias."
            "BIAS", "COGNITIVE BIAS" -> "Curated because noticing subconscious cognitive traps is the highest leverage way to upgrade your decision making."
            else -> "Curated for your feed as a provocative idea worth contemplating."
        }
    }
}
