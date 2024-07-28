package pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.ImageList
import shared.imageList


@Composable
fun ImagesPage() {
    ImageList(
        images = imageList(),
        modifier = Modifier.fillMaxSize().padding(vertical = 10.dp).padding(horizontal = 50.dp)
    )
}