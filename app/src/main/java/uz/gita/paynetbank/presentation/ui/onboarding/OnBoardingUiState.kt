package uz.gita.paynetbank.presentation.ui.onboarding

import uz.gita.paynetbank.R
import uz.gita.paynetbank.data.model.common.OnboardData

class OnBoardingUiState {
    val onboardList: List<OnboardData> = listOf(
        OnboardData(
            id = 1,
            image = R.drawable.onboarding1,
            title = R.string.onboard_title1,
            description = R.string.onboard_description1
        ),
        OnboardData(
            id = 2,
            image = R.drawable.onboarding2,
            title = R.string.onboard_title2,
            description = R.string.onboard_description2
        ),
        OnboardData(
            id = 3,
            image = R.drawable.onboarding3,
            title = R.string.onboard_title3,
            description = R.string.onboard_description3
        ),
        OnboardData(
            id = 4,
            image = R.drawable.onboarding4,
            title = R.string.onboard_title4,
            description = R.string.onboard_description4
        )
    )
}