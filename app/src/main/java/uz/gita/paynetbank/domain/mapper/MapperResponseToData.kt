package uz.gita.paynetbank.domain.mapper

import uz.gita.paynetbank.data.model.common.data.response.ConfirmResponseData
import uz.gita.paynetbank.data.model.common.data.response.SignUpResponseData
import uz.gita.paynetbank.data.model.response.ConfirmResponse
import uz.gita.paynetbank.data.model.response.SignUpResponse


object MapperResponseToData {
    fun SignUpResponse.toSignUpResponseData(): SignUpResponseData = SignUpResponseData(token = token ?: "", message = message ?: "")
    fun ConfirmResponse.toConfirmResponseData(): ConfirmResponseData = ConfirmResponseData(accessToken = accessToken, refreshToken = refreshToken)
}