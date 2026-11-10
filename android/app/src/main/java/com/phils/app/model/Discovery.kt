package com.phils.app.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class KeyPerson(
    val name: String = "",
    @Json(name = "link_id") val linkId: String? = null,
    val role: String? = null,
    val era: String? = null,
    val quote: String? = null
)

@JsonClass(generateAdapter = true)
data class CorePrinciple(
    val name: String = "",
    val explanation: String = "",
    @Json(name = "why_it_matters") val whyItMatters: String = "",
    val reasoning: String? = null,
    val example: String? = null,
    @Json(name = "counter_case") val counterCase: String? = null,
    @Json(name = "common_misunderstanding") val commonMisunderstanding: String? = null,
    @Json(name = "relation_to_other_principles") val relationToOtherPrinciples: String? = null
)

@JsonClass(generateAdapter = true)
data class KeyThinker(
    val name: String = "",
    @Json(name = "link_id") val linkId: String? = null,
    val era: String? = null,
    val role: String? = null,
    @Json(name = "biographical_context") val biographicalContext: String? = null,
    @Json(name = "specific_contribution") val specificContribution: String? = null,
    @Json(name = "major_works_or_arguments") val majorWorksOrArguments: String? = null,
    @Json(name = "distinct_perspective") val distinctPerspective: String? = null,
    val quote: String? = null
)

@JsonClass(generateAdapter = true)
data class PracticalScenario(
    val title: String = "",
    val context: String = "",
    @Json(name = "application_steps") val applicationSteps: List<String> = emptyList(),
    val reflection: String? = null
)

@JsonClass(generateAdapter = true)
data class CriticalPerspectives(
    @Json(name = "proponent_arguments") val proponentArguments: String? = null,
    @Json(name = "critic_arguments") val criticArguments: String? = null,
    @Json(name = "limitations_and_objections") val limitationsAndObjections: List<String> = emptyList(),
    @Json(name = "response_to_objections") val responseToObjections: String? = null,
    @Json(name = "unresolved_debates") val unresolvedDebates: String? = null
)

@JsonClass(generateAdapter = true)
data class ConnectedIdea(
    val id: String = "",
    val title: String = "",
    val type: String = "PHILOSOPHY",
    @Json(name = "relationship_type") val relationshipType: String? = null,
    val explanation: String = ""
)

@JsonClass(generateAdapter = true)
data class RichWhatIsThis(
    val summary: String = "",
    @Json(name = "central_question") val centralQuestion: String? = null,
    @Json(name = "main_argument") val mainArgument: String? = null,
    @Json(name = "how_it_works") val howItWorks: String? = null,
    @Json(name = "introductory_example") val introductoryExample: String? = null,
    val importance: String? = null,
    val misconceptions: List<String> = emptyList(),
    @Json(name = "questions_to_consider") val questionsToConsider: List<String> = emptyList()
)

@JsonClass(generateAdapter = true)
data class RichOriginContext(
    val summary: String = "",
    @Json(name = "era_and_location") val eraAndLocation: String? = null,
    @Json(name = "historical_circumstances") val historicalCircumstances: String? = null,
    @Json(name = "motivating_problem") val motivatingProblem: String? = null,
    @Json(name = "earlier_influences") val earlierInfluences: List<String> = emptyList(),
    @Json(name = "evolution_and_development") val evolutionAndDevelopment: String? = null,
    @Json(name = "historical_legacy") val historicalLegacy: String? = null
)

@JsonClass(generateAdapter = true)
data class RichEverydayLife(
    val summary: String = "",
    val scenarios: List<PracticalScenario> = emptyList(),
    @Json(name = "common_mistakes") val commonMistakes: List<String> = emptyList(),
    val limitations: String? = null
)

@JsonClass(generateAdapter = true)
data class ReadingDepth(
    @Json(name = "quick_intro_word_count") val quickIntroWordCount: Int? = null,
    @Json(name = "deep_dive_word_count") val deepDiveWordCount: Int? = null,
    @Json(name = "reading_time_minutes") val readingTimeMinutes: Int? = null
)

@JsonClass(generateAdapter = true)
data class DiscoveryDetail(
    val whatIsThis: String = "",
    val origin: String = "",
    val coreIdeas: List<String> = emptyList(),
    val keyPeople: List<KeyPerson> = emptyList(),
    val example: String = "",
    val quote: String = "",

    // Progressive deep-dive content
    val richWhatIsThis: RichWhatIsThis? = null,
    val richOriginContext: RichOriginContext? = null,
    val corePrinciplesRich: List<CorePrinciple> = emptyList(),
    val keyThinkersRich: List<KeyThinker> = emptyList(),
    val everydayLifeRich: RichEverydayLife? = null,
    val criticalPerspectives: CriticalPerspectives? = null,
    val connectedIdeasRich: List<ConnectedIdea> = emptyList(),
    val readingDepth: ReadingDepth? = null
)

@JsonClass(generateAdapter = true)
data class Discovery(
    val id: String = "",
    val title: String = "",
    val type: String = "PHILOSOPHY", // "PHILOSOPHY", "PHILOSOPHER", "CONCEPT", "PARADOX", "THOUGHT EXPERIMENT", "SCIENTIFIC IDEA"
    val mood: String = "stone", // "stone", "ocean", "burgundy", "cosmic", "sage", "rose", "ochre", "lavender", "terracotta", "indigo"
    val hook: String = "",
    val short: String = "",
    val tags: List<String> = emptyList(),
    val detail: DiscoveryDetail = DiscoveryDetail(),
    val related: List<String> = emptyList(),
    val contrast: String? = null,
    val saved: Boolean = false
)
