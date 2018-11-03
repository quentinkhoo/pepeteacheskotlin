package com.quentin.is3261.pepeteacheskotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BasicsQuizFragment() : Fragment() {

    companion object {
        fun newInstance(position: Int): BasicsQuizFragment {
            val fragment = BasicsQuizFragment()
            val args = Bundle()
            args.putInt("position", position)
            fragment.setArguments(args)
            return fragment
        }
    }

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        question = view.findViewById<TextView>(R.id.question)
        optionA = view.findViewById<Button>(R.id.butt_a)
        optionB = view.findViewById<Button>(R.id.butt_b)
        optionC = view.findViewById<Button>(R.id.butt_c)
        optionD = view.findViewById<Button>(R.id.butt_d)
        setUpQuestion(this.arguments!!.getInt("position"))

        return view
    }

    private fun setUpQuestion(position: Int) {
        question.setText(getString(questionBank.get(position)))
        optionA.setText(getString(optionAs.get(position)))
        optionB.setText(getString(optionBs.get(position)))
        optionC.setText(getString(optionCs.get(position)))
        optionD.setText(getString(optionDs.get(position)))
        answer = getString(answers.get(position))
    }

}
