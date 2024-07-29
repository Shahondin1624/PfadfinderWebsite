package pages

import ResourceDp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.stringResource
import shared.CustomCard
import shared.CustomHorizontalDivider
import shared.H1
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.boosterClubHeader

@Composable
fun BoosterClubPage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        H1(
            text = stringResource(Res.string.boosterClubHeader),
            modifier = Modifier.padding(vertical = ResourceDp.smallPadding)
        )
        CustomHorizontalDivider()
        CustomCard {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.fillMaxSize(),
                columns = StaggeredGridCells.Adaptive(ResourceDp.mediumGridCellSize),
                verticalItemSpacing = ResourceDp.largePadding,
                horizontalArrangement = Arrangement.SpaceAround,
                contentPadding = PaddingValues(ResourceDp.smallPadding),
                content = {

                })
        }
    }
}