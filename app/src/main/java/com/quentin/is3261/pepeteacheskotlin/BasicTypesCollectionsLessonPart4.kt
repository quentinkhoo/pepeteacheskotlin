package com.quentin.is3261.pepeteacheskotlin


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_basic_types_collections_lesson_part2.view.*
import kotlinx.android.synthetic.main.fragment_basic_types_collections_lesson_part4.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BasicTypesCollectionsLessonPart4 : Fragment() {

    private val url = "https://www.tutorialspoint.com/tpcg.php?p=yBYfCH"

    companion object {
        fun newInstance() = BasicTypesCollectionsLessonPart4()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_basic_types_collections_lesson_part4, container, false)
        myView.collections3.setOnClickListener {
            val urlIntent = Intent(context, TryKotlinActivity::class.java)
            urlIntent.putExtra("KotlinUrl", url)
            startActivity(urlIntent)
        }
        return myView
    }


}
