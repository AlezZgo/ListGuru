package com.example.listguru.users_employed

import android.content.Context
import com.example.listguru.core.Abstract

interface UserEmployedUiToUserEmployedViewMapper : Abstract.Mapper {
    fun map(
        context: Context,
        name: String = "",
        age: Int = 0,
    ): UserEmployedView

    class Base : UserEmployedUiToUserEmployedViewMapper{
        override fun map(
            context: Context,
            name: String,
            age: Int,
        ): UserEmployedView {
            return UserEmployedView(
                context,
                name = name,
                age = age,
            )
        }

    }
}