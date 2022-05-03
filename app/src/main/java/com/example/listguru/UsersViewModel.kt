package com.example.listguru

import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {
    val users = listOf<UserUI>(
        UserUI("Bob", 12),
        UserUI("Alex", 62),
        UserUI("Bill", 94),
        UserUI("John", 24),
        UserUI("Kate", 57),
        UserUI("Robe", 35),
    )

}