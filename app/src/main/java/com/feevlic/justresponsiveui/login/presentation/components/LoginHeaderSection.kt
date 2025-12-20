package com.feevlic.justresponsiveui.login.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginHeaderSection(
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    Column(modifier = modifier, horizontalAlignment = alignment) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "It all starts here, so come and join ",
            style = MaterialTheme.typography.bodyLarge
        )
    }

}