package com.quentin.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ControlFlowForLoopLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ControlFlowForLoopLessonPart1.newInstance()
            1 -> ControlFlowForLoopLessonPart2.newInstance()
            2 -> ControlFlowForLoopLessonPart3.newInstance()

            else ->
                null
        }
    }

}