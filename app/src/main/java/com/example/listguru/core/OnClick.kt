package com.example.listguru.core

interface OnClick {
    fun setOnClickListener(block: (arg: UserClickedData) -> Unit)
}