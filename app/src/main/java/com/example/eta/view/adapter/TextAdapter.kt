package com.example.eta.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.eta.R
import com.example.eta.model.TextItem
import java.text.SimpleDateFormat
import java.util.*

class TextAdapter : ListAdapter<TextItem, TextAdapter.ViewHolder>(TextDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.text_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        val timestamp = SimpleDateFormat("HH:mm",
            Locale.getDefault()).format(Date(item.timestamp))
        val formattedText = "[$timestamp] ${item.text}"
        holder.textView.text = formattedText
    }
}

class TextDiffCallback : DiffUtil.ItemCallback<TextItem>() {
    override fun areItemsTheSame(oldItem: TextItem, newItem: TextItem) =
        oldItem.timestamp == newItem.timestamp
    override fun areContentsTheSame(oldItem: TextItem, newItem: TextItem) =
        oldItem == newItem
}