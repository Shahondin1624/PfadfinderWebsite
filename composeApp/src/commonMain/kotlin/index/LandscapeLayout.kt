package index

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import elements.BottomBar
import navigation.Routes
import org.jetbrains.compose.resources.painterResource
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.icon_logo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LandscapeLayout(isInDarkMode: MutableState<Boolean>, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { }, navigationIcon = {
                IconButton(
                    onClick = { navController.navigate(Routes.TRIBE.name) },
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Icon(painter = painterResource(Res.drawable.icon_logo), contentDescription = "Logo")
                }
            }, actions = {
                LazyRow(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(start = 25.dp)) {
                    createNavigationButtons(navController)
                    item {
                        ThemeButton(isInDarkMode)
                    }
                }
            })
        },
        bottomBar = {
            BottomBar(navigator = navController)
        },
    ) { innerPadding ->
        NavHostGraph(navController, innerPadding)
    }
}
