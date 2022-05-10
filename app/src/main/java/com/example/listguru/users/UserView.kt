package com.example.listguru.users

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.viewbinding.ViewBinding
import com.example.listguru.R
import com.example.listguru.core.*
import com.example.listguru.databinding.ViewUserErrorBinding
import com.example.listguru.databinding.ViewUserLoadingBinding
import com.example.listguru.databinding.ViewUserSuccessBinding

abstract class UserView<T : ViewBinding, C> @JvmOverloads constructor(
    context: Context,
    defStyle: Int = 0,
    attrs: AttributeSet? = null,
    inflate: Inflate<T>,
) : CustomView<T>(context, defStyle, attrs, inflate),
    OnClick, ProgressValue<ClickableView>, ClickableView {

    override fun setOnClickListener(block: (arg: UserClickedData) -> Unit) = Unit

    override fun setProgressValue(value: Int): ClickableView = ClickableView.Empty

    class Success @JvmOverloads constructor(
        context: Context,
        defStyle: Int = 0,
        attrs: AttributeSet? = null,
        private val name: String = "",
        private val age: Int = 0,
    ) : UserView<ViewUserSuccessBinding, Int>(context,
        defStyle,
        attrs,
        ViewUserSuccessBinding::inflate) {

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

        override fun setOnClickListener(block: (data: UserClickedData) -> Unit)  {
            binding.tvAge.setOnClickListener {
                block.invoke(
                    UserClickedData.Age(age)
                )
            }
        }
    }

    class Error @JvmOverloads constructor(
        context: Context,
        defStyle: Int = 0,
        attrs: AttributeSet? = null,
        private val errorMessage: String = "Error",
    ) : UserView<ViewUserErrorBinding, Unit>(
        context, defStyle, attrs, ViewUserErrorBinding::inflate
    ) {

        init {
            bindAttributes {
                binding.tvError.text = it.getString(R.styleable.UserView_textError)
            }
            bindUi()
        }

        override fun bindUi() {
            binding.tvError.text = errorMessage
        }

        override fun setOnClickListener(block: (data: UserClickedData) -> Unit) {
            binding.btnTryAgain.setOnClickListener {
                block.invoke(UserClickedData.TryAgain)
            }
        }
    }

    @SuppressLint("ViewConstructor")
    class Loading @JvmOverloads constructor(
        context: Context,
        defStyle: Int = 0,
        attrs: AttributeSet? = null,
        private val progressValue: Int,
    ) : UserView<ViewUserLoadingBinding, Unit>(
        context, defStyle, attrs, ViewUserLoadingBinding::inflate
    ) {

        init {
            bindUi()
        }

        override fun bindUi() {
            binding.pbLoading.progress = progressValue
        }

        override fun setProgressValue(value: Int): ClickableView {
            binding.pbLoading.progress

            //todo зачем
            return this
        }
    }


}
