package com.example.kotlinjettrivia.repository

import android.util.Log
import com.example.kotlinjettrivia.data.DataOrException
import com.example.kotlinjettrivia.model.QuestionItem
import com.example.kotlinjettrivia.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {

            dataOrException.loading = true

            dataOrException.data = api.getAllQuestions()

            if (dataOrException.data.toString().isNotEmpty()) {
                dataOrException.loading = false
            }


        } catch (exception: Exception) {
            dataOrException.e = exception
            dataOrException.loading = false
            Log.d("Exc", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }

        return dataOrException
    }

}