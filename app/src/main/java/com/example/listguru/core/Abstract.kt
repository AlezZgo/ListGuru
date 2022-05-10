package com.example.listguru.core

interface Abstract {
    interface UserMapper<T> {

        fun map(name: String, age: Int): T
        fun map(errorMessage: String): T
        fun map(progressValue: Int): T
    }

    interface User {
        fun <T> map(mapper: UserMapper<T>): T
    }
}