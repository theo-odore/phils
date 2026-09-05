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
data class DiscoveryDetail(
    val whatIsThis: String,
    val origin: String,
    val coreIdeas: List<String>,
    val keyPeople: List<KeyPerson> = emptyList(),
    val example: String,
    val quote: String
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
