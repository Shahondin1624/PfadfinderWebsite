package pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import shared.Card
import shared.CustomHorizontalDivider
import shared.H1
import shared.H2
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.calendarHeader
import website.composeapp.generated.resources.under_construction

@Composable
fun CalendarPage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(all = 10.dp).verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H1(text = stringResource(Res.string.calendarHeader), modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        Card(
            modifier = Modifier
                .padding(horizontal = 50.dp).padding(vertical = 10.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                H2(
                    text = "Currently in construction...",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Image(
                    painter = painterResource(Res.drawable.under_construction),
                    contentDescription = "Under construction",
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}