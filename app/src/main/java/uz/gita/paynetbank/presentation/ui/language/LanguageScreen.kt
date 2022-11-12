package uz.gita.paynetbank.presentation.ui.language

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.github.terrakok.modo.android.compose.uniqueScreenKey
import kotlinx.parcelize.Parcelize
import uz.gita.paynetbank.data.model.common.LanguageData
import uz.gita.paynetbank.presentation.ui.language.component.LanguageItems
import uz.gita.paynetbank.presentation.ui.language.component.SetLanguage
import uz.gita.paynetbank.utils.components.AuthDefaultButton
import uz.gita.paynetbank.utils.components.AuthTitle
import uz.gita.paynetbank.utils.theme.PaynetBankTheme
import uz.gita.paynetbank.utils.theme.spacing

@Parcelize
class LanguageScreen(override val screenKey: String = uniqueScreenKey) : ComposeScreen("LanguageScreen") {
    @Composable
    override fun Content() {
        val viewModel: LanguageViewModel = viewModel<LanguageViewModelImpl>()
        val uiState = viewModel.languageUiState.collectAsState()
        LanguageScreenContent(languageUiState = uiState, eventDispatcher = viewModel::eventDispatcher)
    }
}

@[Composable]
fun LanguageScreenContent(
    languageUiState: State<LanguageUiState>,
    eventDispatcher: (LanguageIntent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        var listOfLanguages by remember { mutableStateOf<List<LanguageData>>(emptyList()) }
        var selectedLanguage by remember { mutableStateOf(languageUiState.value.currentLanguage) }

        Column(
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing_16dp,
            )
        ) {
            AuthTitle(text = languageUiState.value.titleText)

            Spacer(modifier = Modifier.weight(1f))

            if (languageUiState.value.languages.isNotEmpty()) {
                listOfLanguages = languageUiState.value.languages

                SetLanguage(language = languageUiState.value.currentLanguage)

                LanguageItems(
                    modifier = Modifier
                        .padding(
                            start = MaterialTheme.spacing.spacing_8dp,
                            end = MaterialTheme.spacing.spacing_8dp
                        ),
                    languages = listOfLanguages,
                    selectedLanguage = { language ->
                        selectedLanguage = language
                        eventDispatcher.invoke(LanguageIntent.Selected(selectedLanguage))
                    }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            AuthDefaultButton(
                onClick = { eventDispatcher(LanguageIntent.Next(selectedLanguage)) },
                modifier = Modifier,
                text = languageUiState.value.nextButtonText
            )
        }
    }
}


@[Composable Preview SuppressLint("UnrememberedMutableState")]
fun PreviewLanguageScreen() {
    PaynetBankTheme {
        LanguageScreenContent(languageUiState = mutableStateOf(LanguageUiState())) {}
    }
}