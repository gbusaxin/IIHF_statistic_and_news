package com.example.iihfstatisticandnews.presentation.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.FragmentTourneyBinding
import com.example.iihfstatisticandnews.presentation.adapters.AdapterTourney


class TourneyFragment : Fragment() {

    private lateinit var binding:FragmentTourneyBinding
    private lateinit var adapter:AdapterTourney
    private lateinit var viewModel:GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[GalleryViewModel::class.java]
        adapter = AdapterTourney()
        binding = FragmentTourneyBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvTourney = binding.rvTourney
        viewModel.tourneyList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvTourney.adapter = adapter
        })
    }

}