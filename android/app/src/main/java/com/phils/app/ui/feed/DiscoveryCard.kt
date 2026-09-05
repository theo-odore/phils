package com.phils.app.ui.feed

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phils.app.model.Discovery
import com.phils.app.theme.PhilsTheme
import com.phils.app.theme.getMoodTone
import com.phils.app.ui.components.CatalogCorner
import com.phils.app.ui.components.TypeEyebrow

@Composable
fun DiscoveryCard(
    discovery: Discovery,
    onExplore: (Discovery) -> Unit,
    onToggleSave: (Discovery) -> Unit,
    onShowWhy: (Discovery) -> Unit,
    modifier: Modifier = Modifier,
    isSaved: Boolean = discovery.saved
) {
    val theme = PhilsTheme.colors
    val moodTone = getMoodTone(discovery.mood, theme.isDark)

    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(22.dp))
            .background(moodTone.bg)
            .border(
                1.dp,
                if (!theme.isDark) Color(0x12000000) else Color(0x24FFFFFF),
                RoundedCornerShape(22.dp)
            )
            .clickable { onExplore(discovery) }
    ) {
        // Top right catalog fold corner
        CatalogCorner(
            modifier = Modifier.align(Alignment.TopEnd)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header: Type Eyebrow & Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TypeEyebrow(
                    text = discovery.type,
                    color = moodTone.accent
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { onShowWhy(discovery) },
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = "Why this idea",
                            tint = moodTone.accent.copy(alpha = 0.8f),
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(4.dp))

                    IconButton(
                        onClick = { onToggleSave(discovery) },
                        modifier = Modifier.size(34.dp)
                    ) {
                        Icon(
                            imageVector = if (isSaved) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Save",
                            tint = if (isSaved) moodTone.accent else theme.textFaint,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }

            // Main Content: Hook, Title, Short Description
            Column(
                modifier = Modifier.weight(1f, fill = false),
                verticalArrangement = Arrangement.Center
            ) {
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

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = discovery.short,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.5.sp,
                    lineHeight = 21.sp,
                    color = theme.textSecondary
                )
            }

            // Footer: Explore Call-To-Action
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(999.dp))
                    .background(moodTone.soft.copy(alpha = 0.7f))
                    .padding(horizontal = 18.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Explore idea",
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    color = theme.textPrimary
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Explore",
                    tint = theme.textPrimary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}
