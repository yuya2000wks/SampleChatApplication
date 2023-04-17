package com.example.samplechatapplication.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.samplechatapplication.api.response.ArticleResponse
import com.example.samplechatapplication.databinding.ListItemNewsBinding

// ニュース記事
class NewsAdapter(
    private val newsList: List<ArticleResponse>,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val listItemNewsBinding =
            ListItemNewsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return NewsViewHolder(listItemNewsBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NewsViewHolder) {
            holder.apply {
                // 1件の記事を取得
                val news = newsList[position]

                // 縦幅横幅を設定
                val options = RequestOptions().centerCrop()
                // 画像
                Glide.with(context).load(news.urlToImage).apply(options).into(holder.imageView)
                // 記事内容
                holder.contentView.text = news.content
                // 公開日(公開日は時間まで含まれているのではじめの10文字を切り抜き年月日のみが表示)
                holder.publishView.text = news.publishedAt?.substring(0, 10)

                holder.newsView.setOnClickListener {
                    // urlのページを表示
                    CustomTabsIntent.Builder().build().launchUrl(context, Uri.parse(news.url))
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(
        private val binding: ListItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val contentView = binding.content
        val publishView = binding.publish
        val imageView = binding.image
        val newsView = binding.newsView
    }
}