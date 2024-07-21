package pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import shared.CustomCard
import shared.CustomHorizontalDivider
import shared.H1
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.boosterClubHeader

@Composable
fun BoosterClubPage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        H1(text = stringResource(Res.string.boosterClubHeader), modifier = Modifier.padding(vertical = 10.dp))
        CustomHorizontalDivider()
        CustomCard {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                columns = StaggeredGridCells.Adaptive(300.dp),
                verticalItemSpacing = 50.dp,
                horizontalArrangement = Arrangement.SpaceAround,
                contentPadding = PaddingValues(10.dp),
                content = {

                })
        }
    }
}