package pages

import ResourceDp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import shared.*
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.calendarHeader
import website.composeapp.generated.resources.icon_under_construction


@Composable
fun CalendarPage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(all = ResourceDp.smallPadding).verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(
            text = stringResource(Res.string.calendarHeader),
            modifier = Modifier.padding(vertical = ResourceDp.smallPadding)
        )
        CustomHorizontalDivider()
        CustomCard {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CalendarPlaceholder()
                Calendar()
            }
        }
    }
}

@Composable
fun Calendar() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CopyTextField(
            text = "https://pfadis.ocloud.de/index.php/apps/calendar/p/b3wXd462weC4KpWX",
            label = "Kalender-Wölflinge",
            modifier = Modifier.width(ResourceDp.fieldSize())
                .padding(vertical = ResourceDp.smallPadding, horizontal = ResourceDp.horizontalCardPadding())
        )
        CopyTextField(
            text = "https://pfadis.ocloud.de/index.php/apps/calendar/p/s4jWaPoQz8NToLrB",
            label = "Kalender-Pfadfinder",
            modifier = Modifier.width(ResourceDp.fieldSize())
                .padding(vertical = ResourceDp.smallPadding, horizontal = ResourceDp.horizontalCardPadding())
        )
        CopyTextField(
            text = "https://pfadis.ocloud.de/index.php/apps/calendar/p/jTQteKHDFNxxrLY7",
            label = "Kalender-Stamm",
            modifier = Modifier.width(ResourceDp.fieldSize())
                .padding(vertical = ResourceDp.smallPadding, horizontal = ResourceDp.horizontalCardPadding())
        )
    }
}

@Composable
private fun CalendarPlaceholder() {
    H2(
        text = "Currently in construction...",
        color = MaterialTheme.colorScheme.error,
        modifier = Modifier.padding(vertical = ResourceDp.smallPadding)
    )
    Image(
        painter = painterResource(Res.drawable.icon_under_construction),
        contentDescription = "Under construction",
        modifier = Modifier.padding(horizontal = ResourceDp.largePadding, vertical = ResourceDp.largePadding)
    )
}