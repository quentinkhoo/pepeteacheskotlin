package com.quentin.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BasicTypeNumbersLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> BasicTypesNumbersLessonPart0.newInstance()
            1 -> BasicTypesNumbersLessonPart1.newInstance()
            2 -> BasicTypesNumbersLessonPart2.newInstance()
            3 -> BasicTypesNumbersLessonPart3.newInstance()

            else ->
                null
        }
    }

}