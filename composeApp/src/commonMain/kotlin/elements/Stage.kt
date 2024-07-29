package elements

import ResourceDp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import model.ContactPerson
import shared.*

@Composable
fun Stage(
    stage: String,
    emailAddress: String,
    ageRange: IntRange? = null,
    meetingTime: String? = null,
    description: String,
    contactPersons: List<ContactPerson>,
    sizeClass: WindowWidthSizeClass,
    additional: @Composable () -> Unit
) {
    CustomCard {
        Column(
            modifier = Modifier.padding(horizontal = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            H2(text = "${stage}stufe", modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
            ageRange?.let {
                Text(
                    text = "${ageRange.first} bis ${ageRange.last} Jahre",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            meetingTime?.let {
                Text(text = "Gruppenstunde", modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
                Text(text = meetingTime, modifier = Modifier.padding(vertical = ResourceDp.smallPadding))
            }
            Text(
                text = description,
                modifier = Modifier.padding(vertical = ResourceDp.smallPadding)
                    .padding(horizontal = ResourceDp.horizontalCardPadding())
            )
            Spacer(modifier = Modifier.padding(top = ResourceDp.largePadding))
            HeadShotGrid(contactPersons, sizeClass)
            CustomHorizontalDivider()
            EmailButton(targetText = "${stage}führung", emailAddress = emailAddress)
            additional()
        }
    }
}