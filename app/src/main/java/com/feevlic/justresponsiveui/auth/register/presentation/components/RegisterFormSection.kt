package com.feevlic.justresponsiveui.auth.register.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.feevlic.justresponsiveui.design_system.JustAUiButton
import com.feevlic.justresponsiveui.design_system.JustAUiTextField

@Composable
fun RegisterFormSection(
    nameText: String,
    onNameTextChange: (String) -> Unit,
    emailText: String,
    onEmailTextChange: (String) -> Unit,
    passwordText: String,
    onPasswordTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    emailError: Boolean = false,
    emailErrorMessage: String? = null,
    passwordError: Boolean = false,
    passwordErrorMessage: String? = null,
    onSignupClick: () -> Unit = {}
) {
    Column(modifier = modifier) {
        JustAUiTextField(
            text = emailText,
            onValueChange = onEmailTextChange,
            label = "E-Mail",
            hint = "max.musterman@example.de",
            isInputSecret = false,
            modifier = Modifier.fillMaxWidth(),
            isError = emailError,
            errorMessage = emailErrorMessage
        )
        Spacer(modifier = Modifier.height(12.dp))
        JustAUiTextField(
            text = nameText,
            onValueChange = onNameTextChange,
            label = "Your Name",
            hint = "Max Mustermann",
            isInputSecret = false,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        JustAUiTextField(
            text = passwordText,
            onValueChange = onPasswordTextChange,
            label = "Password",
            hint = "Your password",
            isInputSecret = true,
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError,
            errorMessage = passwordErrorMessage
        )
        Spacer(modifier = Modifier.height(24.dp))
        JustAUiButton(
            text = "Start your journey",
            onClick = onSignupClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        )
    }
}