package uz.gita.paynetbank.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.github.terrakok.modo.android.compose.uniqueScreenKey
import kotlinx.parcelize.Parcelize
import uz.gita.paynetbank.R
import uz.gita.paynetbank.utils.theme.PaynetBankTheme

@Parcelize
class SplashScreen(override val screenKey: String = uniqueScreenKey) : ComposeScreen("SplashScreen") {
    @Composable
    override fun Content() {
        SplashScreenContent()
        val viewModel: SplashViewModel = viewModel<SplashViewModelImpl>()
    }
}

@Composable
fun SplashScreenContent() {
    androidx.compose.material.Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_gita),
                contentDescription = ""
            )
            Text(
                text = stringResource(id = R.string.text_bank),
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.W500,
                    fontFamily = FontFamily.SansSerif,
                    color = MaterialTheme.colors.primary
                )
            )
        }
    }
}


@[Preview Composable]
fun PreviewSplashScreen() {
    PaynetBankTheme { SplashScreenContent() }
}