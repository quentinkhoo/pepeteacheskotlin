package com.quentinsylvia.is3261.pepeteacheskotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class BasicTypesActivity : AppCompatActivity() {


    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: DashboardRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_types)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.recyclerViewDashboard)
        recyclerView.layoutManager = layoutManager
        adapter = DashboardRecyclerAdapter(this)
        recyclerView.adapter = adapter


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home) {
            finish()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == DashboardRecyclerAdapter.BASIC_QUIZ_REQUEST_CODE
            && resultCode == Activity.RESULT_OK) {
            val myIntent = Intent()
            myIntent.putExtra("finishedBasicQuiz", data?.getBooleanExtra("finishedBasicQuiz", false))
            setResult(Activity.RESULT_OK, myIntent)
            finish()
        }
    }

}
