package com.example.carapplication.ui.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carapplication.databinding.ActivityRealNotificationBinding

class RealNotificationActivity : AppCompatActivity() {
   private lateinit var realNotificationBinding: ActivityRealNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* setContentView(R.layout.activity_real_notification)
        var btn_next= findViewById<Button>(R.id.btn_next)
        btn_next.setOnClickListener{
            var fourthintent = Intent(this@RealNotificationActivity, AceessibiltyActivity::class.java)
            startActivity(fourthintent)


        }*/
        realNotificationBinding=ActivityRealNotificationBinding.inflate(layoutInflater)
        val view=realNotificationBinding.root
        setContentView(view)
        realNotificationBinding.btnNext.setOnClickListener(){
            var fourthintent = Intent(this@RealNotificationActivity, AceessibiltyActivity::class.java)
            startActivity(fourthintent)

        }
        realNotificationBinding.btnSkip.setOnClickListener(){
            var intent=Intent(this@RealNotificationActivity, LoginContainerActivity::class.java)
            startActivity(intent)
        }





    }
}