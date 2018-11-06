package com.quentin.is3261.pepeteacheskotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_control_flow_if_else_lesson_part1.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ControlFlowIfElseLessonPart1 : Fragment() {

    companion object {
        fun newInstance() = ControlFlowIfElseLessonPart1()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_control_flow_if_else_lesson_part1, container, false)

        view.ifelse_lesson_intro.setText("")
        view.ifelse_lesson_intro.setCharacterDelay(20)
        view.ifelse_lesson_intro.animateText(getString(R.string.chapter2_lesson_ifelse_part1))

        return view
    }


}
