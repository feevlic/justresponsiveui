package com.feevlic.justresponsiveui.design_system

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.feevlic.justresponsiveui.ui.theme.Shapes

@Composable
fun JustAUiIconTextButton(
    text: String,
    onClick: () -> Unit,
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    painter: Painter
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = Shapes.small,
        colors = colors,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .height(18.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = text,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}