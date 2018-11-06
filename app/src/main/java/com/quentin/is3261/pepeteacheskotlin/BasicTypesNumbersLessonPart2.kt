package com.quentin.is3261.pepeteacheskotlin


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.fragment_basic_types_numbers_lesson_part2.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BasicTypesNumbersLessonPart2 : Fragment() {

    private val numbersLessonImage1Url = "https://pl.kotl.in/BJojHu1a7"

    companion object {
        fun newInstance() = BasicTypesNumbersLessonPart2()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_basic_types_numbers_lesson_part2, container, false)
        //myView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))

        myView.numbersLessonImage1.setOnClickListener {
            val urlIntent = Intent(context, TryKotlinActivity::class.java)
            urlIntent.putExtra("KotlinUrl", numbersLessonImage1Url)
            startActivity(urlIntent)
        }
        return myView
    }

}
