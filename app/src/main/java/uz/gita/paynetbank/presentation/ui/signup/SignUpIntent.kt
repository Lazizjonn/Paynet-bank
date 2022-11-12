package uz.gita.paynetbank.presentation.ui.signup

sealed class SignUpIntent {
    class InformationOfUser(
        val firstname: String = "",
        val lastName: String = "",
        val phoneNumber: String = "",
        val password: String = "",
    ) : SignUpIntent()
}