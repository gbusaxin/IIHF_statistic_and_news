package com.example.iihfstatisticandnews.presentation.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.iihfstatisticandnews.databinding.FragmentTeamDialogBinding
import com.example.iihfstatisticandnews.domain.pojo.TeamItem
import com.example.iihfstatisticandnews.presentation.adapters.ViewPagerAdapter

class TeamDialogFragment(val teamItem: TeamItem) : DialogFragment() {

    private lateinit var binding: FragmentTeamDialogBinding
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var playerFragment: PlayerFragment
    private lateinit var matchesFragment: MatchesFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        matchesFragment = MatchesFragment(teamItem.matches)
        playerFragment = PlayerFragment(teamItem.players)
        adapter = ViewPagerAdapter(childFragmentManager)
        binding = FragmentTeamDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabs = binding.tabs
        val viewPager = binding.viewPager
        adapter.addFragment(playerFragment, "Игроки")
        adapter.addFragment(matchesFragment, "Матчи")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

}