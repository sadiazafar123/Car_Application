package com.example.carapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.carapplication.databinding.CreateAccountBinding
import com.example.carapplication.databinding.FragmentLoginBinding
import com.example.carapplication.datamodel.user.PersonalInformation
import com.example.carapplication.datamodel.user.UserDataViewModel

class CreateAccount : Fragment() {
    lateinit var navController: NavController
    lateinit var createAcntBinding: CreateAccountBinding
    lateinit var viewModel: UserDataViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //simple
        //return inflater.inflate(R.layout.create_account, container, false)
        //binding
        createAcntBinding = CreateAccountBinding.inflate(inflater, container, false)
        val view = createAcntBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_container)

        viewModel= ViewModelProvider(this@CreateAccount)[UserDataViewModel::class.java]
        //simple
        /* view.findViewById<AppCompatButton>(R.id.btn_accountnext).setOnClickListener {

             navController.navigate(R.id.action_createAccount_to_vahicleInformation)
         }*/
        //binding
        createAcntBinding.btnAccountnext.setOnClickListener() {
            validation()
            // navController.navigate(R.id.action_createAccount_to_vahicleInformation,)


        }


    }

    fun validation() {
        if (createAcntBinding.etName.text.toString().isNullOrEmpty()) {
            createAcntBinding.etName.setError("must be fill")
        } else if (createAcntBinding.etPhoneNo.text.toString().isNullOrEmpty()) {
            createAcntBinding.etPhoneNo.setError("must be fill")

        } else if (createAcntBinding.etEmailAdress.text.toString().isNullOrEmpty()) {
            createAcntBinding.etEmailAdress.setError("must be fill")
        } else if (android.util.Patterns.EMAIL_ADDRESS.matcher(createAcntBinding.etEmailAdress.text.toString())
                .matches().not()
        )
        {
            createAcntBinding.etEmailAdress.setError("email format is wrong")
        } else if (createAcntBinding.etPassword.text.toString().isNullOrEmpty()) {
            createAcntBinding.etPassword.setError("must be fill")
        } else if (createAcntBinding.etPassword.length() < 8) {
            createAcntBinding.etPassword.setError("password length must be greater than 8 digit")

        } else if (createAcntBinding.etConfirmPassword.text.toString().isNullOrEmpty())
        {
            createAcntBinding.etConfirmPassword.setError("must be fill")
        } else if (createAcntBinding.etPassword.text.toString()
                .equals(createAcntBinding.etConfirmPassword.text.toString()).not()
        )
        {
            createAcntBinding.etConfirmPassword.setError("password and confirm password must be match")
        } else {
            saveData()
        }
        /* var a:String="a"
         var b:String="b"
             if(a.equals(b))
     */
    }

    fun saveData() {
        var userName = createAcntBinding.etName.text.toString().trim()
        var userPhone = createAcntBinding.etPhoneNo.text.toString().trim()
        var userEmail = createAcntBinding.etEmailAdress.text.toString().trim()
        var userPassword = createAcntBinding.etPassword.text.toString().trim()
        var userConfrimPassword = createAcntBinding.etConfirmPassword.text.toString()


        var personalInformationObject = PersonalInformation(
            userName, userPhone.toLong(), userEmail, userPassword)


        viewModel.userAlreadyExist(userEmail).observe(viewLifecycleOwner){
            Log.v("usernull","$it")
            if (it==null){
               Log.v("usernull","if")
                Toast.makeText(requireContext(),"user does not exist",Toast.LENGTH_SHORT).show()
                //creating the instance of the bundle
                val bundle = Bundle()
                // storing the object in the bundle
                bundle.putParcelable("personal_information", personalInformationObject)
                navController.navigate(R.id.action_createAccount_to_vahicleInformation, bundle)

            } else{
                Toast.makeText(requireContext(),"user already exist",Toast.LENGTH_SHORT).show()
            }

        }

         //creating the instance of the bundle
      // val bundle = Bundle()
        // storing the object in the bundle


      // bundle.putParcelable("personal_information", personalInformationObject)
        /*val intent= Intent (this@CreateAccount,VahicleInformation::class.java)
        intent.putExtras(bundle)*/
      //  navController.navigate(R.id.action_createAccount_to_vahicleInformation, bundle)

    }
}