package uz.gita.paynetbank.presentation.ui.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import uz.gita.mobilebanking.domain.usecase.AuthUseCase
import uz.gita.paynetbank.data.model.common.data.request.SignUpRequestData
import uz.gita.paynetbank.utils.extension.onResource
import uz.gita.paynetbank.utils.extension.onSuccess
import uz.gita.paynetbank.utils.extension.onText
import javax.inject.Inject

@HiltViewModel
class SignUpViewModelImpl @Inject constructor(
    private val signUpScreenDirection: SignUpScreenDirection,
    private val authUseCase: AuthUseCase
) : ViewModel(), SignUpViewModel {

    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    override val signUpUiState: StateFlow<SignUpUiState>
        get() = _signUpUiState.asStateFlow()

    override fun eventDispatcher(signUpIntent: SignUpIntent) {
        when (signUpIntent) {
            is SignUpIntent.InformationOfUser -> {
                val signUpData = SignUpRequestData(
                    firstName = signUpIntent.firstname,
                    lastName = signUpIntent.lastName,
                    password = signUpIntent.password,
                    phone = signUpIntent.phoneNumber
                )
                authUseCase.signUpUser(signUpData)
                    .onEach { resultData ->
                        delay(2000)
                        resultData.onSuccess { Log.d("TTT", "onSuccess") }
                            .onText { Log.d("TTT", message) }
                            .onResource { Log.d("TTT", "onResource") }
                    }.launchIn(viewModelScope)
            }
        }
    }

}