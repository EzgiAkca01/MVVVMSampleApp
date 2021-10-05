package com.ezgiakca.mvvvmsampleapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase:RoomDatabase() {
    abstract  fun  getUserDao():UserDao

    companion object
    {
        @Volatile
        private var instance:AppDatabase? = null
        private  val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?:builDatabase(context).also {
                instance = it
            }
        }

        private fun builDatabase(context: Context)=
            Room.databaseBuilder(context,AppDatabase::class.java,"MyDatabase.db").build()

    }
}
