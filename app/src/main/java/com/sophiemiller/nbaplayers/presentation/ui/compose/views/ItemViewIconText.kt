package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


/**
 *
 * composable
 * row of small icon (40*40) with text 16sp
 *
 * @param iconUrl
 * @param text
 */
@Composable
fun ItemViewIconText(iconUrl: String, text: String) {
    DefaultVerticalSpacer()
    Row {
        val modifier = Modifier.align(Alignment.CenterVertically)
        SmallIconGlide(iconUrl = iconUrl, modifier = modifier)
        DefaultRowSpacer()
        Text(
            modifier = modifier,
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp
        )
    }

}