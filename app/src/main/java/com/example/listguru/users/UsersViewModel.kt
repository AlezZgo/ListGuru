package com.example.listguru.users

import androidx.lifecycle.ViewModel
import com.example.listguru.UserUI

class UsersViewModel : ViewModel() {
    val users = listOf(
        UserUI("Bob", 12),
        UserUI("Alex", 62),
        UserUI("Bill", 94),
        UserUI("John", 24),
        UserUI("Kate", 57),
        UserUI("Robe", 35),
    )

}