package com.example.listguru.users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.listguru.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    private val viewModel: UsersViewModel by viewModels()

    private lateinit var binding: UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = UsersFragmentBinding.inflate(inflater)

        val mapper = UserUiToUserViewMapper.Base(requireContext())

        // my decision
        viewModel.users.forEach { user ->
            val abstractUserView = user.map(mapper)
            binding.llUsers.addView(abstractUserView)

            abstractUserView.setOnClickListener { data ->
                Log.d("zinoviewk", "clicked $data")
            }
        }
        binding.llUsers.addView(
            UserView.Success(requireContext(), name = "Bill", age = 100).apply {
                setProgressValue(100)
            }
        )

        binding.btnNextFragment.setOnClickListener {
            findNavController().navigate(
                UsersFragmentDirections.actionUsersFragmentToUsersEmployedFragment()
            )
        }

        return binding.root
    }

}

