package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * composable
 * spacer for columns at 8dp
 */
@Composable
fun DefaultVerticalSpacer() {
    Spacer(modifier = Modifier.height(8.dp))
}