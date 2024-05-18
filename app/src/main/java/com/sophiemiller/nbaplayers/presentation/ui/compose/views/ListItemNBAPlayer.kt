package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sophiemiller.nbaplayers.data.entities.Player

@Composable
fun ListItemNBAPlayer(
    playerName: String = "TestName",
    playerPosition: String? = null,
    playerTeam: String? = null,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.surface,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            HeaderText(text = playerName)
            playerTeam?.let {
                DefaultSpacer()
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 16.sp
                )
            }
            playerPosition?.let {
                DefaultSpacer()
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp
                )
            }
        }
    }

}