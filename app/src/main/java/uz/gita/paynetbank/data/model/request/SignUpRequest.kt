package uz.gita.paynetbank.data.model.request

data class SignUpRequest(
    val firstName: String,
    val lastName: String,
    val password: String,
    val phone: String
)
