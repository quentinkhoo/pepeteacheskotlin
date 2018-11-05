package com.quentin.is3261.pepeteacheskotlin

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import nl.dionsegijn.konfetti.KonfettiView

class BasicTypeBooleanLessonActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PagerAdapter
    private lateinit var pepeHelper: PepeTeachesKotlinHelper

    private lateinit var doneButton: ImageButton
    private lateinit var konfetti: KonfettiView

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_type_boolean_lesson)

        viewPager = findViewById(R.id.boolean_viewpager)
        pagerAdapter = BasicTypeBooleanLessonPagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        pepeHelper = PepeTeachesKotlinHelper()

        doneButton = findViewById<ImageButton>(R.id.butt_done)
        doneButton.visibility = View.VISIBLE
        konfetti = findViewById<KonfettiView>(R.id.konfettiView)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//
//            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//
//            }
//        })

        doneButton.setOnClickListener {
            finishCharacterLesson()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun finishCharacterLesson() {
        sharedPreferences.set("CharacterLesson", true)
        Toast.makeText(this, "You have finished Character Lesson!", Toast.LENGTH_LONG).show()
        //pepeHelper.throwConfetti(konfetti)
    }

}
