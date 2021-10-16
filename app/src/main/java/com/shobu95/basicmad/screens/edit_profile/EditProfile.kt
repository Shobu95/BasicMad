package com.shobu95.basicmad.screens.edit_profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.shobu95.basicmad.R
import com.shobu95.basicmad.database.Developer
import com.shobu95.basicmad.database.DeveloperDao
import com.shobu95.basicmad.database.DeveloperDatabase
import com.shobu95.basicmad.databinding.FragmentEditProfileBinding

class EditProfile : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding
    private lateinit var viewModel: EditProfileViewModel
    private lateinit var viewModelFactory: EditProfileViewModelFactory
    private lateinit var database: DeveloperDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false)

        setupViewModel()
        setupChangeScreenObserver()

        return binding.root
    }

    private fun setupViewModel() {
        val application = requireNotNull(this.activity).application
        database = DeveloperDatabase.getInstance(application).developerDao

        val arguments = EditProfileArgs.fromBundle(requireArguments())
        // !! (bang operator) converts any value to non-null
        // throws a NUll Pointer Exception when value is null
        viewModelFactory = EditProfileViewModelFactory(arguments.developer!!, database)


        viewModel = ViewModelProvider(this, viewModelFactory).get(EditProfileViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this.viewLifecycleOwner
    }

    private fun setupChangeScreenObserver() {
        viewModel.changeScreen.observe(viewLifecycleOwner, {
            if (it == true) {
                this.findNavController().popBackStack()
                viewModel.changeScreenComplete()
                Snackbar.make(binding.root, "Profile Updated", Snackbar.LENGTH_LONG).show()
            }
        })
    }


}