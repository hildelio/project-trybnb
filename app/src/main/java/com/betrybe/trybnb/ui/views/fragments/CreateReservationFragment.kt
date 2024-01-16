package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.databinding.FragmentCreateReservationBinding

class CreateReservationFragment : Fragment() {
    private var binding: FragmentCreateReservationBinding? = null
    private val createReservationBinding get() = binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateReservationBinding.inflate(inflater, container, false)
        return createReservationBinding.root
    }
}
