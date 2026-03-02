package com.bardaval.joshtalk_app.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.databinding.FragmentLeaderboardBinding

class LeaderboardFragment : Fragment() {

    private var _binding: FragmentLeaderboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLeaderboard()
    }

    private fun setupLeaderboard() {
        binding.tvLeaderboard1.text = "🥇 1. Sarah Johnson - 2500 pts"
        binding.tvLeaderboard2.text = "🥈 2. Mike Chen - 2350 pts"
        binding.tvLeaderboard3.text = "🥉 3. Emma Wilson - 2200 pts"
        binding.tvLeaderboard4.text = "⭐ 4. John Doe - 2100 pts"
        binding.tvLeaderboard5.text = "⭐ 5. Lisa Brown - 1950 pts"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}