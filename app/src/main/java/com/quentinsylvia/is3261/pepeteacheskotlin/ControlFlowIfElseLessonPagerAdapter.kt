package com.quentinsylvia.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ControlFlowIfElseLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ControlFlowIfElseLessonPart1.newInstance()
            1 -> ControlFlowIfElseLessonPart2.newInstance()
            2 -> ControlFlowIfElseLessonPart3.newInstance()

            else ->
                null
        }
    }

}