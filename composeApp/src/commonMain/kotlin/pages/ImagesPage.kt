package pages

import ResourceDp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import elements.ImageList
import shared.imageList


@Composable
fun ImagesPage() {
    ImageList(
        images = imageList(remote = false),
        modifier = Modifier.fillMaxSize().padding(vertical = ResourceDp.smallPadding)
            .padding(horizontal = ResourceDp.horizontalCardPadding())
    )
}