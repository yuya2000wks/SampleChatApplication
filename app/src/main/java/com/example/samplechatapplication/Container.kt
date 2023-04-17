package com.example.samplechatapplication

import com.example.samplechatapplication.api.INewsApi
import com.example.samplechatapplication.api.NewsApiModule
import com.example.samplechatapplication.repository.NewsRepository
import com.example.samplechatapplication.usecase.INewsView
import com.example.samplechatapplication.usecase.NewsUseCase

class Container {

    private val newsApi: INewsApi by lazy {
        NewsApiModule.createNewsApi()
    }

    private val newsRepository: NewsRepository by lazy {
        NewsRepository(newsApi)
    }

    fun newsUseCase(
        newsView: INewsView
    ) = NewsUseCase(
        newsRepository,
        newsView
    )
}