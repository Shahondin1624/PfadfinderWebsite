import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("ComposeApp") {
        App()
    }
}

actual fun openWindow(url: String) {
    window.open(url, "_blank")
}