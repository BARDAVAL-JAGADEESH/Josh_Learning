package com.bardaval.joshtalk_app.fragments


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSettings()
    }

    private fun setupSettings() {
        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(requireContext(),
                if (isChecked) "Notifications Enabled" else "Notifications Disabled",
                Toast.LENGTH_SHORT).show()
        }

        binding.layoutLanguage.setOnClickListener {
            showLanguageDialog()
        }

        binding.layoutTheme.setOnClickListener {
            showThemeDialog()
        }
    }

    private fun showLanguageDialog() {
        val languages = arrayOf("English", "Spanish", "French", "German", "Hindi")
        AlertDialog.Builder(requireContext())
            .setTitle("Select Language")
            .setItems(languages) { _, which ->
                Toast.makeText(requireContext(), "Language: ${languages[which]}", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    private fun showThemeDialog() {
        val themes = arrayOf("Light", "Dark", "System Default")
        AlertDialog.Builder(requireContext())
            .setTitle("Select Theme")
            .setItems(themes) { _, which ->
                Toast.makeText(requireContext(), "Theme: ${themes[which]}", Toast.LENGTH_SHORT).show()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}