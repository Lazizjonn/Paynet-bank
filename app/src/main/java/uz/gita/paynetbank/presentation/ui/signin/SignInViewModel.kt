package uz.gita.paynetbank.presentation.ui.signin

import kotlinx.coroutines.flow.StateFlow

interface SignInViewModel {

    val signInUiState: StateFlow<SignInUiState>

    fun eventDispatcher(signInIntent: SignInIntent)
}