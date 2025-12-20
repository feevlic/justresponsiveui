package com.feevlic.justresponsiveui.design_sytsem

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

@Composable
fun JustAUiTextField(
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    hint: String,
    isInputSecret: Boolean,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by remember {
        mutableStateOf(true)
    }

    Column(modifier = modifier) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = modifier.height(6.dp))
        OutlinedTextField(
            value = text,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = { onValueChange(it.trimEnd()) },
            visualTransformation = if (isPasswordVisible) {
                PasswordVisualTransformation('*')
            } else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                cursorColor = MaterialTheme.colorScheme.primary,
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Transparent
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
                                    imageVector = Icons.Default.VisibilityOff,
                                    contentDescription = "Hide password",
                                )
                            }

                            !isPasswordVisible -> {
                                Icon(
                                    imageVector = Icons.Default.Visibility,
                                    contentDescription = "Show password"
                                )
                            }
                        }
                    }
                }

            }
        )
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