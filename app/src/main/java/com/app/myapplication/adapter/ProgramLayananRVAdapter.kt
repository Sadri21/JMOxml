package com.app.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.DetailProgramActivity
import com.app.myapplication.R
import com.app.myapplication.databinding.ItemLayananAllBinding
import com.app.myapplication.databinding.ItemLayananDashboardBinding
import com.app.myapplication.listResource.LayananItem
import com.app.myapplication.listResource.ListResource.layananListMenu

class ProgramLayananRVAdapter(val from: String, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val listLayanan = layananListMenu

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (from == "dashboard") {
            ServiceDashboardHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_layanan_dashboard, parent, false)
            )
        } else {
            ServiceHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_layanan_all, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return if (from == "dashboard") {
            2
        } else {
            listLayanan.size
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ServiceDashboardHolder -> {
                holder.bind(listLayanan[position])
            }
            is ServiceHolder -> {
                holder.bind(listLayanan[position])
            }
        }
    }

    inner class ServiceDashboardHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayananDashboardBinding.bind(itemView)

        fun bind(service: LayananItem) {
            binding.tvServiceName.text = service.layananName
            binding.tvServiceDescription.text = service.layananDescription
            binding.imgService.setImageResource(service.layananImage)
        }
    }

    inner class ServiceHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemLayananAllBinding.bind(itemView)

        fun bind(service: LayananItem) {
            binding.tvServiceName.text = service.layananName
            binding.imgService.setImageResource(service.layananImage)
            itemView.setOnClickListener {
                val intent = Intent(context, DetailProgramActivity::class.java)
                intent.putExtra("title", service.layananName)
                intent.putExtra("image", service.layananImage)
                context.startActivity(intent)
            }
        }
    }
}