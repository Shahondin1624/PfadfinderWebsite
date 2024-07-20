package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.Stage
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import shared.CustomHorizontalDivider
import shared.DescribedImage
import shared.H1
import shared.Position
import website.composeapp.generated.resources.*

@Composable
fun StagesPage() {
    LazyVerticalStaggeredGrid(modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Adaptive(400.dp),
        verticalItemSpacing = 50.dp,
        horizontalArrangement = Arrangement.SpaceEvenly,
        contentPadding = PaddingValues(10.dp),
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
                    description = stringResource(Res.string.cubScoutsDescription)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.placeholder),
                        contentDescription = null,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                    )
                }
            }
            item {
                Stage(
                    stage = "Pfadfinder",
                    emailAddress = stringResource(Res.string.emailScouts),
                    ageRange = 12..17,
                    meetingTime = "Freitags 17:30 bis 19:30 Uhr",
                    description = stringResource(Res.string.scoutsDescription)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        DescribedImage(
                            text = "Sippe Dachs",
                            position = Position.TOP,
                            image = Res.drawable.placeholder,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                        DescribedImage(
                            text = "Sippe Fledermaus",
                            position = Position.TOP,
                            image = Res.drawable.placeholder,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                        Image(
                            painter = painterResource(Res.drawable.placeholder),
                            contentDescription = null,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                        )
                    }
                }
            }
            item {
                Stage(
                    stage = "Rover",
                    emailAddress = stringResource(Res.string.emailRover),
                    description = stringResource(Res.string.roverDescription)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.placeholder), contentDescription = null,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
                    )
                }
            }
        })
}

@Composable
private fun StagesPageHeader() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(all = 10.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = "Unsere Stufen", modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
    }
}