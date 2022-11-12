package uz.gita.paynetbank.presentation.ui.privacy

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PrivacyPolicyViewModelImpl @Inject constructor(
    private val privacyPolicyScreenDirection: PrivacyPolicyScreenDirection
) : PrivacyPolicyViewModel, ViewModel() {
    private val _privacyPolicyUiState = MutableStateFlow(PrivacyPolicyUiState())
    override val privacyPolicyUiState: StateFlow<PrivacyPolicyUiState>
        get() = _privacyPolicyUiState.asStateFlow()

    override fun eventDispatcher(privacyPolicyIntent: PrivacyPolicyIntent) {
        when (privacyPolicyIntent) {
           PrivacyPolicyIntent.CHECK -> {
                reduce { it.copy(buttonAcceptStatus = !it.buttonAcceptStatus) }
            }
            PrivacyPolicyIntent.ACCEPT -> {
                privacyPolicyScreenDirection.navigateToSignInScreenFromPrivacy()
            }
        }
    }

    private fun reduce(content: (PrivacyPolicyUiState) -> PrivacyPolicyUiState) {
        val oldState = _privacyPolicyUiState.value
        val newState = content(oldState)
        _privacyPolicyUiState.value = newState
    }

}