package com.app.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myapplication.adapter.ProgramLayananRVAdapter
import com.app.myapplication.databinding.ActivityProgramBinding

class ProgramActivity : AppCompatActivity() {

    lateinit var viewBinding: ActivityProgramBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProgramBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        supportActionBar!!.hide()
        viewBinding.rvService.layoutManager = LinearLayoutManager(this)
        val adapter = ProgramLayananRVAdapter("menu", this)
        viewBinding.rvService.adapter = adapter
        viewBinding.imgButton.setOnClickListener {
            finish()
        }

    }
}