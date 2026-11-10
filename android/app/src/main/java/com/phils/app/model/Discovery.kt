package com.phils.app.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class KeyPerson(
    val name: String,
    val linkId: String? = null,
    val role: String? = null,
    val era: String? = null,
    val quote: String? = null
)

@JsonClass(generateAdapter = true)
data class CorePrinciple(
    val name: String,
    val explanation: String,
    val whyItMatters: String,
    val reasoning: String? = null,
    val example: String? = null,
    val counterCase: String? = null,
    val commonMisunderstanding: String? = null,
    val relationToOtherPrinciples: String? = null
)

@JsonClass(generateAdapter = true)
data class KeyThinker(
    val name: String,
    val linkId: String? = null,
    val era: String? = null,
    val role: String? = null,
    val biographicalContext: String? = null,
    val specificContribution: String? = null,
    val majorWorksOrArguments: String? = null,
    val distinctPerspective: String? = null,
    val quote: String? = null
)

@JsonClass(generateAdapter = true)
data class PracticalScenario(
    val title: String,
    val context: String,
    val applicationSteps: List<String> = emptyList(),
    val reflection: String? = null
)

@JsonClass(generateAdapter = true)
data class CriticalPerspectives(
    val proponentArguments: String? = null,
    val criticArguments: String? = null,
    val limitationsAndObjections: List<String> = emptyList(),
    val responseToObjections: String? = null,
    val unresolvedDebates: String? = null
)

@JsonClass(generateAdapter = true)
data class ConnectedIdea(
    val id: String,
    val title: String,
    val type: String = "PHILOSOPHY",
    val relationshipType: String? = null,
    val explanation: String
)

@JsonClass(generateAdapter = true)
data class RichWhatIsThis(
    val summary: String,
    val centralQuestion: String? = null,
    val mainArgument: String? = null,
    val howItWorks: String? = null,
    val introductoryExample: String? = null,
    val importance: String? = null,
    val misconceptions: List<String> = emptyList(),
    val questionsToConsider: List<String> = emptyList()
)

@JsonClass(generateAdapter = true)
data class RichOriginContext(
    val summary: String,
    val eraAndLocation: String? = null,
    val historicalCircumstances: String? = null,
    val motivatingProblem: String? = null,
    val earlierInfluences: List<String> = emptyList(),
    val evolutionAndDevelopment: String? = null,
    val historicalLegacy: String? = null
)

@JsonClass(generateAdapter = true)
data class RichEverydayLife(
    val summary: String,
    val scenarios: List<PracticalScenario> = emptyList(),
    val commonMistakes: List<String> = emptyList(),
    val limitations: String? = null
)

@JsonClass(generateAdapter = true)
data class ReadingDepth(
    val quickIntroWordCount: Int? = null,
    val deepDiveWordCount: Int? = null,
    val readingTimeMinutes: Int? = null
)

@JsonClass(generateAdapter = true)
data class DiscoveryDetail(
    val whatIsThis: String,
    val origin: String,
    val coreIdeas: List<String>,
    val keyPeople: List<KeyPerson> = emptyList(),
    val example: String,
    val quote: String,

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
    val id: String,
    val title: String,
    val type: String, // "PHILOSOPHY", "PHILOSOPHER", "CONCEPT", "PARADOX", "THOUGHT EXPERIMENT", "SCIENTIFIC IDEA"
    val mood: String, // "stone", "ocean", "burgundy", "cosmic", "sage", "rose", "ochre", "lavender", "terracotta", "indigo"
    val hook: String,
    val short: String,
    val tags: List<String> = emptyList(),
    val detail: DiscoveryDetail,
    val related: List<String> = emptyList(),
    val contrast: String? = null,
    val saved: Boolean = false
)
