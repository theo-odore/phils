package com.phils.app.data.api

import com.phils.app.model.ConnectedIdea
import com.phils.app.model.CorePrinciple
import com.phils.app.model.CriticalPerspectives
import com.phils.app.model.Discovery
import com.phils.app.model.DiscoveryDetail
import com.phils.app.model.KeyPerson
import com.phils.app.model.KeyThinker
import com.phils.app.model.PracticalScenario
import com.phils.app.model.ReadingDepth
import com.phils.app.model.RichEverydayLife
import com.phils.app.model.RichOriginContext
import com.phils.app.model.RichWhatIsThis
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FeedApiResponse(
    val success: Boolean,
    val data: FeedDataDto? = null,
    val error: String? = null
)

@JsonClass(generateAdapter = true)
data class FeedDataDto(
    val discoveries: List<ServerDiscoveryDto> = emptyList(),
    val next_cursor: String? = null,
    val has_more: Boolean = true
)

@JsonClass(generateAdapter = true)
data class ServerRelatedItemDto(
    val id: String? = null,
    val title: String,
    val type: String? = null,
    val reason: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerDiscoveryDto(
    val id: String,
    val slug: String? = null,
    val title: String,
    val type: String? = null,
    val hook: String? = null,
    val short_description: String? = null,
    val detailed_description: String? = null,
    val origin_context: String? = null,
    val core_principles: List<String> = emptyList(),
    val everyday_example: String? = null,
    val background_style: String? = null,
    val key_people: List<KeyPerson> = emptyList(),
    val related_discoveries: List<ServerRelatedItemDto> = emptyList(),
    val contrasting_discoveries: List<ServerRelatedItemDto> = emptyList(),
    val why_reason: String? = null,

    // Rich structured section fields mapped directly to domain models
    val section_what_is_this: RichWhatIsThis? = null,
    val section_origin_context: RichOriginContext? = null,
    val section_core_principles: List<CorePrinciple> = emptyList(),
    val section_key_thinkers: List<KeyThinker> = emptyList(),
    val section_everyday_life: RichEverydayLife? = null,
    val section_critical_perspectives: CriticalPerspectives? = null,
    val section_connected_ideas: List<ConnectedIdea> = emptyList(),
    val reading_depth: ReadingDepth? = null
)

fun ServerDiscoveryDto.toDomain(): Discovery {
    val domainType = when (type?.lowercase()) {
        "thought_experiment" -> "THOUGHT EXPERIMENT"
        "scientific_idea" -> "SCIENTIFIC IDEA"
        "paradox" -> "PARADOX"
        "philosopher" -> "PHILOSOPHER"
        "concept" -> "CONCEPT"
        else -> "PHILOSOPHY"
    }

    val domainMood = when (background_style?.lowercase()) {
        "amber_parchment", "ochre" -> "ochre"
        "terracotta_sun", "terracotta", "taoist_flow" -> "terracotta"
        "sage_paper", "sage" -> "sage"
        "indigo_void", "indigo" -> "indigo"
        "crimson_existential", "burgundy", "absurdist_vortex" -> "burgundy"
        "obsidian_dark", "cosmic" -> "cosmic"
        "forest_mist", "ocean" -> "ocean"
        "slate_stone", "stone", "stoic_stone" -> "stone"
        "lavender" -> "lavender"
        "rose" -> "rose"
        else -> "stone"
    }

    val primaryQuote = key_people.firstOrNull { !it.quote.isNullOrBlank() }?.quote
        ?: "Wisdom begins in wonder."

    val contrastText = contrasting_discoveries.firstOrNull()?.let { item ->
        if (!item.reason.isNullOrBlank()) "${item.title}: ${item.reason}" else item.title
    }

    // Synthesize Rich What Is This if absent
    val resolvedWhatIsThis = section_what_is_this ?: RichWhatIsThis(
        summary = detailed_description ?: short_description ?: "",
        centralQuestion = hook ?: "How does this idea reframe our understanding of reality?",
        howItWorks = short_description ?: detailed_description ?: "",
        introductoryExample = everyday_example,
        importance = "A foundational intellectual model in ${domainType.lowercase()} that provides critical insight into human reasoning, behavior, and the nature of knowledge.",
        misconceptions = listOf(
            "Often viewed as an abstract academic curiosity rather than a transformative lens for lived experience.",
            "Mistakenly judged in isolation rather than through its dialogue with contrasting traditions of thought."
        ),
        questionsToConsider = listOf(
            "How would your decisions change if you applied this principle consistently today?",
            "What assumptions or blind spots are challenged when you test this framework in practice?"
        )
    )

    // Synthesize Rich Origin Context if absent
    val resolvedOriginContext = section_origin_context ?: RichOriginContext(
        summary = origin_context ?: "Formulated through classical philosophical inquiry.",
        eraAndLocation = key_people.firstOrNull()?.era ?: "Classical Antiquity",
        historicalCircumstances = "Emerged during pivotal periods of intellectual transformation, addressing fundamental dilemmas of knowledge, ethics, and nature.",
        motivatingProblem = "How can an individual achieve clarity, live ethically, and reason truthfully amidst uncertainty and change?",
        historicalLegacy = "Continues to serve as a cornerstone in ethics, cognition, and modern decision theory."
    )

    // Synthesize Core Principles if absent
    val resolvedPrinciples = if (section_core_principles.isNotEmpty()) {
        section_core_principles
    } else {
        core_principles.mapIndexed { idx, p ->
            val colonIndex = p.indexOf(':')
            val pName = if (colonIndex != -1) p.substring(0, colonIndex).trim() else "Principle ${idx + 1}"
            val pDesc = if (colonIndex != -1) p.substring(colonIndex + 1).trim() else p.trim()
            CorePrinciple(
                name = pName,
                explanation = pDesc,
                whyItMatters = "Clarifies the core mechanics and reasoning behind this concept.",
                example = everyday_example
            )
        }
    }

    // Synthesize Key Thinkers if absent
    val resolvedThinkers = if (section_key_thinkers.isNotEmpty()) {
        section_key_thinkers
    } else {
        key_people.map { p ->
            KeyThinker(
                name = p.name,
                role = p.role,
                era = p.era,
                quote = p.quote,
                biographicalContext = p.role?.let { "$it active during ${p.era ?: "antiquity"}." },
                specificContribution = "Formulated and popularized key foundational aspects of $title."
            )
        }
    }

    // Synthesize Everyday Life if absent
    val resolvedEverydayLife = section_everyday_life ?: RichEverydayLife(
        summary = everyday_example ?: short_description ?: "",
        scenarios = listOf(
            PracticalScenario(
                title = "Navigating Real-World Decisions",
                context = "Applying this perspective to modern daily choices, cognitive habits, and interpersonal dynamics.",
                applicationSteps = listOf(
                    "Pause and observe your initial instinctive assumption or emotional reaction.",
                    "Frame the situation through the lens and principles of $title.",
                    "Act with deliberate intention aligned with reasoned reflection rather than default impulse."
                ),
                reflection = "Examining your choices through this lens transforms theoretical wisdom into daily resilience."
            )
        )
    )

    // Synthesize Critical Perspectives if absent
    val resolvedCritical = section_critical_perspectives ?: CriticalPerspectives(
        proponentArguments = "Advocates argue this framework provides indispensable clarity, cognitive resilience, and intellectual rigor.",
        criticArguments = contrasting_discoveries.firstOrNull()?.let {
            "Contrasting schools of thought, such as ${it.title}, argue that this approach may overlook alternative truths: ${it.reason ?: "different fundamental assumptions about reality"}."
        } ?: "Critics debate whether this framework accounts for extreme edge cases and conflicting human intuitions."
    )

    // Synthesize Connected Ideas if absent
    val resolvedConnected = if (section_connected_ideas.isNotEmpty()) {
        section_connected_ideas
    } else {
        related_discoveries.map { r ->
            ConnectedIdea(
                id = r.id ?: r.title.lowercase().replace(" ", "-"),
                title = r.title,
                type = r.type?.uppercase() ?: "PHILOSOPHY",
                relationshipType = "Intellectual Kinship",
                explanation = r.reason ?: "Shares foundational principles and complementary methods of reasoning."
            )
        }
    }

    val resolvedDepth = reading_depth ?: ReadingDepth(
        quickIntroWordCount = 200,
        deepDiveWordCount = 850,
        readingTimeMinutes = 5
    )

    return Discovery(
        id = id,
        title = title,
        type = domainType,
        mood = domainMood,
        hook = hook ?: "A DEEP QUESTION WORTH CONTEMPLATING",
        short = short_description ?: "",
        tags = listOf(domainType),
        detail = DiscoveryDetail(
            whatIsThis = detailed_description ?: "",
            origin = origin_context ?: "",
            coreIdeas = core_principles,
            keyPeople = key_people,
            example = everyday_example ?: "",
            quote = primaryQuote,
            richWhatIsThis = resolvedWhatIsThis,
            richOriginContext = resolvedOriginContext,
            corePrinciplesRich = resolvedPrinciples,
            keyThinkersRich = resolvedThinkers,
            everydayLifeRich = resolvedEverydayLife,
            criticalPerspectives = resolvedCritical,
            connectedIdeasRich = resolvedConnected,
            readingDepth = resolvedDepth
        ),
        related = related_discoveries.map { it.title },
        contrast = contrastText,
        saved = false
    )
}
