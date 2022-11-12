package uz.gita.paynetbank.navigation

import com.github.terrakok.modo.Modo
import com.github.terrakok.modo.forward
import com.github.terrakok.modo.replace
import uz.gita.paynetbank.presentation.ui.language.LanguageScreenDirection
import uz.gita.paynetbank.presentation.ui.onboarding.OnBoardingScreenDirection
import uz.gita.paynetbank.presentation.ui.privacy.PrivacyPolicyScreenDirection
import uz.gita.paynetbank.presentation.ui.signin.SignInScreenDirection
import uz.gita.paynetbank.presentation.ui.signup.SignUpScreenDirection
import uz.gita.paynetbank.presentation.ui.splash.SplashScreenDirection
import javax.inject.Inject


class AppNavigation @Inject constructor(modo: Modo, appGraph: AppGraph) {
    val splashScreenDirection = object : SplashScreenDirection {
        override fun navigateToLanguageScreenFromSplash() = modo.replace(appGraph.languageScreen())
        override fun navigateToSignInScreenFromSplash() = modo.replace(appGraph.languageScreen())
    }

    val languageScreenDirection = object : LanguageScreenDirection {
        override fun navigateToOnBoardingScreenFromLanguage() {
            modo.forward(appGraph.onBoardingScreen())
        }
    }

    val onBoardingScreenDirection = object : OnBoardingScreenDirection {
        override fun navigateToTermsConditionScreenFromOnBoarding() {
            modo.forward(appGraph.privacyPolicyScreen())
        }
    }

    val privacyPolicyScreenDirection = object : PrivacyPolicyScreenDirection {
        override fun navigateToSignInScreenFromPrivacy() {
            modo.forward(appGraph.signInScreen())
        }
    }

    val signInScreenDirection = object : SignInScreenDirection {
        override fun navigateToSignUpScreenFromSignIn() {
            modo.forward(appGraph.signUpScreen())
        }

        override fun navigateToAccountRecoveryScreenFromSignIn() {
            TODO("Not yet implemented")
        }

        override fun navigateToMainScreenFromSignIn() {
            TODO("Not yet implemented")
        }
    }

    val signUpScreenDirection = object : SignUpScreenDirection {
        override fun navigateToCodeVerifyScreenFromSignUp() {
            TODO("Not yet implemented")
        }

    }

}