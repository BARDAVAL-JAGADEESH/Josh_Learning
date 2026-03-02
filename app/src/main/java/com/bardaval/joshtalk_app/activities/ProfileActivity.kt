package com.bardaval.joshtalk_app.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bardaval.joshtalk_app.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarProfile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile"

        loadUserProfile()
    }

    private fun loadUserProfile() {
        binding.tvUserName.text = "John Doe"
        binding.tvUserEmail.text = "john.doe@example.com"
        binding.tvUserPhone.text = "+91 9876543210"
        binding.tvUserLevel.text = "Level: Intermediate"
        binding.tvUserPoints.text = "Points: 1250"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}