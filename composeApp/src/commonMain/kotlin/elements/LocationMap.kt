package elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import model.Address
import shared.TextLink


@Composable
fun LocationMap(modifier: Modifier = Modifier, address: Address) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Addresse:", style = MaterialTheme.typography.headlineSmall)
        Text(text = "${address.street} ${address.houseNumber}")
        VerticalDivider(thickness = 10.dp)
        Text(text = "${address.postalCode} ${address.cityName}")
        if (address.link.isNotBlank()) {
            val content = createMapsLink(address.link)
            TextLink(content)
        }
    }
}

@Composable
private fun createMapsLink(link: String, linkColor: Color = MaterialTheme.colorScheme.secondary): AnnotatedString {
    return buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline, color = linkColor)) {
            pushStringAnnotation(tag = "URL", annotation = link)
            append("Google-Maps")
            pop()
        }
    }
}