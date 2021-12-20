package com.example.iihfstatisticandnews.presentation.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.iihfstatisticandnews.R
import com.example.iihfstatisticandnews.databinding.FragmentGalleryBinding
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding

    private val tourneyFragment = TourneyFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentGalleryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottom_nav = binding.bottomNav
        replaceFragment(tourneyFragment)
        bottom_nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.id_tourney -> replaceFragment(tourneyFragment)
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        fragment.let {
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_bottom_container,fragment)
            transaction.commit()
        }
    }

}