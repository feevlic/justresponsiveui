package com.feevlic.justresponsiveui.design_sytsem

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.feevlic.justresponsiveui.ui.theme.JustresponsiveuiTheme

@Composable
fun JustAUiLink(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier.clickable(onClick = onClick),
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun JustAUiLinkPreview() {
    JustresponsiveuiTheme() {
        Surface {
            JustAUiLink(
                text = "Preview Link",
                onClick = {},
            )
        }
    }
}