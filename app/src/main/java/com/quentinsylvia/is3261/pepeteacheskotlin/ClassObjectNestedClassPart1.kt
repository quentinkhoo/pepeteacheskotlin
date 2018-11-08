package com.quentinsylvia.is3261.pepeteacheskotlin


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_basic_types_ranges_lesson_part2.view.*
import kotlinx.android.synthetic.main.fragment_class_object_nested_class_part1.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ClassObjectNestedClassPart1 : Fragment() {

    private val url = "https://pl.kotl.in/B1FkYTe6m"

    companion object {
        fun newInstance() = ClassObjectNestedClassPart1()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val myView = inflater.inflate(R.layout.fragment_class_object_nested_class_part1, container, false)

        myView.nestedClassLessonImage1.setOnClickListener {
            val urlIntent = Intent(context, TryKotlinActivity::class.java)
            urlIntent.putExtra("KotlinUrl", url)
            startActivity(urlIntent)
        }

        return myView
    }


}
