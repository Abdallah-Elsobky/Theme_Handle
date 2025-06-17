package com.example.theme_handle

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.theme_handle.databinding.ActivitySettingsBinding
import androidx.core.content.edit

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    private val PREF_DARK_MODE = "pref_dark_mode"
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("app_preference", MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean(PREF_DARK_MODE, false)

        binding.darkModeSwitch.isChecked = isDarkMode

        binding.darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            applyDarkMode(isChecked)
            saveDarkModePref(isChecked)
        }
    }

    private fun saveDarkModePref(isChecked: Boolean) {
        sharedPreferences.edit { putBoolean(PREF_DARK_MODE, isChecked) }
    }

    private fun applyDarkMode(isChecked: Boolean) {
        AppCompatDelegate.setDefaultNightMode(
            if (isChecked)
                AppCompatDelegate.MODE_NIGHT_YES
            else
                AppCompatDelegate.MODE_NIGHT_NO
        )
        recreate()
    }

    companion object {
        fun applySavedDarkMode(context: Context) {
            val sharedPreferences = context.getSharedPreferences("app_preference", MODE_PRIVATE)
            val isDarkMode = sharedPreferences.getBoolean("pref_dark_mode", false)
            AppCompatDelegate.setDefaultNightMode(
                if (isDarkMode)
                    AppCompatDelegate.MODE_NIGHT_YES
                else
                    AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }
}