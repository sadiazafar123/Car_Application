package com.example.carapplication.ui.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.carapplication.databinding.ActivityLoginContainerBinding

class LoginContainerActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var loginContainerBinding: ActivityLoginContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_login_container)
      //binding
        loginContainerBinding=ActivityLoginContainerBinding.inflate(layoutInflater)
        val  view=loginContainerBinding.root
        setContentView(view)




    }
}