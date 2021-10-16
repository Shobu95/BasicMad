package com.shobu95.basicmad.screens.edit_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shobu95.basicmad.database.Developer
import com.shobu95.basicmad.database.DeveloperDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditProfileViewModel(
    val developer: Developer,
    val database: DeveloperDao
) : ViewModel() {

    private var _changeScreen = MutableLiveData<Boolean>()
    val changeScreen: LiveData<Boolean> get() = _changeScreen

    fun setData() {
        CoroutineScope(Dispatchers.Main).launch {
            updateDeveloper(developer)
        }
        _changeScreen.value = true
    }

    private suspend fun updateDeveloper(developer: Developer) {
        withContext(Dispatchers.IO) {
            database.update(developer)
        }
    }

    fun changeScreenComplete() {
        _changeScreen.value = false
    }
}