package com.example.listguru.users_employed

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import com.example.listguru.R
import com.example.listguru.core.CustomView
import com.example.listguru.core.OnButtonClick
import com.example.listguru.core.ProgressValue
import com.example.listguru.databinding.ViewEmployedUserBinding
import com.example.listguru.databinding.ViewUserErrorBinding
import com.example.listguru.databinding.ViewUserLoadingBinding


interface UserEmployedView {

    class Success @JvmOverloads constructor(
        context: Context,
        defStyle: Int = 0,
        attrs: AttributeSet? = null,
        private val name: String = "",
        private val age: Int = 0,
    ) : CustomView<ViewEmployedUserBinding>(context,
        defStyle,
        attrs,
        ViewEmployedUserBinding::inflate),
        OnNameClick<UserEmployedView>, UserEmployedView {

        init {
            bindAttributes {
                binding.tvName.text = it.getString(R.styleable.UserView_name)
                binding.tvAge.text = it.getInt(R.styleable.UserView_age, 0).toString()
            }
            bindUi()
        }

        override fun bindUi() {
            binding.tvName.text = name
            binding.tvAge.text = age.toString()
        }

        override fun setOnNameClickListener(block: (name: String) -> Unit): UserEmployedView {
            binding.tvName.setOnClickListener {
                block.invoke(name)
            }
            return this
        }
    }

    @SuppressLint("ViewConstructor")
    class Error @JvmOverloads constructor(
        context: Context,
        defStyle: Int = 0,
        attrs: AttributeSet? = null,
        private val errorMessage: String = "Error",
    ) : CustomView<ViewUserErrorBinding>(context, defStyle, attrs, ViewUserErrorBinding::inflate),
        UserEmployedView, OnButtonClick<UserEmployedView> {

        init {
            bindAttributes {
                binding.tvError.text = it.getString(R.styleable.UserView_textError)
            }
            bindUi()
        }

        override fun bindUi() {
            binding.tvError.text = errorMessage
        }

        override fun setOnButtonClick(block: () -> Unit): UserEmployedView {
            binding.btnTryAgain.setOnClickListener {
                block.invoke()
            }
            return this
        }

    }

    @SuppressLint("ViewConstructor")
    class Loading @JvmOverloads constructor(
        context: Context,
        defStyle: Int = 0,
        attrs: AttributeSet? = null,
        private val progressValue: Int,
    ) : CustomView<ViewUserLoadingBinding>(context,
        defStyle,
        attrs,
        ViewUserLoadingBinding::inflate),
        UserEmployedView, ProgressValue<UserEmployedView> {
        init {
            bindUi()
        }

        override fun bindUi() {
            binding.pbLoading.progress = progressValue
        }

        override fun setProgressValue(value: Int): UserEmployedView {
            binding.pbLoading.progress
            return this
        }

    }

}
