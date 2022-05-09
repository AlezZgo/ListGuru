package com.example.listguru.users_employed

import androidx.lifecycle.ViewModel
import com.example.listguru.UserUI

class UsersEmployedViewModel : ViewModel() {
    val users = listOf(
        UserUI.Success("Fred", 64),
        UserUI.Error("Not found"),
        UserUI.Loading( 24),
        )

}