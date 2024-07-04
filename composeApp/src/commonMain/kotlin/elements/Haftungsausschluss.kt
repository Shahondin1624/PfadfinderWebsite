package elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.DescribedText
import website.composeapp.generated.resources.*
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.liabilityForContent
import website.composeapp.generated.resources.liabilityForContentContent
import website.composeapp.generated.resources.liabilityForLinks

@Composable
fun Haftungsausschluss() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        DescribedText(
            header = stringResource(Res.string.liabilityForContent),
            content = stringResource(Res.string.liabilityForContentContent),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(horizontal = 50.dp)
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        DescribedText(
            header = stringResource(Res.string.liabilityForLinks),
            content = stringResource(Res.string.liabilityForLinksContent),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(horizontal = 50.dp)
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        DescribedText(
            header = stringResource(Res.string.copyright), content = stringResource(Res.string.copyrightContent),
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(horizontal = 50.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = 50.dp))
        Text(text = "Quelle: Rechtsanwalt Sören Siebert - eRecht24")
    }
}