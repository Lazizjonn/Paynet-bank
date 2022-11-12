package uz.gita.paynetbank.presentation.ui.language


sealed class LanguageIntent {
    data class Next(val selectedLanguage: String) : LanguageIntent()
    data class Selected(val selectedLanguage: String) : LanguageIntent()
}