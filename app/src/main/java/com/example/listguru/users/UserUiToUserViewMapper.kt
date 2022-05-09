package com.example.listguru.users

import android.content.Context
import com.example.listguru.core.Abstract

interface UserUiToUserViewMapper : Abstract.Mapper {
    fun map(
        context: Context,
        name: String = "",
        age: Int = 0,
    ): UserView.Success

    fun map(
        context: Context,
        errorMessage: String = "Error",
    ): UserView.Error

    fun map(
        context: Context,
        progressValue: Int,
    ): UserView.Loading

    class Base : UserUiToUserViewMapper {
        override fun map(
            context: Context,
            name: String,
            age: Int,
        ): UserView.Success {
            return UserView.Success(
                context,
                name = name,
                age = age,
            )
        }

        override fun map(context: Context, errorMessage: String): UserView.Error {
            return UserView.Error(
                context,
                errorMessage = errorMessage
            )
        }

        override fun map(context: Context, progressValue: Int): UserView.Loading {
            return UserView.Loading(
                context, progressValue = progressValue
            )
        }

    }
}