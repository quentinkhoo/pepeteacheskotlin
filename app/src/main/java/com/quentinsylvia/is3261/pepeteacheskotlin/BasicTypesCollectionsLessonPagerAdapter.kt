package com.quentinsylvia.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BasicTypesCollectionsLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    override fun getCount(): Int {
        return 5
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> BasicTypesCollectionsLessonPart1.newInstance()
            1 -> BasicTypesCollectionsLessonPart2.newInstance()
            2 -> BasicTypesCollectionsLessonPart3.newInstance()
            3 -> BasicTypesCollectionsLessonPart4.newInstance()
            4 -> BasicTypesCollectionsLessonPart5.newInstance()

            else ->
                null
        }
    }
}