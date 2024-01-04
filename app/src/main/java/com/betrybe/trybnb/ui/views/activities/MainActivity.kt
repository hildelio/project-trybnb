package com.betrybe.trybnb.ui.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybnb.R
import com.betrybe.trybnb.databinding.ActivityMainBinding
import com.betrybe.trybnb.ui.views.fragments.CreateReservationFragment
import com.betrybe.trybnb.ui.views.fragments.ProfileFragment
import com.betrybe.trybnb.ui.views.fragments.ReservationFragment
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val reservationFragment = ReservationFragment()
    private val createReservationFragment = CreateReservationFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigationBottomView.setOnItemSelectedListener { it ->
            val fragment = when (it.itemId) {
                R.id.reservation_menu_item -> reservationFragment
                R.id.create_reservation_menu_item -> createReservationFragment
                R.id.profile_menu_tem -> profileFragment
                else -> throw IllegalArgumentException("Error!! ${it.itemId}")
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .commit()

            true
        }
    }
}
