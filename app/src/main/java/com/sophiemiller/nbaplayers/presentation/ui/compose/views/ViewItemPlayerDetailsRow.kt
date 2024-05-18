package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun ViewItemPlayerDetailsRow(text: String) {
    DefaultVerticalSpacer()
    Text(text = text, fontSize = 16.sp)
}