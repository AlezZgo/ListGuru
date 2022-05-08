package com.example.listguru.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.listguru.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    private val viewModel: UsersViewModel by viewModels()

    private lateinit var binding: UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = UsersFragmentBinding.inflate(inflater)
        binding.btnNextFragment.setOnClickListener {
            findNavController().navigate(
                UsersFragmentDirections.actionUsersFragmentToUsersEmployedFragment()
            )
        }

        return binding.root
    }

}