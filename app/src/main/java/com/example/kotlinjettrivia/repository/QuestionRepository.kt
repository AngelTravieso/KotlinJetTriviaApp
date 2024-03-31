package com.example.kotlinjettrivia.repository

import com.example.kotlinjettrivia.data.DataOrException
import com.example.kotlinjettrivia.model.QuestionItem
import com.example.kotlinjettrivia.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {

    private val listOfQuestions = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()


}