package uz.gita.paynetbank.presentation.ui.language

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.gita.paynetbank.R
import uz.gita.paynetbank.data.source.local.model.AppLanguage
import uz.gita.paynetbank.domain.usecase.AppUseCase
import javax.inject.Inject

@HiltViewModel
class LanguageViewModelImpl @Inject constructor(
    private val appUseCase: AppUseCase,
    private val languageScreenDirection: LanguageScreenDirection
) : ViewModel(), LanguageViewModel {

    private var _languageUiState = MutableStateFlow(LanguageUiState())
    override val languageUiState: StateFlow<LanguageUiState>
        get() = _languageUiState.asStateFlow()

    init {
        setCurrentLanguage()
        getLanguages()
    }

    override fun eventDispatcher(languageIntent: LanguageIntent) {
        when (languageIntent) {
            is LanguageIntent.Selected -> {
                setUILanguage(languageIntent.selectedLanguage)
            }
            is LanguageIntent.Next -> {
                viewModelScope.launch {
                    appUseCase
                        .chooseLanguage(languageIntent.selectedLanguage)
                        .collectLatest { reduce { it.copy(currentLanguage = languageIntent.selectedLanguage) } }
                }
                languageScreenDirection.navigateToOnBoardingScreenFromLanguage()
            }
        }
    }

    private fun setCurrentLanguage() {
        viewModelScope.launch {
            appUseCase
                .getCurrentLanguage()
                .collectLatest { language -> setUILanguage(language) }
        }
    }

    private fun getLanguages() {
        viewModelScope.launch {
            appUseCase
                .getLanguagesList()
                .collectLatest { languages -> reduce { it.copy(languages = languages) } }
        }
    }

    private fun setUILanguage(language: String) {
        reduce { it.copy(currentLanguage = language) }
        when (language) {
            AppLanguage.UZBEK.value -> reduce {
                it.copy(
                    titleText = R.string.select_language_uz,
                    nextButtonText = R.string.next_uz
                )
            }
            AppLanguage.RUSSIAN.value -> reduce {
                it.copy(
                    titleText = R.string.select_language_ru,
                    nextButtonText = R.string.next_ru
                )
            }
            AppLanguage.ENGLISH.value -> reduce {
                it.copy(
                    titleText = R.string.select_language_en,
                    nextButtonText = R.string.next_en
                )
            }
        }
    }

    private fun reduce(content: (old: LanguageUiState) -> LanguageUiState) {
        val oldState = _languageUiState.value
        val newState = content(oldState)
        _languageUiState.value = newState
    }

}