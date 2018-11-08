package com.quentinsylvia.is3261.pepeteacheskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem

class ClassObjectActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: ClassObjectDashboardRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_object)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.classObjectRecyclerViewDashboard)
        recyclerView.layoutManager = layoutManager
        adapter = ClassObjectDashboardRecycleAdapter(this)
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
}
