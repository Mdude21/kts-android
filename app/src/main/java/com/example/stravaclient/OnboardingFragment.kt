package com.example.stravaclient

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import timber.log.Timber

class OnboardingFragment : Fragment(R.layout.fragment_onboarding){

    private val viewModel : OnBoardingViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("OnBoardingFragment onAttach ${hashCode()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("OnBoardingFragment onCreate ${hashCode()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("OnBoardingFragment onCreateView ${hashCode()}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val startButton : Button? = view?.findViewById(R.id.startButton)
        startButton?.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment) }
        viewModel.state.observe(viewLifecycleOwner,{})
        Timber.d("OnBoardingFragment onActivityCreate ${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("OnBoardingFragment onStart ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("OnBoardingFragment onResume ${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("OnBoardingFragment onActivityPause ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("OnBoardingFragment onStop ${hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("OnBoardingFragment onDestroyView ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("OnBoardingFragment onDestroy ${hashCode()}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("OnBoardingFragment onDetach ${hashCode()}")
    }

}