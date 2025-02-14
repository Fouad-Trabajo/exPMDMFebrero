package edu.iesam.expmdmfebrero.features.mushroom.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.expmdmfebrero.databinding.ItemMushroomBinding
import edu.iesam.expmdmfebrero.features.mushroom.domain.Mushroom

class MushroomAdapter(private val onClick: (Mushroom) -> Unit) :
    ListAdapter<Mushroom, MushroomViewHolder>(SetaDiffCallback()) {

    // Crear el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MushroomViewHolder {
        val binding =
            ItemMushroomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MushroomViewHolder(binding)
    }

    // Enlazar datos en el ViewHolder
    override fun onBindViewHolder(holder: MushroomViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
        holder.itemView.setOnClickListener {
            onClick(album)  // Llamamos a la función onClick con el objeto album
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}
