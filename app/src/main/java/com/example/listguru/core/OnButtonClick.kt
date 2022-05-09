package com.example.listguru.core

interface OnButtonClick<T> {
    fun setOnButtonClick(block: ()-> Unit) : T
}