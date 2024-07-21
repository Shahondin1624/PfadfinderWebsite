package shared

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import openWindow

@Composable
fun LinkButton(targetText: String, link: String, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    Button(modifier = modifier,
        onClick = {
            scope.launch {
                openWindow(link)
            }
        }) {
        Text(text = targetText, maxLines = 1, minLines = 1)
    }
}
