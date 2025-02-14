package edu.iesam.expmdmfebrero.features.albumes.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.expmdmfebrero.features.albumes.domain.Album

class AlbumDiffCallback : DiffUtil.ItemCallback<Album>() {

    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}