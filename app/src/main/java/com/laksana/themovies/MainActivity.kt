package com.laksana.themovies

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.laksana.themovies.databinding.ActivityMainBinding
import com.laksana.themovies.ui.main.PageViewModel
import com.laksana.themovies.ui.main.SectionsPagerAdapter
import com.laksana.themovies.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter

    private lateinit var viewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(
            this@MainActivity, factory
        )[PageViewModel::class.java]

        showTabs()
        activityMainBinding.progressBar.visibility = View.GONE
    }

    private fun showTabs() {
        viewPager2 = activityMainBinding.viewPager
        pagerAdapter = SectionsPagerAdapter(this)
        viewPager2.adapter = pagerAdapter

        TabLayoutMediator(activityMainBinding.tabs, viewPager2) { tab, position ->
            tab.text = when(position) {
                0 -> resources.getString(R.string.tab_text_1)
                else -> resources.getString(R.string.tab_text_2)
            }
        }.attach()
    }
}