package com.bardaval.joshtalk_app.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bardaval.joshtalk_app.R
import com.bardaval.joshtalk_app.adapters.MenuAdapter
import com.bardaval.joshtalk_app.databinding.ActivityMenuOptionsBinding
import com.bardaval.joshtalk_app.fragments.ClearMediaFragment
import com.bardaval.joshtalk_app.fragments.InterestFragment
import com.bardaval.joshtalk_app.fragments.LeaderboardFragment
import com.bardaval.joshtalk_app.fragments.ReferEarnFragment
import com.bardaval.joshtalk_app.fragments.SupportFragment
import com.bardaval.joshtalk_app.models.MenuItem

class MenuOptionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuOptionsBinding
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuOptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMenu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val menuItems = listOf(
            MenuItem(1, "Profile", R.drawable.ic_profile, ProfileActivity::class.java),
            MenuItem(2, "Leaderboard", R.drawable.ic_leaderboard, LeaderboardFragment::class.java),
            MenuItem(3, "Refer & Earn", R.drawable.ic_refer_earn, ReferEarnFragment::class.java),
            MenuItem(4, "Support", R.drawable.ic_support, SupportFragment::class.java),
            MenuItem(5, "Interest", R.drawable.ic_interest, InterestFragment::class.java),
            MenuItem(6, "Clear Media", R.drawable.ic_clear, ClearMediaFragment::class.java)
        )

        adapter = MenuAdapter(menuItems) { menuItem ->
            when (menuItem.fragmentClass) {
                ProfileActivity::class.java -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
                else -> {
                    try {
                        val fragment = (menuItem.fragmentClass as Class<*>).newInstance() as Fragment
                        supportFragmentManager.beginTransaction()
                            .replace(android.R.id.content, fragment)
                            .addToBackStack(null)
                            .commit()
                    } catch (e: Exception) {
                        Toast.makeText(this, "Opening ${menuItem.title}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.recyclerViewMenu.apply {
            layoutManager = LinearLayoutManager(this@MenuOptionsActivity)
            this.adapter = this@MenuOptionsActivity.adapter
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}