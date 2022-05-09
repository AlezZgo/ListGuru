package com.example.listguru

import android.content.Context
import com.example.listguru.users.MappableToUserView
import com.example.listguru.users.UserUiToUserViewMapper
import com.example.listguru.users.UserView
import com.example.listguru.users_employed.MappableToUserEmployedView
import com.example.listguru.users_employed.UserEmployedUiToUserEmployedViewMapper
import com.example.listguru.users_employed.UserEmployedView

sealed class UserUI : MappableToUserView {

    //todo Вынести в интерфейс
    abstract fun map(
        context: Context,
        mapper: UserEmployedUiToUserEmployedViewMapper,
    ): UserEmployedView

    data class Success(
        private val name: String,
        private val age: Int,
    ) : UserUI() {
        override fun map(context: Context, mapper: UserUiToUserViewMapper): UserView {
            return mapper.map(context, name, age)
        }

        override fun map(
            context: Context,
            mapper: UserEmployedUiToUserEmployedViewMapper,
        ): UserEmployedView {
            return mapper.map(context, name, age)
        }

    }

    data class Error(
        private val errorMessage: String,
    ) : UserUI() {
        override fun map(context: Context, mapper: UserUiToUserViewMapper): UserView {
            return mapper.map(context,errorMessage)
        }

        override fun map(
            context: Context,
            mapper: UserEmployedUiToUserEmployedViewMapper,
        ): UserEmployedView {
            return mapper.map(context,errorMessage)
        }
    }

    data class Loading(
        private val progressValue : Int
    ) : UserUI() {
        override fun map(context: Context, mapper: UserUiToUserViewMapper): UserView {
            return mapper.map(context, progressValue = progressValue)
        }

        override fun map(
            context: Context,
            mapper: UserEmployedUiToUserEmployedViewMapper,
        ): UserEmployedView {
            return mapper.map(context, progressValue = progressValue)
        }

    }


}