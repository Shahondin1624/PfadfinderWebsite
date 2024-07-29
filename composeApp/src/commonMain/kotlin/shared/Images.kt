package shared

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.PlatformContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import model.LocalImageResource
import model.RemoteImageResource
import model.ResourceAccessor
import org.jetbrains.compose.resources.painterResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.icon_placeholder

@Composable
fun RemoteAsyncImage(request: String, contentDescription: String? = null, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(PlatformContext.INSTANCE)
            .data(request).crossfade(true).build(),
        placeholder = painterResource(Res.drawable.icon_placeholder),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun CustomImage(resourceAccessor: ResourceAccessor, contentDescription: String?, modifier: Modifier = Modifier) {
    when (resourceAccessor) {
        is LocalImageResource -> {
            Image(
                painter = painterResource(resourceAccessor.resource),
                contentDescription = contentDescription,
                modifier = modifier
            )
        }

        is RemoteImageResource -> {
            RemoteAsyncImage(
                request = resourceAccessor.link,
                contentDescription = contentDescription,
                modifier = modifier
            )
        }
    }
}