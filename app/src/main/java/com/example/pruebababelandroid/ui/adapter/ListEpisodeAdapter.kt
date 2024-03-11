package com.example.pruebababelandroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebababelandroid.R
import com.example.pruebababelandroid.domain.model.Episode
import kotlin.Int

 class ListEpisodeAdapter() :
    ListAdapter<Episode, ListEpisodeAdapter.ViewHolder>(DiffCallback()){

    private class DiffCallback : DiffUtil.ItemCallback<Episode>() {
        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.adapter_episodes, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById(R.id.tvName) as TextView
        private val episodeView = view.findViewById(R.id.tvNumEpisode) as TextView
        private val dateAir = view.findViewById(R.id.tvDateAir) as TextView

        fun bind(episode: Episode){
            name.text = episode.name
            episodeView.text = episode.episode
            dateAir.text = episode.airDate
        }
    }
}