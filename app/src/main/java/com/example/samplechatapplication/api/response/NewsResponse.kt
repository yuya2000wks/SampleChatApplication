package com.example.samplechatapplication.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "articles")
    val articles: List<ArticleResponse>
)

@JsonClass(generateAdapter = true)
data class ArticleResponse(
    @Json(name = "url")
    val url: String?, // 記事url
    @Json(name = "urlToImage")
    val urlToImage: String?, // 画像url
    @Json(name = "publishedAt")
    val publishedAt: String?, // 発行日
    @Json(name = "content")
    val content: String?, // 記事内容
)
