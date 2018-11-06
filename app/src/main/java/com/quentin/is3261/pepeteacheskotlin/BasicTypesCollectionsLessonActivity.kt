package com.quentin.is3261.pepeteacheskotlin

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import nl.dionsegijn.konfetti.KonfettiView

class BasicTypesCollectionsLessonActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var pepeHelper: PepeTeachesKotlinHelper

    private lateinit var prevButton: ImageButton
    private lateinit var nextButton: ImageButton
    private lateinit var doneButton: ImageButton
    private lateinit var konfetti: KonfettiView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_types_collections_lesson)

        viewPager = findViewById(R.id.collections_viewpager)
        pagerAdapter = BasicTypesCollectionsLessonPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        pepeHelper = PepeTeachesKotlinHelper()

        prevButton = findViewById<ImageButton>(R.id.butt_previous)
        nextButton = findViewById<ImageButton>(R.id.butt_next)
        doneButton = findViewById<ImageButton>(R.id.butt_done)
        konfetti = findViewById<KonfettiView>(R.id.konfettiView)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

        nextButton.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem + 1)
        }

        prevButton.setOnClickListener {
            viewPager.setCurrentItem(viewPager.currentItem - 1)
        }

        doneButton.setOnClickListener {
            finishCharacterLesson()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else if (item?.itemId == R.id.infoMenuItem){
            val myIntent = Intent(applicationContext, LessonTipsActivity::class.java)
            startActivity(myIntent)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun finishCharacterLesson() {
        sharedPreferences.set("CharacterLesson", true)
        Toast.makeText(this, "You have finished Collections Lesson!", Toast.LENGTH_LONG).show()
        //pepeHelper.throwConfetti(konfetti)
        finish()
    }

    private fun hideUnhideButton(position: Int) {

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
