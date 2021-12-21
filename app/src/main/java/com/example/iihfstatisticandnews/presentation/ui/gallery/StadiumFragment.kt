package com.example.iihfstatisticandnews.presentation.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.FragmentStadiumBinding
import com.example.iihfstatisticandnews.presentation.adapters.AdapterStadium

class StadiumFragment : Fragment() {

    private lateinit var adapter: AdapterStadium
    private lateinit var viewModel: GalleryViewModel
    private lateinit var binding: FragmentStadiumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[GalleryViewModel::class.java]
        adapter = AdapterStadium()
        binding = FragmentStadiumBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvStadium = binding.rvStadium
        viewModel.stadiumList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvStadium.adapter = adapter
        })
    }

}