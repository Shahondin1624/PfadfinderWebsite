import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLAnchorElement

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("Pfadfinder Stamm Löwe von Schönborn") {
        App()
    }
}

actual fun openWindow(url: String) {
    window.open(url, "_blank")
}

actual fun download(fileName: String) {
    val url = window.location.href + "/downloads/$fileName"
    val anchorElement = document.createElement("a") as HTMLAnchorElement
    anchorElement.href = url
    anchorElement.download = fileName
    anchorElement.click()
}