package shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import openWindow

@Composable
fun EmailButton(targetText: String, emailAddress: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(vertical = 10.dp)) {
        val scope = rememberCoroutineScope()
        Button(
            onClick = {
                scope.launch {
                    sendEmail(address = emailAddress)
                }
            }) {
            Text(text = "Email an die $targetText", maxLines = 2, minLines = 2)
        }
    }
}

private fun sendEmail(address: String) {
    val link = "mailto:$address"
    openWindow(link)
}
