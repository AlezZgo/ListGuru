package com.example.listguru.users

interface OnAgeClick<T>{
    fun setOnAgeClickListener(block: (age: Int)->Unit) : T
}