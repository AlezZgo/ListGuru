package com.example.listguru.users_employed

import android.content.Context
import android.util.AttributeSet
import com.example.listguru.R
import com.example.listguru.core.CustomView
import com.example.listguru.databinding.ViewEmployedUserBinding


class UserEmployedView @JvmOverloads constructor(
    context: Context,
    defStyle: Int = 0,
    attrs: AttributeSet? = null,
    private val name: String = "",
    private val age: Int = 0,
) : CustomView<ViewEmployedUserBinding>(context, defStyle, attrs, ViewEmployedUserBinding::inflate),
    OnNameClick<UserEmployedView> {

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

    override fun setOnNameClickListener(block: (name: String) -> Unit) : UserEmployedView {
        binding.tvName.setOnClickListener {
            block.invoke(name)
        }
        return this
    }
}
