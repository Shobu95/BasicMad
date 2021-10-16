package com.shobu95.basicmad.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DeveloperDao {

    @Insert
    fun insert(developer: Developer)

    @Query("SELECT * FROM developer")
    fun get(): LiveData<Developer>

    @Update
    fun update(developer: Developer)

    @Query("DELETE from developer")
    fun deleteAll()

}