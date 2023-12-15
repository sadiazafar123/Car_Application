package com.example.carapplication.finaproj.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.carapplication.R
import com.example.carapplication.databinding.FragmentLoginBinding
import com.example.carapplication.databinding.RecyclerLayoutBinding
import com.example.carapplication.finaproj.dataclasses.UserData

class DashboardAdapter(val recyclerDataList: ArrayList<UserData>) : RecyclerView.Adapter
<DashboardAdapter.MyDashBoardAdapter>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDashBoardAdapter {
        val binding: RecyclerLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_layout,
            parent,
            false
        )
        /* val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
         Log.v("animalAdapter", "on create view holder")
         val myAdapterPractice = MyDashBoardAdapter(view)*/
        return MyDashBoardAdapter(binding)

    }

    override fun getItemCount(): Int {
        return recyclerDataList.size
    }

    override fun onBindViewHolder(holder: MyDashBoardAdapter, position: Int) {
        /*  holder.textParkingAvailable.text=recyclerDataList[position].name
          holder.textParkingType.text=recyclerDataList[position].type
          holder.textParkingAdres.text=recyclerDataList[position].address.toString()
          holder.image.setImageResource(recyclerDataList[position].image)*/

        holder.binding.tvParkingAdres.text=recyclerDataList[position].name
        holder.binding.tvParkingType.text=recyclerDataList[position].type
        holder.binding.tvParkingVailable.text=recyclerDataList[position].name
        holder.binding.civImg.setImageResource(recyclerDataList[position].image)
    }

    /* class MyDashBoardAdapter(itemview: View):RecyclerView.ViewHolder(itemview){
         var textParkingAvailable: TextView = itemview.findViewById(R.id.tv_parking_vailable)
         var textParkingType: TextView = itemview.findViewById(R.id.tv_parking_type)
         var textParkingAdres : TextView = itemview.findViewById(R.id.tv_parking_adres)
         var image : ImageView = itemview.findViewById(R.id.civ_img)


     }*/
  inner  class MyDashBoardAdapter(val binding: RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root)


}