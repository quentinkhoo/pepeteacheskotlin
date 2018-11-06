package com.quentin.is3261.pepeteacheskotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.TransitionDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Adapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.get
import kotlinx.android.synthetic.main.activity_main.view.*
import nl.dionsegijn.konfetti.KonfettiView

class MainActivity : AppCompatActivity() {

    companion object {
        val QUIZ_REQUEST_CODE = 999
    }

    lateinit var sharedPreferences: SharedPreferences
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: MainRecyclerAdapter
    lateinit var pepeHelper: PepeTeachesKotlinHelper

    lateinit var arButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PepeSharedPreferences.defaultPrefs(this)
        layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recyclerViewMain)
        recyclerView.layoutManager = layoutManager
        adapter = MainRecyclerAdapter(this)
        recyclerView.adapter = adapter
        pepeHelper = PepeTeachesKotlinHelper()

        arButton = findViewById<ImageView>(R.id.ar_button)

        arButton.setOnClickListener{
            val arButtonArray = arrayOf(resources.getDrawable(R.drawable.ar_button),
                                                        resources.getDrawable(R.drawable.ar_button_on_touch))
            val td: TransitionDrawable = TransitionDrawable(arButtonArray)
            arButton.setImageDrawable(td)
            td.startTransition(1000)

            arButton.postDelayed({
                val arIntent = Intent(this, ARActivity::class.java)
                startActivity(arIntent)
                td.reverseTransition(1000)
            }, 1000)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DashboardRecyclerAdapter.BASIC_QUIZ_REQUEST_CODE ||
                requestCode == ControlFlowDashboardRecyclerAdapter.CONTROL_FLOW_REQUEST_CODE) {

            //Toast.makeText(this, data?.getBooleanExtra("finishedBasicQuiz", false).toString(), Toast.LENGTH_LONG).show()
            if (resultCode == Activity.RESULT_OK && data?.getBooleanExtra("finishedBasicQuiz", false) == true) {
                val konfettiView = findViewById<KonfettiView>(R.id.konfettiView)
                pepeHelper.throwConfetti(konfettiView)
                runLayoutAnimation(recyclerView)
            }

            if (resultCode == Activity.RESULT_OK && data?.getBooleanExtra("finishedControlFlowQuiz", false) == true) {
                val konfettiView = findViewById<KonfettiView>(R.id.konfettiView)
                pepeHelper.throwConfetti(konfettiView)
                runLayoutAnimation(recyclerView)
            }
        }
    }

    private fun runLayoutAnimation(recyclerView: RecyclerView) {
        val context = recyclerView.context
        val controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)

        recyclerView.layoutAnimation = controller
        recyclerView.adapter.notifyDataSetChanged()
        recyclerView.scheduleLayoutAnimation()
    }
}
