package com.ui.progress_button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ProgressButton(
    text: String,
    backgroundColor: Color,
    foregroundColor: Color,
    buttonHeight: Dp,
    buttonWidth: Dp,
    onButtonClicked: () -> Unit,
    isLoading: Boolean
) {
    var isButtonEnabled by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .height(buttonHeight)
            .width(buttonWidth)
            .background(backgroundColor)
            .clickable(
                enabled = isButtonEnabled,
                onClick = {
                    onButtonClicked()
                    isButtonEnabled = false
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = foregroundColor,
                strokeWidth = 2.dp,
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
            )
        } else {
            Text(
                text = text,
                color = foregroundColor
            )
        }
    }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000)
            isButtonEnabled = true
        }
    }
}