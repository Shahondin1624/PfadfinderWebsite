package shared

import ResourceDp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import download
import org.jetbrains.compose.resources.painterResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.icon_download

@Composable
fun DownloadButton(fileName: String) {
    Button(modifier = Modifier.fillMaxWidth(), onClick = {
        download(fileName)
    }) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = fileName, modifier = Modifier.padding(end = ResourceDp.smallPadding))
            Icon(painter = painterResource(Res.drawable.icon_download), contentDescription = "Download $fileName")
        }
    }
}