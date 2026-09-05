package com.phils.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phils.app.model.Discovery
import com.phils.app.theme.PhilsTheme
import com.phils.app.theme.getMoodTone

@Composable
fun MiniCard(
    discovery: Discovery,
    onOpen: (String) -> Unit,
    modifier: Modifier = Modifier,
    showSave: Boolean = true,
    isSaved: Boolean = discovery.saved,
    onToggleSave: ((String) -> Unit)? = null
) {
    val theme = PhilsTheme.colors
    val moodTone = getMoodTone(discovery.mood, theme.isDark)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 6.dp, bottomStart = 6.dp))
            .background(moodTone.bg)
            .border(
                1.dp,
                if (!theme.isDark) Color(0x10000000) else Color(0x1AFFFFFF),
                RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 6.dp, bottomStart = 6.dp)
            )
            .clickable { onOpen(discovery.id) }
            .padding(14.dp)
    ) {
        // Corner fold
        CatalogCorner(
            modifier = Modifier
                .align(Alignment.TopEnd)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TypeEyebrow(
                text = discovery.type,
                color = moodTone.accent
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = discovery.title,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                lineHeight = 22.sp,
                color = theme.textPrimary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = discovery.short,
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = theme.textSecondary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

            if (showSave && onToggleSave != null) {
                Spacer(modifier = Modifier.height(10.dp))
                IconButton(
                    onClick = { onToggleSave(discovery.id) },
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.End)
                ) {
                    Icon(
                        imageVector = if (isSaved) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = "Save",
                        tint = if (isSaved) moodTone.accent else theme.textFaint,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}
