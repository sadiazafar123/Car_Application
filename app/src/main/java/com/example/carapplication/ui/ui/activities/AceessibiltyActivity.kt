package com.example.carapplication.ui.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carapplication.databinding.ActivityAccessibilityBinding

class AceessibiltyActivity : AppCompatActivity() {
     private lateinit var accesbilityBinding:ActivityAccessibilityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* setContentView(R.layout.activity_accessibility)
        var btn_next=findViewById<Button>(R.id.btn_next)
        btn_next.setOnClickListener(){
            var fifthintent= Intent(this@AceessibiltyActivity, LoginContainerActivity::class.java)
            startActivity(fifthintent)
        }
*/    accesbilityBinding= ActivityAccessibilityBinding.inflate(layoutInflater)
        val view=accesbilityBinding.root
        setContentView(view)
        accesbilityBinding.btnNext.setOnClickListener(){

            var fifthintent= Intent(this@AceessibiltyActivity, LoginContainerActivity::class.java)
            startActivity(fifthintent)


        }
        accesbilityBinding.btnSkip.setOnClickListener(){
            var intent=Intent(this@AceessibiltyActivity, LoginContainerActivity::class.java)
            startActivity(intent)
        }







    }
}