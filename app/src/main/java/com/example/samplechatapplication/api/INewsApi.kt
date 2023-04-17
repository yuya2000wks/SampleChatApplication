package com.example.samplechatapplication.api

import com.example.samplechatapplication.api.response.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface INewsApi {

    companion object {
        private const val API_KEY = "1a46e86cb0f643978c67855071888515"
    }

    // 現在米国でトップのビジネスの見出し記事一覧取得
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "us",
        @Query("category") category: String = "business",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}

object NewsApiModule {

    fun createNewsApi(): INewsApi {
        val httpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient)
            .build()
        return NewsApi(retrofit.create(INewsApi::class.java))
    }
}

class NewsApi(
    private val newsApi: INewsApi
) : INewsApi {

    override suspend fun getNews(
        country: String,
        category: String,
        apiKey: String
    ) = newsApi.getNews()
}