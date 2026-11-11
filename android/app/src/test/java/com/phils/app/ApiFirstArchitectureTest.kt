package com.phils.app

import com.phils.app.data.api.ServerDiscoveryDto
import com.phils.app.data.api.toDomain
import com.phils.app.model.Discovery
import com.phils.app.model.DiscoveryDetail
import com.phils.app.model.KeyPerson
import com.phils.app.ui.components.getWhyReasonFor
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ApiFirstArchitectureTest {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Test
    fun testGetWhyReasonFor_coversAllTypes() {
        val dummyDetail = DiscoveryDetail(
            whatIsThis = "Test",
            origin = "Origin",
            coreIdeas = listOf("Idea 1"),
            example = "Example",
            quote = "Quote"
        )

        val philosophy = Discovery(
            id = "test-phil",
            title = "Test Phil",
            type = "PHILOSOPHY",
            mood = "stone",
            hook = "Hook",
            short = "Short",
            detail = dummyDetail
        )
        assertTrue(getWhyReasonFor(philosophy).contains("philosophical systems"))

        val paradox = philosophy.copy(type = "PARADOX")
        assertTrue(getWhyReasonFor(paradox).contains("paradoxes break rigid assumptions"))

        val thinker = philosophy.copy(type = "PHILOSOPHER")
        assertTrue(getWhyReasonFor(thinker).contains("studying the thinkers"))

        val thoughtExperiment = philosophy.copy(type = "THOUGHT EXPERIMENT")
        assertTrue(getWhyReasonFor(thoughtExperiment).contains("hypothetical scenarios"))

        val bias = philosophy.copy(type = "COGNITIVE BIAS")
        assertTrue(getWhyReasonFor(bias).contains("cognitive traps"))

        val unknown = philosophy.copy(type = "SOMETHING_ELSE")
        assertTrue(getWhyReasonFor(unknown).contains("provocative idea"))
    }

    @Test
    fun testDiscoverySerializationRoundTrip() {
        val listType = Types.newParameterizedType(List::class.java, Discovery::class.java)
        val adapter = moshi.adapter<List<Discovery>>(listType)

        val testList = listOf(
            Discovery(
                id = "stoicism",
                title = "Stoicism",
                type = "PHILOSOPHY",
                mood = "stone",
                hook = "WHAT IF YOU COULD CONTROL YOUR REACTION?",
                short = "Resilience and virtue in daily life.",
                tags = listOf("ethics", "control", "virtue"),
                detail = DiscoveryDetail(
                    whatIsThis = "Ancient Greek and Roman philosophical system.",
                    origin = "300 BCE Athens",
                    coreIdeas = listOf("Dichotomy of control", "Virtue is the highest good"),
                    keyPeople = listOf(KeyPerson(name = "Marcus Aurelius")),
                    example = "Delayed flight response",
                    quote = "You have power over your mind."
                )
            )
        )

        val json = adapter.toJson(testList)
        assertNotNull(json)
        assertTrue(json.contains("stoicism"))

        val restored = adapter.fromJson(json)
        assertNotNull(restored)
        assertEquals(1, restored?.size)
        assertEquals("stoicism", restored?.first()?.id)
        assertEquals("Marcus Aurelius", restored?.first()?.detail?.keyPeople?.first()?.name)
    }

    @Test
    fun testSearchFilteringOnDynamicDeck() {
        val testDeck = listOf(
            Discovery(
                id = "existentialism",
                title = "Existentialism",
                type = "PHILOSOPHY",
                mood = "burgundy",
                hook = "Existence precedes essence",
                short = "Radical freedom and personal responsibility",
                tags = listOf("freedom", "meaning", "anxiety"),
                detail = DiscoveryDetail(
                    whatIsThis = "A movement centering individual experience and agency.",
                    origin = "19th-20th century Europe",
                    coreIdeas = listOf("Freedom", "Authenticity"),
                    example = "Choosing a career path",
                    quote = "Man is condemned to be free."
                )
            ),
            Discovery(
                id = "ship-of-theseus",
                title = "Ship of Theseus",
                type = "PARADOX",
                mood = "ocean",
                hook = "If every plank is replaced, is it the same ship?",
                short = "Identity over time and component replacement",
                tags = listOf("identity", "change", "logic"),
                detail = DiscoveryDetail(
                    whatIsThis = "A thought experiment regarding identity across time.",
                    origin = "Ancient Greece",
                    coreIdeas = listOf("Continuity", "Essential properties"),
                    example = "Replacing every part in a car",
                    quote = "Identity is not purely physical."
                )
            )
        )

        // Query by title
        val titleMatch = testDeck.filter { it.title.lowercase().contains("exist") }
        assertEquals(1, titleMatch.size)
        assertEquals("existentialism", titleMatch.first().id)

        // Query by tag
        val tagMatch = testDeck.filter { it.tags.any { tag -> tag.contains("identity") } }
        assertEquals(1, tagMatch.size)
        assertEquals("ship-of-theseus", tagMatch.first().id)

        // Query by hook
        val hookMatch = testDeck.filter { it.hook.lowercase().contains("plank") }
        assertEquals(1, hookMatch.size)
        assertEquals("ship-of-theseus", hookMatch.first().id)
    }

    @Test
    fun testServerDiscoveryDtoToDomain_handlesNullsAndEmptySectionsGracefully() {
        val dto = com.phils.app.data.api.ServerDiscoveryDto(
            id = "sparse-id",
            title = "Sparse Title"
        )
        val domain = dto.toDomain()
        assertEquals("sparse-id", domain.id)
        assertEquals("Sparse Title", domain.title)
        assertEquals("PHILOSOPHY", domain.type)
        assertEquals("stone", domain.mood)
        assertEquals("Wisdom begins in wonder.", domain.detail.quote)
        assertTrue(domain.detail.corePrinciplesRich.isEmpty())
        assertTrue(domain.detail.keyThinkersRich.isEmpty())
        assertNotNull(domain.detail.richWhatIsThis)
        assertNotNull(domain.detail.richOriginContext)
        assertNotNull(domain.detail.everydayLifeRich)
        assertNotNull(domain.detail.criticalPerspectives)
        assertNotNull(domain.detail.readingDepth)
        assertTrue(domain.detail.richWhatIsThis?.centralQuestion?.isNotEmpty() == true)
    }

    @Test
    fun testPartialJsonDeserialization_withDefaults() {
        val adapter = moshi.adapter(Discovery::class.java)
        // Missing almost all fields, should not throw JsonDataException
        val minimalJson = """{"id":"min-1","title":"Minimal"}"""
        val parsed = adapter.fromJson(minimalJson)
        assertNotNull(parsed)
        assertEquals("min-1", parsed?.id)
        assertEquals("Minimal", parsed?.title)
        assertEquals("stone", parsed?.mood)
        assertEquals("PHILOSOPHY", parsed?.type)
    }

    @Test
    fun testDeckRandomization_shufflesItemsUniformly() {
        val items = (1..30).map { i ->
            Discovery(
                id = "idea-$i",
                title = "Idea $i",
                type = "PHILOSOPHY",
                mood = "stone",
                hook = "Hook $i",
                short = "Short $i",
                detail = DiscoveryDetail(whatIsThis = "Test $i")
            )
        }
        val shuffled1 = items.shuffled()
        val shuffled2 = items.shuffled()
        // With 30 items, the chance of two independent shuffles matching the original exactly is 1 / 30! (~3.7e-33)
        assertEquals(items.size, shuffled1.size)
        assertEquals(items.toSet(), shuffled1.toSet())
        assertTrue(items != shuffled1 || items != shuffled2)
    }
}
