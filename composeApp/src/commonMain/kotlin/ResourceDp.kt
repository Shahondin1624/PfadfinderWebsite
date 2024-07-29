import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object ResourceDp {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    private fun widthSizeClass(): WindowWidthSizeClass = calculateWindowSizeClass().widthSizeClass

    @Composable
    fun horizontalCardPadding(): Dp {
        return when (widthSizeClass()) {
            WindowWidthSizeClass.Compact -> 5.dp
            WindowWidthSizeClass.Medium -> 10.dp
            WindowWidthSizeClass.Expanded -> 20.dp
            else -> 5.dp
        }
    }
    val navigationButtonHorizontalPadding = 10.dp
    val verySmallPadding = 5.dp
    val smallPadding = 10.dp
    val mediumPadding = 25.dp
    val largePadding = 50.dp

    @Composable
    fun fieldSize(): Dp {
        return when (widthSizeClass()) {
            WindowWidthSizeClass.Compact -> 300.dp
            WindowWidthSizeClass.Medium -> 400.dp
            WindowWidthSizeClass.Expanded -> 800.dp
            else -> 1000.dp
        }
    }

    val smallGridCellSize = 200.dp
    val mediumGridCellSize = 300.dp
    val largeGridCellSize = 400.dp
}