package com.quentin.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BasicTypeFragmentPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 7
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> BasicTypesPart1Fragment.newInstance()
            1 -> BasicTypesPart2Fragment.newInstance()
            2 -> BasicTypesPart3Fragment.newInstance()
            3 -> BasicTypesPart4Fragment.newInstance()
            4 -> BasicTypesPart5Fragment.newInstance()
            5 -> BasicTypesPart6Fragment.newInstance()
            6 -> BasicTypesPart7Fragment.newInstance()

            else ->
                BasicTypesPart1Fragment.newInstance()
        }
    }

}