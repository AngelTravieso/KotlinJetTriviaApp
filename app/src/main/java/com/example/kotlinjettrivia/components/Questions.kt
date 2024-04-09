package com.example.kotlinjettrivia.components

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.example.kotlinjettrivia.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()

    if (viewModel.data.value.loading == true) {
        Log.d("Loading", "Questions: ...Loading")
        CircularProgressIndicator()
    } else {
        Log.d("Loading", "Questions: Loading STOPPED...")
        questions?.forEach { questionItem ->
            Log.d("Result", "Questions: ${questionItem.question}")
        }

        Log.d("SIZE", "Questions: ${questions?.size}")
    }
}