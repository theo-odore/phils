package com.phils.app.data.api

import com.phils.app.model.Discovery
import com.phils.app.model.DiscoveryDetail
import com.phils.app.model.KeyPerson
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
    val why_reason: String? = null
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
            quote = primaryQuote
        ),
        related = related_discoveries.map { it.title },
        contrast = contrastText,
        saved = false
    )
}
