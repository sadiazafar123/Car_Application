package com.example.carapplication.datamodel.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.selects.select


@Dao
interface UserDataDao {
    @Insert
    fun insert(userData: UserData)
    @Delete
    fun delete(userData: UserData)
    @Update
      fun update(userData: UserData):Int




    @Query("select * from user_data_table")
    fun getAllInfo(): LiveData<List<UserData>>

    //@Query("select * from user_data_table where eMail Like , eMail AND Password Like :Password")

    @Query("SELECT * FROM user_data_table WHERE eMail LIKE :email AND password LIKE :password")
    fun readLoginData(email:String, password:String):LiveData<UserData>
    @Query("SELECT * FROM user_data_table WHERE id LIKE :id ")
    fun specificUserData( id : Int ):LiveData<UserData>
    //query for checking email/user alreadt exist at the time of registration
    @Query("SELECT * FROM USER_DATA_TABLE WHERE eMail LIKE :email ")
    fun userAlreadyExist(email: String): LiveData<UserData>


}