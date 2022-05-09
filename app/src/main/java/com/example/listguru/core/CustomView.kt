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
    protected val attrs: AttributeSet? = null,
    private val inflate: Inflate<B>,
) : LinearLayout(context, attrs, defStyle) {

    private var _viewBinding: B? = null
    protected val binding get() = checkNotNull(_viewBinding)

    init {
        _viewBinding = inflate.invoke(
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            this,
            true
        )
    }

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