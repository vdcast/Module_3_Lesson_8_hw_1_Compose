package com.example.module_3_lesson_8_hw_1_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.module_3_lesson_8_hw_1_compose.ui.theme.Module_3_Lesson_8_hw_1_ComposeTheme
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

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
fun MyApp(
    viewModelMain: MainViewModel = viewModel()
) {
    val someTextFromViewModel by viewModelMain.someText
    val isLoadingFromViewModel by viewModelMain.isLoading
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.text_title),
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            text = stringResource(id = R.string.text_description),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Button(onClick = {
            coroutineScope.launch { viewModelMain.refreshText() }
        }) { Text(text = stringResource(id = R.string.button_text))}
        Text(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            text = someTextFromViewModel,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center
        )
        AnimatedVisibility(visible = isLoadingFromViewModel) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Module_3_Lesson_8_hw_1_ComposeTheme {
        MyApp()
    }
}