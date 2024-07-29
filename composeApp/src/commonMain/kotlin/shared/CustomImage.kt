package shared

import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.PlatformContext
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import model.LocalImageResource
import model.RemoteImageResource
import model.ResourceAccessor
import org.jetbrains.compose.resources.painterResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.icon_placeholder

@Composable
private fun RemoteAsyncImage(request: String, contentDescription: String? = null, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(PlatformContext.INSTANCE)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .data(request).crossfade(true).build(),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> CircularProgressIndicator()
            is AsyncImagePainter.State.Error, AsyncImagePainter.State.Empty -> Image(
                painter = painterResource(
                    Res.drawable.icon_placeholder
                ),
                contentDescription = "Placeholder Image"
            )

            is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
        }
    }
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