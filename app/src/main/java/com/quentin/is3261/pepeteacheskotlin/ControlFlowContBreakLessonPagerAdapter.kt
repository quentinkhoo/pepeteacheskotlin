package com.quentin.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ControlFlowContBreakLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ControlFlowContBreakLessonPart1.newInstance()
            1 -> ControlFlowContBreakLessonPart2.newInstance()

            else ->
                null
        }
    }

}