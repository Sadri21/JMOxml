package com.app.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication.R
import com.app.myapplication.databinding.ItemImageBinding
import com.app.myapplication.databinding.ItemMenuDashboardBinding
import com.app.myapplication.listResource.ListResource.listBannerSrc
import com.app.myapplication.listResource.MenuItem

class BannerAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val listBanner = listBannerSrc

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listBanner.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageHolder -> {
                holder.bind(listBanner[position])
            }
        }
    }

    inner class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemImageBinding.bind(itemView)

        fun bind(banerSrc: Int) {
            binding.imgBanner.setImageResource(banerSrc)
        }
    }
}