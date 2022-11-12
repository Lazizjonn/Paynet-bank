package uz.gita.paynetbank.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.paynetbank.data.model.common.LanguageData

interface AppUseCase {
    fun isFirstTime(bool: Boolean)
    fun getIsFirstTime(): Boolean

    fun getLanguagesList(): Flow<List<LanguageData>>
    fun getCurrentLanguage(): Flow<String>
    fun chooseLanguage(language: String): Flow<Unit>
}