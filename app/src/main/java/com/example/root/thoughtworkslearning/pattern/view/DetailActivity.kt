package com.example.root.thoughtworkslearning.pattern.view

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.ViewPager
import com.example.root.thoughtworkslearning.R
import com.example.root.thoughtworkslearning.pattern.adapter.weatherPagerAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    companion object {
        public fun intance(context: Context) : Intent =Intent(context, DetailActivity::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onResume() {
        super.onResume()
        pager.adapter = weatherPagerAdapter(supportFragmentManager,"Item")
        tab_layout.setupWithViewPager(pager)

    }
}
