package com.example.carapplication.ui.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.carapplication.R
import com.example.carapplication.databinding.ActivityDashboardContainerBinding
import com.example.carapplication.datamodel.user.UserData
import com.example.carapplication.sharepreference.SharedPreference


class DashboardContainerActivity : AppCompatActivity() {
    lateinit var navController: NavController
  //  lateinit var bottomNavigationView : BottomNavigationView
   lateinit var dashBoardBinding : ActivityDashboardContainerBinding
   companion object{
       var userData: UserData? =null
   }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setContentView(R.layout.activity_dashboard_container)
        userData = intent.extras!!.getParcelable("userData")
        dashBoardBinding = ActivityDashboardContainerBinding.inflate(layoutInflater)
        val view = dashBoardBinding.root
        setContentView(view)


     //   val bottomNavigationView= findViewById<BottomNavigationView>(R.id.bottomNavigation)

        navController= Navigation.findNavController(this@DashboardContainerActivity,R.id.dashboard_fragment_container)
  //     NavigationUI.setupWithNavController(bottomNavigationView, navController)
        NavigationUI.setupWithNavController(dashBoardBinding.bottomNavigation, navController)

    //to click on specific bottom navigation graph item ,use this ,method
        dashBoardBinding.bottomNavigation.menu.findItem(R.id.logoutItem).setOnMenuItemClickListener {
            SharedPreference.logOut(this@DashboardContainerActivity)
            val i= Intent(this@DashboardContainerActivity, SplashActivity::class.java)
            startActivity(i)
            finish()
            true
        }

    }

}