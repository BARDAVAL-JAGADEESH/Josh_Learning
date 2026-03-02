package com.bardaval.joshtalk_app.fragments


import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.databinding.FragmentReferralBinding

class ReferralFragment : Fragment() {

    private var _binding: FragmentReferralBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReferralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCopyCode.setOnClickListener {
            val code = binding.tvReferralCode.text.toString()
            copyToClipboard(code)
        }

        binding.btnShare.setOnClickListener {
            shareReferralCode()
        }
    }

    private fun copyToClipboard(text: String) {
        val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Referral Code", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(requireContext(), "Referral code copied!", Toast.LENGTH_SHORT).show()
    }

    private fun shareReferralCode() {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,
                "Use my referral code ${binding.tvReferralCode.text} to join English Learning App!")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}