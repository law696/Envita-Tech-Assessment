package com.example.eta.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eta.model.TextItem
import com.example.eta.model.TextRepository

class MainViewModel(private val repository: TextRepository): ViewModel() {
    private val _textList = MutableLiveData<List<TextItem>>()
    val textList: LiveData<List<TextItem>> = _textList

    init {
        loadTextList()
    }

    fun loadTextList() {
        _textList.value = repository.getTextList()
    }

    fun addText(text: String) {
        repository.saveText(text)
        loadTextList()
    }
}