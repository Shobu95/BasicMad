package com.shobu95.basicmad

import android.app.Application
import com.shobu95.basicmad.database.Developer
import com.shobu95.basicmad.database.DeveloperDao
import com.shobu95.basicmad.database.DeveloperDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BasicMad : Application() {

    // lateinit lets you declare a null variable
    // which will be initialized later
    private lateinit var database: DeveloperDao

    override fun onCreate() {
        super.onCreate()

        // A class to define your global level dependencies and objects
        //setBasicData()
    }

    private fun setBasicData() {
        database = DeveloperDatabase.getInstance(this).developerDao

        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                database.deleteAll()
            }
        }

        val basicDeveloper = Developer()
        basicDeveloper.name = "Basic Name"
        basicDeveloper.role = "Basic Role"
        basicDeveloper.description = "Basic Description"

        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO){
                database.insert(basicDeveloper)
            }
        }
    }

}