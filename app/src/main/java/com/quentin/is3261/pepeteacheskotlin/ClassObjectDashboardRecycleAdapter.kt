package com.quentin.is3261.pepeteacheskotlin

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

class ClassObjectDashboardRecycleAdapter(val context: Context) : RecyclerView.Adapter<ClassObjectDashboardRecycleAdapter.ViewHolder>() {

    companion object {
        val CLASS_OBJECT_REQUEST_CODE = 9998
    }

    private val itemImages = intArrayOf(R.drawable.nested_class, R.drawable.inner_class,
            R.drawable.type_aliases,R.drawable.quiz_icon)

    private val itemTitles = arrayOf("Nested Class", "Inner Class", "Type Aliases", "Class Object Quiz")

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
                    v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.spin_rotate))
                    v.postDelayed({
                        when (position) {
                            0 -> {
                                myIntent = Intent(context, ClassObjectNestedClassLessonActivity::class.java)
                                //context.startActivity(myIntent);
                                (context as Activity).startActivity(myIntent)
                            }
                            1 -> {
                                myIntent = Intent(context, ClassObjectInnerClassLessonActivity::class.java)
                                //context.startActivity(myIntent);
                                (context as Activity).startActivity(myIntent)
                            }
                            2 -> {
                                myIntent = Intent(context, ClassObjectTypeAliasesLessonActivity::class.java)
                                //context.startActivity(myIntent);
                                (context as Activity).startActivity(myIntent)
                            }
                            3 -> {
                                Toast.makeText(context, "Work still in progress", Toast.LENGTH_LONG).show()
                                myIntent = Intent(context, ControlFlowQuizActivity::class.java)
                                (context as Activity).startActivityForResult(myIntent, ClassObjectDashboardRecycleAdapter.CLASS_OBJECT_REQUEST_CODE)
                            }

                            else -> Toast.makeText(context, "Coming Soon!", Toast.LENGTH_SHORT).show()
                        }

                    }, 500)
                }
            })
        }
    }
}