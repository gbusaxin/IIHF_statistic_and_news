package com.example.iihfstatisticandnews.presentation.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.iihfstatisticandnews.databinding.FragmentTeamsBinding
import com.example.iihfstatisticandnews.presentation.adapters.AdapterTeam

class TeamsFragment : Fragment() {

    private lateinit var binding: FragmentTeamsBinding
    private lateinit var viewModel:TeamViewModel
    private lateinit var adapter:AdapterTeam

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[TeamViewModel::class.java]
        adapter = AdapterTeam(childFragmentManager)
        binding = FragmentTeamsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvTeam = binding.rvTeams
        viewModel.teamList.observe(viewLifecycleOwner,{
            adapter.list = it
            rvTeam.adapter = adapter
        })
    }

}