package com.quentinsylvia.is3261.pepeteacheskotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ClassObjectInnerClassLessonPart4 : Fragment() {

    private val url = "https://www.tutorialspoint.com/tpcg.php?p=TdGTLL"

    companion object {
        fun newInstance() = ClassObjectInnerClassLessonPart4()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_class_object_inner_class_lesson_part4, container, false)
    }


}
