package com.quentin.is3261.pepeteacheskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.widget.ImageButton

class BasicTypesNumbersLessonActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_types_numbers_lesson)

        viewPager = findViewById(R.id.numbers_viewpager)
        pagerAdapter = BasicTypeNumbersLessonPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        val nextButton = findViewById<ImageButton>(R.id.butt_next)

    }
}
