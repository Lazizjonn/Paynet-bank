package uz.gita.paynetbank.domain.repositories

import uz.gita.paynetbank.data.model.common.LanguageData

interface AppRepository {
    fun isFirstTime(bool: Boolean)
    fun getIsFirstTime(): Boolean

    suspend fun getLanguagesList(): List<LanguageData>
    suspend fun chooseLanguage(language: String)
    suspend fun getCurrentLanguage(): String
}