package com.example.eta

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.eta.model.TextItem
import com.example.eta.model.TextRepository
import com.example.eta.viewmodel.MainViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: TextRepository

    @Mock
    lateinit var observer: Observer<List<TextItem>>

    private lateinit var viewModel: MainViewModel

    @Rule
    @JvmField
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        viewModel = MainViewModel(repository)
        viewModel.textList.observeForever(observer)
    }

    @Test
    fun loadTextListShouldSetTheValueOfTextList() {
        val expectedTextList = listOf(
            TextItem("foo", System.currentTimeMillis()),
            TextItem("bar", System.currentTimeMillis()))

        `when`(repository.getTextList()).thenReturn(expectedTextList)
        viewModel.loadTextList()

        assertEquals(expectedTextList, viewModel.textList.value)

        verify(observer).onChanged(expectedTextList)
    }
}

