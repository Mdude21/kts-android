package com.example.stravaclient.fragments.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.stravaclient.R

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var buttonLogin : Button? = null
    private var passwordText : EditText? = null
    private var emailText : EditText? = null
    private val viewModel : LoginViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        passwordText = view?.findViewById(R.id.editTextPassword)
        emailText = view?.findViewById(R.id.editTextEmailAddress)
        buttonLogin = view?.findViewById(R.id.buttonLogin)

        emailText?.doAfterTextChanged {
            validateViewModel()
        }
        passwordText?.doAfterTextChanged {
            validateViewModel()
        }
        viewModel.inputValidData.observe(viewLifecycleOwner, {inputValidData ->
            buttonLogin?.isEnabled = inputValidData
        })
        buttonLogin?.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_MainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        buttonLogin = null
        passwordText = null
        emailText = null
    }

    private fun validateViewModel(){
        val email = emailText?.text.toString()
        val pass = passwordText?.text.toString()
        viewModel.validateInput(email, pass)
    }
}