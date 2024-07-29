package elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.ResourceAccessor
import org.jetbrains.compose.resources.painterResource
import shared.CustomImage
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.icon_left_arrow
import website.composeapp.generated.resources.icon_right_arrow

@Composable
fun ImageSpinner(modifier: Modifier = Modifier, images: List<ResourceAccessor>) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        var index by remember { mutableStateOf(0) }
        var image by remember { mutableStateOf(images.first()) }
        IconButton(modifier = Modifier.align(Alignment.CenterVertically).weight(0.15f), onClick = {
            val previous = index - 1
            index = if (previous < 0) {
                images.size - 1
            } else {
                previous
            }
            image = images[index]
        }) {
            Icon(painter = painterResource(Res.drawable.icon_left_arrow), contentDescription = "Left Image")
        }
        CustomImage(resourceAccessor = image, contentDescription = "ImageSpinner", modifier = Modifier.weight(0.7f))
        IconButton(modifier = Modifier.align(Alignment.CenterVertically).weight(0.15f), onClick = {
            val next = index + 1
            index = if (next >= images.size) {
                0
            } else {
                next
            }
            image = images[index]
        }) {
            Icon(painter = painterResource(Res.drawable.icon_right_arrow), contentDescription = "Right Image")
        }
    }
}



