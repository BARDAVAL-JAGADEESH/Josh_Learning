package com.bardaval.joshtalk_app.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.databinding.FragmentInterestBinding

class InterestFragment : Fragment() {

    private var _binding: FragmentInterestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInterestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSaveInterests.setOnClickListener {
            val selectedInterests = mutableListOf<String>()
            if (binding.cbBusiness.isChecked) selectedInterests.add("Business English")
            if (binding.cbTravel.isChecked) selectedInterests.add("Travel English")
            if (binding.cbAcademic.isChecked) selectedInterests.add("Academic English")
            if (binding.cbConversational.isChecked) selectedInterests.add("Conversational English")
            if (binding.cbKids.isChecked) selectedInterests.add("English for Kids")

            if (selectedInterests.isNotEmpty()) {
                Toast.makeText(requireContext(),
                    "Selected: ${selectedInterests.joinToString()}",
                    Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(),
                    "Please select at least one interest",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}