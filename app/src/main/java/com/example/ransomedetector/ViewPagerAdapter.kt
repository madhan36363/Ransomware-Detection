package com.example.ransomedetector

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val tabTypes = listOf("System", "Known", "Others")

    override fun getItemCount(): Int = tabTypes.size

    override fun createFragment(position: Int): Fragment {
        return AppListFragment(tabTypes[position])
    }
}
