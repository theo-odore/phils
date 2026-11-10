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
data class ServerKeyPersonDto(
    val name: String,
    val role: String? = null,
    val era: String? = null,
    val quote: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerRelatedItemDto(
    val id: String? = null,
    val title: String,
    val type: String? = null,
    val reason: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerRichWhatIsThisDto(
    val summary: String,
    val central_question: String? = null,
    val main_argument: String? = null,
    val how_it_works: String? = null,
    val introductory_example: String? = null,
    val importance: String? = null,
    val misconceptions: List<String> = emptyList(),
    val questions_to_consider: List<String> = emptyList()
)

@JsonClass(generateAdapter = true)
data class ServerRichOriginContextDto(
    val summary: String,
    val era_and_location: String? = null,
    val historical_circumstances: String? = null,
    val motivating_problem: String? = null,
    val earlier_influences: List<String> = emptyList(),
    val evolution_and_development: String? = null,
    val historical_legacy: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerCorePrincipleDto(
    val name: String,
    val explanation: String,
    val why_it_matters: String,
    val reasoning: String? = null,
    val example: String? = null,
    val counter_case: String? = null,
    val common_misunderstanding: String? = null,
    val relation_to_other_principles: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerKeyThinkerDto(
    val name: String,
    val link_id: String? = null,
    val era: String? = null,
    val role: String? = null,
    val biographical_context: String? = null,
    val specific_contribution: String? = null,
    val major_works_or_arguments: String? = null,
    val distinct_perspective: String? = null,
    val quote: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerScenarioDto(
    val title: String,
    val context: String,
    val application_steps: List<String> = emptyList(),
    val reflection: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerEverydayLifeDto(
    val summary: String,
    val scenarios: List<ServerScenarioDto> = emptyList(),
    val common_mistakes: List<String> = emptyList(),
    val limitations: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerCriticalPerspectivesDto(
    val proponent_arguments: String? = null,
    val critic_arguments: String? = null,
    val limitations_and_objections: List<String> = emptyList(),
    val response_to_objections: String? = null,
    val unresolved_debates: String? = null
)

@JsonClass(generateAdapter = true)
data class ServerConnectedIdeaDto(
    val id: String,
    val title: String,
    val type: String? = null,
    val relationship_type: String? = null,
    val explanation: String
)

@JsonClass(generateAdapter = true)
data class ServerReadingDepthDto(
    val quick_intro_word_count: Int? = null,
    val deep_dive_word_count: Int? = null,
    val reading_time_minutes: Int? = null
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
    val key_people: List<ServerKeyPersonDto> = emptyList(),
    val related_discoveries: List<ServerRelatedItemDto> = emptyList(),
    val contrasting_discoveries: List<ServerRelatedItemDto> = emptyList(),
    val why_reason: String? = null,

    // Rich structured section fields
    val section_what_is_this: ServerRichWhatIsThisDto? = null,
    val section_origin_context: ServerRichOriginContextDto? = null,
    val section_core_principles: List<ServerCorePrincipleDto> = emptyList(),
    val section_key_thinkers: List<ServerKeyThinkerDto> = emptyList(),
    val section_everyday_life: ServerEverydayLifeDto? = null,
    val section_critical_perspectives: ServerCriticalPerspectivesDto? = null,
    val section_connected_ideas: List<ServerConnectedIdeaDto> = emptyList(),
    val reading_depth: ServerReadingDepthDto? = null
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
        "terracotta_sun", "terracotta" -> "terracotta"
        "sage_paper", "sage" -> "sage"
        "indigo_void", "indigo" -> "indigo"
        "crimson_existential", "burgundy" -> "burgundy"
        "obsidian_dark", "cosmic" -> "cosmic"
        "forest_mist", "ocean" -> "ocean"
        "slate_stone", "stone" -> "stone"
        "lavender" -> "lavender"
        "rose" -> "rose"
        else -> "stone"
    }

    val primaryQuote = key_people.firstOrNull { !it.quote.isNullOrBlank() }?.quote 
        ?: "Wisdom begins in wonder."

    val domainKeyPeople = key_people.map { p ->
        KeyPerson(
            name = p.name,
            role = p.role,
            era = p.era,
            quote = p.quote
        )
    }

    val contrastText = contrasting_discoveries.firstOrNull()?.let { item ->
        if (!item.reason.isNullOrBlank()) "${item.title}: ${item.reason}" else item.title
    }

    // Map rich sections
    val richWhat = section_what_is_this?.let {
        RichWhatIsThis(
            summary = it.summary,
            centralQuestion = it.central_question,
            mainArgument = it.main_argument,
            howItWorks = it.how_it_works,
            introductoryExample = it.introductory_example,
            importance = it.importance,
            misconceptions = it.misconceptions,
            questionsToConsider = it.questions_to_consider
        )
    }

    val richOrigin = section_origin_context?.let {
        RichOriginContext(
            summary = it.summary,
            eraAndLocation = it.era_and_location,
            historicalCircumstances = it.historical_circumstances,
            motivatingProblem = it.motivating_problem,
            earlierInfluences = it.earlier_influences,
            evolutionAndDevelopment = it.evolution_and_development,
            historicalLegacy = it.historical_legacy
        )
    }

    val richPrinciples = section_core_principles.map {
        CorePrinciple(
            name = it.name,
            explanation = it.explanation,
            whyItMatters = it.why_it_matters,
            reasoning = it.reasoning,
            example = it.example,
            counterCase = it.counter_case,
            commonMisunderstanding = it.common_misunderstanding,
            relationToOtherPrinciples = it.relation_to_other_principles
        )
    }

    val richThinkers = section_key_thinkers.map {
        KeyThinker(
            name = it.name,
            linkId = it.link_id,
            era = it.era,
            role = it.role,
            biographicalContext = it.biographical_context,
            specificContribution = it.specific_contribution,
            majorWorksOrArguments = it.major_works_or_arguments,
            distinctPerspective = it.distinct_perspective,
            quote = it.quote
        )
    }

    val richLife = section_everyday_life?.let {
        RichEverydayLife(
            summary = it.summary,
            scenarios = it.scenarios.map { s ->
                PracticalScenario(
                    title = s.title,
                    context = s.context,
                    applicationSteps = s.application_steps,
                    reflection = s.reflection
                )
            },
            commonMistakes = it.common_mistakes,
            limitations = it.limitations
        )
    }

    val richCritical = section_critical_perspectives?.let {
        CriticalPerspectives(
            proponentArguments = it.proponent_arguments,
            criticArguments = it.critic_arguments,
            limitationsAndObjections = it.limitations_and_objections,
            responseToObjections = it.response_to_objections,
            unresolvedDebates = it.unresolved_debates
        )
    }

    val richConnected = section_connected_ideas.map {
        ConnectedIdea(
            id = it.id,
            title = it.title,
            type = it.type ?: "PHILOSOPHY",
            relationshipType = it.relationship_type,
            explanation = it.explanation
        )
    }

    val depth = reading_depth?.let {
        ReadingDepth(
            quickIntroWordCount = it.quick_intro_word_count,
            deepDiveWordCount = it.deep_dive_word_count,
            readingTimeMinutes = it.reading_time_minutes
        )
    }

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
            keyPeople = domainKeyPeople,
            example = everyday_example ?: "",
            quote = primaryQuote,
            richWhatIsThis = richWhat,
            richOriginContext = richOrigin,
            corePrinciplesRich = richPrinciples,
            keyThinkersRich = richThinkers,
            everydayLifeRich = richLife,
            criticalPerspectives = richCritical,
            connectedIdeasRich = richConnected,
            readingDepth = depth
        ),
        related = related_discoveries.map { it.title },
        contrast = contrastText,
        saved = false
    )
}
