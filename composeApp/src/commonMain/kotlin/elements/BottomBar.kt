package elements

import ResourceDp
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.onClick
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.navigation.NavController
import navigation.Routes
import org.jetbrains.compose.resources.stringResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.dataProtectionDeclaration
import website.composeapp.generated.resources.impressum
import website.composeapp.generated.resources.legalDisclaimer

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBar(navigator: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.dataProtectionDeclaration),
            modifier = Modifier.padding(horizontal = ResourceDp.smallPadding).pointerHoverIcon(icon = PointerIcon.Hand)
                .onClick {
                    navigator.navigate(Routes.COPYRIGHT.name)
                }
        )
        Text(
            text = stringResource(Res.string.impressum),
            modifier = Modifier.padding(horizontal = ResourceDp.smallPadding).pointerHoverIcon(icon = PointerIcon.Hand)
                .onClick { navigator.navigate(Routes.COPYRIGHT.name) }
        )
        Text(
            text = stringResource(Res.string.legalDisclaimer),
            modifier = Modifier.padding(horizontal = ResourceDp.smallPadding).pointerHoverIcon(icon = PointerIcon.Hand)
                .onClick { navigator.navigate(Routes.COPYRIGHT.name) }
        )
    }
}
