package com.example.listguru.users_employed

import androidx.lifecycle.ViewModel
import com.example.listguru.UserUI

class UsersEmployedViewModel : ViewModel() {
    val users = listOf(
        UserUI("Fred", 64),
        UserUI("Trevor", 22),
        UserUI("Mark", 24),
        )

}