package edu.iesam.expmdmfebrero.features.albumes.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import edu.iesam.expmdmfebrero.databinding.ItemAlbumBinding
import edu.iesam.expmdmfebrero.features.albumes.domain.Album

class AlbumViewHolder(private val binding: ItemAlbumBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(album: Album) {
        binding.textViewName.text = album.name
        binding.textViewDate.text = album.dateCreation
        binding.textViewDescription.text = album.description
        binding.imageViewAlbum.load(album.urlImage)
        binding.favorite.setOnClickListener {
            //added favorite
        }
    }
}
