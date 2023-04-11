package com.example.eta.model

import android.content.Context
import java.io.File

class TextRepository(
    private val context: Context,
    private val filename: String = "textfile.txt") {

    fun saveText(text: String) {
        val timestamp = System.currentTimeMillis()
        val item = TextItem(text, timestamp)
        val file = context.getFileStreamPath(filename)
        file?.appendText("$item\n")
    }

    fun getTextList(): List<TextItem> {
        val file = File(context.filesDir, filename)
        val textList = mutableListOf<TextItem>()

        if (file.exists()) {
            file.forEachLine {
                val parts = it.split("timestamp=")
                if (parts.size == 2) {
                    val text = parts[0].trim()
                    val result =
                        text.substringAfter("text=").removeSuffix(",")
                    val timestamp = parts[1].substring(0, parts[1].length - 1).toLong()
                    textList.add(TextItem(result, timestamp))
                }
            }
        }
        return textList
    }
}