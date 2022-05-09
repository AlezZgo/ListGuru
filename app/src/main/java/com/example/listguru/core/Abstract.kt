package com.example.listguru.core

import android.content.Context

interface Abstract {

    interface ObjectUI<M: Mapper,T>{
        fun map(context: Context,mapper: M): T
    }

    interface Mapper{
        class Empty: Mapper
    }
}