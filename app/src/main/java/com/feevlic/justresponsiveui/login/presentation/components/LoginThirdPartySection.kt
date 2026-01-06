package com.feevlic.justresponsiveui.login.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.feevlic.justresponsiveui.R
import com.feevlic.justresponsiveui.design_system.JustAUiIconTextButton

@Composable
fun LoginThirdPartySection(
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier.fillMaxWidth()
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "or",
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.height(16.dp))
        JustAUiIconTextButton(
            text = "Sign in with Google",
            onClick = { },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onSurface),
            modifier = buttonModifier,
            painter = painterResource(R.drawable.google_logo)
        )
    }
}