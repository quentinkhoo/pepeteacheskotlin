package com.quentin.is3261.pepeteacheskotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BasicTypesQuizPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        return BasicsQuizFragment.newInstance(position)
    }

    override fun getCount(): Int {
        return 5
    }
}
