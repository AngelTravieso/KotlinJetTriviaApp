package com.example.kotlinjettrivia.network

import com.example.kotlinjettrivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI { // QuestionDao, it's a DAO

    @GET("/world.json")
    suspend fun getAllQuestions(): Question


}