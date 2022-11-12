package uz.gita.paynetbank.presentation.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.paynetbank.domain.usecase.AppUseCase
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val useCase: AppUseCase,
    private val splashScreenDirection: SplashScreenDirection
) : ViewModel(), SplashViewModel {

    init {
        viewModelScope.launch {
            delay(2000)
            if (useCase.getIsFirstTime()) splashScreenDirection.navigateToLanguageScreenFromSplash()
            else splashScreenDirection.navigateToSignInScreenFromSplash()
        }
    }
}