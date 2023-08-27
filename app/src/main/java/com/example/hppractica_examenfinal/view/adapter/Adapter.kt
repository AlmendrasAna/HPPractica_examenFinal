package com.example.hppractica_examenfinal.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hppractica_examenfinal.data.local.CharacterEntity
import com.example.hppractica_examenfinal.databinding.ItemBinding

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {


    private var listCharacter: List<CharacterEntity> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characterEntity = listCharacter[position]
        holder.bind(characterEntity)
    }

    fun setData(listCharacterEntity: List<CharacterEntity>) {

        this.listCharacter = listCharacterEntity

        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(characterEntity: CharacterEntity) {
            binding.imageCharacter.load(characterEntity.image)
            binding.nameCharacterTxt.text = characterEntity.name

        }

    }

}
