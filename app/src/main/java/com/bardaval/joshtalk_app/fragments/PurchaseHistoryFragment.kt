package com.bardaval.joshtalk_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bardaval.joshtalk_app.databinding.FragmentPurchaseHistoryBinding

class PurchaseHistoryFragment : Fragment() {

    private var _binding: FragmentPurchaseHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPurchaseHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPurchaseHistory()
    }

    private fun setupPurchaseHistory() {
        val purchases = listOf(
            "Basic Course - ₹499 - Mar 15, 2024",
            "Advanced Grammar - ₹799 - Mar 10, 2024",
            "Vocabulary Pack - ₹299 - Mar 5, 2024",
            "Pronunciation Course - ₹599 - Feb 28, 2024",
            "IELTS Preparation - ₹999 - Feb 20, 2024"
        )

        val adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                val textView = TextView(requireContext()).apply {
                    layoutParams = RecyclerView.LayoutParams(
                        RecyclerView.LayoutParams.MATCH_PARENT,
                        RecyclerView.LayoutParams.WRAP_CONTENT
                    )
                    setPadding(50, 30, 50, 30)
                    textSize = 16f
                }
                return object : RecyclerView.ViewHolder(textView) {}
            }

            override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                (holder.itemView as TextView).text = purchases[position]
            }

            override fun getItemCount() = purchases.size
        }

        binding.recyclerViewPurchase.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}