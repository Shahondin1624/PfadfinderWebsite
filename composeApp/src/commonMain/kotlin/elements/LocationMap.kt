package elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Address
import shared.TextLink
import shared.createLink


@Composable
fun LocationMap(modifier: Modifier = Modifier, address: Address) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Addresse:", style = MaterialTheme.typography.headlineSmall)
        Text(text = "${address.street} ${address.houseNumber}")
        VerticalDivider(thickness = 10.dp)
        Text(text = "${address.postalCode} ${address.cityName}")
        if (address.link.isNotBlank()) {
            val content = createLink(link = address.link, displayText = "Google-Maps")
            TextLink(content = content)
        }
    }
}