package edu.iesam.expmdmfebrero.features.albumes.domain

import org.koin.core.annotation.Single

@Single
class GetAlbumUseCase(private val albumRepository: AlbumRepository) {
    suspend operator fun invoke(): Result<List<Album>> {
        return albumRepository.getAlbumes()
    }
}