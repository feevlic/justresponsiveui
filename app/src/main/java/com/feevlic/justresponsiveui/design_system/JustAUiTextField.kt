package com.feevlic.justresponsiveui.design_system

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.feevlic.justresponsiveui.ui.theme.JustresponsiveuiTheme
import com.feevlic.justresponsiveui.ui.theme.Shapes
import kotlinx.coroutines.delay

@Composable
fun JustAUiTextField(
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    hint: String,
    isInputSecret: Boolean,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val shouldBeVisible = isError && !errorMessage.isNullOrEmpty()
    var showError by remember { mutableStateOf(shouldBeVisible) }

    LaunchedEffect(shouldBeVisible) {
        if (shouldBeVisible) {
            showError = false
            delay(60)
            showError = true
        } else {
            showError = false
        }
    }

    Column(modifier = modifier.animateContentSize()) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = modifier.height(6.dp))
        OutlinedTextField(
            value = text,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { onValueChange(it.trimEnd()) },
            visualTransformation = if (isInputSecret) {
                if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(
                    '*'
                )
            } else {
                VisualTransformation.None
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = if (isError) MaterialTheme.colorScheme.error else Color.Transparent
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyLarge
                )
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            shape = Shapes.small,
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            trailingIcon = {
                if (isInputSecret) {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                        when {
                            isPasswordVisible -> {
                                Icon(
                                    imageVector = Icons.Default.Visibility,
                                    contentDescription = "Hide password",
                                )
                            }

                            !isPasswordVisible -> {
                                Icon(
                                    imageVector = Icons.Default.VisibilityOff,
                                    contentDescription = "Show password"
                                )
                            }
                        }
                    }
                }
            },
            isError = isError
        )

        AnimatedVisibility(
            visible = showError,
            enter = fadeIn(animationSpec = tween(durationMillis = 260, delayMillis = 0)),
            exit = fadeOut(animationSpec = tween(durationMillis = 180))
        ) {
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun JustAUiTextFieldPreview() {
    val state = remember { mutableStateOf("ExampleText") }
    JustresponsiveuiTheme {
        Surface {
            JustAUiTextField(
                text = state.value,
                onValueChange = { state.value = it },
                label = "Label",
                hint = "Placeholder",
                isInputSecret = false,
                modifier = Modifier
            )
        }
    }
}
