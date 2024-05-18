package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

/**
 * composable
 * medium text at 16sp with default spacing above
 *
 * @param text
 */
@Composable
fun ViewItemMediumTextRow(text: String) {
    DefaultVerticalSpacer()
    Text(text = text, fontSize = 16.sp)
}