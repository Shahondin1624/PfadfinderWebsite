package shared

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import org.jetbrains.compose.resources.painterResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.copy

@Composable
fun CopyTextField(text: String, label: String = "", modifier: Modifier = Modifier) {
    val clipboardManager = LocalClipboardManager.current
    TextField(value = text, readOnly = true, onValueChange = {}, minLines = 1, trailingIcon = {
        IconButton(onClick = { clipboardManager.setText(AnnotatedString(text)) }) {
            Icon(painter = painterResource(Res.drawable.copy), contentDescription = "Copy value")
        }
    }, label = {
        Text(text = label)
    },
        modifier = modifier
    )
}