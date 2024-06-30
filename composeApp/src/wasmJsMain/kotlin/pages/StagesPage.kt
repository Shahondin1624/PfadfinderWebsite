package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import elements.Stage
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.*

@Composable
fun StagesPage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(all = 10.dp).verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = "Unsere Stufen", modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        Card(
            modifier = Modifier
                .padding(horizontal = 50.dp).padding(vertical = 10.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column {
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
                        modifier = Modifier.padding(vertical = 50.dp)
                    )
                }
                Stage(
                    stage = "Pfadfinder",
                    emailAddress = stringResource(Res.string.emailScouts),
                    ageRange = 12..17,
                    meetingTime = "Freitags 17:30 bis 19:30 Uhr",
                    description = stringResource(Res.string.scoutsDescription)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row {
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
                        }
                        Image(
                            painter = painterResource(Res.drawable.placeholder),
                            contentDescription = null,
                            modifier = Modifier.padding(vertical = 10.dp).padding(horizontal = 50.dp)
                        )
                    }
                }
                Stage(stage = "Rover", emailAddress = "", description = stringResource(Res.string.roverDescription)) {
                    Image(
                        painter = painterResource(Res.drawable.placeholder), contentDescription = null,
                        modifier = Modifier.padding(vertical = 10.dp).padding(horizontal = 50.dp)
                    )
                }
            }
        }
    }
}