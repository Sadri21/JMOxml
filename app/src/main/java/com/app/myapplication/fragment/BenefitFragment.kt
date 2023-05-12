package com.app.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.myapplication.R
import com.app.myapplication.adapter.ItemListCheckAdapter
import com.app.myapplication.databinding.FragmentBenefitBinding


class BenefitFragment : Fragment() {
    // TODO: Rename and change types of parameters

    lateinit var viewBinding: FragmentBenefitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentBenefitBinding.inflate(inflater, container, false)
        viewBinding.rvBenefit.layoutManager = LinearLayoutManager(requireContext())
        val listString = listOf("Akumulasi iuran ditambah hasil pengembangan yang besarnya minimal setara rata-rata tingkat suku bungan depostio bank pemerintah")
        val adapter = ItemListCheckAdapter(listString)
        viewBinding.rvBenefit.adapter = adapter
        return viewBinding.root
    }


}