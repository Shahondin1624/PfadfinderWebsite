package shared

import ResourceDp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    width: Dp = ResourceDp.fieldSize(),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .width(width)
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .shadow(elevation = ResourceDp.verySmallPadding),
        shape = RoundedCornerShape(ResourceDp.smallPadding)
    ) {
        Column(
            modifier = modifier.width(width).background(color = MaterialTheme.colorScheme.secondaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()
        }
    }
}