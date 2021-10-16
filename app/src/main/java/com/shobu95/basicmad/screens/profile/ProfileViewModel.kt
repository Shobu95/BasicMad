package com.shobu95.basicmad.screens.profile

import androidx.lifecycle.ViewModel
import com.shobu95.basicmad.database.DeveloperDao

class ProfileViewModel(val database: DeveloperDao): ViewModel() {
    val developer = database.get()
}