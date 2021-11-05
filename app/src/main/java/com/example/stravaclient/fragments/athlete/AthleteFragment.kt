package com.example.stravaclient.fragments.athlete

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.stravaclient.R
import com.example.stravaclient.databinding.ItemAthleteBinding

class AthleteFragment : Fragment(R.layout.item_athlete){

    private val binding: ItemAthleteBinding by viewBinding(ItemAthleteBinding::bind)
    private val viewModel: AthleteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserInfo()

        viewModel.failToast.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        })

        viewModel.userInfo.observe(viewLifecycleOwner, {
            with(binding) {
                userName.text = it?.firstname + " " + it?.lastname
                countDescribes.text = it?.countFriends.toString()
                countFollowers.text = it?.countFollowers.toString()
                dateAthleteItem.text = it?.date
                photo.picture = it?.avatar
                Glide.with(view)
                    .load(it?.avatar)
                    .placeholder(R.drawable.avatar)
                    .into(avatarImage)
            }
        })
        binding.getActivityButton.setOnClickListener{ findNavController().navigate(R.id.action_athleteFragment_to_listFragment)}
    }

    object photo {
        var picture: String? = null
    }
}