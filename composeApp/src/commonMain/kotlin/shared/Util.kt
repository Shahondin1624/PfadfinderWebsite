package shared

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import org.jetbrains.compose.resources.DrawableResource
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

fun getGithubContentPath(pathToImage: String): String {
    return "https://raw.githubusercontent.com/Shahondin1624/PfadfinderWebsite/master/$pathToImage"
}

fun imageList(): MutableList<DrawableResource> = mutableListOf(
    Res.drawable.image_Meute_1,
    Res.drawable.image_Fuehrung_1,
    Res.drawable.image_Fuehrung_2,
    Res.drawable.image_Fuehrung_3,
    Res.drawable.image_Meute_1,
    Res.drawable.image_Rover_1,
    Res.drawable.image_Stamm_1,
    Res.drawable.image_Stamm_2,
)