package shared

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun DescribedImage(text: String, position: Position, image: DrawableResource, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (position == Position.TOP) {
            Text(text, modifier = Modifier.padding(vertical = 10.dp))
        }
        Image(painterResource(image), contentDescription = null, modifier = Modifier.padding(vertical = 10.dp))
        if (position == Position.BOTTOM) {
            Text(text, modifier = Modifier.padding(vertical = 10.dp))
        }
    }
}

enum class Position {
    TOP, BOTTOM
}