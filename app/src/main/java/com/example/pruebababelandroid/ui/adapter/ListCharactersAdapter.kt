package com.example.pruebababelandroid.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebababelandroid.R
import com.example.pruebababelandroid.domain.model.Characters
import com.squareup.picasso.Picasso
import kotlin.Int

 class ListCharactersAdapter() :
    ListAdapter<Characters, ListCharactersAdapter.ViewHolder>(DiffCallback()){

    private class DiffCallback : DiffUtil.ItemCallback<Characters>() {
        override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.adapter_characters, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = currentList[position]
        holder.bind(item)

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image = view.findViewById(R.id.ivImage) as ImageView
        private val nameCharacter = view.findViewById(R.id.tvNameCharacter) as TextView
        private val specie = view.findViewById(R.id.tvSpecie) as TextView
        private val gender = view.findViewById(R.id.tvGender) as TextView


        fun bind(characters: Characters){
            Picasso.get().load(characters.image).into(image)
            nameCharacter.text = characters.name
            specie.text = characters.species
            gender.text = characters.gender
        }
    }
}