package com.freedasd.rickandmorty.presentation.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.freedasd.rickandmorty.databinding.CharacterItemBinding
import com.freedasd.rickandmorty.presentation.modules.CharacterUi

class CharacterListAdapter : ListAdapter<CharacterUi, RecyclerView.ViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as CharacterViewHolder).bind(item)
    }

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterUi) {
            item.details(
                binding.characterPic,
                binding.characterName,
                binding.characterIsAlive,
                binding.characterSpecies,
                binding.characterGender,
                binding.characterOrigin
            )
        }
    }

    companion object Diff : DiffUtil.ItemCallback<CharacterUi>() {

        override fun areItemsTheSame(oldItem: CharacterUi, newItem: CharacterUi) = oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: CharacterUi, newItem: CharacterUi) = oldItem.toString() == newItem.toString()
    }
}