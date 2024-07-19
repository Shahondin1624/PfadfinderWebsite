package pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import elements.DataProtection
import elements.Haftungsausschluss
import elements.Impressum

@Composable
fun CopyrightPage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.inversePrimary)
            .padding(all = 10.dp).verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 50.dp).padding(vertical = 10.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .shadow(elevation = 5.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Impressum()
                Haftungsausschluss()
                DataProtection()
            }
        }
    }
}