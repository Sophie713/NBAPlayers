package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

/**
 * composable
 * header view - black, 20sp, extra spacing
 *
 * @param text
 */
@Composable
fun HeaderText(text: String) {
    Text(
        text = text,
        color = Color.Black,
        letterSpacing = 1.sp,
        style = MaterialTheme.typography.headlineLarge,
        fontSize = 20.sp
    )
}