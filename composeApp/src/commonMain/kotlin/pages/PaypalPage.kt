package pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.*

@Composable
fun PaypalPage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        H1(text = stringResource(Res.string.paypal), modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        CustomCard {
            DescribedText(
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 10.dp)
                    .align(Alignment.CenterHorizontally),
                textModifier = Modifier.width(800.dp),
                header = stringResource(Res.string.paypalHeader),
                content = stringResource(Res.string.paypalContent)
            )
            TextLink(
                modifier = Modifier.padding(horizontal = 50.dp, vertical = 10.dp)
                    .align(Alignment.CenterHorizontally),
                content = createLink(
                    link = stringResource(Res.string.paypalLink),
                    displayText = "Spenden"
                )
            )
        }
    }
}