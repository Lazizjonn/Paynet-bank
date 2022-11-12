package uz.gita.paynetbank.presentation.ui.onboarding

import kotlinx.coroutines.flow.StateFlow

interface OnBoardingViewModel {
    fun eventDispatcher(onBoardingIntent: OnBoardingIntent)
    val onBoardingUiState: StateFlow<OnBoardingUiState>
}