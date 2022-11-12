package uz.gita.mobilebanking.domain.usecase.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.paynetbank.data.model.common.data.request.ConfirmRequestData
import uz.gita.paynetbank.data.model.common.data.request.SignUpRequestData
import uz.gita.paynetbank.domain.repositories.AuthRepository
import uz.gita.mobilebanking.domain.usecase.AuthUseCase
import uz.gita.paynetbank.utils.extension.ResultData
import uz.gita.paynetbank.utils.extension.fail
import javax.inject.Inject


class AuthUseCaseImpl @Inject constructor(
    private val repository: AuthRepository
) : AuthUseCase {

    override fun signUpUser(data: SignUpRequestData): Flow<ResultData<Unit>> = flow {
        val res = repository.signUpUser(data)
        emit(res)
    }.catch { emit(ResultData.fail("Error $it")) }.flowOn(Dispatchers.IO)

    override suspend fun sendCodeAndTakeTokens(data: ConfirmRequestData): Flow<ResultData<Unit>> = flow {
        emit(repository.sendCodeAndTakeTokens(data))
    }.catch { emit(ResultData.fail("Error $it")) }

}