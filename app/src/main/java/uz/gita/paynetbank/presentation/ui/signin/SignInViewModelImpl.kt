package uz.gita.paynetbank.presentation.ui.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor(
    private val signInScreenDirection: SignInScreenDirection,

    ) : ViewModel(), SignInViewModel {

    private val _signInUiState = MutableStateFlow(SignInUiState())
    override val signInUiState: StateFlow<SignInUiState>
        get() = _signInUiState.asStateFlow()

    override fun eventDispatcher(signInIntent: SignInIntent) {
        when (signInIntent) {

            is SignInIntent.SignIn -> {

            }

            is SignInIntent.SignUp -> {
                signInScreenDirection.navigateToSignUpScreenFromSignIn()
            }

            is SignInIntent.ForgotPassword -> {

            }
        }
    }

}