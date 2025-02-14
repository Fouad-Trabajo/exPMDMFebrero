package edu.iesam.expmdmfebrero.features.albumes.data.local.mock

import edu.iesam.expmdmfebrero.features.albumes.domain.Album
import org.koin.core.annotation.Single

@Single
class AlbumMockLocalDataSource {

    fun getAlbums(): Result<List<Album>> {
        val albums = listOf(
            Album(
                "1",
                "Album 1 Setas del Norte",
                "2024-01-01",
                "Álbum con setas del norte de España",
                "https://www.album-online.com/photos/prev/ZjQ0MDc3MA/album_alb1558480.webp"
            ),
            Album(
                "2",
                "Album hongos",
                "2024-02-10",
                "Álbum con hongos raros de todo el mundo",
                "https://cloud10.todocoleccion.online/album-incompleto/tc/2021/12/30/11/309693368.webp?r=3"
            ),
            Album(
                "3",
                "Album setas comestibles",
                "2024-03-05",
                "Álbum con setas aptas para el consumo",
                "https://www.album-online.com/photos/prev/ZjQ0MDc3MA/album_alb1558480.webp"
            ),
            Album(
                "4",
                "Album Setas Venenosas",
                "2024-04-15",
                "Álbum con setas peligrosas para aprender a identificarlas",
                "https://cloud10.todocoleccion.online/album-incompleto/tc/2021/12/30/11/309693368.webp?r=3"
            ),
            Album(
                "5",
                "Albumn Setas Bioluminiscentes",
                "2024-05-22",
                "Álbum con setas que brillan en la oscuridad",
                "https://www.album-online.com/photos/prev/ZjQ0MDc3MA/album_alb1558480.webp"
            ),
            Album(
                "6",
                "Hongos Medicinales",
                "2024-06-30",
                "Álbum con hongos utilizados en medicina natural",
                "https://cloud10.todocoleccion.online/album-incompleto/tc/2021/12/30/11/309693368.webp?r=3"
            ),
            Album(
                "7",
                "Album Setas Micorrícicas",
                "2024-07-18",
                "Álbum con setas que viven en simbiosis con árboles",
                "https://www.album-online.com/photos/prev/ZjQ0MDc3MA/album_alb1558480.webp"
            ),
            Album(
                "8",
                "Album Setas Tropicales",
                "2024-08-21",
                "Álbum con hongos de climas tropicales",
                "https://cloud10.todocoleccion.online/album-incompleto/tc/2021/12/30/11/309693368.webp?r=3"
            ),
            Album(
                "9",
                "Album Hongos del Suelo",
                "2024-09-09",
                "Álbum con setas que crecen en suelos ricos en nutrientes",
                "https://www.album-online.com/photos/prev/ZjQ0MDc3MA/album_alb1558480.webp"
            ),
            Album(
                "10",
                "Album Setas Gigantes",
                "2024-10-11",
                "Álbum con setas de tamaños impresionantes",
                "https://cloud10.todocoleccion.online/album-incompleto/tc/2021/12/30/11/309693368.webp?r=3"
            )
            //added more if there is necessary
        )
        return Result.success(albums)
    }
}
