package uz.gita.paynetbank.domain.repositories.impl



import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.gita.paynetbank.data.model.common.data.request.ConfirmRequestData
import uz.gita.paynetbank.data.model.common.data.request.SignUpRequestData
import uz.gita.paynetbank.data.source.local.sharedPref.MySharedPref
import uz.gita.paynetbank.data.source.remote.api.auth.AuthApi
import uz.gita.paynetbank.domain.mapper.MapperToRequest
import uz.gita.paynetbank.domain.repositories.AuthRepository
import uz.gita.paynetbank.utils.extension.*
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPref: MySharedPref,
    private val api: AuthApi
) : AuthRepository {

    override suspend fun signUpUser(data: SignUpRequestData): ResultData<Unit> = withContext(Dispatchers.IO) {
        val request = MapperToRequest.run { data.toSignUpRequest() }
        val result = api.signUpUser(request).resultCodeCheck()
        when {
            result.isSuccess -> {
                sharedPref.accessToken = result.asSuccess.data.token!!
                ResultData.Success(Unit)
            }
            else -> result.asFail
        }

    }

    override suspend fun sendCodeAndTakeTokens(data: ConfirmRequestData): ResultData<Unit> = withContext(Dispatchers.IO) {
        val request = MapperToRequest.run { data.toConfirmRequest() }
        val result = api.sendCodeAndTakeTokens("Bearer ${sharedPref.accessToken}", request).resultCodeCheck()
        when {
            result.isSuccess -> {
                sharedPref.accessToken = result.asSuccess.data.accessToken
                sharedPref.refreshToken = result.asSuccess.data.refreshToken
                ResultData.Success(Unit)
            }
            else -> result.asFail
        }
    }

}