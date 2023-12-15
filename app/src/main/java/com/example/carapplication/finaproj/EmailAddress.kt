package com.example.carapplication.finaproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.carapplication.R
import com.example.carapplication.databinding.EmailAddressBinding
import com.example.carapplication.databinding.FragmentLoginBinding

class EmailAddress : Fragment() {
    lateinit var navController: NavController
    lateinit var emailAddressBinding:EmailAddressBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return inflater.inflate(R.layout.email_address, container, false)
        //binding method
        emailAddressBinding= EmailAddressBinding.inflate(inflater,container,false)
        val view=emailAddressBinding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController= Navigation.findNavController(requireActivity(),R.id.fragment_container)
        //simple method
       /* view.findViewById<AppCompatButton>(R.id.btn_resetpasemail).setOnClickListener {

            navController.navigate(R.id.action_emailAddress2_to_resetPassword2)
        }*/
        //binding
        emailAddressBinding.btnResetpasemail.setOnClickListener(){
            navController.navigate(R.id.action_emailAddress2_to_resetPassword2)


        }


    }


}