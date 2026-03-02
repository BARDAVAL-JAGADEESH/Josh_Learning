package com.bardaval.joshtalk_app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bardaval.joshtalk_app.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.Random

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var generatedOTP = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSendOtp.setOnClickListener {
            val phoneNumber = binding.etPhoneNumber.text.toString()
            if (phoneNumber.length == 10) {
                generatedOTP = generateOTP()
                showOTPDialog(phoneNumber, generatedOTP)
            } else {
                binding.etPhoneNumber.error = "Enter valid 10-digit phone number"
            }
        }

        binding.btnVerifyOtp.setOnClickListener {
            val enteredOtp = binding.etOtp.text.toString()
            if (enteredOtp == generatedOTP) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                binding.etOtp.error = "Invalid OTP"
            }
        }
    }

    private fun generateOTP(): String {
        val random = Random()
        return String.format("%06d", random.nextInt(1000000))
    }

    private fun showOTPDialog(phone: String, otp: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("OTP Sent")
            .setMessage("Your OTP for $phone is: $otp")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                binding.etOtp.isEnabled = true
                binding.btnVerifyOtp.isEnabled = true
            }
            .show()
    }
}