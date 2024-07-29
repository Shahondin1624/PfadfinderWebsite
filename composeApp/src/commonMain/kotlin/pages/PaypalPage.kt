package pages

import ResourceDp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.*

@Composable
fun PaypalPage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        H1(text = stringResource(Res.string.paypal), modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
        CustomHorizontalDivider()
        CustomCard {
            DescribedText(
                modifier = Modifier.padding(
                    horizontal = ResourceDp.horizontalCardPadding(),
                    vertical = ResourceDp.smallPadding
                )
                    .align(Alignment.CenterHorizontally),
                textModifier = Modifier.width(ResourceDp.fieldSize()),
                header = stringResource(Res.string.paypalHeader),
                content = stringResource(Res.string.paypalContent)
            )
            LinkButton(
                modifier = Modifier.padding(
                    horizontal = ResourceDp.horizontalCardPadding(),
                    vertical = ResourceDp.smallPadding
                )
                    .align(Alignment.CenterHorizontally),
                link = stringResource(Res.string.paypalLink),
                targetText = "Spenden"
            )
        }
    }
}