package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sophiemiller.nbaplayers.data.constants.ImageURLs

/**
 * Player card with basic info
 *
 * @param playerName
 * @param playerPosition
 * @param playerTeam
 * @param onClick
 */
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
                ItemViewIconText(iconUrl = ImageURLs.ICON_TEAM_NAME, text = it)
            }
            playerPosition?.let {
                ItemViewIconText(ImageURLs.ICOT_TEAM_POSITION, it)
            }
        }

    }
}