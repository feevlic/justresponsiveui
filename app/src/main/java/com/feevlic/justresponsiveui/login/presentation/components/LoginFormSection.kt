package com.feevlic.justresponsiveui.login.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.feevlic.justresponsiveui.design_sytsem.JustAUiButton
import com.feevlic.justresponsiveui.design_sytsem.JustAUiLink
import com.feevlic.justresponsiveui.design_sytsem.JustAUiTextField

@Composable
fun LoginFormSection(
    emailText: String,
    onEmailTextChange: (String) -> Unit,
    passwordText: String,
    onPasswordTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        JustAUiTextField(
            text = emailText,
            onValueChange = onEmailTextChange,
            label = "E-Mail",
            hint = "max.musterman@example.de",
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
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        JustAUiButton(
            text = "Log In",
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.height(16.dp))
        JustAUiLink(
            text = "Don't have an account?",
            onClick = {},
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}