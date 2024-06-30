package elements

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import org.jetbrains.compose.resources.stringResource
import shared.H1
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.legalDisclaimer

@Composable
fun DataProtection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        H1(text = stringResource(Res.string.legalDisclaimer))
        Text(text = "TODO: Datenschutz-Generator.de")
    }
}