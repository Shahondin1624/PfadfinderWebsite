package pages

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.ImageList
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.compose_multiplatform
import website.composeapp.generated.resources.placeholder

@Composable
fun ImagesPage() {
    ImageList(
        listOf(Res.drawable.placeholder, Res.drawable.compose_multiplatform),
        modifier = Modifier.padding(vertical = 10.dp).padding(horizontal = 50.dp)
    )
}