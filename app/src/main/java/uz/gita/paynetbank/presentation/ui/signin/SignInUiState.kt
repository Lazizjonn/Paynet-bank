package uz.gita.paynetbank.presentation.ui.signin

data class SignInUiState(
    val isProgress: Boolean = false,
    val forgotPasswordEnabled: Boolean = true,
    val enterButtonEnabled: Boolean = true,
    val signUpButtonEnabled: Boolean = true,
)