package com.example.listguru.users_employed

import android.content.Context
import com.example.listguru.users.UserView

interface UserEmployedUiToUserEmployedView {
    fun map(
        context: Context,
        name: String = "",
        age: Int = 0,
        onNameClickListener: (name: String) -> Unit = {},
    ): UserEmployedView

    class Base : UserEmployedUiToUserEmployedView{
        override fun map(
            context: Context,
            name: String,
            age: Int,
            onNameClickListener: (name: String) -> Unit,
        ): UserEmployedView {
            return UserEmployedView(
                context,
                name = name,
                age = age,
                onNameClickListener = onNameClickListener
            )
        }

    }
}