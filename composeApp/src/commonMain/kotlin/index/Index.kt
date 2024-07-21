package index

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import navigation.Routes
import org.jetbrains.compose.resources.stringResource
import pages.*
import website.composeapp.generated.resources.*

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Index(isInDarkMode: MutableState<Boolean>) {
    val navController = rememberNavController()
    val windowSizeClass = calculateWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact, WindowWidthSizeClass.Medium -> {
            CompactLayout(isInDarkMode, navController)
        }

        WindowWidthSizeClass.Expanded -> {
            LandscapeLayout(isInDarkMode, navController)
        }
    }
}

fun LazyListScope.createNavigationButtons(navController: NavHostController) {
    item {
        Button(
            onClick = { navController.navigate(Routes.TRIBE.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.stamm))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.STAGES.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.stufen))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.CALENDAR.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.kalender))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.IMAGES.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.bilder))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.DOWNLOADS.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.downloads))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.PAYPAL.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.paypal))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.FOERDERVEREIN.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.boosterClubHeader))
        }
    }
    item {
        Button(
            onClick = { navController.navigate(Routes.COPYRIGHT.name) },
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Text(text = stringResource(Res.string.impressum))
        }
    }
}

@Composable
fun ThemeButton(isInDarkMode: MutableState<Boolean>) {
    var themeModeText by remember { mutableStateOf("White Mode") }
    Button(
        onClick = {
            isInDarkMode.value = !isInDarkMode.value
            themeModeText = if (!isInDarkMode.value) "Dark Mode" else "White Mode"
        },
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Text(text = themeModeText)
    }
}

@Composable
fun NavHostGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    Surface(color = MaterialTheme.colorScheme.inversePrimary) {
        NavHost(
            navController = navController,
            startDestination = Routes.TRIBE.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Routes.TRIBE.name) {
                TribePage()
            }
            composable(route = Routes.STAGES.name) {
                StagesPage()
            }
            composable(route = Routes.CALENDAR.name) {
                CalendarPage()
            }
            composable(route = Routes.IMAGES.name) {
                ImagesPage()
            }
            composable(route = Routes.DOWNLOADS.name) {
                DownloadPage()
            }
            composable(route = Routes.PAYPAL.name) {
                PaypalPage()
            }
            composable(route = Routes.FOERDERVEREIN.name) {
                BoosterClubPage()
            }
            composable(route = Routes.COPYRIGHT.name) {
                CopyrightPage()
            }
        }
    }
}