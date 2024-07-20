package shared

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun H1(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    val theme = MaterialTheme.typography.headlineLarge
    Header(
        modifier = modifier,
        text = text,
        color = color,
        theme = theme
    )
}

@Composable
fun H2(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    val theme = MaterialTheme.typography.headlineMedium
    Header(
        modifier = modifier,
        text = text,
        color = color,
        theme = theme
    )
}

@Composable
fun H3(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
) {
    val theme = MaterialTheme.typography.headlineSmall
    Header(
        modifier = modifier,
        text = text,
        color = color,
        theme = theme
    )
}

@Composable
private fun Header(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    theme: TextStyle
) {
    Text(
        modifier = modifier,
        text = text,
        style = theme,
        color = color
    )
}
