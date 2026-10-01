package com.example.mvvm2

import androidx.lifecycle.ViewModel
import com.example.mvvm2.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {
    private val _user = MutableStateFlow(User())
    val user: StateFlow<User> = _user

    fun setUser(selectedUser: User) {
        _user.value = selectedUser
    }
}