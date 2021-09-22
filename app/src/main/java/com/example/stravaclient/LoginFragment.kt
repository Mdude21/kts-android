package com.example.stravaclient

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import timber.log.Timber

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var buttonLogin : Button? = null
    private var passwordText : EditText? = null
    private var emailText : EditText? = null
    private val viewModel : OnBoardingViewModel by viewModels()
    private var isValidEmail : Boolean = false
    private var isValidPass : Boolean = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("LoginFragment onAttach ${hashCode()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("LoginFragment onCreate ${hashCode()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("LoginFragment onCreateView ${hashCode()}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        passwordText = view?.findViewById(R.id.editTextPassword)
        emailText = view?.findViewById(R.id.editTextEmailAddress)
        buttonLogin = view?.findViewById(R.id.buttonLogin)

        emailText?.doAfterTextChanged {
            doAfterEmail()
        }
        passwordText?.doAfterTextChanged {
            doAfterPassword()
        }
        Timber.d("LoginFragment onActivityCreated ${hashCode()}")
        viewModel.state.observe(viewLifecycleOwner,{})
    }

    override fun onStart() {
        super.onStart()
        Timber.d("LoginFragment onStart ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("LoginFragment onResume ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("LoginFragment onStop ${hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        buttonLogin = null
        passwordText = null
        emailText = null
        Timber.d("LoginFragment onDestroyView ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("LoginFragment onDestroy ${hashCode()}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("LoginFragment onDetach ${hashCode()}")
    }

    private fun doAfterEmail(){
        isValidEmail = Patterns.EMAIL_ADDRESS.matcher(emailText!!.text).matches()
        if (isValidEmail && isValidPass) {
            buttonLogin?.isEnabled = true
            buttonLogin?.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_MainFragment)
            }}
        else
            buttonLogin?.isEnabled = false
    }

    private fun doAfterPassword(){
        isValidPass = passwordText!!.text.length >= 8
        if (isValidEmail && isValidPass) {
            buttonLogin?.isEnabled = true
            buttonLogin?.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_MainFragment)
            }}
        else
            buttonLogin?.isEnabled = false
    }


}