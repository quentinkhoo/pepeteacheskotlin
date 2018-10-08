package com.quentin.is3261.pepeteacheskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager

class LessonBasicTypesActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_basic_types)

        viewPager = findViewById(R.id.lesson1viewpager)
        pagerAdapter = BasicTypeFragmentPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
    }
}
