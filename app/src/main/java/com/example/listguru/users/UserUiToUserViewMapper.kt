package com.example.listguru.users

import android.content.Context
import com.example.listguru.core.Abstract

interface UserUiToUserViewMapper : Abstract.UserMapper<UserView<*, *>> {

    class Base(
        private val context: Context,
    ) : UserUiToUserViewMapper {

        override fun map(name: String, age: Int) = UserView.Success(
            context, name = name, age = age
        )

        override fun map(errorMessage: String) = UserView.Error(
            context,
            errorMessage = errorMessage
        )

        override fun map(progressValue: Int) = UserView.Loading(
            context, progressValue = progressValue
        )

    }
}