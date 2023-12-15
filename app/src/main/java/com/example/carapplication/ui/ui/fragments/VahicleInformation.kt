package com.example.carapplication.ui.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.carapplication.R
import com.example.carapplication.databinding.ActivityVahicleInformationBinding
import com.example.carapplication.datamodel.user.PersonalInformation
import com.example.carapplication.datamodel.user.UserData
import com.example.carapplication.datamodel.user.UserDataViewModel
import com.example.carapplication.datamodel.user.VahicleInfo

class VahicleInformation : Fragment() {
    lateinit var navController: NavController
    lateinit var vahicleInfoBinding:ActivityVahicleInformationBinding
    lateinit var viewModel:UserDataViewModel
    lateinit var personalInformation:PersonalInformation


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return inflater.inflate(R.layout.activity_vahicle_information, container, false)
        vahicleInfoBinding= ActivityVahicleInformationBinding.inflate(inflater,container,false)
        val view=vahicleInfoBinding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(requireActivity(), R.id.fragment_container)
        ///receive bundle
        val bundle= this.arguments

        if (bundle!= null){
            /*var personalInformationObj :PersonalInformation =
                bundle.getParcelable("personal_information",PersonalInformation)!!*/
             personalInformation = bundle!!.getParcelable("personal_information")!!
            Log.v("personalInformation","personalInformation  "+ personalInformation!!.name)
        }


        /* view.findViewById<AppCompatButton>(R.id.btn_nextvahicle).setOnClickListener {

             navController.navigate(R.id.activity6Login2)
         }*/
        //binding
        viewModel= ViewModelProvider(this@VahicleInformation)[UserDataViewModel::class.java]

        vahicleInfoBinding.btnSignUp.setOnClickListener(){
            //simple navigation
           // navController.navigate(R.id.activity6Login2)
            validation()

        }
        /*var useData:UserData=UserData(personalInfo = )*/

    }
    fun validation(){
        if (vahicleInfoBinding.carName.text.toString().isNullOrEmpty()){
            vahicleInfoBinding.carName.setError("must be fill")
        } else if (vahicleInfoBinding.carType.text.toString().isNullOrEmpty()){
            vahicleInfoBinding.carType.setError("must be fill")
        }else if (vahicleInfoBinding.carColor.text.toString().isNullOrEmpty()){
            vahicleInfoBinding.carColor.setError("must be fill")
        }else {
            saveData()
        }

    }
    fun saveData(){
        var carName=vahicleInfoBinding.carName.text.toString()
        var carType=vahicleInfoBinding.carType.text.toString()
        var carColor=vahicleInfoBinding.carColor.text.toString()
        var vahicleInformation= VahicleInfo(carName,carType,carColor)
        var userData:UserData= UserData(personalInformation,vahicleInformation)
        viewModel.insert(userData)


        Toast.makeText(requireContext(),"saved data in database",Toast.LENGTH_SHORT).show()
        requireActivity().finish()

    }
}