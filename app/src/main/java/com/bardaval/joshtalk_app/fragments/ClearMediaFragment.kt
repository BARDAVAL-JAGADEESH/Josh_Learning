package com.bardaval.joshtalk_app.fragments



import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.databinding.FragmentClearMediaBinding

class ClearMediaFragment : Fragment() {

    private var _binding: FragmentClearMediaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClearMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClearMedia.setOnClickListener {
            showClearMediaDialog()
        }
    }

    private fun showClearMediaDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Clear Media")
            .setMessage("Are you sure you want to clear all downloaded media? This will free up 255 MB of storage.")
            .setPositiveButton("Clear") { _, _ ->
                Toast.makeText(requireContext(), "Media cleared successfully!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}