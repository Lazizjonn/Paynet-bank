package uz.gita.paynetbank.presentation.ui.language

import kotlinx.coroutines.flow.StateFlow
import uz.gita.paynetbank.presentation.ui.language.LanguageIntent
import uz.gita.paynetbank.presentation.ui.language.LanguageUiState

interface LanguageViewModel {
    fun eventDispatcher(languageIntent: LanguageIntent)
    val languageUiState: StateFlow<LanguageUiState>
}