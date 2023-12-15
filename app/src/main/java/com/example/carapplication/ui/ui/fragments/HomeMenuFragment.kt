package com.example.carapplication.ui.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carapplication.R
import com.example.carapplication.ui.ui.activities.DashboardContainerActivity
import com.example.carapplication.finaproj.adapters.DashboardAdapter
import com.example.carapplication.finaproj.dataclasses.UserData

class HomeMenuFragment : Fragment() {
    lateinit var recycler:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_menu, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler= view.findViewById(R.id.recycler_view)
        var name=view.findViewById<TextView>(R.id.tvName)
        name.setText(DashboardContainerActivity.userData?.personalInfo?.name)
        setRecyclerData()
    }
    fun setRecyclerData(){
        val recyclerDataList:ArrayList<UserData> =  ArrayList()
        recyclerDataList.add(UserData("parking available","Red carper","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","Red carpet","washington Dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))
        recyclerDataList.add(UserData("parking available","red carpet","washington dc",R.drawable.flower))


        val parkinginfoAdapter: DashboardAdapter= DashboardAdapter(recyclerDataList)
        recycler.layoutManager= LinearLayoutManager(requireContext())
        recycler.adapter= parkinginfoAdapter


       // Log.v("Userdata","data name "+DashboardContainerActivity.userData?.personalInfo?.name)



    }

}