package shared

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import model.LocalImageResource
import model.RemoteImageResource
import model.ResourceAccessor
import website.composeapp.generated.resources.*

@Composable
fun createLinkTarget(
    content: String,
    annotate: String,
    linkTarget: String,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    linkColor: Color = MaterialTheme.colorScheme.secondary
): AnnotatedString {
    return buildAnnotatedString {
        val startIndex = content.indexOf(annotate)
        val endIndex = startIndex + annotate.length
        if (startIndex >= 0 && endIndex <= content.length) {
            withStyle(style = SpanStyle(color = contentColor)) {
                append(content.substring(0, startIndex))
            }
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = linkColor)) {
                pushStringAnnotation(tag = "URL", annotation = linkTarget)
                append(content.substring(startIndex, endIndex))
                pop()
            }
            withStyle(style = SpanStyle(color = contentColor)) {
                append(content.substring(endIndex))
            }
        } else {
            withStyle(style = SpanStyle(color = contentColor)) {
                append(content)
            }
        }
    }
}

@Composable
fun createLink(
    link: String,
    displayText: String,
    linkColor: Color = MaterialTheme.colorScheme.secondary
): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = linkColor)) {
            pushStringAnnotation(tag = "URL", annotation = link)
            append(displayText)
            pop()
        }
    }
}

private const val drawableRemotePath = "composeApp/src/commonMain/composeResources/drawable/"

fun getGithubImagePath(imageName: String): String {
    return "https://raw.githubusercontent.com/Shahondin1624/PfadfinderWebsite/master/${drawableRemotePath}image_$imageName.jpeg"
}

private fun localImageList(): MutableList<ResourceAccessor> = mutableListOf(
    LocalImageResource(Res.drawable.image_Fuehrung_1),
    LocalImageResource(Res.drawable.image_Fuehrung_2),
    LocalImageResource(Res.drawable.image_Fuehrung_3),
    LocalImageResource(Res.drawable.image_Meute_1),
    LocalImageResource(Res.drawable.image_Trupp_Sebastian_von_Rotenhan),
    LocalImageResource(Res.drawable.image_Trupp_Sebastian_von_Rotenhan_2),
    LocalImageResource(Res.drawable.image_Rover_1),
    LocalImageResource(Res.drawable.image_Stamm_1),
    LocalImageResource(Res.drawable.image_Stamm_2),
)

private fun remoteImageList(): MutableList<ResourceAccessor> {
    return mutableListOf(
        "Fuehrung_1",
        "Fuehrung_2",
        "Fuehrung_3",
        "Meute_1",
        "Trupp_Sebastian_von_Rotenhan",
        "Trupp_Sebastian_von_Rotenhan_2",
        "Rover_1",
        "Stamm_1",
        "Stamm_2",
    ).map { RemoteImageResource(getGithubImagePath(it)) }
        .toMutableList()
}

fun imageList(remote: Boolean = false): MutableList<ResourceAccessor> =
    if (remote) remoteImageList() else localImageList()

fun imageListWithLogo(list: MutableList<ResourceAccessor>): MutableList<ResourceAccessor> {
    if (list.first() is RemoteImageResource) {
        list.add(0, RemoteImageResource("${drawableRemotePath}icon_logo.png"))
    } else {
        list.add(0, LocalImageResource(Res.drawable.icon_logo))
    }
    return list
}