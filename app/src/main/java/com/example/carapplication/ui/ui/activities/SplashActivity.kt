package com.example.carapplication.ui.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.carapplication.R
import com.example.carapplication.datamodel.user.UserData

import com.example.carapplication.sharepreference.SharedPreference
import com.google.gson.Gson

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({

            if (SharedPreference.isLogin(this@SplashActivity)) {
                val userinfo = SharedPreference.getUserData(this@SplashActivity)
               val userInfoData = Gson().fromJson(userinfo, UserData::class.java)
                val i = Intent(this@SplashActivity, DashboardContainerActivity::class.java)
                i.putExtra("userData", userInfoData!!)
                startActivity(i)
                finish()

            }
                else {
                val firstIntent = Intent(this@SplashActivity, WelcomeActivity::class.java)
                startActivity(firstIntent)
                finish()
            }

        }, 2000)


    }
}