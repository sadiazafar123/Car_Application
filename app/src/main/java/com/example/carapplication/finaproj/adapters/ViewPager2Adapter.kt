package com.example.carapplication.finaproj.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.carapplication.CarInfo
import com.example.carapplication.PersonalInfo

private const val NUM_TABS = 2


class ViewPager2Adapter(fragmentManager:FragmentManager,lifecycle: Lifecycle)
    :FragmentStateAdapter(fragmentManager,lifecycle)
{
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
      return  when(position){
            0->PersonalInfo()
          else->CarInfo()
        }

    }
}