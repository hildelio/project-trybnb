package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.repository.TokenRepository
import com.betrybe.trybnb.databinding.FragmentProfileBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val tokenFromRepo = TokenRepository()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentProfileBinding.bind(view)

        binding.loginButtonProfile.setOnClickListener {
            val login = binding.loginInputProfile.editText?.text.toString()
            val password = binding.passwordInputProfile.editText?.text.toString()

            validation(binding, login, password)
            loginSuccess(binding, login, password)
        }
    }
    private fun validation(binding: FragmentProfileBinding, login: String, password: String) {
        binding.apply {
            loginError.isVisible = login.isEmpty()
            passwordError.isVisible = password.isEmpty()
        }
    }

    private fun loginSuccess(binding: FragmentProfileBinding, login: String, password: String) {
        binding.success.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {
            try {
                ApiIdlingResource.increment()
                val token = withContext(Dispatchers.IO) {
                    tokenFromRepo.isValidToken(login, password)
                }
                Log.d("ProfileFragment", "token: $token")
            } finally {
                ApiIdlingResource.decrement()
            }
        }
    }
}
