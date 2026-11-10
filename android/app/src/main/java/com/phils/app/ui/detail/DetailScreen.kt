package com.phils.app.ui.detail

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phils.app.data.api.NetworkClient
import com.phils.app.model.ConnectedIdea
import com.phils.app.model.CorePrinciple
import com.phils.app.model.CriticalPerspectives
import com.phils.app.model.Discovery
import com.phils.app.model.KeyThinker
import com.phils.app.model.PracticalScenario
import com.phils.app.model.RichEverydayLife
import com.phils.app.model.RichOriginContext
import com.phils.app.model.RichWhatIsThis
import com.phils.app.theme.PhilsTheme
import com.phils.app.theme.getMoodTone
import com.phils.app.ui.components.CatalogCorner
import com.phils.app.ui.components.MiniCard
import com.phils.app.ui.components.TypeEyebrow

enum class ReadingDepthMode {
    QUICK_READ,
    DEEP_DIVE
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailScreen(
    discovery: Discovery,
    onBack: () -> Unit,
    onOpenDiscovery: (String) -> Unit,
    onToggleSave: (Discovery) -> Unit,
    isSaved: Boolean,
    onLookupDiscovery: (String) -> Discovery? = { null },
    modifier: Modifier = Modifier
) {
    val theme = PhilsTheme.colors
    val context = LocalContext.current
    val moodTone = getMoodTone(discovery.mood, theme.isDark)
    val scrollState = rememberScrollState()

    val detail = discovery.detail
    val hasRichContent = detail.richWhatIsThis != null || detail.corePrinciplesRich.isNotEmpty()

    var depthMode by rememberSaveable { mutableStateOf(ReadingDepthMode.DEEP_DIVE) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(theme.bg)
    ) {
        // ----------------------------------------------------
        // Top App Bar
        // ----------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(top = 8.dp, start = 12.dp, end = 12.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = theme.textPrimary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    val shareUrl = NetworkClient.getShareUrl(discovery.id)
                    val shareText = "\"${discovery.hook}\"\n\nRead \"${discovery.title}\" on Phils:\n$shareUrl"
                    val sendIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_SUBJECT, discovery.title)
                        putExtra(Intent.EXTRA_TEXT, shareText)
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(sendIntent, "Share ${discovery.title}"))
                }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = theme.textPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                IconButton(onClick = { onToggleSave(discovery) }) {
                    Icon(
                        imageVector = if (isSaved) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = "Save",
                        tint = if (isSaved) moodTone.accent else theme.textFaint,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        // ----------------------------------------------------
        // Scrollable Article Body
        // ----------------------------------------------------
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .verticalScroll(scrollState)
                .padding(horizontal = 22.dp, vertical = 8.dp)
        ) {
            // Header Card Box (Level 1: Discovery Identity)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(moodTone.bg)
                    .border(
                        1.dp,
                        if (!theme.isDark) Color(0x12000000) else Color(0x24FFFFFF),
                        RoundedCornerShape(20.dp)
                    )
                    .padding(24.dp)
            ) {
                CatalogCorner(modifier = Modifier.align(Alignment.TopEnd))

                Column {
                    TypeEyebrow(
                        text = discovery.type,
                        color = moodTone.accent
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = discovery.hook,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        lineHeight = 29.sp,
                        color = theme.textPrimary
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = discovery.title,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = moodTone.accent
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = discovery.short,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.5.sp,
                        lineHeight = 21.sp,
                        color = theme.textSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // ----------------------------------------------------
            // Progressive Reading Depth Selector
            // ----------------------------------------------------
            if (hasRichContent) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(theme.surface)
                        .border(1.dp, theme.line, RoundedCornerShape(12.dp))
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DepthTabButton(
                        title = "Quick Overview",
                        subtitle = "~2 min read",
                        icon = Icons.Filled.Lightbulb,
                        selected = depthMode == ReadingDepthMode.QUICK_READ,
                        accentColor = moodTone.accent,
                        onClick = { depthMode = ReadingDepthMode.QUICK_READ },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    DepthTabButton(
                        title = "Deep Dive",
                        subtitle = detail.readingDepth?.readingTimeMinutes?.let { "~$it min read" } ?: "~6 min read",
                        icon = Icons.AutoMirrored.Filled.MenuBook,
                        selected = depthMode == ReadingDepthMode.DEEP_DIVE,
                        accentColor = moodTone.accent,
                        onClick = { depthMode = ReadingDepthMode.DEEP_DIVE },
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // ----------------------------------------------------
            // Glowing Quote Box
            // ----------------------------------------------------
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(theme.surface)
                    .border(1.5.dp, moodTone.accent.copy(alpha = 0.35f), RoundedCornerShape(16.dp))
                    .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    Icon(
                        imageVector = Icons.Filled.FormatQuote,
                        contentDescription = "Quote",
                        tint = moodTone.accent,
                        modifier = Modifier
                            .size(28.dp)
                            .padding(end = 6.dp)
                    )
                    Text(
                        text = "\"${detail.quote}\"",
                        fontFamily = FontFamily.Serif,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        lineHeight = 25.sp,
                        color = theme.textPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))

            // ====================================================
            // LEVEL 2: QUICK OVERVIEW MODE
            // ====================================================
            if (hasRichContent && depthMode == ReadingDepthMode.QUICK_READ) {
                QuickOverviewContent(
                    discovery = discovery,
                    moodToneAccent = moodTone.accent,
                    moodToneSoft = moodTone.soft,
                    onOpenDiscovery = onOpenDiscovery,
                    onLookupDiscovery = onLookupDiscovery,
                    onSwitchToDeepDive = { depthMode = ReadingDepthMode.DEEP_DIVE }
                )
            } else {
                // ====================================================
                // LEVEL 3 & 4: DEEP DIVE COMPLETE ARTICLE
                // ====================================================
                DeepDiveContent(
                    discovery = discovery,
                    moodToneAccent = moodTone.accent,
                    moodToneSoft = moodTone.soft,
                    onOpenDiscovery = onOpenDiscovery,
                    onLookupDiscovery = onLookupDiscovery
                )
            }

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

// -----------------------------------------------------------------------------
// Quick Overview Presentation Component (Classic Canonical Layout)
// -----------------------------------------------------------------------------
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun QuickOverviewContent(
    discovery: Discovery,
    moodToneAccent: Color,
    moodToneSoft: Color,
    onOpenDiscovery: (String) -> Unit,
    onLookupDiscovery: (String) -> Discovery?,
    onSwitchToDeepDive: () -> Unit
) {
    val theme = PhilsTheme.colors
    val detail = discovery.detail

    // What is this?
    SectionTitle(title = "What is this?")
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = detail.whatIsThis.ifBlank { detail.richWhatIsThis?.summary ?: "" },
        fontFamily = FontFamily.SansSerif,
        fontSize = 15.sp,
        lineHeight = 23.sp,
        color = theme.textSecondary
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Origin context
    val originText = detail.origin.ifBlank { detail.richOriginContext?.summary ?: "" }
    if (originText.isNotBlank()) {
        SectionTitle(title = "Origin context")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = originText,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
        Spacer(modifier = Modifier.height(24.dp))
    }

    // Core principles
    val coreIdeas = if (detail.coreIdeas.isNotEmpty()) {
        detail.coreIdeas
    } else {
        detail.corePrinciplesRich.map { "${it.name}: ${it.explanation}" }
    }
    if (coreIdeas.isNotEmpty()) {
        SectionTitle(title = "Core principles")
        Spacer(modifier = Modifier.height(10.dp))
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            coreIdeas.forEach { idea ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(moodToneAccent)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = idea,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.5.sp,
                        lineHeight = 22.sp,
                        color = theme.textSecondary
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }

    // Key thinkers
    val thinkers = if (detail.keyPeople.isNotEmpty()) {
        detail.keyPeople.map { it.name to it.linkId }
    } else {
        detail.keyThinkersRich.map { it.name to it.linkId }
    }
    if (thinkers.isNotEmpty()) {
        SectionTitle(title = "Key thinkers")
        Spacer(modifier = Modifier.height(10.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            thinkers.forEach { (name, linkId) ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(999.dp))
                        .background(if (linkId != null) moodToneSoft else theme.surface)
                        .border(1.dp, theme.line, RoundedCornerShape(999.dp))
                        .clickable(enabled = linkId != null) {
                            linkId?.let { onOpenDiscovery(it) }
                        }
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = name + if (linkId != null) " →" else "",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = if (linkId != null) FontWeight.SemiBold else FontWeight.Normal,
                        fontSize = 13.sp,
                        color = theme.textPrimary,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }

    // In everyday life
    val exampleText = detail.example.ifBlank { detail.everydayLifeRich?.summary ?: "" }
    if (exampleText.isNotBlank()) {
        SectionTitle(title = "In everyday life")
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = exampleText,
            fontFamily = FontFamily.SansSerif,
            fontSize = 15.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
        Spacer(modifier = Modifier.height(24.dp))
    }

    // Connected ideas
    if (discovery.related.isNotEmpty()) {
        val relatedItems = discovery.related.mapNotNull { onLookupDiscovery(it) }
        if (relatedItems.isNotEmpty()) {
            SectionTitle(title = "Connected ideas")
            Spacer(modifier = Modifier.height(12.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                relatedItems.forEach { rel ->
                    MiniCard(
                        discovery = rel,
                        onOpen = onOpenDiscovery,
                        showSave = false
                    )
                }
            }
            Spacer(modifier = Modifier.height(28.dp))
        }
    }

    // Deep Dive Prompt CTA Button
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(moodToneSoft)
            .border(1.dp, moodToneAccent.copy(alpha = 0.5f), RoundedCornerShape(16.dp))
            .clickable { onSwitchToDeepDive() }
            .padding(18.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Continue to Full Deep Dive",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = theme.textPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Explore complete principles, criticisms, thinkers, and historical genesis.",
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.5.sp,
                color = theme.textSecondary
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Expand",
            tint = moodToneAccent,
            modifier = Modifier.size(20.dp)
        )
    }
}

// -----------------------------------------------------------------------------
// Deep Dive Full Article Content Component
// -----------------------------------------------------------------------------
@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun DeepDiveContent(
    discovery: Discovery,
    moodToneAccent: Color,
    moodToneSoft: Color,
    onOpenDiscovery: (String) -> Unit,
    onLookupDiscovery: (String) -> Discovery?
) {
    val theme = PhilsTheme.colors
    val detail = discovery.detail

    val richWhat = detail.richWhatIsThis
    val richOrigin = detail.richOriginContext
    val richPrinciples = detail.corePrinciplesRich
    val richThinkers = detail.keyThinkersRich
    val richLife = detail.everydayLifeRich
    val richCritical = detail.criticalPerspectives
    val richConnected = detail.connectedIdeasRich

    // ====================================================
    // SECTION 1: WHAT IS THIS?
    // ====================================================
    SectionHeaderWithEyebrow(
        number = "01",
        title = "What is ${discovery.title}?",
        accentColor = moodToneAccent
    )

    richWhat?.centralQuestion?.let { question ->
        Spacer(modifier = Modifier.height(10.dp))
        CalloutBox(
            title = "Central Question",
            text = question,
            accentColor = moodToneAccent,
            backgroundColor = moodToneSoft.copy(alpha = 0.35f)
        )
    }

    Spacer(modifier = Modifier.height(14.dp))
    Text(
        text = richWhat?.summary ?: detail.whatIsThis,
        fontFamily = FontFamily.SansSerif,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        color = theme.textSecondary
    )

    richWhat?.howItWorks?.let { how ->
        Spacer(modifier = Modifier.height(14.dp))
        SubsectionTitle(title = "How It Works")
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = how,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.5.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
    }

    richWhat?.introductoryExample?.let { eg ->
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(theme.surface)
                .border(1.dp, theme.line, RoundedCornerShape(14.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "INTRODUCTORY EXAMPLE",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = moodToneAccent,
                    letterSpacing = 1.2.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = eg,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                    color = theme.textPrimary
                )
            }
        }
    }

    richWhat?.importance?.let { imp ->
        Spacer(modifier = Modifier.height(14.dp))
        SubsectionTitle(title = "Why This Idea Matters")
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = imp,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.5.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
    }

    if (!richWhat?.misconceptions.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(theme.surface)
                .border(1.dp, theme.line, RoundedCornerShape(14.dp))
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.WarningAmber,
                        contentDescription = "Misconceptions",
                        tint = moodToneAccent,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "COMMON MISCONCEPTIONS",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = moodToneAccent,
                        letterSpacing = 1.2.sp
                    )
                }

                richWhat?.misconceptions?.forEach { misc ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "✕",
                            color = moodToneAccent,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 2.dp, end = 8.dp)
                        )
                        Text(
                            text = misc,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 13.5.sp,
                            lineHeight = 20.sp,
                            color = theme.textSecondary
                        )
                    }
                }
            }
        }
    }

    if (!richWhat?.questionsToConsider.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(moodToneSoft.copy(alpha = 0.25f))
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.HelpOutline,
                        contentDescription = "Questions",
                        tint = moodToneAccent,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "QUESTIONS TO CONSIDER",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = moodToneAccent,
                        letterSpacing = 1.2.sp
                    )
                }

                richWhat?.questionsToConsider?.forEach { q ->
                    Text(
                        text = "•  $q",
                        fontFamily = FontFamily.Serif,
                        fontStyle = FontStyle.Italic,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = theme.textPrimary
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(36.dp))

    // ====================================================
    // SECTION 2: ORIGIN AND CONTEXT
    // ====================================================
    SectionHeaderWithEyebrow(
        number = "02",
        title = "Origin & Historical Context",
        accentColor = moodToneAccent
    )

    richOrigin?.eraAndLocation?.let { era ->
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(999.dp))
                .background(theme.surface)
                .border(1.dp, theme.line, RoundedCornerShape(999.dp))
                .padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            Text(
                text = "📍 $era",
                fontFamily = FontFamily.Monospace,
                fontSize = 11.5.sp,
                color = theme.textPrimary
            )
        }
    }

    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = richOrigin?.summary ?: detail.origin,
        fontFamily = FontFamily.SansSerif,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        color = theme.textSecondary
    )

    richOrigin?.historicalCircumstances?.let { circum ->
        Spacer(modifier = Modifier.height(14.dp))
        SubsectionTitle(title = "Historical Circumstances")
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = circum,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.5.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
    }

    richOrigin?.motivatingProblem?.let { prob ->
        Spacer(modifier = Modifier.height(14.dp))
        CalloutBox(
            title = "The Motivating Crisis",
            text = prob,
            accentColor = moodToneAccent,
            backgroundColor = theme.surface
        )
    }

    if (!richOrigin?.earlierInfluences.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(16.dp))
        SubsectionTitle(title = "Earlier Influences & Traditions")
        Spacer(modifier = Modifier.height(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            richOrigin?.earlierInfluences?.forEach { inf ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(moodToneAccent)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = inf,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = theme.textSecondary
                    )
                }
            }
        }
    }

    richOrigin?.evolutionAndDevelopment?.let { evol ->
        Spacer(modifier = Modifier.height(14.dp))
        SubsectionTitle(title = "Evolution Over Time")
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = evol,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.5.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
    }

    richOrigin?.historicalLegacy?.let { leg ->
        Spacer(modifier = Modifier.height(14.dp))
        SubsectionTitle(title = "Legacy & Influence Today")
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = leg,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.5.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
    }

    Spacer(modifier = Modifier.height(36.dp))

    // ====================================================
    // SECTION 3: CORE PRINCIPLES
    // ====================================================
    SectionHeaderWithEyebrow(
        number = "03",
        title = "Core Principles",
        accentColor = moodToneAccent
    )
    Spacer(modifier = Modifier.height(12.dp))

    if (richPrinciples.isNotEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            richPrinciples.forEachIndexed { idx, principle ->
                CorePrincipleCard(
                    number = String.format("%02d", idx + 1),
                    principle = principle,
                    accentColor = moodToneAccent,
                    backgroundColor = theme.surface,
                    lineColor = theme.line
                )
            }
        }
    } else {
        // Fallback for simple discoveries
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            detail.coreIdeas.forEach { idea ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(moodToneAccent)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = idea,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 14.5.sp,
                        lineHeight = 22.sp,
                        color = theme.textSecondary
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(36.dp))

    // ====================================================
    // SECTION 4: CRITICAL THINKING & COUNTERARGUMENTS
    // ====================================================
    if (richCritical != null) {
        SectionHeaderWithEyebrow(
            number = "04",
            title = "Critical Perspectives & Debates",
            accentColor = moodToneAccent
        )
        Spacer(modifier = Modifier.height(14.dp))

        // Proponents vs Critics comparative box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(theme.surface)
                .border(1.dp, theme.line, RoundedCornerShape(16.dp))
                .padding(18.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                richCritical.proponentArguments?.let { prop ->
                    Column {
                        Text(
                            text = "WHAT PROPONENTS ARGUE",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = moodToneAccent,
                            letterSpacing = 1.2.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = prop,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 14.sp,
                            lineHeight = 22.sp,
                            color = theme.textPrimary
                        )
                    }
                }

                HorizontalDivider(color = theme.line)

                richCritical.criticArguments?.let { crit ->
                    Column {
                        Text(
                            text = "WHAT CRITICS ARGUE",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = theme.textSecondary,
                            letterSpacing = 1.2.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = crit,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 14.sp,
                            lineHeight = 22.sp,
                            color = theme.textSecondary
                        )
                    }
                }
            }
        }

        if (richCritical.limitationsAndObjections.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            SubsectionTitle(title = "Important Objections & Vulnerabilities")
            Spacer(modifier = Modifier.height(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                richCritical.limitationsAndObjections.forEach { obj ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "—",
                            color = moodToneAccent,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = obj,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 14.sp,
                            lineHeight = 21.sp,
                            color = theme.textSecondary
                        )
                    }
                }
            }
        }

        richCritical.responseToObjections?.let { resp ->
            Spacer(modifier = Modifier.height(14.dp))
            SubsectionTitle(title = "How Proponents Respond")
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = resp,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.5.sp,
                lineHeight = 23.sp,
                color = theme.textSecondary
            )
        }

        richCritical.unresolvedDebates?.let { unres ->
            Spacer(modifier = Modifier.height(14.dp))
            SubsectionTitle(title = "What Remains Unresolved")
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = unres,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontSize = 14.5.sp,
                lineHeight = 23.sp,
                color = theme.textSecondary
            )
        }

        Spacer(modifier = Modifier.height(36.dp))
    }

    // ====================================================
    // SECTION 5: KEY THINKERS
    // ====================================================
    SectionHeaderWithEyebrow(
        number = if (richCritical != null) "05" else "04",
        title = "Key Thinkers",
        accentColor = moodToneAccent
    )
    Spacer(modifier = Modifier.height(14.dp))

    if (richThinkers.isNotEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            richThinkers.forEach { thinker ->
                KeyThinkerCard(
                    thinker = thinker,
                    accentColor = moodToneAccent,
                    backgroundColor = theme.surface,
                    onOpen = onOpenDiscovery
                )
            }
        }
    } else {
        // Fallback for simple thinker chips
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            detail.keyPeople.forEach { person ->
                val linkId = person.linkId
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(999.dp))
                        .background(if (linkId != null) moodToneSoft else theme.surface)
                        .border(1.dp, theme.line, RoundedCornerShape(999.dp))
                        .clickable(enabled = linkId != null) {
                            linkId?.let { onOpenDiscovery(it) }
                        }
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = person.name + if (linkId != null) " →" else "",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = if (linkId != null) FontWeight.SemiBold else FontWeight.Normal,
                        fontSize = 13.sp,
                        color = theme.textPrimary,
                        maxLines = 1,
                        softWrap = false
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(36.dp))

    // ====================================================
    // SECTION 6: IN EVERYDAY LIFE
    // ====================================================
    SectionHeaderWithEyebrow(
        number = if (richCritical != null) "06" else "05",
        title = "In Everyday Life",
        accentColor = moodToneAccent
    )
    Spacer(modifier = Modifier.height(10.dp))

    Text(
        text = richLife?.summary ?: detail.example,
        fontFamily = FontFamily.SansSerif,
        fontSize = 15.sp,
        lineHeight = 23.sp,
        color = theme.textSecondary
    )

    if (!richLife?.scenarios.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(18.dp))
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            richLife?.scenarios?.forEach { scenario ->
                PracticalScenarioCard(
                    scenario = scenario,
                    accentColor = moodToneAccent,
                    backgroundColor = theme.surface
                )
            }
        }
    }

    if (!richLife?.commonMistakes.isNullOrEmpty()) {
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(theme.surface)
                .border(1.dp, theme.line, RoundedCornerShape(14.dp))
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "COMMON MISAPPLICATIONS",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = moodToneAccent,
                    letterSpacing = 1.2.sp
                )
                richLife?.commonMistakes?.forEach { mis ->
                    Text(
                        text = "• $mis",
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 13.5.sp,
                        lineHeight = 20.sp,
                        color = theme.textSecondary
                    )
                }
            }
        }
    }

    richLife?.limitations?.let { lim ->
        Spacer(modifier = Modifier.height(14.dp))
        SubsectionTitle(title = "Crucial Limitations")
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = lim,
            fontFamily = FontFamily.SansSerif,
            fontSize = 14.5.sp,
            lineHeight = 23.sp,
            color = theme.textSecondary
        )
    }

    Spacer(modifier = Modifier.height(36.dp))

    // ====================================================
    // SECTION 7: CONNECTED IDEAS
    // ====================================================
    SectionHeaderWithEyebrow(
        number = if (richCritical != null) "07" else "06",
        title = "Connected Ideas",
        accentColor = moodToneAccent
    )
    Spacer(modifier = Modifier.height(14.dp))

    if (richConnected.isNotEmpty()) {
        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            richConnected.forEach { item ->
                ConnectedIdeaCard(
                    item = item,
                    accentColor = moodToneAccent,
                    backgroundColor = theme.surface,
                    onOpen = onOpenDiscovery
                )
            }
        }
    } else if (discovery.related.isNotEmpty()) {
        // Fallback for simple related mini cards
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            discovery.related.mapNotNull { onLookupDiscovery(it) }.forEach { rel ->
                MiniCard(
                    discovery = rel,
                    onOpen = onOpenDiscovery,
                    showSave = false
                )
            }
        }
    }
}

// -----------------------------------------------------------------------------
// Core Component Widgets
// -----------------------------------------------------------------------------

@Composable
private fun SectionHeaderWithEyebrow(
    number: String,
    title: String,
    accentColor: Color
) {
    val theme = PhilsTheme.colors
    Column {
        Text(
            text = "SECTION $number",
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp,
            color = accentColor,
            letterSpacing = 1.8.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            color = theme.textPrimary
        )
    }
}

@Composable
private fun SectionTitle(title: String) {
    val theme = PhilsTheme.colors
    Text(
        text = title,
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.sp,
        color = theme.textPrimary
    )
}

@Composable
private fun SubsectionTitle(title: String) {
    val theme = PhilsTheme.colors
    Text(
        text = title,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = theme.textPrimary
    )
}

@Composable
private fun CalloutBox(
    title: String,
    text: String,
    accentColor: Color,
    backgroundColor: Color
) {
    val theme = PhilsTheme.colors
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(backgroundColor)
            .border(1.dp, accentColor.copy(alpha = 0.4f), RoundedCornerShape(14.dp))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = title.uppercase(),
                fontFamily = FontFamily.Monospace,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = accentColor,
                letterSpacing = 1.2.sp
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = text,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = theme.textPrimary
            )
        }
    }
}

@Composable
private fun DepthTabButton(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    selected: Boolean,
    accentColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val theme = PhilsTheme.colors
    val bg = if (selected) accentColor.copy(alpha = 0.16f) else Color.Transparent
    val borderCol = if (selected) accentColor.copy(alpha = 0.5f) else Color.Transparent

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(bg)
            .border(1.dp, borderCol, RoundedCornerShape(10.dp))
            .clickable { onClick() }
            .padding(vertical = 10.dp, horizontal = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = if (selected) accentColor else theme.textFaint,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = title,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                    fontSize = 13.sp,
                    color = if (selected) theme.textPrimary else theme.textSecondary
                )
                Text(
                    text = subtitle,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.5.sp,
                    color = if (selected) accentColor else theme.textFaint
                )
            }
        }
    }
}

@Composable
private fun CorePrincipleCard(
    number: String,
    principle: CorePrinciple,
    accentColor: Color,
    backgroundColor: Color,
    lineColor: Color
) {
    val theme = PhilsTheme.colors
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .border(1.dp, lineColor, RoundedCornerShape(16.dp))
            .clickable { expanded = !expanded }
            .padding(18.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(accentColor.copy(alpha = 0.16f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = number,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.5.sp,
                            color = accentColor
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = principle.name,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.5.sp,
                        color = theme.textPrimary
                    )
                }

                Text(
                    text = if (expanded) "▲" else "▼",
                    color = theme.textFaint,
                    fontSize = 12.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = principle.explanation,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.5.sp,
                lineHeight = 22.sp,
                color = theme.textSecondary
            )

            principle.reasoning?.let { reason ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Reasoning: $reason",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 13.5.sp,
                    lineHeight = 20.sp,
                    color = theme.textSecondary
                )
            }

            // Expandable deep content
            AnimatedVisibility(visible = expanded) {
                Column(
                    modifier = Modifier.padding(top = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    principle.example?.let { eg ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(accentColor.copy(alpha = 0.08f))
                                .padding(12.dp)
                        ) {
                            Column {
                                Text(
                                    text = "CONCRETE EXAMPLE",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 10.5.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = accentColor
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = eg,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = 13.sp,
                                    lineHeight = 19.sp,
                                    color = theme.textPrimary
                                )
                            }
                        }
                    }

                    principle.counterCase?.let { cc ->
                        Text(
                            text = "Counter-case / Edge case: $cc",
                            fontFamily = FontFamily.SansSerif,
                            fontStyle = FontStyle.Italic,
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = theme.textSecondary
                        )
                    }

                    principle.commonMisunderstanding?.let { cm ->
                        Text(
                            text = "Common Misunderstanding: $cm",
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 13.sp,
                            lineHeight = 19.sp,
                            color = theme.textFaint
                        )
                    }

                    principle.relationToOtherPrinciples?.let { rel ->
                        Text(
                            text = "Connection: $rel",
                            fontFamily = FontFamily.Monospace,
                            fontSize = 11.5.sp,
                            color = accentColor
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun KeyThinkerCard(
    thinker: KeyThinker,
    accentColor: Color,
    backgroundColor: Color,
    onOpen: (String) -> Unit
) {
    val theme = PhilsTheme.colors
    val hasLink = !thinker.linkId.isNullOrBlank()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .border(1.dp, theme.line, RoundedCornerShape(16.dp))
            .padding(18.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = thinker.name,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = theme.textPrimary
                    )
                    thinker.role?.let { r ->
                        Text(
                            text = r,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 12.5.sp,
                            color = theme.textSecondary
                        )
                    }
                }

                thinker.era?.let { era ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(999.dp))
                            .background(accentColor.copy(alpha = 0.12f))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = era,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 10.5.sp,
                            color = accentColor
                        )
                    }
                }
            }

            thinker.biographicalContext?.let { bio ->
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = bio,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 13.5.sp,
                    lineHeight = 20.sp,
                    color = theme.textSecondary
                )
            }

            thinker.specificContribution?.let { contrib ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Contribution: $contrib",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = theme.textPrimary
                )
            }

            thinker.quote?.let { q ->
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "\"$q\"",
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 13.5.sp,
                    lineHeight = 20.sp,
                    color = accentColor
                )
            }

            if (hasLink) {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(999.dp))
                        .background(accentColor.copy(alpha = 0.14f))
                        .clickable { onOpen(thinker.linkId!!) }
                        .padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Explore ${thinker.name}'s ideas",
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = theme.textPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Open",
                        tint = theme.textPrimary,
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun PracticalScenarioCard(
    scenario: PracticalScenario,
    accentColor: Color,
    backgroundColor: Color
) {
    val theme = PhilsTheme.colors

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .border(1.dp, theme.line, RoundedCornerShape(16.dp))
            .padding(18.dp)
    ) {
        Column {
            Text(
                text = scenario.title,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = theme.textPrimary
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = scenario.context,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontSize = 13.5.sp,
                lineHeight = 20.sp,
                color = theme.textSecondary
            )

            if (scenario.applicationSteps.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    scenario.applicationSteps.forEachIndexed { idx, step ->
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(CircleShape)
                                    .background(accentColor.copy(alpha = 0.16f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${idx + 1}",
                                    fontFamily = FontFamily.Monospace,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 10.sp,
                                    color = accentColor
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = step,
                                fontFamily = FontFamily.SansSerif,
                                fontSize = 13.sp,
                                lineHeight = 19.sp,
                                color = theme.textPrimary
                            )
                        }
                    }
                }
            }

            scenario.reflection?.let { refl ->
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = refl,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Medium,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = accentColor
                )
            }
        }
    }
}

@Composable
private fun ConnectedIdeaCard(
    item: ConnectedIdea,
    accentColor: Color,
    backgroundColor: Color,
    onOpen: (String) -> Unit
) {
    val theme = PhilsTheme.colors

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .border(1.dp, theme.line, RoundedCornerShape(16.dp))
            .clickable { onOpen(item.id) }
            .padding(18.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TypeEyebrow(
                    text = item.type,
                    color = accentColor
                )

                item.relationshipType?.let { rel ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(999.dp))
                            .background(accentColor.copy(alpha = 0.12f))
                            .padding(horizontal = 10.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = rel,
                            fontFamily = FontFamily.Monospace,
                            fontSize = 10.5.sp,
                            color = accentColor
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.title,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = theme.textPrimary
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = item.explanation,
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.5.sp,
                lineHeight = 20.sp,
                color = theme.textSecondary
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Explore ${item.title}",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = accentColor
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Explore",
                    tint = accentColor,
                    modifier = Modifier.size(13.dp)
                )
            }
        }
    }
}
