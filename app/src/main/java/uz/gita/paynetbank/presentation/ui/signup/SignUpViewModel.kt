package uz.gita.paynetbank.presentation.ui.signup

import kotlinx.coroutines.flow.StateFlow

interface SignUpViewModel {

    val signUpUiState: StateFlow<SignUpUiState>

    fun eventDispatcher(signUpIntent: SignUpIntent)
}