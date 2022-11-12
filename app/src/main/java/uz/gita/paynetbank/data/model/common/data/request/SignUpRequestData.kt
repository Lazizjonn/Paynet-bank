package uz.gita.paynetbank.data.model.common.data.request


data class SignUpRequestData(
    val firstName: String,
    val lastName: String,
    val password: String,
    val phone: String
)

