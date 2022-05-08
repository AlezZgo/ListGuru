package com.example.listguru.users_employed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.listguru.databinding.UsersEmployedFragmentBinding
import com.example.listguru.users.UserView

class UsersEmployedFragment : Fragment() {

    private val viewModel: UsersEmployedViewModel by viewModels()

    private lateinit var binding: UsersEmployedFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = UsersEmployedFragmentBinding.inflate(inflater)

        viewModel.users.forEach{ user->
            binding.llUsers.addView(
                UserEmployedView(context = requireContext(), user = user)
            )
        }

        return binding.root
    }

}