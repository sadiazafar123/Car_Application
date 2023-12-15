package com.example.carapplication.ui.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carapplication.databinding.ActivityFindParkingBinding

class FindParkingActivity : AppCompatActivity() {
     private lateinit var findParkingBinding: ActivityFindParkingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_find_parking)
       // var btn_next= findViewById<Button>(R.id.btn_next)
       /* btn_next.setOnClickListener{
            var thirdIntent = Intent(this, RealNotificationActivity::class.java)
            startActivity(thirdIntent)
        }*/
       // binding method
        findParkingBinding=ActivityFindParkingBinding.inflate(layoutInflater)
        val view=findParkingBinding.root
        setContentView(view)
        findParkingBinding.btnNext.setOnClickListener(){
            var thirdIntent = Intent(this, RealNotificationActivity::class.java)
            startActivity(thirdIntent)

        }
        findParkingBinding.btnSkip.setOnClickListener(){
            var intent=Intent(this@FindParkingActivity, LoginContainerActivity::class.java)
            startActivity(intent)
        }

    }
}