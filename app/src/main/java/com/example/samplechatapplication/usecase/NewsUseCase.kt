package com.example.samplechatapplication.usecase

import com.example.samplechatapplication.api.response.NewsResponse
import com.example.samplechatapplication.repository.NewsRepository
import timber.log.Timber

class NewsUseCase(
    private val newsRepository: NewsRepository,
    private val newsView: INewsView
) {
    suspend fun execute() {
        try {
            val news = newsRepository.getNews()
            newsView.showNewsView(news)
        } catch (exception: Exception) {
            Timber.d("ExceptionOfGetNews:${exception}")
        }
    }
}

interface INewsView {
    fun showNewsView(news: NewsResponse)
}