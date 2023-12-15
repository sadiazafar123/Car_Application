package com.example.carapplication.finaproj

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.carapplication.R
import com.example.carapplication.databinding.FragmentLoginBinding
import com.example.carapplication.datamodel.user.UserDataViewModel
import com.example.carapplication.ui.ui.activities.DashboardContainerActivity
import com.example.carapplication.sharepreference.SharedPreference
import com.google.gson.Gson

class LoginFragment : Fragment() {
    lateinit var navController: NavController
     lateinit var fragmentBinding:FragmentLoginBinding
     lateinit var viewModel:UserDataViewModel
     lateinit var email:EditText
     lateinit var password:EditText


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //simple_method
        //return inflater.inflate(R.layout.fragment_login, container, false)
        //binding method
        fragmentBinding=FragmentLoginBinding.inflate(inflater,container,false)
        val view=fragmentBinding.root
        return view



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        //simple method
        //navcontroller will use simple not with binding
       navController= Navigation.findNavController(requireActivity(),R.id.fragment_container)
       //simple method
       /* view.findViewById<TextView>(R.id.tvForgotPassword).setOnClickListener {
            navController.navigate(R.id.action_activity6Login2_to_emailAddress2)
        }*/
        //binding method

        fragmentBinding.tvForgotPassword.setOnClickListener(){
            navController.navigate(R.id.action_activity6Login2_to_emailAddress2)
        }
        //simple method

       /* view.findViewById<TextView>(R.id.btn_signup).setOnClickListener {
            navController.navigate(R.id.action_activity6Login2_to_createAccount)
        }*/
        //binding method
        fragmentBinding.btnSignUp.setOnClickListener(){
            navController.navigate(R.id.action_activity6Login2_to_createAccount)
        }
       /* view.findViewById<Button>(R.id.btn_signin).setOnClickListener {
            navController.navigate(R.id.container_bottom_navigation)
        }*/
        //simple method
       /* view.findViewById<Button>(R.id.btn_signin).setOnClickListener(){
            var signIn_intent= Intent(requireActivity(), DashboardContainerActivity::class.java)
            startActivity(signIn_intent)
        }*/
        //binding method
        viewModel=ViewModelProvider(this@LoginFragment)[UserDataViewModel::class.java]
        fragmentBinding.btnSignin.setOnClickListener(){
            validation()

            //simple intenet or move from one activity to another

           /* var signIn_intent= Intent(requireActivity(), DashboardContainerActivity::class.java)
            startActivity(signIn_intent)
*/
        }
        /*btn_next.setOnClickListener{
            var secondintent = Intent(this@Activity2Welcome, Activity3FindParking::class.java)
            startActivity(secondintent)

        }*/ }
    fun validation(){
        if (fragmentBinding.etEmail.text.toString().isNullOrEmpty()){
            fragmentBinding.etEmail.setError("must be fill")
        }else if (fragmentBinding.etPassword.text.toString().isNullOrEmpty()){
            fragmentBinding.etPassword.setError("must be fill")
        } else {
            verifyLoginData()

        }

    }
    fun verifyLoginData(){
        email = fragmentBinding.etEmail
        password = fragmentBinding.etPassword
        var email:String=email.text.toString()
        var password:String=password.text.toString()

        viewModel.readLoginDataSend(email,password)

        viewModel.readLoginDataResponse().observe(requireActivity()){
            //here we are receiving object of user data in "it",we can store "it" in another variable to avoid confusion
            if (it!=null){

               // Toast.makeText(requireContext(),"email and password corect",Toast.LENGTH_SHORT).show()
              // Log.v("Userdata","data id "+it.id)
            //method :2 to send object by using json
               //Log.v("Userdata","data personalInfo "+ Gson().toJson(it.personalInfo))
              // Log.v("Userdata","data vahicleInfo "+ Gson().toJson(it.vahicleInfo))


                //method :2 to send object by using json

                var userinfo=Gson().toJson(it)
                SharedPreference.saveUSerInfo(userinfo,requireContext())

                var intent = Intent(requireActivity(), DashboardContainerActivity::class.java)
                intent.putExtra("userData",it)
                startActivity(intent)


            }
            else
            {
                Toast.makeText(requireContext(),"email and password mismatch",Toast.LENGTH_SHORT).show()
            }


        }
    }

}