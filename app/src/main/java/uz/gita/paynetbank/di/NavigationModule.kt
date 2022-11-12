package uz.gita.paynetbank.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.paynetbank.navigation.AppNavigation
import uz.gita.paynetbank.presentation.ui.language.LanguageScreenDirection
import uz.gita.paynetbank.presentation.ui.onboarding.OnBoardingScreenDirection
import uz.gita.paynetbank.presentation.ui.privacy.PrivacyPolicyScreenDirection
import uz.gita.paynetbank.presentation.ui.signin.SignInScreenDirection
import uz.gita.paynetbank.presentation.ui.signup.SignUpScreenDirection
import uz.gita.paynetbank.presentation.ui.splash.SplashScreenDirection

@[Module InstallIn(ViewModelComponent::class)]
class NavigationModule {
    @Provides
    fun splashScreenDirection(appNavigation: AppNavigation): SplashScreenDirection = appNavigation.splashScreenDirection

    @Provides
    fun languageScreenDirection(appNavigation: AppNavigation): LanguageScreenDirection = appNavigation.languageScreenDirection

    @Provides
    fun onBoardingScreenDirection(appNavigation: AppNavigation): OnBoardingScreenDirection = appNavigation.onBoardingScreenDirection

    @Provides
    fun privacyPolicyDirection(appNavigation: AppNavigation): PrivacyPolicyScreenDirection = appNavigation.privacyPolicyScreenDirection

    @Provides
    fun signInDirection(appNavigation: AppNavigation): SignInScreenDirection = appNavigation.signInScreenDirection

    @Provides
    fun signUpDirection(appNavigation: AppNavigation): SignUpScreenDirection = appNavigation.signUpScreenDirection
}