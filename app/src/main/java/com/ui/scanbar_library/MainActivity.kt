package com.ui.scanbar_library


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ui.progress_button.ProgressButton
import com.ui.scanbar_library.ui.theme.ScanbarlibraryTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScanbarlibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScreen();
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    var isLoading by remember { mutableStateOf(false) }

    Column() {
        ProgressButton(
            text = "Submit",
            backgroundColor = Color.Blue,
            foregroundColor = Color.White,
            buttonHeight = 50.dp,
            buttonWidth = 200.dp,
            onButtonClicked = {
                isLoading = true;
            },
            isLoading = isLoading
        )
    }

    LaunchedEffect(isLoading) {
        if (isLoading) {
            delay(2000) // delay for 2 seconds
            // execute your statement here
            // for example, show a Toast message
            isLoading = false;
        }
    }
}


