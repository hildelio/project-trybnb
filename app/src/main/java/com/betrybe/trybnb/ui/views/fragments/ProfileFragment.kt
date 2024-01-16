package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.betrybe.trybnb.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentProfileBinding.bind(view)

        binding.loginButtonProfile.setOnClickListener {
            val login = binding.loginInputProfile.editText?.text.toString()
            val password = binding.passwordInputProfile.editText?.text.toString()

            validation(binding, login, password)
        }
    }
    private fun validation(binding: FragmentProfileBinding, login: String, password: String) {
        binding.apply {
            loginError.isVisible = login.isEmpty()
            passwordError.isVisible = password.isEmpty()
        }
    }
}
