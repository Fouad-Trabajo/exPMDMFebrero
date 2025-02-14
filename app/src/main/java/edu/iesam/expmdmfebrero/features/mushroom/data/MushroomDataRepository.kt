package edu.iesam.expmdmfebrero.features.mushroom.data

import edu.iesam.expmdmfebrero.features.mushroom.data.local.mock.MushroomMockLocalDataSource
import edu.iesam.expmdmfebrero.features.mushroom.domain.Mushroom
import edu.iesam.expmdmfebrero.features.mushroom.domain.MushroomRepository
import org.koin.core.annotation.Single

@Single
class MushroomDataRepository(private val mushroomMockLocalDataSource: MushroomMockLocalDataSource) :
    MushroomRepository {
    override suspend fun getSetas(): Result<List<Mushroom>> {
        return mushroomMockLocalDataSource.getAlbums()
    }
}