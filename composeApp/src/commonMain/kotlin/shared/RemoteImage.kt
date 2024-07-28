package shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import org.jetbrains.compose.resources.painterResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.icon_placeholder

@Composable
fun RemoteImage(request: String, contentDescription: String? = null, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(PlatformContext.INSTANCE)
            .data(request).crossfade(true).build(),
        placeholder = painterResource(Res.drawable.icon_placeholder),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}