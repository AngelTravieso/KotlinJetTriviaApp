package com.example.kotlinjettrivia.di

import com.example.kotlinjettrivia.network.QuestionAPI
import com.example.kotlinjettrivia.repository.QuestionRepository
import com.example.kotlinjettrivia.util.Constants
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionRepository(api: QuestionAPI) = QuestionRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create((GsonBuilder().create()))
            ).build()
            .create(QuestionAPI::class.java)
    }

}