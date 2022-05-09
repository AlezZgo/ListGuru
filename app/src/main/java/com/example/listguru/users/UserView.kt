package com.example.listguru.users

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.listguru.R
import com.example.listguru.core.CustomView
import com.example.listguru.databinding.ViewEmployedUserBinding
import com.example.listguru.databinding.ViewUserBinding

@SuppressLint("ViewConstructor")
class UserView @JvmOverloads constructor(
    context: Context,
    defStyle: Int = 0,
    attrs: AttributeSet? = null,
    private val name: String = "",
    private val age: Int = 0,
) : CustomView<ViewUserBinding>(context, defStyle, attrs, ViewUserBinding::inflate),
    OnAgeClick<UserView> {

    init {
        bindAttributes{
            binding.tvName.text = it.getString(R.styleable.UserView_name)
            binding.tvAge.text = it.getInt(R.styleable.UserView_age, 0).toString()
        }
        bindUi()
    }


    override fun bindUi() {
        binding.tvName.text = name
        binding.tvAge.text = age.toString()
    }

    override fun setOnAgeClickListener(block: (age: Int)->Unit) : UserView{
        binding.tvAge.setOnClickListener {
            block.invoke(age)
        }
        return this
    }

}