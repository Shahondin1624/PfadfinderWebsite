import androidx.compose.runtime.*
import index.Index
import theme.AppTheme

@Composable
fun App() {
    val isInDarkMode = remember { mutableStateOf(true) }
    AppTheme(isInDarkMode.value) {
        Index(isInDarkMode)
    }
}