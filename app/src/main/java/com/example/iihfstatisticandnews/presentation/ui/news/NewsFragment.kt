package com.example.iihfstatisticandnews.presentation.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.iihfstatisticandnews.databinding.FragmentNewsBinding
import com.example.iihfstatisticandnews.presentation.adapters.AdapterNews

class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewModel:NewsViewModel
    private lateinit var adapter:AdapterNews

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = AdapterNews()
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvNews = binding.rvNews
        viewModel.newsList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvNews.adapter = adapter
        })
    }



}