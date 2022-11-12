package uz.gita.paynetbank.domain.repositories


import uz.gita.paynetbank.data.model.common.data.request.ConfirmRequestData
import uz.gita.paynetbank.data.model.common.data.request.SignUpRequestData
import uz.gita.paynetbank.utils.extension.ResultData

interface AuthRepository {
    suspend fun signUpUser(data: SignUpRequestData): ResultData<Unit>
    suspend fun sendCodeAndTakeTokens(data: ConfirmRequestData): ResultData<Unit>
}