package shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

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