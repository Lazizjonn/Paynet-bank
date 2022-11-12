package uz.gita.paynetbank.presentation.ui.signin

sealed class SignInIntent {
    object SignUp : SignInIntent()
    data class ForgotPassword(val phoneNumber: String) : SignInIntent()
    data class SignIn(
        val phoneNumber: String,
        val password: String,
        val isTrustedDevice: Boolean
    ) : SignInIntent()
}