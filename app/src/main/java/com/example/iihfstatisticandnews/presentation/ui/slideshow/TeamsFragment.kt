package com.example.iihfstatisticandnews.presentation.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iihfstatisticandnews.databinding.FragmentTeamsBinding

class TeamsFragment : Fragment() {

    private lateinit var binding: FragmentTeamsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamsBinding.inflate(inflater,container,false)
        return binding.root
    }


}