package com.example.samplechatapplication.repository

import com.example.samplechatapplication.api.INewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepository(
    private val newsApi: INewsApi
) {
    suspend fun getNews() = withContext(Dispatchers.IO) {
        try {
            newsApi.getNews()
        } catch (exception: Exception) {
            throw exception
        }
    }
}