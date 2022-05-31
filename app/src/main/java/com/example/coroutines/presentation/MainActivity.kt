package com.example.coroutines.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.coroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindEvents()
    }

    private fun bindEvents() = with(binding) {
        btnSearch.setOnClickListener {
            viewModel.findAddress(tilCep.editText?.text?.toString().orEmpty())
        }

        viewModel.state.observe(this@MainActivity) {
            tvAddress.text = it
        }
    }
}