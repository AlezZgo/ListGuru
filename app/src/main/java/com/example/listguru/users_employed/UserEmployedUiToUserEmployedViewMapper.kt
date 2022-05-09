package com.example.listguru.users_employed

import android.content.Context
import com.example.listguru.core.Abstract
import com.example.listguru.users.UserView

interface UserEmployedUiToUserEmployedViewMapper : Abstract.Mapper {
    fun map(
        context: Context,
        name: String = "",
        age: Int = 0,
    ): UserEmployedView

    fun map(
        context: Context,
        errorMessage: String = "Error",
    ): UserEmployedView

    fun map(
        context: Context,
        progressValue: Int,
    ): UserEmployedView


    class Base : UserEmployedUiToUserEmployedViewMapper{
        override fun map(
            context: Context,
            name: String,
            age: Int,
        ): UserEmployedView {
            return UserEmployedView.Success(
                context,
                name = name,
                age = age,
            )
        }

        override fun map(context: Context, errorMessage: String): UserEmployedView {
            return UserEmployedView.Error(
                context,
                errorMessage = errorMessage
            )
        }

        override fun map(context: Context, progressValue: Int): UserEmployedView {

            return UserEmployedView.Loading(
                context, progressValue = progressValue
            )
        }

    }
}