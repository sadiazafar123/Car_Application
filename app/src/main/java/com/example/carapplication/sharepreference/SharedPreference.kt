package com.example.carapplication.sharepreference

import android.content.Context

object SharedPreference {
    // Store the data in the SharedPreference
     private var SHARE_PREF_NAME = "login"
     private var USER_DATA_KEY   = "userKEY"


     fun saveUSerInfo(userInfo: String, context: Context) {
         val sharedPreference=context.getSharedPreferences(SHARE_PREF_NAME,Context.MODE_PRIVATE)
         val editor=sharedPreference.edit()
         editor.putString(USER_DATA_KEY,userInfo)
         editor.apply()
     }
    fun isLogin(context: Context):Boolean{
        val sharedPreference=context.getSharedPreferences(SHARE_PREF_NAME,Context.MODE_PRIVATE)
        return sharedPreference.getString(USER_DATA_KEY,null)!=null
    }


    fun getUserData(context: Context):String{
        val sharedPreference=context.getSharedPreferences(SHARE_PREF_NAME,Context.MODE_PRIVATE)
        return sharedPreference.getString(USER_DATA_KEY,null)!!
    }

    fun logOut(context: Context){
        val sharedPreference=context.getSharedPreferences(SHARE_PREF_NAME,Context.MODE_PRIVATE)
        val editor=sharedPreference.edit()
        editor.clear()
        editor.apply()





    }

}