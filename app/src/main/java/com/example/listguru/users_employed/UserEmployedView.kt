package com.example.listguru.users_employed

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.example.listguru.R
import com.example.listguru.UserUI
import com.example.listguru.databinding.ViewEmployedUserBinding


class UserEmployedView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    user: UserUI? = null,) :
    androidx.cardview.widget.CardView(context, attrs, defStyle) {

    init {
        val binding = ViewEmployedUserBinding.inflate(
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater,
            this,
            true)

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
            binding.tvAge.text = getInt(R.styleable.UserView_age,0).toString()
        }
        user?.let {
            binding.tvName.text = user.name
            binding.tvAge.text = user.age.toString()
        }
    }

}