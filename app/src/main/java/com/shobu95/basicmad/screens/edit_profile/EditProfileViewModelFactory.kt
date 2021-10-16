package com.shobu95.basicmad.screens.edit_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shobu95.basicmad.database.Developer
import com.shobu95.basicmad.database.DeveloperDao

class EditProfileViewModelFactory(
    private val developer: Developer,
    private val database: DeveloperDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EditProfileViewModel(developer, database) as T
    }
}