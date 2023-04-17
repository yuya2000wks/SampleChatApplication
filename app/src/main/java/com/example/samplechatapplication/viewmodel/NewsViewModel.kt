package com.example.samplechatapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.samplechatapplication.SampleChatApplication
import com.example.samplechatapplication.api.response.NewsResponse
import com.example.samplechatapplication.usecase.INewsView
import kotlinx.coroutines.launch

class NewsViewModel(
    application: Application
) : AndroidViewModel(application), INewsView {

    private val _showNewsView: MutableLiveData<NewsResponse> = MutableLiveData()
    val showNewsView: LiveData<NewsResponse> = _showNewsView

    fun getNews() {
        val application = getApplication<SampleChatApplication>()
        val useCase = application.container.newsUseCase(this)
        viewModelScope.launch {
            useCase.execute()
        }
    }

    override fun showNewsView(news: NewsResponse) {
        _showNewsView.value = news
    }
}