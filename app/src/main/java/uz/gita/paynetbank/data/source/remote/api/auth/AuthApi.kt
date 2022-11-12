package uz.gita.paynetbank.data.source.remote.api.auth

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import uz.gita.paynetbank.data.model.request.ConfirmRequest
import uz.gita.paynetbank.data.model.request.SignUpRequest
import uz.gita.paynetbank.data.model.response.ConfirmResponse
import uz.gita.paynetbank.data.model.response.SignUpResponse
import uz.gita.paynetbank.data.model.response.TokenResponse

interface AuthApi {

    @POST("/auth/sign-up")
    suspend fun signUpUser(@Body data: SignUpRequest): Response<SignUpResponse>

    @POST("/auth/sign-up/verify")
    suspend fun sendCodeAndTakeTokens(
        @Header("Authorization") token : String,
        @Body data : ConfirmRequest
    ): Response<ConfirmResponse>

    @POST("")
    fun refreshToken(refresh : String) : Call<TokenResponse>

    @POST("")
    fun deleteUser()

}