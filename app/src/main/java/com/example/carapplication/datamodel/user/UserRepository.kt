package com.example.carapplication.datamodel.user

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserRepository(application: Application) {
    var dao: UserDataDao? =null
    var allInfo: LiveData<List<UserData>>
     var ack: MutableLiveData<Int>?=null
    val database=UserDatabase.getInstance(application)

    init {
        dao=database.userDataDao()
        allInfo = dao!!.getAllInfo()
    }


    fun insert(model:UserData?){
        subscribeOnBackground {
            dao!!.insert(model!!)
        }
    }


    fun update(model: UserData): MutableLiveData<Int> {
        ack= MutableLiveData()
        subscribeOnBackground {
        val updateResponse=dao!!.update(model)
            ack!!.postValue(updateResponse)

        }
        return ack!!

    }
     fun specificUserData(id: Int):LiveData<UserData>{
        return dao!!.specificUserData(id)
     }
    fun userAlreadyExist(email: String):LiveData<UserData>{
        return dao!!.userAlreadyExist(email)
    }




    fun verifyLoginUser(email:String,password:String): LiveData<UserData> {
     return   dao!!.readLoginData(email,password)
    }


    fun getAll():LiveData<List<UserData>>{
     return allInfo

 }

}