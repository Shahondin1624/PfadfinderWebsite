package shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import openWindow

@Composable
fun DescribedContent(modifier: Modifier = Modifier, header: String, content: @Composable () -> Unit) {
    Column(modifier = modifier) {
        H3(text = header, modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp))
        content()
    }
}

@Composable
fun DescribedText(modifier: Modifier = Modifier, header: String, content: String) {
    DescribedContent(modifier, header) {
        Text(
            text = content,
            modifier = Modifier.fillMaxWidth(),
            style = LocalTextStyle.current.merge(
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.Both
                )
            )
        )
    }
}

@Composable
fun DescribedTextWithLink(modifier: Modifier = Modifier, header: String, content: AnnotatedString) {
    DescribedContent(modifier, header) {
        TextLink(content)
    }
}

@Composable
fun TextLink(content: AnnotatedString) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        ClickableText(
            text = content,
            style = LocalTextStyle.current.merge(
                color = MaterialTheme.colorScheme.onPrimary,
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Center,
                    trim = LineHeightStyle.Trim.Both
                )
            ),
            onClick = { offset ->
                content.getStringAnnotations(tag = "URL", start = offset, end = offset)
                    .firstOrNull()?.let { annotation ->
                        openWindow(annotation.item)
                    }
            }
        )
    }
}
