package com.example.listguru

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.NestedScrollView
import com.example.listguru.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    private lateinit var viewModel: UsersViewModel

    private lateinit var binding : UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = UsersFragmentBinding.inflate(inflater)

        binding.llUsers.apply {
            addView(
                TextView(requireContext()).apply {
                    text = "Hello world"
                }
            )
            addView(
                ImageView(requireContext()).apply {
                    setImageResource(R.drawable.app_icon)
                }
            )
            addView(
                HorizontalScrollView(requireContext()).apply {
                    addView(
                        LinearLayout(requireContext()).apply {
                            addView(
                                ImageView(requireContext()).apply {
                                    setImageResource(R.drawable.app_icon)
                                }
                            )
                            addView(
                                ImageView(requireContext()).apply {
                                    setImageResource(R.drawable.app_icon)
                                }
                            )
                            addView(
                                ImageView(requireContext()).apply {
                                    setImageResource(R.drawable.app_icon)
                                }
                            )
                            addView(
                                ImageView(requireContext()).apply {
                                    setImageResource(R.drawable.app_icon)
                                }
                            )
                        }
                    )

                }
            )
        }

        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]

        return binding.root
    }

}