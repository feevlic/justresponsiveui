package com.feevlic.justresponsiveui.auth.register.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.feevlic.justresponsiveui.auth.login.presentation.components.LoginThirdPartySection
import com.feevlic.justresponsiveui.auth.register.presentation.components.RegisterFormSection
import com.feevlic.justresponsiveui.auth.register.presentation.components.RegisterHeaderSection
import com.feevlic.justresponsiveui.auth.shared.presentation.SharedAuthViewModel
import com.feevlic.justresponsiveui.util.DeviceConfiguration

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    sharedAuthViewModel: SharedAuthViewModel,
    viewModel: RegisterViewModel = hiltViewModel(),
) {
    val focusManager = LocalFocusManager.current
    val prefilledEmail by sharedAuthViewModel.email.collectAsState()
    val emailText by viewModel.email.collectAsState()
    val passwordText by viewModel.password.collectAsState()
    val emailError by viewModel.emailError.collectAsState()
    val passwordError by viewModel.passwordError.collectAsState()

    LaunchedEffect(prefilledEmail) {
        if (prefilledEmail.isNotBlank()) {
            viewModel.setEmail(prefilledEmail)
        }
    }

    val passwordErrorMessage =
        "Password must be at least 8 characters, include one uppercase letter and one digit."
    val emailErrorMessage = "Please enter a valid email address"

    Scaffold(
        modifier = Modifier.fillMaxSize(), contentWindowInsets = WindowInsets.statusBars
    ) { innerPadding ->

        val rootModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp, topEnd = 15.dp
                )
            )
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(
                horizontal = 16.dp, vertical = 24.dp
            )
            .consumeWindowInsets(WindowInsets.navigationBars)
            .pointerInput(Unit) {
                detectTapGestures(onTap = { focusManager.clearFocus() })
            }

        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
        when (deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT -> {
                Column(
                    modifier = rootModifier,
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RegisterHeaderSection(modifier = Modifier.fillMaxWidth())
                    RegisterFormSection(
                        nameText = "",
                        onNameTextChange = {},
                        emailText = emailText,
                        onEmailTextChange = { viewModel.onEmailChanged(it) },
                        passwordText = passwordText,
                        onPasswordTextChange = { viewModel.onPasswordChanged(it) },
                        modifier = Modifier.fillMaxWidth(),
                        emailError = emailError,
                        emailErrorMessage = emailErrorMessage,
                        passwordError = passwordError,
                        passwordErrorMessage = passwordErrorMessage,
                        onSignupClick = { viewModel.onSignupClicked() })
                    LoginThirdPartySection(
                        modifier = Modifier.fillMaxWidth(), buttonModifier = Modifier.fillMaxWidth()
                    )
                }
            }

            DeviceConfiguration.MOBILE_LANDSCAPE -> {
                Row(
                    modifier = rootModifier
                        .padding(horizontal = 32.dp)
                        .windowInsetsPadding(WindowInsets.displayCutout),
                    horizontalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    RegisterHeaderSection(modifier = modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        RegisterFormSection(
                            nameText = "",
                            onNameTextChange = {},
                            emailText = emailText,
                            onEmailTextChange = { viewModel.onEmailChanged(it) },
                            passwordText = passwordText,
                            onPasswordTextChange = { viewModel.onPasswordChanged(it) },
                            modifier = Modifier.fillMaxWidth(),
                            emailError = emailError,
                            emailErrorMessage = emailErrorMessage,
                            passwordError = passwordError,
                            passwordErrorMessage = passwordErrorMessage,
                            onSignupClick = { viewModel.onSignupClicked() })

                        LoginThirdPartySection(
                            modifier = Modifier.fillMaxWidth(),
                            buttonModifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

            DeviceConfiguration.TABLET_PORTRAIT, DeviceConfiguration.TABLET_LANDSCAPE -> {
                Column(
                    modifier = rootModifier
                        .padding(top = 48.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RegisterHeaderSection(
                        modifier = Modifier.widthIn(max = 540.dp),
                        alignment = Alignment.CenterHorizontally
                    )
                    RegisterFormSection(
                        nameText = "",
                        onNameTextChange = {},
                        emailText = emailText,
                        onEmailTextChange = { viewModel.onEmailChanged(it) },
                        passwordText = passwordText,
                        onPasswordTextChange = { viewModel.onPasswordChanged(it) },
                        modifier = Modifier.widthIn(max = 540.dp),
                        emailError = emailError,
                        emailErrorMessage = emailErrorMessage,
                        passwordError = passwordError,
                        passwordErrorMessage = passwordErrorMessage,
                        onSignupClick = { viewModel.onSignupClicked() })
                    LoginThirdPartySection(
                        modifier = Modifier.widthIn(max = 540.dp),
                        buttonModifier = Modifier.widthIn(480.dp)
                    )
                }

            }
        }
    }
}