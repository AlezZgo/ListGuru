package com.example.listguru.users

import androidx.lifecycle.ViewModel
import com.example.listguru.UserUI

class UsersViewModel : ViewModel() {
    val users = listOf(
        UserUI.Success("Bob", 12),
        UserUI.Success("Alex", 62),
        UserUI.Error("Not found exception"),
        UserUI.Success("John", 24),
        UserUI.Loading(50),
        UserUI.Success("Robe", 35),
    )

}