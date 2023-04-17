package com.example.samplechatapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.samplechatapplication.databinding.FragmentFriendSearchBinding
import com.example.samplechatapplication.viewmodel.FriendSearchViewModel

class FriendSearchFragment : Fragment() {

    private val viewModel: FriendSearchViewModel by viewModels()

    private var _binding: FragmentFriendSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFriendSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: ViewModelを使用予定
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}