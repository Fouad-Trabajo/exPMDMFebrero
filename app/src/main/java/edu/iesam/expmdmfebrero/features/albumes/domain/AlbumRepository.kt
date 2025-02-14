package edu.iesam.expmdmfebrero.features.albumes.domain

import org.koin.core.annotation.Single

@Single
interface AlbumRepository {

    suspend fun getAlbumes(): Result<List<Album>>
}