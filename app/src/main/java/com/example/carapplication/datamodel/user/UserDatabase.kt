package com.example.carapplication.datamodel.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [UserData::class], version = 2)
 abstract class UserDatabase :RoomDatabase(){

      abstract fun userDataDao():UserDataDao
      companion object{
          private  var instance:UserDatabase?=null
          @Synchronized
         fun getInstance(context:Context):UserDatabase{
             if (instance==null)
                 instance= Room.databaseBuilder(context.applicationContext, UserDatabase::class.java,
                     "personal_info_database").fallbackToDestructiveMigration().addCallback(
                     roomCallback
                 ).build()
              return instance!!


          }
          private val roomCallback = object : Callback() {
              override fun onCreate(db: SupportSQLiteDatabase) {
                  super.onCreate(db)
                  //populateDatabase(instance!!)
                  //PopulateDbAsyncTask(instance!!).execute();
                  populateDatabase(instance!!)
              }
          }
          private fun populateDatabase(db:UserDatabase){
              val noteDao=db.userDataDao()
              /*  subscribeOnBackground {
                    noteDao.insert(PersonalInfo("sadia",40,"msc","teaching"))
                    noteDao.insert(PersonalInfo("sana",30,"ics","teaching"))
                    noteDao.insert(PersonalInfo("asia",20,"b.com","banking"))

                }*/

          }







      }

}