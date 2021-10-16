package com.shobu95.basicmad.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shobu95.basicmad.database.DeveloperDao

class ProfileViewModelFactory(private val database: DeveloperDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(database) as T
    }
}