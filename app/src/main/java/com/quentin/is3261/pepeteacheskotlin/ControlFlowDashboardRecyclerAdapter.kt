package com.quentin.is3261.pepeteacheskotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.get

class ControlFlowDashboardRecyclerAdapter(val context: Context) : RecyclerView.Adapter<ControlFlowDashboardRecyclerAdapter.ViewHolder>() {

    companion object {
        val REQUEST_CODE = 998
    }

    private val itemImages = intArrayOf(R.drawable.if_else, R.drawable.when_statement, R.drawable.for_loop,
            R.drawable.while_loop, R.drawable.return_icon, R.drawable.break_and_continue, R.drawable.quiz_icon)

    private val itemTitles = arrayOf("If-Else", "When", "For Loop", "While Loop", "Return",
            "Break & Continue", "Control Flow Quiz")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.dashboard_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(itemImages.get(position))
        holder.itemTitle.text = itemTitles.get(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.dashboardImg)
            itemTitle = itemView.findViewById(R.id.cardTitle)

            itemView.setOnClickListener(object : View.OnClickListener {
                var myIntent: Intent? = null
                override fun onClick(v: View) {
                    val position = getAdapterPosition()
                    when (position) {
                        0 -> {
                            myIntent = Intent(context, ControlFlowIfElseLessonActivity::class.java)
                            //context.startActivity(myIntent);
                            (context as Activity).startActivity(myIntent)
                        }
                        1 -> {
                            myIntent = Intent(context, ControlFlowWhenLessonActivity::class.java)
                            (context as Activity).startActivity(myIntent)
                        }
                        2 -> {
                            myIntent = Intent(context, ControlFlowForLoopLessonActivity::class.java)
                            (context as Activity).startActivity(myIntent)
                        }
                        3 -> {
                            myIntent = Intent(context, ControlFlowWhileLoopLessonActivity::class.java)
                            (context as Activity).startActivity(myIntent)
                        }
                        4 -> {
                            myIntent = Intent(context, ControlFlowReturnLessonActivity::class.java)
                            (context as Activity).startActivity(myIntent)
                        }
                        5 -> {
                            myIntent = Intent(context, ControlFlowContBreakLessonActivity::class.java)
                            (context as Activity).startActivity(myIntent)
                        }
                        6 -> {
                            myIntent = Intent(context, ControlFlowQuizActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, REQUEST_CODE)
                        }
                        else -> Toast.makeText(context, "Coming Soon!", Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }
    }
}