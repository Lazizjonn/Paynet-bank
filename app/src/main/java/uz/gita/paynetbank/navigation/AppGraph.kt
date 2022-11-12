package uz.gita.paynetbank.navigation

import uz.gita.paynetbank.presentation.ui.language.LanguageScreen
import uz.gita.paynetbank.presentation.ui.onboarding.OnBoardingScreen
import uz.gita.paynetbank.presentation.ui.privacy.PrivacyPolicyScreen
import uz.gita.paynetbank.presentation.ui.signin.SignInScreen
import uz.gita.paynetbank.presentation.ui.signup.SignUpScreen
import uz.gita.paynetbank.presentation.ui.splash.SplashScreen


class AppGraph {
    fun splashScreen() = SplashScreen()
    fun languageScreen() = LanguageScreen()
    fun onBoardingScreen() = OnBoardingScreen()
    fun privacyPolicyScreen() = PrivacyPolicyScreen()
    fun signInScreen() = SignInScreen()
    fun signUpScreen() = SignUpScreen()
}