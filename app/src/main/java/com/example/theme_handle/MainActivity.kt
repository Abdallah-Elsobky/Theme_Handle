package com.example.theme_handle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.theme_handle.adapters.PostAdapter
import com.example.theme_handle.adapters.StoryAdapter
import com.example.theme_handle.databinding.ActivityMainBinding
import com.example.theme_handle.dummy_data.Generator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.storiesRecyclerView.apply {
            val generatedStories = Generator.generateStories(15)
            adapter = StoryAdapter(generatedStories)
        }

        binding.postsRecyclerView.apply {
            val generatedPosts = Generator.generatePosts(20)
            adapter = PostAdapter(generatedPosts)
        }

        binding.settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
