package com.example.listguru

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.listguru.databinding.ViewUserBinding

class UserView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0) :
    LinearLayout(context, attrs, defStyle) {

    init {
        val binding = ViewUserBinding.inflate(
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            this,
            true)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.UserView,
            0,
            0
        ).apply {
            binding.tvName.text = getString(R.styleable.UserView_name)?:"null"
            binding.tvLastName.text = getString(R.styleable.UserView_lastname)?:"null"
        }
    }
}