package elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import shared.CustomHorizontalDivider
import shared.EmailButton
import shared.H2

@Composable
fun Stage(
    stage: String,
    emailAddress: String,
    ageRange: IntRange? = null,
    meetingTime: String? = null,
    description: String,
    additional: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H2(text = "${stage}stufe", modifier = Modifier.padding(vertical = 10.dp))
        ageRange?.let {
            Text(
                text = "${ageRange.first} bis ${ageRange.last} Jahre",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
        meetingTime?.let {
            Text(text = "Gruppenstunde", modifier = Modifier.padding(vertical = 10.dp))
            Text(text = meetingTime, modifier = Modifier.padding(vertical = 10.dp))
        }
        Text(text = description, modifier = Modifier.padding(vertical = 10.dp).padding(horizontal = 50.dp))
        Spacer(modifier = Modifier.padding(top = 50.dp))
        CustomHorizontalDivider()
        EmailButton(targetText = "${stage}führung", emailAddress = emailAddress)
        additional()
    }
}