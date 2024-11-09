package com.sophiemiller.nbaplayers.presentation.ui.compose.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import com.sophiemiller.nbaplayers.data.constants.ImageURLs

/**
 * Use Glide library to upload icons from URLs
 *
 * @param modifier
 * @param iconUrl
 */
@Preview
@Composable
fun SmallIconGlide(modifier: Modifier = Modifier, iconUrl: String = ImageURLs.ICON_TEAM_NAME) {
    Surface(
        modifier = modifier
            .width(40.dp)
            .height(40.dp)
    ) {
        GlideImage(
            imageModel = iconUrl,
            contentDescription = "Loaded with Glide",
            modifier = Modifier
                .padding(8.dp),
            contentScale = ContentScale.FillWidth,
            // Customize the loading and error placeholders
            loading = {
                Box(modifier = Modifier.matchParentSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(androidx.compose.ui.Alignment.Center)
                    )
                }
            },
            failure = {
                Box(modifier = Modifier.matchParentSize()) {
                    Icon(
                        imageVector = Icons.Default.Build,
                        contentDescription = "Error",
                        modifier = Modifier.align(androidx.compose.ui.Alignment.Center)
                    )
                }
            }
        )
    }
}