package com.example.kotlinjettrivia.network

import com.example.kotlinjettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("/world.json")
    suspend fun getAllQuestions(): Question


}