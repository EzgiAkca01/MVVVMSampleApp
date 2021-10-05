package com.ezgiakca.mvvvmsampleapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ezgiakca.mvvvmsampleapp.data.db.entities.CURRENT_USER_ID
import com.ezgiakca.mvvvmsampleapp.data.db.entities.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User)

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser():LiveData<User>
}