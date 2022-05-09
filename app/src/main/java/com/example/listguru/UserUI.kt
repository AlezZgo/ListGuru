package com.example.listguru

import android.content.Context
import com.example.listguru.users.UserUiToUserViewMapper
import com.example.listguru.users_employed.UserEmployedUiToUserEmployedView

data class UserUI(
    private val name: String,
    private val age: Int,
) {

    fun map(context: Context, mapper: UserUiToUserViewMapper,block: (age: Int) -> Unit) =
        mapper.map(context, name, age, block)

    fun map(context: Context, mapper: UserEmployedUiToUserEmployedView,block: (name: String) -> Unit) =
        mapper.map(context, name, age, block)

}