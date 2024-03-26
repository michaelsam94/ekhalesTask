package com.example.myapplication.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentPostsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PostsFragment @Inject constructor() : BaseFragment() {
    private var _binding: FragmentPostsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()

        viewModel.posts.observe(viewLifecycleOwner) {
            val adapter = PostAdapter(it)
            binding.rvPosts.adapter = adapter
            binding.rvPosts.layoutManager = LinearLayoutManager(requireContext())
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
