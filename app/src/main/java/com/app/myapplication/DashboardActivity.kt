package com.app.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myapplication.adapter.BannerAdapter
import com.app.myapplication.adapter.MainMenuAdapter
import com.app.myapplication.adapter.ProgramLayananRVAdapter
import com.app.myapplication.databinding.ActivityDashboardBinding
import com.google.android.material.tabs.TabLayoutMediator


class DashboardActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        supportActionBar!!.hide()
        viewBinding.rvProgramLayanan.layoutManager = LinearLayoutManager(this)
        viewBinding.rvMainMenu.layoutManager = GridLayoutManager(this, 4)
        val adapter = ProgramLayananRVAdapter("dashboard", this)
        val menuAdapter = MainMenuAdapter(this)
        viewBinding.rvProgramLayanan.adapter = adapter
        viewBinding.rvMainMenu.adapter = menuAdapter
        val adapterBanner = BannerAdapter()
        viewBinding.pagerDashboard.adapter = adapterBanner
        TabLayoutMediator(viewBinding.intoTabLayout, viewBinding.pagerDashboard)
        { _, _ ->}.attach()

        runningBanner()
    }

    private fun runningBanner() {
        val handler = Handler()
        val run = object : Runnable {
            override fun run() {
                handler.postDelayed(this, 7000)// 7 seconds
                if (viewBinding.pagerDashboard.currentItem == 1) {
                    viewBinding.pagerDashboard.currentItem = 0
                } else {
                    viewBinding.pagerDashboard.currentItem = viewBinding.pagerDashboard.currentItem + 1
                }
                Log.e("TAG", "run: " + viewBinding.pagerDashboard.currentItem)

            }
        }
        handler.post(run)
    }
}