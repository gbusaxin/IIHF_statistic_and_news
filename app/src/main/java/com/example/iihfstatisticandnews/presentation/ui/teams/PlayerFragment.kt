package com.example.iihfstatisticandnews.presentation.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.FragmentPlayerBinding
import com.example.iihfstatisticandnews.domain.pojo.PlayerItem
import com.example.iihfstatisticandnews.presentation.adapters.AdapterPlayer


class PlayerFragment(val list: List<PlayerItem>) : Fragment() {

    private lateinit var binding: FragmentPlayerBinding
    private lateinit var adapter: AdapterPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = AdapterPlayer()
        binding = FragmentPlayerBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvPlayers = binding.rvPlayers
        adapter.list = list
        rvPlayers.adapter = adapter
    }


}