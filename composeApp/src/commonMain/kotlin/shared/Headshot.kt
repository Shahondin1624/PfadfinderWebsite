package shared

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import model.ContactPerson
import model.LocalImageResource

@Composable
fun Headshot(person: ContactPerson, maximumWidth: Dp, modifier: Modifier) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        CustomImage(
            resourceAccessor = LocalImageResource(person.image), contentDescription = person.name,
            modifier = Modifier
                .sizeIn(maxWidth = maximumWidth)
                .aspectRatio(1f)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Text(text = person.name, style = MaterialTheme.typography.labelSmall)
    }
}

