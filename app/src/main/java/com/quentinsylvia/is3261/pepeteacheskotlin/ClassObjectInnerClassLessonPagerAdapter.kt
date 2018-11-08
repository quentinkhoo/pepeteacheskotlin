package com.quentinsylvia.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ClassObjectInnerClassLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ClassObjectInnerClassLessonPart1.newInstance()
            1 -> ClassObjectInnerClassLessonPart2.newInstance()
            2 -> ClassObjectInnerClassLessonPart3.newInstance()
            3 -> ClassObjectInnerClassLessonPart4.newInstance()

            else ->
                null
        }
    }

}