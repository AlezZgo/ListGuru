package com.example.listguru.core

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewbinding.ViewBinding
import com.example.listguru.R

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

@SuppressLint("ViewConstructor")
abstract class CustomView<B : ViewBinding> @JvmOverloads constructor(
    context: Context,
    defStyle: Int = 0,
    private val attrs: AttributeSet? = null,
    inflate: Inflate<B>,
) : LinearLayout(context, attrs, defStyle) {

    private val _viewBinding: B = inflate.invoke(
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
        this,
        true
    )
    protected val binding get() = _viewBinding

    open fun bindAttributes(block: (typedArray: TypedArray) -> Unit) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.UserView,
            0,
            0
        ).apply {
            block.invoke(this)
        }
    }

    open fun bindUi() = Unit

}