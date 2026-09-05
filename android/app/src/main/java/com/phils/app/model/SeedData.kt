package com.phils.app.model

object SeedData {
    val discoveries: List<Discovery> = listOf(
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
                    "Virtue — wisdom, courage, justice, and temperance — is the only true good.",
                    "Disturbance comes from judgment, not from events themselves."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Marcus Aurelius", linkId = "marcus-aurelius"),
                    KeyPerson(name = "Epictetus"),
                    KeyPerson(name = "Seneca")
                ),
                example = "A delayed flight can't be controlled. How you spend the two-hour wait can.",
                quote = "The event doesn't disturb you — your verdict on it does."
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
                whatIsThis = "Existentialism holds that people aren't born with a fixed purpose — we exist first, then define ourselves through the choices we make.",
                origin = "Emerged across 19th and 20th century Europe, gaining momentum after two world wars stripped away easy answers.",
                coreIdeas = listOf(
                    "Existence precedes essence — you aren't born with a nature to fulfill.",
                    "Freedom is unavoidable, and so is the responsibility that comes with it.",
                    "Authenticity means owning your choices instead of drifting on autopilot."
                ),
                keyPeople = listOf(
                    KeyPerson(name = "Jean-Paul Sartre"),
                    KeyPerson(name = "Søren Kierkegaard"),
                    KeyPerson(name = "Albert Camus", linkId = "camus")
                ),
                example = "Choosing a career not because it's expected of you, but because you've decided it's yours.",
                quote = "You are your choices, and little else."
            ),
            related = listOf("absurdism", "nihilism", "camus"),
            contrast = "nihilism"
        ),
        Discovery(
            id = "absurdism",
            title = "Absurdism",
            type = "PHILOSOPHY",
            mood = "terracotta",
            hook = "THE UNIVERSE WON'T ANSWER YOU —\nKEEP ASKING ANYWAY.",
            short = "A response to a universe with no inherent meaning: not despair, but a defiant kind of freedom.",
            tags = listOf("meaning", "freedom", "universe", "rebellion", "happiness"),
            detail = DiscoveryDetail(
                whatIsThis = "Absurdism starts from a collision: humans crave meaning, and the universe offers none. Rather than resolving that tension, it asks you to live inside it.",
                origin = "Developed by Albert Camus in the mid-20th century as a third path between religious faith and nihilistic despair.",
                coreIdeas = listOf(
                    "The absurd is the gap between our need for meaning and the universe's silence.",
                    "You can reject both surrender and false hope — and choose to keep living anyway.",
                    "Revolt, freedom, and passion become the response to meaninglessness."
                ),
                keyPeople = listOf(KeyPerson(name = "Albert Camus", linkId = "camus")),
                example = "Waking up to work on something with no guaranteed payoff, and doing it wholeheartedly regardless.",
                quote = "The silence doesn't need an answer — it needs a response."
            ),
            related = listOf("existentialism", "nihilism", "camus"),
            contrast = "nihilism"
        ),
        Discovery(
            id = "nihilism",
            title = "Nihilism",
            type = "PHILOSOPHY",
            mood = "cosmic",
            hook = "WHAT IF NOTHING MEANS ANYTHING —\nAND THAT'S FINE?",
            short = "The view that life has no inherent meaning, value, or purpose — and an invitation to sit with that.",
            tags = listOf("meaning", "void", "purpose", "despair", "freedom", "values"),
            detail = DiscoveryDetail(
                whatIsThis = "Nihilism argues that claims about objective meaning, morality, or purpose don't hold up — there's no built-in reason for anything, including us.",
                origin = "Associated with 19th century thinkers responding to the erosion of traditional religious and moral certainties.",
                coreIdeas = listOf(
                    "No universal meaning is handed to us by the universe.",
                    "Traditional values may be human inventions rather than discovered truths.",
                    "This can be read as despair — or as total freedom from imposed rules."
                ),
                keyPeople = listOf(KeyPerson(name = "Friedrich Nietzsche", linkId = "nietzsche")),
                example = "Realizing a long-held 'should' in your life was never actually required of you.",
                quote = "An empty sky isn't a threat. It's just empty."
            ),
            related = listOf("existentialism", "absurdism", "nietzsche"),
            contrast = "existentialism"
        ),
        Discovery(
            id = "epicureanism",
            title = "Epicureanism",
            type = "PHILOSOPHY",
            mood = "sage",
            hook = "WHAT IF THE GOOD LIFE WAS QUIETER\nTHAN YOU THINK?",
            short = "A philosophy focused on tranquility, moderation, and freedom from unnecessary desires.",
            tags = listOf("pleasure", "happiness", "desire", "tranquility", "simplicity"),
            detail = DiscoveryDetail(
                whatIsThis = "Epicureanism defines the good life not as constant pleasure-seeking, but as removing the pain caused by unnecessary wants and fears.",
                origin = "Founded by Epicurus in Athens around 307 BCE, taught in a community garden open to anyone regardless of status.",
                coreIdeas = listOf(
                    "True pleasure is the absence of pain and disturbance, not intensity.",
                    "Most suffering comes from desires that were never necessary.",
                    "Simple pleasures — friendship, food, rest — outperform excess."
                ),
                keyPeople = listOf(KeyPerson(name = "Epicurus")),
                example = "Choosing a quiet dinner with two close friends over a loud party with fifty acquaintances.",
                quote = "Enough was always closer than more."
            ),
            related = listOf("stoicism", "hedonic-adaptation"),
            contrast = "stoicism"
        ),
        Discovery(
            id = "marcus-aurelius",
            title = "Marcus Aurelius",
            type = "PHILOSOPHER",
            mood = "stone",
            hook = "THE MOST POWERFUL MAN IN ROME\nWROTE HIMSELF REMINDERS TO STAY HUMBLE.",
            short = "A Roman emperor who used private journaling to practice the Stoic philosophy he ruled by.",
            tags = listOf("stoicism", "leadership", "journaling", "duty", "discipline"),
            detail = DiscoveryDetail(
                whatIsThis = "Marcus Aurelius ruled the Roman Empire for nearly two decades while keeping a private journal working through Stoic ideas — never intended for publication.",
                origin = "Written during military campaigns between 161–180 CE, later preserved as Meditations.",
                coreIdeas = listOf(
                    "Self-discipline over indulgence, even with unlimited power available.",
                    "Daily reflection as a tool for staying grounded.",
                    "Duty to others outweighs personal comfort."
                ),
                keyPeople = listOf(KeyPerson(name = "Epictetus"), KeyPerson(name = "Seneca")),
                example = "Reviewing tough moments from your day each night, the way a journal entry might.",
                quote = "The empire could wait. The journal couldn't."
            ),
            related = listOf("stoicism", "dichotomy-of-control"),
            contrast = null
        ),
        Discovery(
            id = "nietzsche",
            title = "Friedrich Nietzsche",
            type = "PHILOSOPHER",
            mood = "burgundy",
            hook = "WHAT IF YOU HAD TO LIVE THIS EXACT LIFE\nAGAIN, FOREVER?",
            short = "A philosopher who challenged inherited morality and asked what values we'd choose if we built our own.",
            tags = listOf("eternal return", "morality", "values", "power", "self-creation"),
            detail = DiscoveryDetail(
                whatIsThis = "Nietzsche questioned where our moral rules actually come from, and pushed people to build values through their own will instead of inherited tradition.",
                origin = "Writing in late 19th century Germany, often in poor health and outside academic life.",
                coreIdeas = listOf(
                    "Traditional morality may serve power structures more than truth.",
                    "The 'will to power' as a drive behind human behavior.",
                    "Eternal return: a thought experiment testing whether you'd affirm your life on repeat."
                ),
                keyPeople = listOf(KeyPerson(name = "Arthur Schopenhauer")),
                example = "Asking, before a big decision, whether you'd be proud to repeat it infinitely.",
                quote = "Not comfort. Amplitude — a life you'd choose again."
            ),
            related = listOf("nihilism", "absurdism"),
            contrast = null
        ),
        Discovery(
            id = "camus",
            title = "Albert Camus",
            type = "PHILOSOPHER",
            mood = "terracotta",
            hook = "HE FOUGHT IN THE RESISTANCE\nAND STILL FOUND ROOM FOR JOY.",
            short = "A writer-philosopher who faced a meaningless universe head-on and argued for revolt, freedom, and passion anyway.",
            tags = listOf("absurdism", "meaning", "freedom", "joy", "rebellion"),
            detail = DiscoveryDetail(
                whatIsThis = "Camus rejected both religious answers and despairing nihilism, proposing we face an indifferent universe clearly and still choose to live fully.",
                origin = "Writing in France and Algeria through the 1940s–50s, shaped by war, illness, and a love of physical life.",
                coreIdeas = listOf(
                    "Revolt: living in full awareness of the absurd, without surrendering to it.",
                    "Freedom: no imposed meaning means no imposed limits either.",
                    "Passion: since there's no 'why', the intensity of experience matters more."
                ),
                keyPeople = listOf(KeyPerson(name = "Jean-Paul Sartre")),
                example = "Fully committing to a passion project with no promise it will 'lead anywhere.'",
                quote = "No conclusion, and still — fully alive."
            ),
            related = listOf("absurdism", "existentialism"),
            contrast = "nihilism"
        ),
        Discovery(
            id = "cognitive-dissonance",
            title = "Cognitive Dissonance",
            type = "CONCEPT",
            mood = "burgundy",
            hook = "YOUR MIND WILL REWRITE THE TRUTH\nTO AVOID FEELING WRONG.",
            short = "The quiet discomfort of holding two conflicting beliefs, and the lengths the mind goes to resolve it.",
            tags = listOf("mind", "psychology", "belief", "bias", "self-justification"),
            detail = DiscoveryDetail(
                whatIsThis = "When two beliefs — or a belief and an action — contradict each other, it creates mental tension. The mind resolves it fast, often by changing what we believe rather than what we did.",
                origin = "Coined by psychologist Leon Festinger in 1957 after studying a doomsday cult's failed prophecy.",
                coreIdeas = listOf(
                    "Contradiction creates real, measurable psychological discomfort.",
                    "The mind prefers changing beliefs over admitting an action was wrong.",
                    "The bigger the investment, the stronger the justification that follows."
                ),
                keyPeople = listOf(KeyPerson(name = "Leon Festinger")),
                example = "Convincing yourself an expensive purchase was worth it, right after buying it.",
                quote = "The story changes so the self doesn't have to."
            ),
            related = listOf("confirmation-bias", "hedonic-adaptation"),
            contrast = null
        ),
        Discovery(
            id = "hedonic-adaptation",
            title = "Hedonic Adaptation",
            type = "CONCEPT",
            mood = "ochre",
            hook = "THE RAISE WILL FEEL AMAZING —\nFOR ABOUT THREE WEEKS.",
            short = "The tendency to quickly return to a stable level of happiness, no matter what changes.",
            tags = listOf("happiness", "psychology", "desire", "pleasure", "adaptation"),
            detail = DiscoveryDetail(
                whatIsThis = "Humans adjust to new circumstances — good or bad — faster than expected, settling back near an emotional baseline.",
                origin = "Studied since the 1970s, including well-known research comparing lottery winners and accident survivors over time.",
                coreIdeas = listOf(
                    "Big wins and losses affect happiness less, and for shorter, than we predict.",
                    "We recalibrate our sense of 'normal' constantly.",
                    "This explains why chasing more rarely produces lasting satisfaction."
                ),
                keyPeople = listOf(KeyPerson(name = "Philip Brickman")),
                example = "A dream apartment that felt thrilling on move-in day and just feels like home two months later.",
                quote = "The new normal arrives faster than the thrill does."
            ),
            related = listOf("epicureanism", "cognitive-dissonance"),
            contrast = null
        ),
        Discovery(
            id = "confirmation-bias",
            title = "Confirmation Bias",
            type = "CONCEPT",
            mood = "rose",
            hook = "YOU DON'T SEE THE EVIDENCE —\nYOU SEE WHAT AGREES WITH YOU.",
            short = "The tendency to notice, favor, and remember information that confirms what you already believe.",
            tags = listOf("mind", "psychology", "bias", "belief", "evidence"),
            detail = DiscoveryDetail(
                whatIsThis = "The brain isn't a neutral evidence-processor. It quietly favors information that fits existing beliefs and filters out what doesn't.",
                origin = "A well-documented cognitive bias formalized through psychology research across the 20th century.",
                coreIdeas = listOf(
                    "We search for confirming evidence more actively than disconfirming evidence.",
                    "Ambiguous information gets interpreted to fit prior beliefs.",
                    "Awareness of the bias doesn't fully cancel it out."
                ),
                keyPeople = listOf(KeyPerson(name = "Peter Wason")),
                example = "Reading only news sources that already agree with your politics.",
                quote = "Agreement feels like proof. It usually isn't."
            ),
            related = listOf("cognitive-dissonance"),
            contrast = null
        ),
        Discovery(
            id = "dichotomy-of-control",
            title = "Dichotomy of Control",
            type = "CONCEPT",
            mood = "stone",
            hook = "HALF THE THINGS YOU WORRY ABOUT\nWERE NEVER YOURS TO CONTROL.",
            short = "A Stoic tool for sorting life into what you can influence and what you can't.",
            tags = listOf("stoicism", "control", "anxiety", "focus", "clarity"),
            detail = DiscoveryDetail(
                whatIsThis = "A simple but demanding filter: separate everything in your life into 'up to me' and 'not up to me,' and stop spending energy on the second pile.",
                origin = "Central to Stoic practice, articulated by Epictetus at the opening of his Enchiridion.",
                coreIdeas = listOf(
                    "Your judgments, choices, and effort are 'up to you.'",
                    "Outcomes, other people, and reputation are not.",
                    "Peace grows in proportion to how well you sort the two."
                ),
                keyPeople = listOf(KeyPerson(name = "Epictetus"), KeyPerson(name = "Marcus Aurelius", linkId = "marcus-aurelius")),
                example = "Preparing thoroughly for an interview, then releasing the outcome once you've walked out the door.",
                quote = "Sort first. Worry second, if there's anything left to worry about."
            ),
            related = listOf("stoicism", "marcus-aurelius"),
            contrast = null
        ),
        Discovery(
            id = "ship-of-theseus",
            title = "Ship of Theseus",
            type = "PARADOX",
            mood = "ocean",
            hook = "REPLACE EVERY PLANK OF A SHIP —\nIS IT STILL THE SAME SHIP?",
            short = "An ancient puzzle about identity, asking what actually makes something the same thing over time.",
            tags = listOf("identity", "change", "self", "time", "paradox"),
            detail = DiscoveryDetail(
                whatIsThis = "If a ship has every one of its planks replaced over time, is the fully-repaired ship still the 'same' ship? The puzzle sharpens if someone rebuilds a second ship from the discarded original planks.",
                origin = "Described by Plutarch in the 1st century CE, referencing a ship linked to the hero Theseus.",
                coreIdeas = listOf(
                    "Identity might depend on continuity of form, not material.",
                    "Or identity might depend on the physical parts themselves.",
                    "The puzzle applies directly to human bodies and minds over a lifetime."
                ),
                keyPeople = listOf(KeyPerson(name = "Plutarch")),
                example = "You don't have a single cell left from age seven — are you still 'you'?",
                quote = "Nothing stayed. Somehow, it's still the same ship."
            ),
            related = listOf("dichotomy-of-control"),
            contrast = null
        ),
        Discovery(
            id = "fermi-paradox",
            title = "Fermi Paradox",
            type = "PARADOX",
            mood = "cosmic",
            hook = "THE UNIVERSE IS UNIMAGINABLY VAST —\nSO WHERE IS EVERYONE?",
            short = "A contradiction between the high odds of alien life and our total lack of evidence for it.",
            tags = listOf("universe", "space", "life", "science", "aliens"),
            detail = DiscoveryDetail(
                whatIsThis = "Given the sheer number of stars and potentially habitable planets, the galaxy should statistically be loud with civilizations. Instead, we've found total silence.",
                origin = "Named after physicist Enrico Fermi, who reportedly raised the question casually over lunch in 1950.",
                coreIdeas = listOf(
                    "The scale of the universe makes life elsewhere statistically likely.",
                    "We have zero confirmed contact despite decades of searching.",
                    "Proposed answers range from 'we're early' to 'civilizations self-destruct' to 'they're hiding.'"
                ),
                keyPeople = listOf(KeyPerson(name = "Enrico Fermi")),
                example = "Scanning a packed stadium and hearing complete silence — not one voice.",
                quote = "The math says loud. The sky says quiet."
            ),
            related = listOf("simulation-hypothesis"),
            contrast = null
        ),
        Discovery(
            id = "trolley-problem",
            title = "The Trolley Problem",
            type = "THOUGHT EXPERIMENT",
            mood = "burgundy",
            hook = "PULL THE LEVER, AND YOU CHOOSE\nWHO LIVES. DO NOTHING, AND YOU STILL DO.",
            short = "A moral dilemma testing whether causing harm is worse than allowing it, even with the same outcome.",
            tags = listOf("ethics", "morality", "choice", "action", "harm"),
            detail = DiscoveryDetail(
                whatIsThis = "A runaway trolley is about to kill five people. You can pull a lever to divert it onto a track where it will kill one person instead. Do you pull it?",
                origin = "Introduced by philosopher Philippa Foot in 1967, later expanded into dozens of moral variations.",
                coreIdeas = listOf(
                    "Tests whether outcomes alone should determine right action.",
                    "Tests whether the act/omission distinction matters morally.",
                    "Variations change people's answers even when the math stays identical."
                ),
                keyPeople = listOf(KeyPerson(name = "Philippa Foot")),
                example = "A self-driving car forced to choose between two unavoidable harms in a split second.",
                quote = "Same math, different lever — and suddenly it's not the same choice."
            ),
            related = listOf("experience-machine"),
            contrast = null
        ),
        Discovery(
            id = "experience-machine",
            title = "The Experience Machine",
            type = "THOUGHT EXPERIMENT",
            mood = "lavender",
            hook = "A MACHINE COULD GIVE YOU A PERFECT LIFE —\nWOULD YOU PLUG IN?",
            short = "A thought experiment testing whether we truly want pleasure, or something more than pleasure.",
            tags = listOf("pleasure", "happiness", "reality", "meaning", "choice"),
            detail = DiscoveryDetail(
                whatIsThis = "Imagine a machine that could simulate any experience you want, indistinguishable from real life, for the rest of your life. Would you choose to plug in permanently?",
                origin = "Proposed by philosopher Robert Nozick in 1974, arguing against purely pleasure-based theories of the good life.",
                coreIdeas = listOf(
                    "Most people hesitate to plug in, even knowing it would feel identical to reality.",
                    "This suggests we value real achievement, connection, and truth — not just the feeling of them.",
                    "Challenges the idea that pleasure alone defines a good life."
                ),
                keyPeople = listOf(KeyPerson(name = "Robert Nozick")),
                example = "Choosing a real, difficult relationship over a simulated 'perfect' one that felt just as good.",
                quote = "Feeling loved and being loved turned out to be different questions."
            ),
            related = listOf("epicureanism", "trolley-problem"),
            contrast = "epicureanism"
        ),
        Discovery(
            id = "simulation-hypothesis",
            title = "Simulation Hypothesis",
            type = "SCIENTIFIC IDEA",
            mood = "cosmic",
            hook = "WHAT IF REALITY IS RUNNING\nON SOMEONE ELSE'S HARDWARE?",
            short = "The idea that our entire reality could be a highly advanced computer simulation.",
            tags = listOf("reality", "universe", "simulation", "technology", "philosophy of mind"),
            detail = DiscoveryDetail(
                whatIsThis = "As computing power grows, some argue advanced civilizations could run enormous numbers of simulated realities — making it statistically plausible we're in one.",
                origin = "Formalized by philosopher Nick Bostrom in a 2003 paper outlining the probability argument.",
                coreIdeas = listOf(
                    "If simulations become common, simulated minds could outnumber 'real' ones.",
                    "We currently have no way to test the hypothesis from inside the system.",
                    "The idea echoes much older philosophical questions about the nature of reality."
                ),
                keyPeople = listOf(KeyPerson(name = "Nick Bostrom")),
                example = "Glitches, déjà vu, or the universe's oddly mathematical structure are sometimes cited as folk evidence, though none are proof.",
                quote = "If it's a simulation, it's a very convincing one."
            ),
            related = listOf("fermi-paradox", "quantum-superposition"),
            contrast = null
        ),
        Discovery(
            id = "quantum-superposition",
            title = "Quantum Superposition",
            type = "SCIENTIFIC IDEA",
            mood = "indigo",
            hook = "UNTIL YOU LOOK, IT'S BOTH —\nNOT EITHER.",
            short = "The strange rule that particles can exist in multiple states at once, until measured.",
            tags = listOf("physics", "reality", "science", "observation", "quantum"),
            detail = DiscoveryDetail(
                whatIsThis = "At the smallest scales, particles don't settle into one definite state — they exist as a mix of possibilities until an observation forces one outcome.",
                origin = "A core principle of quantum mechanics developed in the 1920s, illustrated by Schrödinger's cat.",
                coreIdeas = listOf(
                    "Particles can be in multiple states simultaneously — a superposition.",
                    "Measurement appears to 'collapse' that superposition into one outcome.",
                    "The role of the observer remains genuinely debated, not just popular-science myth."
                ),
                keyPeople = listOf(KeyPerson(name = "Erwin Schrödinger"), KeyPerson(name = "Werner Heisenberg")),
                example = "A coin spinning in the air isn't heads or tails — it's both, until it lands.",
                quote = "Not undecided. Genuinely both, until it isn't."
            ),
            related = listOf("simulation-hypothesis"),
            contrast = null
        )
    )

    val discoveryMap: Map<String, Discovery> = discoveries.associateBy { it.id }

    val searchSuggestions: List<String> = listOf(
        "meaning of life",
        "identity",
        "free will",
        "happiness",
        "the mind",
        "ethics",
        "reality"
    )

    fun search(query: String): List<Discovery> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return emptyList()
        return discoveries.filter { d ->
            val haystack = listOf(
                d.title,
                d.hook,
                d.short,
                d.type
            ).plus(d.tags).joinToString(" ").lowercase()
            haystack.contains(q)
        }
    }

    private val whyReasons = listOf<(Discovery) -> String>(
        { d ->
            val relTitle = d.related.firstOrNull()?.let { discoveryMap[it]?.title }
            if (relTitle != null) {
                "You recently explored $relTitle. This one looks at a nearby question from a different angle."
            } else {
                "You recently explored a related idea. This one looks at a nearby question from a different angle."
            }
        },
        { "This connects to something you saved earlier." },
        { "A contrasting perspective to an idea you spent time with." },
        { "Added for a bit of exploration diversity — a different type than your recent picks." },
        { "A quiet classic worth surfacing every so often." }
    )

    fun whyReasonFor(discovery: Discovery): String {
        val idx = kotlin.math.abs(discovery.id.hashCode()) % whyReasons.size
        return whyReasons[idx](discovery)
    }
}
