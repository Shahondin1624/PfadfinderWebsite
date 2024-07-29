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
import elements.ImageSpinner
import elements.LocationMap
import model.Address
import model.ContactPerson
import model.LocalImageResource
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
        columns = StaggeredGridCells.Adaptive(ResourceDp.largeGridCellSize),
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
                CustomCard(modifier = Modifier.width(ResourceDp.fieldSize())) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.mediumPadding
                        )
                    ) {
                        H2(text = "Herrenseehütte Untersambach")
                        Spacer(Modifier.height(ResourceDp.mediumPadding))
                        Text(text = stringResource(Res.string.herrenseehuetteText))
                        Spacer(Modifier.height(ResourceDp.mediumPadding))
                        Image(
                            painter = painterResource(Res.drawable.icon_placeholder),
                            contentDescription = "Bild der Herrenseehütte Untersambach"
                        )
                    }
                }
            }
            item(span = StaggeredGridItemSpan.FullLine) {
                val sizeClass = calculateWindowSizeClass().widthSizeClass
                CustomCard(modifier = Modifier.width(ResourceDp.fieldSize())) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = ResourceDp.horizontalCardPadding()),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        H2(text = "Stammesführung", modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
                        Text(text = "TODO")
                        HeadShotGrid(
                            contactPersons = listOf(
                                ContactPerson(name = "Michi", image = Res.drawable.image_Michael_Headshot),
                                ContactPerson(name = "Phuket (Fahrtenname)", image = Res.drawable.image_Phuket_Headshot)
                            ),
                            sizeClass = sizeClass
                        )
                        HorizontalDivider()
                        EmailButton(
                            targetText = "Stammesführung",
                            emailAddress = stringResource(Res.string.emailTribe)
                        )
                        CustomCard {
                            LocationMap(
                                modifier = Modifier.width(ResourceDp.smallGridCellSize).padding(
                                    vertical = ResourceDp.smallPadding,
                                    horizontal = ResourceDp.horizontalCardPadding()
                                ),
                                address = address
                            )
                        }
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
            images = imageList().apply {
                this.add(0, LocalImageResource(Res.drawable.icon_logo))
            },
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