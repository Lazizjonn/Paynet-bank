package uz.gita.paynetbank.domain.repositories.impl

import uz.gita.paynetbank.data.model.common.LanguageData
import uz.gita.paynetbank.data.model.common.languagesList
import uz.gita.paynetbank.data.source.local.sharedPref.MySharedPref
import uz.gita.paynetbank.domain.repositories.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val sharedPref: MySharedPref
) : AppRepository {

    override fun isFirstTime(bool: Boolean) {
        sharedPref.isFirstTime = bool
    }

    override fun getIsFirstTime(): Boolean = sharedPref.isFirstTime
    override suspend fun getLanguagesList(): List<LanguageData> = LanguageData().languagesList()

    override suspend fun chooseLanguage(language: String) {
        sharedPref.language = language
    }

    override suspend fun getCurrentLanguage(): String = sharedPref.language
}