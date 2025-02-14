package edu.iesam.expmdmfebrero.features.albumes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.expmdmfebrero.databinding.ItemAlbumBinding
import edu.iesam.expmdmfebrero.features.albumes.domain.Album

class AlbumAdapter(private val onClick: (Album) -> Unit) :
    ListAdapter<Album, AlbumViewHolder>(AlbumDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
        holder.itemView.setOnClickListener {
            onClick(album)
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
