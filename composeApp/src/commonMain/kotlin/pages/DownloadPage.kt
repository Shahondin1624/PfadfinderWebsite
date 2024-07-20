package pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.CustomCard
import shared.CustomHorizontalDivider
import shared.DownloadButton
import shared.H1
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.downloads

@Composable
fun DownloadPage() {
    val downloadContents = listOf("Sola_Patch.jpeg")
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        H1(text = stringResource(Res.string.downloads), modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        CustomCard {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                columns = StaggeredGridCells.Adaptive(300.dp),
                verticalItemSpacing = 50.dp,
                horizontalArrangement = Arrangement.SpaceAround,
                contentPadding = PaddingValues(10.dp),
                content = {
                    items(downloadContents) { fileName ->
                        DownloadButton(fileName)
                    }
                })
        }
    }
}