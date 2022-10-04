package com.freedasd.rickandmorty.presentation.characterList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.*
import com.freedasd.rickandmorty.R
import com.freedasd.rickandmorty.databinding.CharacterItemBinding
import com.freedasd.rickandmorty.presentation.modules.CharacterUi

class CharacterListAdapter : PagingDataAdapter<CharacterUi.Base, RecyclerView.ViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.characters_animation)
        (holder as CharacterViewHolder).bind(item!!)
    }

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterUi) {
            val context = binding.characterGender.context
            item.details(
                binding.characterPic,
                binding.characterName,
                binding.characterIsAlive,
                binding.characterSpecies,
                binding.characterGender,
                binding.characterOrigin
            )
            if (item.isAlive() == "Dead") {
                binding.isAliveDot.background = context.getDrawable(R.drawable.dead_round_dot)
            } else if (item.isAlive() == "Alive") {
                binding.isAliveDot.background = context.getDrawable(R.drawable.alive_round_dot)
            } else {
                binding.isAliveDot.background = context.getDrawable(R.drawable.unknown_round_dot)
            }
        }
    }

    companion object Diff : DiffUtil.ItemCallback<CharacterUi.Base>() {

        override fun areItemsTheSame(oldItem: CharacterUi.Base, newItem: CharacterUi.Base) = oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: CharacterUi.Base, newItem: CharacterUi.Base) = oldItem.toString() == newItem.toString()
    }
}