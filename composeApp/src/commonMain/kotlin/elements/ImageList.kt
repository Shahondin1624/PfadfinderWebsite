package elements

import ResourceDp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.ResourceAccessor
import shared.CustomImage

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ImageList(images: List<ResourceAccessor>, modifier: Modifier = Modifier) {
    val widthSizeClass = calculateWindowSizeClass().widthSizeClass
    val imageWidth = when (widthSizeClass) {
        WindowWidthSizeClass.Compact -> 300
        WindowWidthSizeClass.Medium -> 400
        WindowWidthSizeClass.Expanded -> 600
        else -> {
            300
        }
    }.dp
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(imageWidth),
            verticalItemSpacing = ResourceDp.largePadding,
            horizontalArrangement = Arrangement.SpaceBetween,
            content = {
                itemsIndexed(images) { _, image ->
                    CustomImage(
                        resourceAccessor = image,
                        contentDescription = null,
                        modifier = Modifier.padding(horizontal = ResourceDp.mediumPadding)
                    )
                }
            }
        )
    }
}