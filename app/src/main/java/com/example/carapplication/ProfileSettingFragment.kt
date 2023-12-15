package com.example.carapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.carapplication.databinding.EmailAddressBinding
import com.example.carapplication.databinding.FragmentProfileSettingBinding
import com.example.carapplication.finaproj.adapters.ViewPager2Adapter
import com.google.android.material.tabs.TabLayoutMediator

val infoArray= arrayOf(
    "personal info"," car setting"
)

class ProfileSettingFragment : Fragment() {
    lateinit var profileSettingBinding:FragmentProfileSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //simple method
        //return inflater.inflate(R.layout.fragment_profile_setting, container, false)
        //binding
        profileSettingBinding= FragmentProfileSettingBinding.inflate(inflater,container,false)
        val view=profileSettingBinding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout=profileSettingBinding.tabLayout
        val viewPager2=profileSettingBinding.viewPager2
        val adapter=ViewPager2Adapter(requireActivity().supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            tab.text= infoArray[position]

        }.attach()

    }
        }
        //simple methodsu
       // var btnPersonalInfo=view.findViewById<Button>(R.id.btn_personal_info)
      //  var btnCarInfo=view.findViewById<Button>(R.id.btn_car_info)
      //  var rlPersonalInfo=view.findViewById<RelativeLayout>(R.id.rl_personal_info)
       // var rlCarInfo=view.findViewById<RelativeLayout>(R.id.rl_car_info)
        //simple method
       /* btnPersonalInfo.setOnClickListener(){
            btnPersonalInfo.setBackgroundResource(R.drawable.carinfo_shape)
            btnCarInfo.setBackgroundResource(R.drawable.personalinfo_shape)

            btnPersonalInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            btnCarInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue2))

            rlPersonalInfo.visibility=View.VISIBLE
            rlCarInfo.visibility=View.GONE
        }*/
        //Binding method
      /*  profileSettingBinding.btnPersonalInfo.setOnClickListener(){
            profileSettingBinding.btnPersonalInfo.setBackgroundResource(R.drawable.carinfo_shape)
            profileSettingBinding.btnCarInfo.setBackgroundResource(R.drawable.personalinfo_shape)
            profileSettingBinding.btnPersonalInfo.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            profileSettingBinding.btnCarInfo.setTextColor(ContextCompat.getColor(requireContext(),R.color.blue2))
            profileSettingBinding.rlPersonalInfo.visibility=View.VISIBLE
            profileSettingBinding.rlCarInfo.visibility=View.GONE
        }*/
        //simple method


       /* btnCarInfo.setOnClickListener(){
            btnPersonalInfo.setBackgroundResource(R.drawable.personalinfo_shape)
            btnCarInfo.setBackgroundResource(R.drawable.carinfo_shape)

            btnCarInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            btnPersonalInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue2))

            rlCarInfo.visibility= View.VISIBLE
            rlPersonalInfo.visibility=View.GONE

        }*/
        //Binding method
       /* profileSettingBinding.btnCarInfo.setOnClickListener(){
            profileSettingBinding.btnPersonalInfo.setBackgroundResource(R.drawable.personalinfo_shape)
            profileSettingBinding.btnCarInfo.setBackgroundResource(R.drawable.carinfo_shape)

            profileSettingBinding. btnCarInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            profileSettingBinding.btnPersonalInfo.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue2))

          profileSettingBinding.rlCarInfo.visibility= View.VISIBLE
              profileSettingBinding.rlPersonalInfo.visibility=View.GONE

        }
*/




