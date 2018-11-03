package com.quentin.is3261.pepeteacheskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.GridView
import android.widget.ScrollView

class TestActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: DashboardRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


        layoutManager = GridLayoutManager(this, 2)
        recyclerView = findViewById(R.id.recyclerViewDashboard)
        recyclerView.layoutManager = layoutManager
        adapter = DashboardRecyclerAdapter(this)
        recyclerView.adapter = adapter


    }
}
