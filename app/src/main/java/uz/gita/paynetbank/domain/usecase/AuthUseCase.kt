package uz.gita.mobilebanking.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.paynetbank.data.model.common.data.request.ConfirmRequestData
import uz.gita.paynetbank.data.model.common.data.request.SignUpRequestData
import uz.gita.paynetbank.utils.extension.ResultData

interface AuthUseCase {

    fun signUpUser(data: SignUpRequestData): Flow<ResultData<Unit>>
    suspend fun sendCodeAndTakeTokens(data: ConfirmRequestData): Flow<ResultData<Unit>>

}