package uz.gita.paynetbank.presentation.ui.privacy

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.github.terrakok.modo.android.compose.uniqueScreenKey
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.parcelize.Parcelize
import uz.gita.paynetbank.R
import uz.gita.paynetbank.presentation.ui.privacy.components.AppIcon
import uz.gita.paynetbank.utils.components.AuthButton
import uz.gita.paynetbank.utils.components.AuthTitle
import uz.gita.paynetbank.utils.theme.PaynetBankTheme
import uz.gita.paynetbank.utils.theme.spacing

@Parcelize
class PrivacyPolicyScreen(override val screenKey: String = uniqueScreenKey) : ComposeScreen(id = "PrivacyPolicyScreen") {

    @Composable
    override fun Content() {
        val viewModel: PrivacyPolicyViewModel = viewModel<PrivacyPolicyViewModelImpl>()
        val uiState = viewModel.privacyPolicyUiState.collectAsState()
        PrivacyPolicyScreenContent(privacyPolicyUiState = uiState, eventDispatcher = viewModel::eventDispatcher)
    }
}

@[Composable OptIn(ExperimentalPagerApi::class)]
fun PrivacyPolicyScreenContent(
    privacyPolicyUiState: State<PrivacyPolicyUiState>,
    eventDispatcher: (PrivacyPolicyIntent) -> Unit
) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState()))
    {

        AuthTitle(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing_16dp),
            text = R.string.privacy_policy
        )

        AppIcon(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.spacing_16dp,
                    top = MaterialTheme.spacing.spacing_48dp
                )
        )

        Text(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.spacing_16dp,
                    top = MaterialTheme.spacing.spacing_16dp
                ),
            text = stringResource(id = R.string.privacy_policy_service),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.W600
            )
        )

        Text(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.spacing_16dp,
                    end = MaterialTheme.spacing.spacing_16dp,
                    top = 8.dp
                ),
            text = stringResource(id = R.string.privacy_policy_text),
            style = MaterialTheme.typography.body2,
        )

        Row(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.spacing_4dp,
                    top = MaterialTheme.spacing.spacing_16dp,
                    bottom = 26.dp
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = privacyPolicyUiState.value.buttonAcceptStatus,
                onClick = { eventDispatcher(PrivacyPolicyIntent.CHECK) },
            )
            Text(
                text = stringResource(id = R.string.privacy_policy_agreement),
                style = MaterialTheme.typography.body2.copy(
                    when (privacyPolicyUiState.value.buttonAcceptStatus) {
                        false -> MaterialTheme.colors.secondaryVariant
                        else -> MaterialTheme.colors.secondary
                    }
                )
            )
        }

        AuthButton(
            onClick = { eventDispatcher(PrivacyPolicyIntent.ACCEPT) },
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.spacing_16dp,
                    end = MaterialTheme.spacing.spacing_16dp,
                    bottom = 32.dp
                ),
            enabled = privacyPolicyUiState.value.buttonAcceptStatus,
            text = R.string.accept
        )
    }
}

@[Composable Preview SuppressLint("UnrememberedMutableState")]
fun PreviewPrivacyPolicyScreen() {
    PaynetBankTheme { PrivacyPolicyScreenContent(mutableStateOf(PrivacyPolicyUiState())) {} }
}