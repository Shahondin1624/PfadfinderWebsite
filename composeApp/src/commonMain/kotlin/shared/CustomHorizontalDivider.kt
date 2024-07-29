package shared

import ResourceDp
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomHorizontalDivider(modifier: Modifier = Modifier) {
    androidx.compose.material3.HorizontalDivider(
        modifier = modifier.padding(vertical = ResourceDp.smallPadding)
            .padding(horizontal = ResourceDp.horizontalCardPadding())
    )
}