package pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import elements.ImageSpinner
import elements.LocationMap
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.*


@Composable
fun TribePage() {
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(all = 10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = stringResource(Res.string.header), modifier = Modifier.padding(vertical = 10.dp))
        H3(text = stringResource(Res.string.villageName), modifier = Modifier.padding(vertical = 10.dp))
        ImageSpinner(
            images = listOf(Res.drawable.placeholder, Res.drawable.compose_multiplatform),
            modifier = Modifier.height(height = 400.dp).fillMaxWidth().padding(vertical = 10.dp)
        )
        H2(text = stringResource(Res.string.tribeDescriptionHeader), modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        Card(
            modifier = Modifier
                .padding(horizontal = 50.dp).padding(vertical = 10.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .shadow(elevation = 5.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(300.dp),
                verticalItemSpacing = 10.dp,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    item {
                        DescribedTextWithLink(
                            modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp)
                                .padding(vertical = 20.dp),
                            header = stringResource(Res.string.info),
                            content = createLinkTarget(
                                stringResource(Res.string.infoContent),
                                annotate = "Europapfadfindern St.Michael",
                                linkTarget = "https://www.michaelspfadfinder.de/"
                            )
                        )
                    }
                    item {
                        DescribedText(
                            modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp)
                                .padding(vertical = 20.dp),
                            header = stringResource(Res.string.europaPfadfinderStMichael),
                            content = stringResource(Res.string.europaPfadfinderStMichaelContent)
                        )
                    }
                    item {
                        DescribedText(
                            modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp)
                                .padding(vertical = 20.dp),
                            header = stringResource(Res.string.prinzipien),
                            content = stringResource(Res.string.prinzipienContent)
                        )
                    }
                    item {
                        DescribedText(
                            modifier = Modifier.weight(weight = 0.5f).padding(horizontal = 10.dp)
                                .padding(vertical = 20.dp),
                            header = stringResource(Res.string.insignien),
                            content = stringResource(Res.string.insignienContent)
                        )
                    }
                    item(span = StaggeredGridItemSpan.FullLine ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            HorizontalDivider()
                            EmailButton(
                                targetText = "Stammesführung",
                                emailAddress = stringResource(Res.string.emailTribe)
                            )
                            LocationMap(modifier = Modifier.padding(vertical = 10.dp))
                        }
                    }
                }
            )

        }

    }
}