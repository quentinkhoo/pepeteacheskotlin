package com.quentinsylvia.is3261.pepeteacheskotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.quentinsylvia.is3261.pepeteacheskotlin.PepeSharedPreferences.get

class DashboardRecyclerAdapter(val context: Context) : RecyclerView.Adapter<DashboardRecyclerAdapter.ViewHolder>() {

    companion object {
        val BASIC_QUIZ_REQUEST_CODE = 9999
    }

    private val itemImages = intArrayOf(R.drawable.number, R.drawable.alphabet, R.drawable.venn_diagram,
            R.drawable.chat, R.drawable.array_edited, R.drawable.collections, R.drawable.range,
            R.drawable.quiz_icon)

    private val itemTitles = arrayOf("Numbers", "Characters", "Boolean", "String", "Arrays", "Collections",
            "Ranges", "Basic Types Quiz")


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
        var currentItem: Int = 0
        var itemImage: ImageView
        var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.dashboardImg)
            itemTitle = itemView.findViewById(R.id.cardTitle)

            itemView.setOnClickListener(object : View.OnClickListener {
                var myIntent: Intent? = null
                override fun onClick(v: View) {
                    val position = getAdapterPosition()

                    v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.spin_rotate))
                    v.postDelayed({
                        when (position) {
                            0 -> {
                                myIntent = Intent(context, BasicTypesNumbersLessonActivity::class.java)
                                //context.startActivity(myIntent);
                                (context as Activity).startActivity(myIntent)
                            }
                            1 -> {
                                myIntent = Intent(context, BasicTypesCharactersLessonActivity::class.java)
                                (context as Activity).startActivity(myIntent)
                            }
                            2 -> {
                                myIntent = Intent(context, BasicTypeBooleanLessonActivity::class.java)
                                (context as Activity).startActivity(myIntent)

                            }
                            3 -> {
                                myIntent = Intent(context, BasicTypesStringLessonActivity::class.java)
                                (context as Activity).startActivity(myIntent)

                            }
                            4 -> {
                                myIntent = Intent(context, BasicTypesArraysLessonActivity::class.java)
                                (context as Activity).startActivity(myIntent)

                            }
                            5 -> {
                                myIntent = Intent(context, BasicTypesCollectionsLessonActivity::class.java)
                                (context as Activity).startActivity(myIntent)

                            }
                            6 -> {
                                myIntent = Intent(context, BasicTypesRangesLessonActivity::class.java)
                                (context as Activity).startActivity(myIntent)

                            }
                            7 -> {
                                myIntent = Intent(context, BasicTypesQuizActivity::class.java)
                                (context as Activity).startActivityForResult(myIntent, BASIC_QUIZ_REQUEST_CODE)
                            }
                            else -> Toast.makeText(context, "Coming Soon!", Toast.LENGTH_SHORT).show()
                        }
                    }, 500)
                }

            })
        }
    }
}