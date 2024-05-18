package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * composable
 * spacer for rows at 8dp
 */
@Composable
fun DefaultHorizontalSpacer() {
    Spacer(modifier = Modifier.width(8.dp))
}