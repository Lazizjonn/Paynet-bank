package uz.gita.paynetbank.domain.mapper

import uz.gita.paynetbank.data.model.common.data.request.ConfirmRequestData
import uz.gita.paynetbank.data.model.common.data.request.SignUpRequestData
import uz.gita.paynetbank.data.model.request.ConfirmRequest
import uz.gita.paynetbank.data.model.request.SignUpRequest

object MapperToRequest {
    fun ConfirmRequestData.toConfirmRequest(): ConfirmRequest = ConfirmRequest(code = code)
    fun SignUpRequestData.toSignUpRequest(): SignUpRequest = SignUpRequest(firstName = firstName, lastName = lastName, password = password, phone = phone)
}