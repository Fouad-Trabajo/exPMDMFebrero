package edu.iesam.expmdmfebrero.features.albumes.data

import edu.iesam.expmdmfebrero.features.albumes.data.local.mock.AlbumMockLocalDataSource
import edu.iesam.expmdmfebrero.features.albumes.domain.Album
import edu.iesam.expmdmfebrero.features.albumes.domain.AlbumRepository
import org.koin.core.annotation.Single

@Single
class AlbumDataRepository(private val albumMockLocalDataSource: AlbumMockLocalDataSource) :
    AlbumRepository {
    override suspend fun getAlbumes(): Result<List<Album>> {
        return albumMockLocalDataSource.getAlbums()
    }
}