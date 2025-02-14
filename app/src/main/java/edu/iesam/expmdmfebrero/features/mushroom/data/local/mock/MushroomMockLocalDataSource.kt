package edu.iesam.expmdmfebrero.features.mushroom.data.local.mock

import edu.iesam.expmdmfebrero.features.mushroom.domain.Mushroom
import org.koin.core.annotation.Single

@Single
class MushroomMockLocalDataSource {

    fun getAlbums(): Result<List<Mushroom>> {
        val albums = listOf(
            Mushroom(
                "1",
                "Setas del Norte",
                "https://static.eldiario.es/clip/1a15217d-7099-4b78-92be-314ed49474a5_16-9-aspect-ratio_default_0.webp"
            ),
            Mushroom(
                "2",
                "Hongos Exóticos",
                "https://madridsalud.es/wp-content/uploads/2016/10/setas_grande.jpg"
            ),
            Mushroom(
                "3",
                "Setas Comestibles",
                "https://static.eldiario.es/clip/1a15217d-7099-4b78-92be-314ed49474a5_16-9-aspect-ratio_default_0.webp"
            ),
            Mushroom(
                "4",
                "Setas Venenosas",
                "https://madridsalud.es/wp-content/uploads/2016/10/setas_grande.jpg"
            ),
            Mushroom(
                "5",
                "Setas Bioluminiscentes",
                "https://static.eldiario.es/clip/1a15217d-7099-4b78-92be-314ed49474a5_16-9-aspect-ratio_default_0.webp"
            )
        )
        //added more if there is necessary

        return Result.success(albums)
    }
}
