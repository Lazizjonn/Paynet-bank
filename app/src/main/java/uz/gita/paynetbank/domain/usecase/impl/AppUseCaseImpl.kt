package uz.gita.mobilebanking.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.paynetbank.data.model.common.LanguageData
import uz.gita.paynetbank.domain.repositories.AppRepository
import uz.gita.paynetbank.domain.usecase.AppUseCase
import javax.inject.Inject

class AppUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : AppUseCase {
    override fun isFirstTime(bool: Boolean) {
        repository.isFirstTime(bool)
    }

    override fun getIsFirstTime(): Boolean = repository.getIsFirstTime()
    override fun getLanguagesList() = flow<List<LanguageData>> {
        emit(repository.getLanguagesList())
    }.flowOn(Dispatchers.IO)

    override fun chooseLanguage(language: String) = flow<Unit> {
        emit(repository.chooseLanguage(language))
    }.flowOn(Dispatchers.IO)

    override fun getCurrentLanguage() = flow<String> {
        emit(repository.getCurrentLanguage())
    }.flowOn(Dispatchers.IO)

}