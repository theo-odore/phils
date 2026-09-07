package com.phils.app.ui.detail

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.phils.app.model.Discovery
import com.phils.app.model.SeedData
import com.phils.app.theme.PhilsTheme
import com.phils.app.theme.getMoodTone
import com.phils.app.ui.components.CatalogCorner
import com.phils.app.ui.components.MiniCard
import com.phils.app.ui.components.TypeEyebrow

@Composable
fun DetailScreen(
    discovery: Discovery,
    onBack: () -> Unit,
    onOpenDiscovery: (String) -> Unit,
    onToggleSave: (Discovery) -> Unit,
    isSaved: Boolean,
    modifier: Modifier = Modifier
) {
    val theme = PhilsTheme.colors
    val context = LocalContext.current
    val moodTone = getMoodTone(discovery.mood, theme.isDark)
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(theme.bg)
    ) {
        // Top App Bar
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

        // Scrollable Article Body
        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding()
                .verticalScroll(scrollState)
                .padding(horizontal = 22.dp, vertical = 12.dp)
        ) {
            // Header Card Box
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

            Spacer(modifier = Modifier.height(28.dp))

            // Glowing Quote Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(theme.surface)
                    .border(1.5.dp, moodTone.accent.copy(alpha = 0.35f), RoundedCornerShape(16.dp))
                    .padding(20.dp)
            ) {
                Text(
                    text = "\"${discovery.detail.quote}\"",
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Medium,
                    fontSize = 17.sp,
                    lineHeight = 25.sp,
                    color = theme.textPrimary
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // What is this?
            SectionTitle(title = "What is this?")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = discovery.detail.whatIsThis,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                lineHeight = 23.sp,
                color = theme.textSecondary
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Origin
            SectionTitle(title = "Origin context")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = discovery.detail.origin,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                lineHeight = 23.sp,
                color = theme.textSecondary
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Core Ideas
            SectionTitle(title = "Core principles")
            Spacer(modifier = Modifier.height(10.dp))
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                discovery.detail.coreIdeas.forEach { idea ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(moodTone.accent)
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

            // Key People
            if (discovery.detail.keyPeople.isNotEmpty()) {
                Spacer(modifier = Modifier.height(24.dp))
                SectionTitle(title = "Key thinkers")
                Spacer(modifier = Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    discovery.detail.keyPeople.forEach { person ->
                        val linkId = person.linkId
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(999.dp))
                                .background(if (linkId != null) moodTone.soft else theme.surface)
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
                                color = theme.textPrimary
                            )
                        }
                    }
                }
            }

            // Everyday Example
            Spacer(modifier = Modifier.height(24.dp))
            SectionTitle(title = "In everyday life")
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = discovery.detail.example,
                fontFamily = FontFamily.SansSerif,
                fontSize = 15.sp,
                lineHeight = 23.sp,
                color = theme.textSecondary
            )

            // Related Ideas
            if (discovery.related.isNotEmpty()) {
                Spacer(modifier = Modifier.height(32.dp))
                SectionTitle(title = "Connected ideas")
                Spacer(modifier = Modifier.height(12.dp))

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    discovery.related.mapNotNull { SeedData.discoveryMap[it] }.forEach { rel ->
                        MiniCard(
                            discovery = rel,
                            onOpen = onOpenDiscovery,
                            showSave = false
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(48.dp))
        }
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
