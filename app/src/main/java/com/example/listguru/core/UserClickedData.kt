package com.example.listguru.core

interface UserClickedData {

    fun handle() = Unit

    data class Age(
        private val age: Int,
    ) : UserClickedData

    data class Name(
        private val name: String,
    ) : UserClickedData

    object TryAgain : UserClickedData

    object Empty : UserClickedData
}