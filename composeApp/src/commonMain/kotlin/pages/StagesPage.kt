package pages

import ResourceDp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.Stage
import model.ContactPerson
import model.LocalImageResource
import org.jetbrains.compose.resources.stringResource
import shared.CustomHorizontalDivider
import shared.DescribedImage
import shared.H1
import shared.Position
import website.composeapp.generated.resources.*

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun StagesPage() {
    val widthSizeClass = calculateWindowSizeClass().widthSizeClass
    val adaptiveWidth = when (widthSizeClass) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> 400.dp
        else -> 800.dp
    }
    LazyVerticalStaggeredGrid(modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Adaptive(adaptiveWidth),
        verticalItemSpacing = ResourceDp.largePadding,
        horizontalArrangement = Arrangement.SpaceEvenly,
        contentPadding = PaddingValues(ResourceDp.smallPadding),
        content = {
            item(span = StaggeredGridItemSpan.FullLine) {
                StagesPageHeader()
            }
            item {
                Stage(
                    stage = "Wölflings",
                    emailAddress = stringResource(Res.string.emailCubScouts),
                    ageRange = 7..12,
                    meetingTime = "Freitags 17:30 bis 19:30 Uhr",
                    description = stringResource(Res.string.cubScoutsDescription),
                    contactPersons = listOf(
                        ContactPerson(name = "Lena", image = Res.drawable.image_Lena_Headshot),
                        ContactPerson(name = "Helena", image = Res.drawable.image_Helena_Headshot),
                        ContactPerson(name = "Rachel", image = Res.drawable.image_Rachel_Headshot),
                    ),
                    sizeClass = widthSizeClass
                ) {
                    DescribedImage(
                        text = "Meute Hathi",
                        position = Position.BOTTOM,
                        resourceAccessor = LocalImageResource(Res.drawable.image_Meute_1),
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.smallPadding
                        )
                    )
                }
            }
            item {
                Stage(
                    stage = "Pfadfinder",
                    emailAddress = stringResource(Res.string.emailScouts),
                    ageRange = 12..17,
                    meetingTime = "Freitags 17:30 bis 19:30 Uhr",
                    description = stringResource(Res.string.scoutsDescription),
                    contactPersons = listOf(
                        ContactPerson(name = "Tobias", image = Res.drawable.image_Tobias_Headshot),
                        ContactPerson(name = "Michi", image = Res.drawable.image_Michael_Headshot),
                        ContactPerson(name = "Phuket (Fahrtenname)", image = Res.drawable.image_Phuket_Headshot),
                    ),
                    sizeClass = widthSizeClass
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        DescribedImage(
                            text = "Sippe Dachs",
                            position = Position.BOTTOM,
                            resourceAccessor = LocalImageResource(Res.drawable.image_Sippe_Dachs),
                            modifier = Modifier.padding(horizontal = ResourceDp.horizontalCardPadding())
                        )
                        DescribedImage(
                            text = "Sippe Fledermaus",
                            position = Position.BOTTOM,
                            resourceAccessor = LocalImageResource(Res.drawable.image_Sippe_Fledermaus),
                            modifier = Modifier.padding(horizontal = ResourceDp.horizontalCardPadding())
                        )
                        DescribedImage(
                            text = "Trupp Sebastian von Rotenhan",
                            position = Position.BOTTOM,
                            resourceAccessor = LocalImageResource(Res.drawable.image_Trupp_Sebastian_von_Rotenhan),
                            modifier = Modifier.padding(
                                horizontal = ResourceDp.horizontalCardPadding(),
                                vertical = ResourceDp.smallPadding
                            )
                        )
                    }
                }
            }
            item {
                Stage(
                    stage = "Rover",
                    emailAddress = stringResource(Res.string.emailRover),
                    description = stringResource(Res.string.roverDescription),
                    contactPersons = listOf(
                        ContactPerson(name = "Andi", image = Res.drawable.image_Andi_Headshot),
                    ),
                    sizeClass = widthSizeClass
                ) {
                    DescribedImage(
                        text = "Roverrunde St. Mauritius",
                        position = Position.BOTTOM,
                        resourceAccessor = LocalImageResource(Res.drawable.image_Rover_1),
                        modifier = Modifier.padding(
                            horizontal = ResourceDp.horizontalCardPadding(),
                            vertical = ResourceDp.smallPadding
                        )
                    )
                }
            }
        })
}

@Composable
private fun StagesPageHeader() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = ResourceDp.smallPadding), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = "Unsere Stufen", modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
        CustomHorizontalDivider()
    }
}