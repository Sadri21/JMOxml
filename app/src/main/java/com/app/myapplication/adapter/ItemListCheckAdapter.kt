package com.app.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.R
import com.app.myapplication.databinding.ItemListCheckBinding

class ItemListCheckAdapter(val listString: List<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return checkAdapterHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_check, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listString.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is checkAdapterHolder -> {
                holder.bind(listString[position])
            }
        }
    }

    inner class checkAdapterHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val viewBinding = ItemListCheckBinding.bind(itemView)

        fun bind(string: String) {
            viewBinding.tvCheckContent.text = string
        }
    }
}