package com.example.listguru.users

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.listguru.R
import com.example.listguru.databinding.ViewUserBinding

@SuppressLint("ViewConstructor")
class UserView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    private val name: String = "",
    private val age: Int = 0,
    private val onAgeClickListener: (age: Int) -> Unit = { /*empty*/ },
) : androidx.cardview.widget.CardView(context, attrs, defStyle) {

    private val binding by lazy {
        ViewUserBinding.inflate(
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            this,
            true)
    }

    init {
        parent.apply {
            radius = 8F
            cardElevation = 8F
            maxCardElevation = 8F
            useCompatPadding = true
        }

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.UserView,
            0,
            0
        ).apply {
            binding.tvName.text = getString(R.styleable.UserView_name)
            binding.tvAge.text = getInt(R.styleable.UserView_age, 0).toString()
        }
        binding.tvName.text = name
        binding.tvAge.text = age.toString()
        binding.tvAge.setOnClickListener {
            onAgeClickListener.invoke(age)
        }


    }

}