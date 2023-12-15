package com.example.carapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carapplication.databinding.CarInfoBinding
import com.example.carapplication.datamodel.user.UserData
import com.example.carapplication.datamodel.user.UserDataViewModel
import com.example.carapplication.datamodel.user.VahicleInfo
import com.example.carapplication.ui.ui.activities.DashboardContainerActivity
import com.example.carapplication.sharepreference.SharedPreference
import com.google.gson.Gson

class CarInfo : Fragment() {
    lateinit var carInfoBinding: CarInfoBinding
    lateinit var viewModel : UserDataViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        carInfoBinding=CarInfoBinding.inflate(inflater,container,false)
        val view=carInfoBinding.root
        return view
       // return inflater.inflate(R.layout.car_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


         viewModel=ViewModelProvider(this@CarInfo)[UserDataViewModel::class.java]
        //receiving object of updated personal infromation



        carInfoBinding.carName.setText(DashboardContainerActivity.userData?.vahicleInfo?.carName)
        carInfoBinding.carType.setText(DashboardContainerActivity.userData?.vahicleInfo?.carType)
        carInfoBinding.carColor.setText(DashboardContainerActivity.userData?.vahicleInfo?.carColor)
        carInfoBinding.btnUpdate.setOnClickListener(){
            updateCarInfo()
        }




    }
   fun updateCarInfo(){
       var carName = carInfoBinding.carName.text.toString()
       var carType = carInfoBinding.carType.text.toString()
       var carColor= carInfoBinding.carColor.text.toString()
       var updateCarInfo = VahicleInfo( carName , carType , carColor)
       var userData = UserData(
           DashboardContainerActivity.userData!!.personalInfo,updateCarInfo,
           DashboardContainerActivity.userData!!.id)
       viewModel.update(userData).observe(viewLifecycleOwner){
           if (it!=null){
               Toast.makeText(requireContext(),"update vahicle info",Toast.LENGTH_SHORT).show()
               if (it==1){
                   //to get specific user detail
                   viewModel.specificUserData(DashboardContainerActivity.userData!!.id!!).
                   observe(viewLifecycleOwner){
                       val updatedInfo= Gson().toJson(it)
                       //update data in share prefrence
                       SharedPreference.saveUSerInfo(updatedInfo,requireContext())
                       //update data in dashboard
                       DashboardContainerActivity.userData=it

                   }
               }

           }
           else
           {
               Toast.makeText(requireContext(),"not updated user data",Toast.LENGTH_SHORT).show()
           }

       }


    }

}