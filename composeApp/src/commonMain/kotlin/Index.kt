import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import elements.BottomBar
import navigation.Routes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import pages.*
import shared.H1
import website.composeapp.generated.resources.*
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.logo
import website.composeapp.generated.resources.stamm
import website.composeapp.generated.resources.stufen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Index(isInDarkMode: MutableState<Boolean>) {
    val navController = rememberNavController()
    Scaffold(topBar = {
        TopAppBar(title = {
            H1(text = "Stamm Löwe von Schönborn", modifier = Modifier.padding(start = 50.dp))
        }, navigationIcon = {
            IconButton(
                onClick = { navController.navigate(Routes.TRIBE.name) },
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Icon(painter = painterResource(Res.drawable.logo), contentDescription = "Logo")
            }
        }, actions = {
            Row(horizontalArrangement = Arrangement.Center) {
                Button(
                    onClick = { navController.navigate(Routes.TRIBE.name) },
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = stringResource(Res.string.stamm))
                }
                Button(
                    onClick = { navController.navigate(Routes.STAGES.name) },
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = stringResource(Res.string.stufen))
                }
                Button(
                    onClick = { navController.navigate(Routes.CALENDAR.name) },
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = stringResource(Res.string.kalender))
                }
                Button(
                    onClick = { navController.navigate(Routes.IMAGES.name) },
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = stringResource(Res.string.bilder))
                }
                Button(
                    onClick = { navController.navigate(Routes.COPYRIGHT.name) },
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Text(text = stringResource(Res.string.impressum))
                }
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
        })
    },
        bottomBar = {
            BottomBar(navigator = navController)
        }) { innerPadding ->
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
            composable(route = Routes.COPYRIGHT.name) {
                CopyrightPage()
            }
        }
    }
}