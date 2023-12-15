package com.example.carapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carapplication.databinding.PersonalInfoBinding
import com.example.carapplication.datamodel.user.PersonalInformation
import com.example.carapplication.datamodel.user.UserData
import com.example.carapplication.datamodel.user.UserDataViewModel
import com.example.carapplication.ui.ui.activities.DashboardContainerActivity
import com.example.carapplication.sharepreference.SharedPreference
import com.google.gson.Gson

class PersonalInfo : Fragment() {
    lateinit var viewModel : UserDataViewModel
    lateinit var allInfo : List<UserData>


    lateinit var personInfoBinding: PersonalInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personInfoBinding=PersonalInfoBinding.inflate(inflater,container,false)
        val view=personInfoBinding.root
        return view

      //  return inflater.inflate(R.layout.personal_info, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this@PersonalInfo)[UserDataViewModel::class.java]


        personInfoBinding.personName.setText(DashboardContainerActivity.userData?.personalInfo?.name)
        personInfoBinding.personPhone.setText(DashboardContainerActivity.userData?.personalInfo?.phone.toString())
        personInfoBinding.personEmail.setText(DashboardContainerActivity.userData?.personalInfo?.eMail)
        personInfoBinding.btnUpdate.setOnClickListener(){
            updateUserInfo()
        }

    }
    fun updateUserInfo(){
        var password= DashboardContainerActivity.userData!!.personalInfo!!.Password
        var name=personInfoBinding.personName.text.toString()
        var phone=personInfoBinding.personPhone.text.toString()
        var email=personInfoBinding.personEmail.text.toString()
        var updatePersonData = PersonalInformation( name,phone.toLong(),email,password)
        /*var i=Intent(requireActivity(),CarInfo::class.java)
        i.putExtra("update_personal_info",updateUserObj)
      //  var gson=Gson().toJson(updateUserObj)
        startActivity(i)*/
        val useData=UserData(updatePersonData, DashboardContainerActivity.userData!!.vahicleInfo,
            DashboardContainerActivity.userData!!.id)



        viewModel.update(useData).observe(viewLifecycleOwner){
            if(it!=null){
                Log.v("updateData","data personalInfo "+it)
                if (it==1){
                    Toast.makeText(requireContext()," update data succesfully",Toast.LENGTH_SHORT).show()
                    //to get specific user info
                    viewModel.specificUserData(DashboardContainerActivity.userData!!.id!!)
                        .observe(viewLifecycleOwner){
                        Log.v("updateddata","data "+Gson().toJson(it))
                        val updatedInfo= Gson().toJson(it)
                            //save ,updated data, in share preference
                        SharedPreference.saveUSerInfo(updatedInfo,requireContext())
                            //updated info update in dashboard container also
                        DashboardContainerActivity.userData=it
                    }

                    //

                }
                else{
                    Toast.makeText(requireContext()," data is not updated",Toast.LENGTH_SHORT).show()


                }


            }else{
                Log.v("updateData","data personalInfo else ")
            }

        }



    }

}