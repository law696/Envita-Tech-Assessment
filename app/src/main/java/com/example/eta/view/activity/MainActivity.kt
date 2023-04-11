package com.example.eta.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eta.databinding.ActivityMainBinding
import com.example.eta.view.adapter.TextAdapter
import com.example.eta.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initEditText()
        initOkButton()
        initViewModelObservers()
    }

    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = TextAdapter()
        }
    }

    private fun initEditText() {
        binding.editText.text.clear()
    }

    private fun initOkButton() {
        binding.buttonOk.setOnClickListener {
            val text = binding.editText.text.toString()
            viewModel.addText(text)
            binding.editText.text.clear()
        }
    }

    private fun initViewModelObservers() {
        viewModel.textList.observe(this) { textList ->
            (binding.recyclerView.adapter as TextAdapter).submitList(textList)
        }
    }
}