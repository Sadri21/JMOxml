package com.app.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.ProgramActivity
import com.app.myapplication.R
import com.app.myapplication.databinding.ItemMenuDashboardBinding
import com.app.myapplication.listResource.ListResource.menuDashboard
import com.app.myapplication.listResource.MenuItem

class MainMenuAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var listMenu = menuDashboard

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MenuHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_menu_dashboard, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuHolder -> {
                holder.bind(listMenu[position])
            }
        }
    }

    inner class MenuHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMenuDashboardBinding.bind(itemView)

        fun bind(menu: MenuItem) {
            binding.nameMenu.text = menu.menuName
            binding.imgMenu.setImageResource(menu.menuImage)
            itemView.setOnClickListener {
                if (menu.menuName == "Info Program") {
                    val intent = Intent(context, ProgramActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }
}