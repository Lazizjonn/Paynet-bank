package uz.gita.paynetbank.data.model.common

import uz.gita.paynetbank.R
import uz.gita.paynetbank.data.source.local.model.AppLanguage

data class LanguageData(
    val id: Int = 0,
    val icon :String = "",
    val language: Int = 0,
    val code: String = "",
    var isChecked: Boolean = false
)

fun LanguageData.languagesList(): List<LanguageData> = listOf(
    LanguageData(id = 1, icon = "\uD83C\uDDF7\uD83C\uDDFA",language = R.string.russian, code = AppLanguage.RUSSIAN.value),
    LanguageData(id = 2, icon = "\uD83C\uDDFA\uD83C\uDDFF",language = R.string.uzbek, code = AppLanguage.UZBEK.value, isChecked = true),
    LanguageData(id = 3, icon = "\uD83C\uDDEC\uD83C\uDDE7",language = R.string.english, code = AppLanguage.ENGLISH.value)
)

