package com.mobdeve.mp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.mp.CompanyAdapter
import com.mobdeve.mp.CompanyDataHelper
import com.mobdeve.mp.CompanyPostModel
import com.mobdeve.mp.DataHelper
import com.mobdeve.mp.MyAdapter
import com.mobdeve.mp.PostModel
import com.mobdeve.mp.R

class bookFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private val data: ArrayList<PostModel>  = DataHelper.initializeData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.horizontalRv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MyAdapter(this.data)
        recyclerView.adapter = adapter
        return view
    }
}