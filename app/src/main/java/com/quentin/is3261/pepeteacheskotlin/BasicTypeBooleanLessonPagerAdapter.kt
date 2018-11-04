package com.quentin.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BasicTypeBooleanLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> BasicTypeBooleanLessonFragment.newInstance()

            else ->
                null
        }
    }
}