package com.example.iihfstatisticandnews.presentation.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.FragmentMatchesBinding
import com.example.iihfstatisticandnews.domain.pojo.MatchItem
import com.example.iihfstatisticandnews.presentation.adapters.AdapterMatch

class MatchesFragment(val list:List<MatchItem>) : Fragment() {

    private lateinit var adapter:AdapterMatch
    private lateinit var binding:FragmentMatchesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchesBinding.inflate(inflater,container,false)
        adapter = AdapterMatch()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvMatches = binding.rvMatches
        adapter.list = list
        rvMatches.adapter = adapter
    }


}