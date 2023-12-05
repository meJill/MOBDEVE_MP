package com.mobdeve.mp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobdeve.mp.StudentDataHelper
import com.mobdeve.mp.StudentAdapter
import com.mobdeve.mp.MyDatabaseHelper
import com.mobdeve.mp.StudentPostModel


import com.mobdeve.mp.R

class homeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val name = arguments?.getString("name").toString()
        println(name)
        val dbHelper = MyDatabaseHelper(requireContext())
        val data: ArrayList<StudentPostModel>  = StudentDataHelper.studentData(dbHelper.getAllCompanies())

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.horizontalRv)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = StudentAdapter(data, requireContext(), name)
        recyclerView.adapter = adapter
        return view
    }
}
