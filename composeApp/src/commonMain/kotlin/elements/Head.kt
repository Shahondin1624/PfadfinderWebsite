package elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import shared.H1
import website.composeapp.generated.resources.Res
import website.composeapp.generated.resources.logo

@Composable
fun Head() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(horizontal = 50.dp)) {
        H1(text = "Stamm Löwe von Schönborn")
        Spacer(Modifier.height(20.dp))
        Image(painter = painterResource(Res.drawable.logo), contentDescription = "Stammeswappen", modifier = Modifier.size(100.dp))
    }
}

@Composable
fun WithHead(content: @Composable () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Head()
        Spacer(Modifier.height(20.dp))
        content()
    }
}