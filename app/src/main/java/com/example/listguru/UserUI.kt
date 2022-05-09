package com.example.listguru

import android.content.Context
import com.example.listguru.users.UserUiToUserViewMapper
import com.example.listguru.users_employed.UserEmployedUiToUserEmployedViewMapper

data class UserUI(
    private val name: String,
    private val age: Int,
) {

    fun map(context: Context, mapper: UserUiToUserViewMapper) =
        mapper.map(context, name, age)

    fun map(context: Context, mapper: UserEmployedUiToUserEmployedViewMapper) =
        mapper.map(context, name, age)

}