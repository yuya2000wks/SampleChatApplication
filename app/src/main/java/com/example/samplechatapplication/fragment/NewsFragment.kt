package com.example.samplechatapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplechatapplication.adapter.NewsAdapter
import com.example.samplechatapplication.databinding.FragmentNewsBinding
import com.example.samplechatapplication.viewmodel.NewsViewModel

class NewsFragment : Fragment() {

    private val viewModel: NewsViewModel by viewModels()

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showNewsView.observe(viewLifecycleOwner, Observer { news ->
            // 取得したニュースを表示
            val newsRecyclerView = binding.newsRecyclerView
            val adapter = context?.let { NewsAdapter(news.articles, it) }
            newsRecyclerView.layoutManager = LinearLayoutManager(context)
            newsRecyclerView.adapter = adapter
        })

        viewModel.getNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}