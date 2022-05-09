package com.example.listguru.users

import android.content.Context
import com.example.listguru.core.Abstract

interface UserUiToUserViewMapper : Abstract.Mapper {
    fun map(
        context: Context,
        name: String = "",
        age: Int = 0,
    ): UserView

    class Base : UserUiToUserViewMapper {
        override fun map(
            context: Context,
            name: String,
            age: Int,
        ): UserView {
            return UserView(
                context,
                name = name,
                age = age,
            )
        }

    }
}