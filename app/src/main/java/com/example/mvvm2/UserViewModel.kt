package com.example.mvvm2

import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UserViewModel : ViewModel() {
    private val _user = MutableStateFlow<User>(User())
    val user: StateFlow<User> = _user

    fun setUser(id: Int, name: String) {
        // _user.value = User(id = id, name = name)
        _user.update { user ->user.copy(id=id,name=name) }
    }
}