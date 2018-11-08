package com.quentinsylvia.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BasicTypesArraysLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return 1
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> BasicTypesArraysLessonPart1.newInstance()

            else ->
                null
        }
    }
}