package com.example.stravaclient.fragments.login

import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.stravaclient.R
import com.example.stravaclient.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding: FragmentLoginBinding by viewBinding(FragmentLoginBinding::bind)

    private val viewModel : LoginViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.editTextEmailAddress.doAfterTextChanged {
            validateViewModel()
        }
        binding.editTextPassword.doAfterTextChanged {
            validateViewModel()
        }
        viewModel.inputValidData.observe(viewLifecycleOwner, {inputValidData ->
            binding.buttonLogin.isEnabled = inputValidData
        })
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_MainFragment)
        }
    }

    private fun validateViewModel() {
        val email = binding.editTextEmailAddress.text.toString()
        val pass = binding.editTextPassword.text.toString()
        viewModel.validateInput(email, pass)
    }
}