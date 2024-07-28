package shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.ContactPerson
import kotlin.math.ceil

@Composable
fun HeadShotGrid(contactPersons: List<ContactPerson>, sizeClass: WindowWidthSizeClass) {
    val itemsPerRow = when (sizeClass) {
        WindowWidthSizeClass.Compact -> 1
        WindowWidthSizeClass.Medium -> 2
        WindowWidthSizeClass.Expanded -> 4
        else -> {
            1
        }
    }
    val requiredRows = ceil(contactPersons.size.toDouble() / itemsPerRow).toInt()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var counter = 0
        for (row in 0 until requiredRows) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                for (headshot in 0 until itemsPerRow) {
                    if (counter < contactPersons.size) {
                        val contact = contactPersons[counter++]
                        Headshot(
                            person = contact,
                            maximumWidth = 100.dp,
                            modifier = Modifier.padding(all = 25.dp)
                        )
                    }
                }
            }
        }
    }
}