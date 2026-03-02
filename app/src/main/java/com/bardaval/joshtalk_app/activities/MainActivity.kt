package com.bardaval.joshtalk_app.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bardaval.joshtalk_app.R
import com.bardaval.joshtalk_app.databinding.ActivityMainBinding
import com.bardaval.joshtalk_app.fragments.PurchaseHistoryFragment
import com.bardaval.joshtalk_app.fragments.ReferralFragment
import com.bardaval.joshtalk_app.fragments.SettingsFragment
import com.bardaval.joshtalk_app.fragments.SupportFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.btnExplore.setOnClickListener {
            startActivity(Intent(this, MenuOptionsActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_referral -> {
                openFragment(ReferralFragment())
                true
            }
            R.id.action_support -> {
                openFragment(SupportFragment())
                true
            }
            R.id.action_purchase_history -> {
                openFragment(PurchaseHistoryFragment())
                true
            }
            R.id.action_settings -> {
                openFragment(SettingsFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}