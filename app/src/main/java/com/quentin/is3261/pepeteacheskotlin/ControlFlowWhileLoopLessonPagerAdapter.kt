package com.quentin.is3261.pepeteacheskotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ControlFlowWhileLoopLessonPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> ControlFlowWhileLoopPart1.newInstance()
            1 -> ControlFlowWhileLoopPart2.newInstance()
            2 -> ControlFlowWhileLoopPart3.newInstance()
            3 -> ControlFlowWhileLoopPart4.newInstance()

            else ->
                null
        }
    }
}
