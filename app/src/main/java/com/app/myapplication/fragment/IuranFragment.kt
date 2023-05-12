package com.app.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myapplication.R
import com.app.myapplication.adapter.ItemListCheckAdapter
import com.app.myapplication.databinding.FragmentIuranBinding


class IuranFragment : Fragment() {

    lateinit var viewBinding: FragmentIuranBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentIuranBinding.inflate(inflater, container, false)
        viewBinding.rvIuran.layoutManager = LinearLayoutManager(requireContext())
        val list = listOf("Besar Iuran Penerima Upah 2% Pekerja 3.7% Perushaan (dari upah yang dilaporkan)", "Besar Iuran Bukan Penerima Upah 2%", "Besar Iuran Pekerja Migran Indonesia:\nRp 50.000.000(Lima puluh ribu rupiah)\nRp 100.000.000(Seratur ribu rupiah)")
        val adapter = ItemListCheckAdapter(list)
        viewBinding.rvIuran.adapter = adapter
        return viewBinding.root
    }
}