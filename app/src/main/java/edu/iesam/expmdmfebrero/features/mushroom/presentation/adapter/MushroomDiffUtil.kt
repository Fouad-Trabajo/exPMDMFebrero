package edu.iesam.expmdmfebrero.features.mushroom.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.expmdmfebrero.features.mushroom.domain.Mushroom

class SetaDiffCallback : DiffUtil.ItemCallback<Mushroom>() {

    override fun areItemsTheSame(oldItem: Mushroom, newItem: Mushroom): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Mushroom, newItem: Mushroom): Boolean {
        return oldItem == newItem
    }
}