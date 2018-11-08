package com.quentinsylvia.is3261.pepeteacheskotlin


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_control_flow_while_loop_part1.view.*
import kotlinx.android.synthetic.main.fragment_control_flow_while_loop_part3.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ControlFlowWhileLoopPart3 : Fragment() {

    private val url = "https://pl.kotl.in/rksDvdJpm"

    companion object {
        fun newInstance() = ControlFlowWhileLoopPart3()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_control_flow_while_loop_part3, container, false)

        myView.whileLoopLessonImage2.setOnClickListener {
            val urlIntent = Intent(context, TryKotlinActivity::class.java)
            urlIntent.putExtra("KotlinUrl", url)
            startActivity(urlIntent)
        }

        return myView
    }


}
