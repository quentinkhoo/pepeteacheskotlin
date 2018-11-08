package com.quentinsylvia.is3261.pepeteacheskotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import cn.dreamtobe.messagehandler.MessageHandler
import kotlinx.android.synthetic.main.fragment_basic_types_numbers_lesson_part1.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BasicTypesNumbersLessonPart1 : Fragment() {

    companion object {
        fun newInstance() = BasicTypesNumbersLessonPart1()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_basic_types_numbers_lesson_part1, container, false)

        /* Can't convert animation to typewriter
        val animationset: AnimationSet = AnimationSet(true)
        myView.numberChapter.setText("")
        myView.numberIntro.setText("")

        myView.numberChapter.setCharacterDelay(150)
        myView.numberChapter.animateText(getString(R.string.chapter1_lesson_numbers))

        myView.numberIntro.setCharacterDelay(150)
        myView.numberIntro.animateText(getString(R.string.chapter1_lesson_numbers_part1))
        */
       // myView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in))

        return myView
    }


}
