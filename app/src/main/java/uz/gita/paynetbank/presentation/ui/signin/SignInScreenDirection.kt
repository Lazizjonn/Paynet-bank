package uz.gita.paynetbank.presentation.ui.signin

interface SignInScreenDirection {
    fun navigateToSignUpScreenFromSignIn()
    fun navigateToAccountRecoveryScreenFromSignIn()
    fun navigateToMainScreenFromSignIn()
}