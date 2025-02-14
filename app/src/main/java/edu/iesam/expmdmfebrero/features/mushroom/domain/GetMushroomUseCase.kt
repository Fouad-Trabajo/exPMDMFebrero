package edu.iesam.expmdmfebrero.features.mushroom.domain

import org.koin.core.annotation.Single

@Single
class GetMushroomUseCase(private val mushroomRepository: MushroomRepository) {
    suspend operator fun invoke(): Result<List<Mushroom>> {
        return mushroomRepository.getSetas()
    }
}