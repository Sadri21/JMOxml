package com.app.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.myapplication.adapter.ViewPagerAdapter
import com.app.myapplication.databinding.ActivityDetailProgramBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailProgramActivity : AppCompatActivity() {

    lateinit var viewBinding : ActivityDetailProgramBinding
    val itemArray = arrayOf(
        "Manfaat",
        "Besar Iuran"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityDetailProgramBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        supportActionBar!!.hide()
        val stringTitle = intent.getStringExtra("title") ?: ""
        val imageInt = intent.getIntExtra("image", 0)
        viewBinding.imgService.setImageResource(imageInt)
        viewBinding.titleService.text = stringTitle
        viewBinding.tvServiceName.text = stringTitle
        val viewPager = viewBinding.viewPager
        val tabLayout = viewBinding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter
        viewBinding.backButton.setOnClickListener {
            finish()
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = itemArray[position]
        }.attach()

    }
}