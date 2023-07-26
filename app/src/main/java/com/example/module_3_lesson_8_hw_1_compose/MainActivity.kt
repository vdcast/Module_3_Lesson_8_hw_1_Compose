package com.example.module_3_lesson_8_hw_1_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.module_3_lesson_8_hw_1_compose.ui.theme.Module_3_Lesson_8_hw_1_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Module_3_Lesson_8_hw_1_ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    Text(text = "Hello bro!")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module_3_Lesson_8_hw_1_ComposeTheme {
        MyApp()
    }
}