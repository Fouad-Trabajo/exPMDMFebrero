package edu.iesam.expmdmfebrero.features.mushroom.domain

import org.koin.core.annotation.Single

@Single
interface MushroomRepository {

    suspend fun getSetas(): Result<List<Mushroom>>
}