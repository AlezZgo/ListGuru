package com.example.listguru.users_employed

interface OnNameClick<T> {
    fun setOnNameClickListener(block: (name: String) -> Unit): T
}