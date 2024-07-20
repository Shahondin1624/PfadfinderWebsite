package shared

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

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