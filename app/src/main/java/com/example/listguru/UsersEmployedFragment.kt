package com.example.listguru

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.listguru.databinding.UsersEmployedFragmentBinding

class UsersEmployedFragment : Fragment() {

    private lateinit var binding: UsersEmployedFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = UsersEmployedFragmentBinding.inflate(inflater)

        return binding.root
    }

}