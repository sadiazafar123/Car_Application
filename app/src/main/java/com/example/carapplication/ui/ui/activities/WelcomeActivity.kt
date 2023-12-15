package com.example.carapplication.ui.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carapplication.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

   private lateinit var welcomeBinding: ActivityWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // simple method for fectching ids
       // setContentView(R.layout.activity_welcome)
        //var btn_next=findViewById<Button>(R.id.btn_next)
        welcomeBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = welcomeBinding.root
        setContentView(view)


        welcomeBinding.btnNext.setOnClickListener{
            var secondintent = Intent(this@WelcomeActivity, FindParkingActivity::class.java)
            startActivity(secondintent)

        }
        welcomeBinding.btnSkip.setOnClickListener(){
            var intent=Intent(this@WelcomeActivity, LoginContainerActivity::class.java)
            startActivity(intent)
        }

    }
}