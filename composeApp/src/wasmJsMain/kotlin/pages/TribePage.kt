package pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.ImageSpinner
import elements.LocationMap
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.*

@Composable
fun TribePage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(all = 10.dp).verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = stringResource(Res.string.header), modifier = Modifier.padding(vertical = 10.dp))
        H3(text = stringResource(Res.string.villageName), modifier = Modifier.padding(vertical = 10.dp))
        ImageSpinner(
            images = listOf(Res.drawable.placeholder, Res.drawable.compose_multiplatform),
            modifier = Modifier.size(width = 800.dp, height = 400.dp).padding(vertical = 10.dp)
        )
        H2(text = stringResource(Res.string.tribeDescriptionHeader), modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        Card(
            modifier = Modifier
                .padding(horizontal = 50.dp).padding(vertical = 10.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row {
                    DescribedTextWithLink(
                        modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp).padding(vertical = 20.dp),
                        header = stringResource(Res.string.info),
                        content = createLinkTarget(
                            stringResource(Res.string.infoContent),
                            annotate = "Europapfadfindern St.Michael",
                            linkTarget = "https://www.michaelspfadfinder.de/"
                        )
                    )
                    DescribedText(
                        modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp).padding(vertical = 20.dp),
                        header = stringResource(Res.string.europaPfadfinderStMichael),
                        content = stringResource(Res.string.europaPfadfinderStMichaelContent)
                    )
                }
                Row {
                    DescribedText(
                        modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp).padding(vertical = 20.dp),
                        header = stringResource(Res.string.prinzipien),
                        content = stringResource(Res.string.prinzipienContent)
                    )
                    DescribedText(
                        modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp).padding(vertical = 20.dp),
                        header = stringResource(Res.string.insignien),
                        content = stringResource(Res.string.insignienContent)
                    )
                }
                CustomHorizontalDivider()
                EmailButton(targetText = "Stammesführung", emailAddress = stringResource(Res.string.emailTribe))
                LocationMap(modifier = Modifier.padding(vertical = 10.dp))
            }
        }
    }
}