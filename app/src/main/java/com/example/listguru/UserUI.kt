package com.example.listguru

import com.example.listguru.core.Abstract

sealed class UserUI : Abstract.User {

    data class Success(
        private val name: String,
        private val age: Int,
    ) : UserUI() {

        override fun <T> map(mapper: Abstract.UserMapper<T>): T = mapper.map(name, age)
    }

    data class Error(
        private val errorMessage: String,
    ) : UserUI() {

        override fun <T> map(mapper: Abstract.UserMapper<T>): T = mapper.map(errorMessage)
    }

    data class Loading(
        private val progressValue: Int,
    ) : UserUI() {
        override fun <T> map(mapper: Abstract.UserMapper<T>): T = mapper.map(progressValue)
    }


}