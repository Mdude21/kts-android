package com.example.stravaclient

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("MainFragment onAttach ${hashCode()}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("MainFragment onCreate ${hashCode()}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("MainFragment onCreateView ${hashCode()}")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("MainFragment onActivityCreated ${hashCode()}")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("MainFragment onStart ${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("MainFragment onResume ${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("MainFragment onStop ${hashCode()}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("MainFragment onDestroyView ${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("MainFragment onDestroy ${hashCode()}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("MainFragment onDetach ${hashCode()}")
    }
}