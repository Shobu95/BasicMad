package com.shobu95.basicmad.screens.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.shobu95.basicmad.R
import com.shobu95.basicmad.database.DeveloperDao
import com.shobu95.basicmad.database.DeveloperDatabase
import com.shobu95.basicmad.databinding.FragmentProfileBinding

class Profile : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var viewModelFactory: ProfileViewModelFactory
    private lateinit var database: DeveloperDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        setupViewModel()

        binding.floatingActionButton.setOnClickListener {
            val direction = ProfileDirections.actionProfileToEditProfile(viewModel.developer.value)
            it.findNavController().navigate(direction)
        }

        return binding.root
    }

    private fun setupViewModel() {
        val application = requireNotNull(this.activity).application
        database = DeveloperDatabase.getInstance(application).developerDao
        viewModelFactory = ProfileViewModelFactory(database)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ProfileViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
    }


}