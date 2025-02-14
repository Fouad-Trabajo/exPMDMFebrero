package edu.iesam.expmdmfebrero.features.mushroom.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.iesam.expmdmfebrero.databinding.ItemMushroomBinding
import edu.iesam.expmdmfebrero.features.mushroom.domain.Mushroom

class MushroomViewHolder(private val binding: ItemMushroomBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(mushroom: Mushroom) {
        binding.textViewName.text = mushroom.name
        binding.imageViewAlbum.load(mushroom.urlImage)
    }
}
