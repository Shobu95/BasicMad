package com.shobu95.basicmad.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Developer::class], version = 1)
abstract class DeveloperDatabase : RoomDatabase() {

    abstract val developerDao: DeveloperDao

    // for making static objects
    companion object {

        @Volatile // changes in this field are notified to other threads
        private var INSTANCE: DeveloperDatabase? = null

        fun getInstance(context: Context): DeveloperDatabase {
            // can be used by one thread at a time
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DeveloperDatabase::class.java,
                        "developer_database"
                    ).build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}