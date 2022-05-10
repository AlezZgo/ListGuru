package com.example.listguru.users_employed

import android.content.Context
import com.example.listguru.core.Abstract

interface UserEmployedUiToUserEmployedViewMapper : Abstract.UserMapper<UserEmployedView<*,*>> {

    class Base(
        private val context: Context,
    ) : UserEmployedUiToUserEmployedViewMapper {

        override fun map(name: String, age: Int) = UserEmployedView.Success(
            context, name = name, age = age
        )

        override fun map(errorMessage: String) = UserEmployedView.Error(
            context,
            errorMessage = errorMessage
        )

        override fun map(progressValue: Int) = UserEmployedView.Loading(
            context, progressValue = progressValue
        )

    }

}