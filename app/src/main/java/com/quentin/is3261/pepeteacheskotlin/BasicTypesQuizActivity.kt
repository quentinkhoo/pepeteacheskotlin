package com.quentin.is3261.pepeteacheskotlin

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import nl.dionsegijn.konfetti.KonfettiView

class BasicTypesQuizActivity : AppCompatActivity() {

    private lateinit var question: TextView
    private lateinit var optionA: Button
    private lateinit var optionB: Button
    private lateinit var optionC: Button
    private lateinit var optionD: Button
    private lateinit var answer: String

    private val questionBank = arrayOf(R.string.chapter1_quiz_1, R.string.chapter1_quiz_2, R.string.chapter1_quiz_3,
            R.string.chapter1_quiz_4, R.string.chapter1_quiz_5)

    private val optionAs = arrayOf(R.string.chapter1_quiz_1_a, R.string.chapter1_quiz_2_a, R.string.chapter1_quiz_3_a,
            R.string.chapter1_quiz_4_a, R.string.chapter1_quiz_5_a)

    private val optionBs = arrayOf(R.string.chapter1_quiz_1_b, R.string.chapter1_quiz_2_b, R.string.chapter1_quiz_3_b,
            R.string.chapter1_quiz_4_b, R.string.chapter1_quiz_5_b)

    private val optionCs = arrayOf(R.string.chapter1_quiz_1_c, R.string.chapter1_quiz_2_c, R.string.chapter1_quiz_3_c,
            R.string.chapter1_quiz_4_c, R.string.chapter1_quiz_5_c)

    private val optionDs = arrayOf(R.string.chapter1_quiz_1_d, R.string.chapter1_quiz_2_d, R.string.chapter1_quiz_3_d,
            R.string.chapter1_quiz_4_d, R.string.chapter1_quiz_5_d)

    private val answers = arrayOf(R.string.chapter1_quiz_1_a, R.string.chapter1_quiz_2_c, R.string.chapter1_quiz_3_d,
            R.string.chapter1_quiz_4_b, R.string.chapter1_quiz_5_d)

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
        setContentView(R.layout.activity_basic_types_quiz)

        pepeHelper = PepeTeachesKotlinHelper()

        doneButton = findViewById<ImageButton>(R.id.butt_done)
        question = findViewById<TextView>(R.id.question)
        optionA = findViewById<Button>(R.id.butt_a)
        optionB = findViewById<Button>(R.id.butt_b)
        optionC = findViewById<Button>(R.id.butt_c)
        optionD = findViewById<Button>(R.id.butt_d)

        konfetti = findViewById<KonfettiView>(R.id.konfettiView)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun finishQuiz() {
        sharedPreferences.set("BasicQuizComplete", true)
        Toast.makeText(this, "You have finished Number Lesson!", Toast.LENGTH_LONG).show()
        pepeHelper.throwConfetti(konfetti)
    }

}

