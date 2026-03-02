package com.bardaval.joshtalk_app.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.databinding.FragmentReferEarnBinding

class ReferEarnFragment : Fragment() {

    private var _binding: FragmentReferEarnBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReferEarnBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReferNow.setOnClickListener {
            shareApp()
        }
    }

    private fun shareApp() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,
                "Learn English with this amazing app! Download now: https://play.google.com/store/apps/details?id=com.englishlearning")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share App"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}