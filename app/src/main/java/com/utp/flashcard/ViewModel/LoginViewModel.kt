package com.utp.flashcard.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.utp.flashcard.database.entities.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _nickName = MutableStateFlow("")
    val nickName: StateFlow<String> = _nickName

    private val _loggedInUserId = MutableStateFlow<Int?>(null)
    val loggedInUserId: StateFlow<Int?> = _loggedInUserId

    // Funciones para actualizar los campos
    fun updateName(newName: String) {
        _name.value = newName
    }

    fun updateNickName(newNickname: String) {
        _nickName.value = newNickname
    }

    // Lógica de login
    fun loginUser() {
        val user = User(
            _name.value,
            _nickName.value
        )
        _loggedInUserId.value = user.id
    }




}