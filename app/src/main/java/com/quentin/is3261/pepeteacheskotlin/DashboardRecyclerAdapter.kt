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

class DashboardRecyclerAdapter(val context: Context) : RecyclerView.Adapter<DashboardRecyclerAdapter.ViewHolder>() {

    companion object {
        val REQUEST_CODE = 1
    }

    private val itemImages = intArrayOf(R.drawable.number, R.drawable.alphabet, R.drawable.venn_diagram,
            R.drawable.chat, R.drawable.array_edited, R.drawable.collections, R.drawable.range,
            R.drawable.quiz_icon)

    private val itemTitles = arrayOf("Numbers", "Characters", "Boolean", "String", "Arrays", "Collections",
            "Ranges", "Quiz")


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
                    when (position) {
                        0 -> {
                            myIntent = Intent(context, BasicTypesNumbersLessonActivity::class.java)
                            //context.startActivity(myIntent);
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)
                        }
                        1 -> {
                            myIntent = Intent(context, BasicTypesCharactersLessonActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)
                        }
                        2 -> {
                            myIntent = Intent(context, BasicTypeBooleanLessonActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)

                        }
                        3 -> {
                            myIntent = Intent(context, BasicTypesStringLessonActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)

                        }
                        4 -> {
                            myIntent = Intent(context, BasicTypesArraysLessonActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)

                        }
                        5 -> {
                            myIntent = Intent(context, BasicTypesCollectionsLessonActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)

                        }
                        7 -> {
                            myIntent = Intent(context, BasicTypesQuizActivity::class.java)
                            (context as Activity).startActivityForResult(myIntent, DashboardRecyclerAdapter.REQUEST_CODE)
                        }
                        else -> Toast.makeText(context, "Coming Soon!", Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }
    }
}