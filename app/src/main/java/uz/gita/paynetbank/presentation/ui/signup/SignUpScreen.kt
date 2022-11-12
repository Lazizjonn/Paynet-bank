package uz.gita.paynetbank.presentation.ui.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.github.terrakok.modo.android.compose.ComposeScreen
import com.github.terrakok.modo.android.compose.uniqueScreenKey
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.parcelize.Parcelize
import uz.gita.paynetbank.R
import uz.gita.paynetbank.utils.components.AuthButton
import uz.gita.paynetbank.utils.components.AuthTextField
import uz.gita.paynetbank.utils.components.AuthTitle
import uz.gita.paynetbank.utils.extension.PasswordTrailingIcon
import uz.gita.paynetbank.utils.extension.isPhoneNumber
import uz.gita.paynetbank.utils.extension.passwordVisualTransformation
import uz.gita.paynetbank.utils.extension.phoneNumberFilter
import uz.gita.paynetbank.utils.theme.PaynetBankTheme
import uz.gita.paynetbank.utils.theme.spacing

@Parcelize
class SignUpScreen(override val screenKey: String = uniqueScreenKey) : ComposeScreen(id = "SignInScreen") {
    @Composable
    override fun Content() {
        val viewModel: SignUpViewModel = viewModel<SignUpViewModelImpl>()
        val uiState = viewModel.signUpUiState.collectAsState()
        SignInScreenContent(signUpUiState = uiState, eventDispatcher = viewModel::eventDispatcher)
    }
}

@[Composable OptIn(ExperimentalPagerApi::class)]
fun SignInScreenContent(
    signUpUiState: State<SignUpUiState>,
    eventDispatcher: (SignUpIntent) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing_16dp,
                start = MaterialTheme.spacing.spacing_16dp,
                end = MaterialTheme.spacing.spacing_16dp
            )
        ) {
            var firstNameText by remember { mutableStateOf("") }
            var firstNameState by remember { mutableStateOf(false) }
            var firstNameError by remember { mutableStateOf(false) }

            var lastNameText by remember { mutableStateOf("") }
            var lastNameState by remember { mutableStateOf(false) }
            var lastNameError by remember { mutableStateOf(false) }

            var phoneNumberText by remember { mutableStateOf("+998") }
            var phoneNumberState by remember { mutableStateOf(false) }
            var phoneNumberError by remember { mutableStateOf(false) }

            var passwordText by remember { mutableStateOf("") }
            var passwordState by remember { mutableStateOf(false) }
            var passwordError by remember { mutableStateOf(false) }
            var passwordTrailingIconState by remember { mutableStateOf(false) }

            var checkBoxState by remember { mutableStateOf(false) }
            val signInButtonState by remember { mutableStateOf(true) }

            val focusManager = LocalFocusManager.current

            AuthTitle(modifier = Modifier.weight(1f), text = R.string.sign_in)

            AuthTextField(
                modifier = Modifier,
                label = R.string.name,
                value = firstNameText,
                onValueChange = { firstName ->
                    if (firstName.length >= 15) return@AuthTextField
                    if (firstNameError) firstNameError = false
                    firstNameText = firstName
                    firstNameState = firstNameText.length >= 3
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                isError = firstNameError,
                errorText = R.string.error_firstname
            )

            AuthTextField(
                modifier = Modifier.padding(top = MaterialTheme.spacing.spacing_16dp),
                label = R.string.name,
                value = lastNameText,
                onValueChange = { lastName ->
                    if (lastName.length >= 15) return@AuthTextField
                    if (lastNameError) lastNameError = false
                    lastNameText = lastName
                    lastNameState = lastNameText.length >= 3
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                isError = lastNameError,
                errorText = R.string.error_lastname
            )

            AuthTextField(
                modifier = Modifier.padding(top = MaterialTheme.spacing.spacing_16dp),
                label = R.string.phone_number,
                value = phoneNumberText,
                onValueChange = { phone ->
                    if (phone.length >= 14) return@AuthTextField
                    if (phoneNumberError) phoneNumberError = false
                    phoneNumberText = phone
                    phoneNumberState = phoneNumberText.isPhoneNumber()
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                visualTransformation = { phoneNumberFilter(it) },
                isError = phoneNumberError,
                errorText = R.string.phone_is_empty
            )

            AuthTextField(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.spacing_16dp),
                label = R.string.enter_password,
                value = passwordText,
                onValueChange = { password ->
                    if (password.length >= 20) return@AuthTextField
                    if (passwordError) passwordError = false
                    passwordText = password
                    passwordState = passwordText.length >= 6
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                visualTransformation = passwordVisualTransformation(passwordTrailingIconState),
                trailingIcon = {
                    PasswordTrailingIcon(onIconClick = {
                        passwordTrailingIconState = !passwordTrailingIconState
                    }, passwordVisible = passwordTrailingIconState)
                },
                isError = passwordError,
                errorText = R.string.field_is_empty
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.spacing_16dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Checkbox(
                    modifier = Modifier,
                    checked = checkBoxState,
                    onCheckedChange = { checkBoxState = !checkBoxState })

                Text(
                    text = stringResource(id = R.string.is_trusted_device)
                )
            }

            AuthButton(
                modifier = Modifier.padding(top = MaterialTheme.spacing.spacing_32dp),
                text = R.string.sign_in,
                enabled = true,
                onClick = {
                    if (!firstNameState) {
                        firstNameError = true
                        return@AuthButton
                    }

                    if (!lastNameState) {
                        lastNameError = true
                        return@AuthButton
                    }

                    if (!phoneNumberState) {
                        phoneNumberError = true
                        return@AuthButton
                    }
                    if (!passwordState) {
                        passwordError = true
                        return@AuthButton
                    }

                    eventDispatcher.invoke(
                        SignUpIntent.InformationOfUser(
                            firstname = firstNameText,
                            lastName = lastNameText,
                            phoneNumber = phoneNumberText,
                            password = passwordText
                        )
                    )

                }
            )

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@[Composable Preview SuppressLint("UnrememberedMutableState")]
fun PreviewSignInScreen() {
    PaynetBankTheme { SignInScreenContent(mutableStateOf(SignUpUiState())) {} }
}