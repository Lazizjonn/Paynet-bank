package uz.gita.paynetbank.presentation.ui.language

import uz.gita.paynetbank.R
import uz.gita.paynetbank.data.model.common.LanguageData

data class LanguageUiState(
    val titleText: Int = R.string.select_language_uz,
    val nextButtonText: Int = R.string.next_uz,
    val currentLanguage: String = "",
    val languages: List<LanguageData> = emptyList()
)