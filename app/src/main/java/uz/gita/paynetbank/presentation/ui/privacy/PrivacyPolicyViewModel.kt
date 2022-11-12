package uz.gita.paynetbank.presentation.ui.privacy

import kotlinx.coroutines.flow.StateFlow

interface PrivacyPolicyViewModel {
    val privacyPolicyUiState: StateFlow<PrivacyPolicyUiState>

    fun eventDispatcher(privacyPolicyIntent: PrivacyPolicyIntent)
}