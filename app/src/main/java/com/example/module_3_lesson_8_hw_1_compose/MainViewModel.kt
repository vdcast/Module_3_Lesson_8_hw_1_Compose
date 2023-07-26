package com.example.module_3_lesson_8_hw_1_compose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val apiManager = ApiManager()
    val someText = mutableStateOf("")
    val isLoading = mutableStateOf(false)
    private val isDebounced = mutableStateOf(false)

    suspend fun refreshText() {
        withContext(Dispatchers.IO) {
            if (isDebounced.value) return@withContext
            isDebounced.value = true

            isLoading.value = true
            delay(2_000)
            someText.value = apiManager.getNewText()
            isLoading.value = false

            isDebounced.value = false
        }
    }

}