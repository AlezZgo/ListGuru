package com.example.listguru.users

import android.content.Context

interface UserUiToUserViewMapper {
    fun map(
        context: Context,
        name: String = "",
        age: Int = 0,
        onAgeClickListener: (age: Int) -> Unit = {},
    ): UserView

    class Base : UserUiToUserViewMapper {
        override fun map(
            context: Context,
            name: String,
            age: Int,
            onAgeClickListener: (age: Int) -> Unit,
        ): UserView {
            return UserView(
                context,
                name = name,
                age = age,
                onAgeClickListener = onAgeClickListener)
        }

    }
}