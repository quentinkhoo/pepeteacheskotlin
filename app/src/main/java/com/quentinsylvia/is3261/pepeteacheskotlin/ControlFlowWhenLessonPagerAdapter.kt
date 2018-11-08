package com.quentinsylvia.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ControlFlowWhenLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ControlFlowWhenLessonPart1.newInstance()
            1 -> ControlFlowWhenLessonPart2.newInstance()
            2 -> ControlFlowWhenLessonPart3.newInstance()
            3 -> ControlFlowWhenLessonPart4.newInstance()

            else ->
                null
        }
    }
}

