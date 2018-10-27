package com.quentin.is3261.pepeteacheskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class BasicTypesNumbersLessonActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_types_numbers_lesson)

        viewPager = findViewById(R.id.numbers_viewpager)
        pagerAdapter = BasicTypeNumbersLessonPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

        hideUnhideButton(viewPager.currentItem)

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                hideUnhideButton(position)
            }
        })

        val nextButton = findViewById<ImageButton>(R.id.butt_next)
        nextButton.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1)
        }

        val prevButton = findViewById<ImageButton>(R.id.butt_previous)
        prevButton.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem - 1)
        }

        val doneButton = findViewById<ImageButton>(R.id.butt_done)
        doneButton.setOnClickListener {
            Toast.makeText(this, "Doneeeeeee", Toast.LENGTH_LONG).show()
        }

    }

    private fun hideUnhideButton(position: Int) {
        val prevButton = findViewById<ImageButton>(R.id.butt_previous)
        val nextButton = findViewById<ImageButton>(R.id.butt_next)
        val doneButton = findViewById<ImageButton>(R.id.butt_done)

        if (position == pagerAdapter.count - 1) {
            nextButton.isClickable = false
            nextButton.visibility = View.INVISIBLE
            doneButton.isClickable = true
            doneButton.visibility = View.VISIBLE
        }

        if (position != pagerAdapter.count - 1 && nextButton.visibility == View.INVISIBLE
                && doneButton.visibility == View.VISIBLE) {
            nextButton.visibility = View.VISIBLE
            nextButton.isClickable = true
            doneButton.isClickable = false
            doneButton.visibility = View.INVISIBLE
        }

        if (position == 0) {
            prevButton.isClickable = false
            prevButton.visibility = View.INVISIBLE
        }

        if (position != 0 && prevButton.visibility == View.INVISIBLE) {
            prevButton.visibility = View.VISIBLE
            prevButton.isClickable = true
        }
    }
}
