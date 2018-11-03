package com.quentin.is3261.pepeteacheskotlin

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import nl.dionsegijn.konfetti.KonfettiView
import android.widget.Toast





class BasicTypesQuizActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var question: TextView
    private lateinit var optionA: Button
    private lateinit var optionB: Button
    private lateinit var optionC: Button
    private lateinit var optionD: Button
    private lateinit var answer: String
    private var currentQuestion: Int = 0

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

    private lateinit var pepeHelper: PepeTeachesKotlinHelper

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
        optionA.setOnClickListener(this)
        optionB = findViewById<Button>(R.id.butt_b)
        optionB.setOnClickListener(this)
        optionC = findViewById<Button>(R.id.butt_c)
        optionC.setOnClickListener(this)
        optionD = findViewById<Button>(R.id.butt_d)
        optionD.setOnClickListener(this)

        konfetti = findViewById<KonfettiView>(R.id.konfettiView)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpQuestion(currentQuestion)

    }

    private fun wrongAnswerStuff() {
        val inflater = layoutInflater

        val layout = inflater.inflate(R.layout.wrong_answer_toast, findViewById(R.id.wrong_answer_toast_container))
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }

    private fun correctAnswerStuff() {
        val inflater = layoutInflater

        val layout = inflater.inflate(R.layout.correct_answer_toast, findViewById(R.id.correct_answer_toast_container))
        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.butt_a ->
                if (optionA.text.equals(answer)) {
                    correctAnswerStuff()
                    if (currentQuestion < 4) {
                        currentQuestion++
                        setUpQuestion(currentQuestion)
                    } else {
                        unhideButton()
                    }
                } else {
                    wrongAnswerStuff()
                }
            R.id.butt_b ->
                if (optionB.text.equals(answer)) {
                    correctAnswerStuff()
                    if (currentQuestion < 4) {
                        currentQuestion++
                        setUpQuestion(currentQuestion)
                    } else {
                        unhideButton()
                    }
                } else {
                    wrongAnswerStuff()
                }
            R.id.butt_c ->
                if (optionC.text.equals(answer)) {
                    correctAnswerStuff()
                    if (currentQuestion < 4) {
                        currentQuestion++
                        setUpQuestion(currentQuestion)
                    } else {
                        unhideButton()
                    }
                } else {
                    wrongAnswerStuff()
                }
            R.id.butt_d ->
                if (optionD.text.equals(answer)) {
                    correctAnswerStuff()
                    if (currentQuestion < 4) {
                        currentQuestion++
                        setUpQuestion(currentQuestion)
                    } else {
                        unhideButton()
                    }
                } else {
                    wrongAnswerStuff()
                }
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

    private fun unhideButton() {
        doneButton.isClickable = true
        doneButton.visibility = View.VISIBLE
        doneButton.setOnClickListener {
            finishQuiz()
        }
    }

    private fun setUpQuestion(currentQuestion: Int) {

        question.setText(getString(questionBank.get(currentQuestion)))
        optionA.setText(getString(optionAs.get(currentQuestion)))
        optionB.setText(getString(optionBs.get(currentQuestion)))
        optionC.setText(getString(optionCs.get(currentQuestion)))
        optionD.setText(getString(optionDs.get(currentQuestion)))
        answer = getString(answers.get(currentQuestion))
    }

    private fun finishQuiz() {
        sharedPreferences.set("BasicQuizComplete", true)
        Toast.makeText(this, "You have completed Basic Quiz!", Toast.LENGTH_LONG).show()
        pepeHelper.throwConfetti(konfetti)
    }

}

