package com.example.stravaclient.fragments.onboarding

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.stravaclient.R

class OnboardingFragment : Fragment(R.layout.fragment_onboarding){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val startButton : Button? = view?.findViewById(R.id.startButton)
        startButton?.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment) }
    }
}