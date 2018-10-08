package com.quentin.is3261.pepeteacheskotlin


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BasicTypesPart7Fragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    private var myPreferences = "myPrefs"
    private var unlockedAR = "unlockedAR"

    companion object {
        fun newInstance() = BasicTypesPart7Fragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_basic_types_part7, container, false)

        val finishLesson1Button = myView.findViewById<Button>(R.id.finishlesson1_butt)
        finishLesson1Button.setOnClickListener {

            sharedPreferences = this.getActivity()!!.getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean(unlockedAR, true)
            editor.apply()

            getActivity()?.finish()
        }

        return myView
    }


}
