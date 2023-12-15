package com.example.carapplication.finaproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.carapplication.R
import com.example.carapplication.databinding.EmailAddressBinding
import com.example.carapplication.databinding.ResetPasswordBinding

class ResetPassword : Fragment() {
    lateinit var navController: NavController
    lateinit var resetPassBinding:ResetPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //simple method
      //  return inflater.inflate(R.layout.reset_password, container, false)
        resetPassBinding= ResetPasswordBinding.inflate(inflater,container,false)
        val view=resetPassBinding.root
        return view



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(requireActivity(),R.id.fragment_container)
        //simple method
       /* view.findViewById<AppCompatButton>(R.id.btn_resetpassword).setOnClickListener {

            navController.navigate(R.id.activity6Login2)
        }*/
        //binding
        resetPassBinding.btnResetpassword.setOnClickListener(){
            navController.navigate(R.id.activity6Login2)


        }


    }

}