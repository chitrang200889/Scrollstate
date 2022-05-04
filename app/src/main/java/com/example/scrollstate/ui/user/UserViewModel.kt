package com.example.scrollstate.ui.user

import androidx.lifecycle.ViewModel
import com.example.scrollstate.data.repository.UserLocalDataSource
import com.example.scrollstate.model.User


class UserViewModel : ViewModel() {
    val userList: List<User> = UserLocalDataSource.users

    var currentUser : User? = null
}