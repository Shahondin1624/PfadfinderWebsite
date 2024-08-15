package pages

import ResourceDp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.ImageSpinner
import elements.LocationMap
import model.Address
import model.stammesFuehrung
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.*


@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun TribePage() {
    val address = Address(
        name = stringResource(Res.string.header),
        street = stringResource(Res.string.addressStreet),
        houseNumber = stringResource(Res.string.addressHouseNumber),
        postalCode = stringResource(Res.string.addressZipCode),
        cityName = stringResource(Res.string.addressCityName),
        link = stringResource(Res.string.addressGoogleMapsLink),
    )
    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.FixedSize(ResourceDp.fieldSize()),
        verticalItemSpacing = ResourceDp.largePadding,
        horizontalArrangement = Arrangement.SpaceAround,
        contentPadding = PaddingValues(ResourceDp.smallPadding),
        content = {
            item(span = StaggeredGridItemSpan.FullLine) {
                TribePageHeader()
            }
            item {
                CustomCard {
                    DescribedText(
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.mediumPadding
                        ),
                        header = stringResource(Res.string.info),
                        content = stringResource(Res.string.infoContent)
                    )
                }
            }
            item {
                CustomCard {
                    DescribedTextWithLink(
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.mediumPadding
                        ),
                        header = stringResource(Res.string.europaPfadfinderStMichael),
                        content = createLinkTarget(
                            stringResource(Res.string.europaPfadfinderStMichaelContent),
                            annotate = "Europapfadfinder St. Michael",
                            linkTarget = "https://www.michaelspfadfinder.de"
                        )
                    )
                }
            }
            item {
                CustomCard {
                    DescribedText(
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.mediumPadding
                        ),
                        header = stringResource(Res.string.prinzipien),
                        content = stringResource(Res.string.prinzipienContent)
                    )
                }
            }
            item {
                CustomCard {
                    DescribedText(
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.mediumPadding
                        ),
                        header = stringResource(Res.string.insignien),
                        content = stringResource(Res.string.insignienContent)
                    )
                }
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(all = ResourceDp.smallPadding), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomHorizontalDivider()
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CustomCard {
                            Spacer(modifier = Modifier.height(ResourceDp.smallPadding))
                            H2(text = "Herrenseehütte Untersambach")
                            Spacer(Modifier.height(ResourceDp.mediumPadding))
                            Text(
                                text = stringResource(Res.string.herrenseehuetteText),
                                modifier = Modifier.padding(horizontal = ResourceDp.horizontalCardPadding())
                            )
                            Spacer(Modifier.height(ResourceDp.mediumPadding))
                            Image(
                                painter = painterResource(Res.drawable.icon_placeholder),
                                contentDescription = "Bild der Herrenseehütte Untersambach"
                            )
                            Spacer(modifier = Modifier.height(ResourceDp.smallPadding))
                        }
                    }
                }
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val sizeClass = calculateWindowSizeClass().widthSizeClass
                    CustomCard {
                        H2(text = "Stammesführung", modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
                        Text(
                            text = "TODO",
                            modifier = Modifier.padding(horizontal = ResourceDp.horizontalCardPadding())
                        )
                        HeadShotGrid(
                            contactPersons = stammesFuehrung(),
                            sizeClass = sizeClass
                        )
                        HorizontalDivider()
                        EmailButton(
                            targetText = "Stammesführung",
                            emailAddress = stringResource(Res.string.emailTribe)
                        )
                    }
                }
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CustomCard {
                        LocationMap(
                            modifier = Modifier.width(ResourceDp.mediumGridCellSize).padding(
                                vertical = ResourceDp.smallPadding,
                                horizontal = ResourceDp.horizontalCardPadding()
                            ),
                            address = address
                        )
                    }
                }
            }
        })
}

@Composable
private fun TribePageHeader() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = ResourceDp.smallPadding), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = stringResource(Res.string.header), modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
        H3(
            text = stringResource(Res.string.villageName),
            modifier = Modifier.padding(vertical = ResourceDp.smallPadding)
        )
        ImageSpinner(
            images = imageListWithLogo(imageList(remote = false)),
            modifier = Modifier.height(height = ResourceDp.largeGridCellSize).fillMaxWidth()
                .padding(vertical = ResourceDp.smallPadding)
        )
        H2(
            text = stringResource(Res.string.tribeDescriptionHeader),
            modifier = Modifier.padding(vertical = ResourceDp.smallPadding)
        )
        CustomHorizontalDivider()
    }
}