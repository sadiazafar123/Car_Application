package com.example.carapplication.datamodel.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserDataViewModel(application: Application):AndroidViewModel(application) {
    private var repository = UserRepository(application)
    val allUserInfo= repository.getAll()
    lateinit var userData: LiveData<UserData>

    private val allUsers: LiveData<List<UserData>>? = null

    fun insert(model: UserData?) {
        /* repository =  PersonalRepository()*/
        repository!!.insert(model)
    }
    fun update(model:UserData):LiveData<Int>{
       return repository.update(model)

    }
    fun specificUserData( id:Int):LiveData<UserData>{
       return repository.specificUserData(id)

    }
    fun userAlreadyExist(email:String):LiveData<UserData>{
        return repository.userAlreadyExist(email)

    }


    fun getAllInfo():LiveData<List<UserData>>{
        return allUserInfo

    }
   /* fun readLoginDataSend(password:String,email:String):LiveData<UserData>{
        return repository.verifyLoginUser(password,email)

    }*/
    //
   fun readLoginDataSend(password:String,email:String){
       userData= repository.verifyLoginUser(password,email)
   }
    fun readLoginDataResponse():LiveData<UserData>{
        return userData

    }

}