package uz.gita.paynetbank.presentation.ui.onboarding

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModelImpl @Inject constructor(
    private val onBoardingScreenDirection: OnBoardingScreenDirection
) : OnBoardingViewModel, ViewModel() {

    private var _onBoardingUiState = MutableStateFlow(OnBoardingUiState())
    override val onBoardingUiState: StateFlow<OnBoardingUiState>
        get() = _onBoardingUiState.asStateFlow()

    override fun eventDispatcher(onBoardingIntent: OnBoardingIntent) {
        when (onBoardingIntent) {
            OnBoardingIntent.SKIP -> {
                onBoardingScreenDirection.navigateToTermsConditionScreenFromOnBoarding()
            }
            OnBoardingIntent.START -> {
                onBoardingScreenDirection.navigateToTermsConditionScreenFromOnBoarding()
            }
        }
    }

    private fun reduce(content: (old: OnBoardingUiState) -> OnBoardingUiState) {
        val oldState = _onBoardingUiState.value
        val newState = content(oldState)
        _onBoardingUiState.value = newState
    }
}