package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sophiemiller.nbaplayers.data.constants.ImageURLs
import com.sophiemiller.nbaplayers.data.entities.Player

/**
 * Player card with basic info
 *
 * @param player
 * @param onClick
 */
@Composable
fun ListItemNBAPlayer(
    player: Player,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.tertiaryContainer,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            HeaderText(text = "${player.firstName} ${player.lastName}")
            player.team?.let {
                ItemViewIconText(iconUrl = ImageURLs.ICON_TEAM_NAME, text = "${it.name}")
            }
            player.position?.let {
                ItemViewIconText(ImageURLs.ICON_TEAM_POSITION, it)
            }
        }

    }
}