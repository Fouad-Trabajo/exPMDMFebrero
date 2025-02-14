package edu.iesam.expmdmfebrero.features.albumes.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.expmdmfebrero.databinding.ItemAlbumBinding
import edu.iesam.expmdmfebrero.features.albumes.domain.Album

class AlbumAdapter(private val onClick: (Album) -> Unit) :
    ListAdapter<Album, AlbumViewHolder>(AlbumDiffCallback()) {

    // Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    // Enlazar datos en el ViewHolder
    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
        // Manejar el clic dentro del ViewHolder
        holder.itemView.setOnClickListener {
            onClick(album)  // Llamamos a la función onClick con el objeto album
        }
    }

    // Retornar el tamaño de la lista (ListAdapter maneja esto automáticamente)
    override fun getItemCount(): Int {
        return currentList.size
    }
}
