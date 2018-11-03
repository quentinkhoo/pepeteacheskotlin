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
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.set
import com.quentin.is3261.pepeteacheskotlin.PepeSharedPreferences.get

class MainRecyclerAdapter(val context: Context) : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {

    companion object {
        val REQUEST_CODE = 999
    }

    private val itemImages = intArrayOf(R.drawable.thinking_pepe, R.drawable.party_pepe, R.drawable.pepe_oop,
            R.drawable.stressed_out_pepe_2, R.drawable.retarded_pepe)

    private val itemTitles = arrayOf("Try out Kotlin!", "Lesson 1: Basic Types", "Lesson 2: Control Flow", "Lesson 3: Class & Object",
            "Augmented Reality: Enter Pepe Land")

    private val unlockedIcon = R.drawable.icon_unlock

    private val lockedIcon = R.drawable.icon_lock

    lateinit var sharedPreferences: SharedPreferences

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.main_menu_card, parent, false)
        val viewHolder = ViewHolder(v)
        sharedPreferences = PepeSharedPreferences.defaultPrefs(context)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(itemImages.get(position))
        holder.itemTitle.text = itemTitles.get(position)
        if (position == 0)
            holder.itemUnlock.setImageResource(unlockedIcon)
        if (position == 1)
            holder.itemUnlock.setImageResource(unlockedIcon)
        if (position == 2)
            if (sharedPreferences.get("BasicQuizComplete")?: false == true)
                holder.itemUnlock.setImageResource(unlockedIcon)
            else
                holder.itemUnlock.setImageResource(lockedIcon)
        if (position == 3)
            if (sharedPreferences.get("ControlFlowQuizComplete")?: false == true)
                holder.itemUnlock.setImageResource(unlockedIcon)
            else
                holder.itemUnlock.setImageResource(lockedIcon)
        if (position == 4)
            if (sharedPreferences.get("BasicQuizComplete")?: false == true)
                holder.itemUnlock.setImageResource(unlockedIcon)
            else
                holder.itemUnlock.setImageResource(lockedIcon)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemUnlock: ImageView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTextView)
            itemUnlock = itemView.findViewById(R.id.itemLock)

            itemView.setOnClickListener(object : View.OnClickListener {
                var myIntent: Intent? = null
                override fun onClick(v: View) {
                    val position = getAdapterPosition()
                    when (position) {
                        0 -> {
                            myIntent = Intent(context, TryKotlinActivity::class.java)
                            (context as Activity).startActivity(myIntent)
                        }
                        1 -> {
                            myIntent = Intent(context, BasicTypesActivity::class.java)
                            //context.startActivity(myIntent);
                            (context as Activity).startActivityForResult(myIntent, REQUEST_CODE)
                        }
                        2 -> {
                            if (sharedPreferences.get("BasicQuizComplete")?: false == true) {
                                myIntent = Intent(context, Lesson2Activity::class.java)
                                (context as Activity).startActivityForResult(myIntent, REQUEST_CODE)
                            } else {
                                Toast.makeText(context, "You have yet to finish the previous lesson", Toast.LENGTH_LONG).show()
                            }
                        }
                        3 -> {
                            if (sharedPreferences.get("ControlFlowQuizComplete")?: false == true) {
                                myIntent = Intent(context, Lesson2Activity::class.java)
                                (context as Activity).startActivityForResult(myIntent, REQUEST_CODE)
                            } else {
                                Toast.makeText(context, "You have yet to finish the previous lesson", Toast.LENGTH_LONG).show()
                            }
                        }
                        4 -> {
                            myIntent = Intent(context, ARActivity::class.java)
                            if (sharedPreferences.get("BasicQuizComplete", false) == true) {
                                (context as Activity).startActivity(myIntent)
                            } else {
                                Toast.makeText(context, "You have yet to unlock AR Mode.", Toast.LENGTH_LONG).show()
                            }
                        }
                        else -> Toast.makeText(context, "Coming Soon!", Toast.LENGTH_SHORT).show()
                    }

                }
            })
        }
    }
}