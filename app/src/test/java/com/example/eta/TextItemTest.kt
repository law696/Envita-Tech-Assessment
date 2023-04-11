package com.example.eta

import com.example.eta.model.TextItem
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TextItemTest {

    @Test
    fun testTextItem() {
        val text = "Hello, world!"
        val timestamp = System.currentTimeMillis()
        val item = TextItem(text, timestamp)
        assertEquals(text, item.text)
        assertEquals(timestamp, item.timestamp)
    }
}