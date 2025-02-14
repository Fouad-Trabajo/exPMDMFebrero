package edu.iesam.expmdmfebrero.features.mushroom.di

import edu.iesam.expmdmfebrero.features.mushroom.data.MushroomDataRepository
import edu.iesam.expmdmfebrero.features.mushroom.data.local.mock.MushroomMockLocalDataSource
import edu.iesam.expmdmfebrero.features.mushroom.domain.GetMushroomUseCase
import edu.iesam.expmdmfebrero.features.mushroom.domain.MushroomRepository
import edu.iesam.expmdmfebrero.features.mushroom.presentation.MushroomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val SetaModule = module {
    // Proporcionamos la implementación de la interfaz AlbumRepository
    single<MushroomRepository> { MushroomDataRepository(get()) } // Aquí se especifica la interfaz y la implementación

    // Otros servicios y dependencias
    single { MushroomMockLocalDataSource() } // El mock de datos
    single { GetMushroomUseCase(get()) } // El caso de uso que depende del repositorio
    viewModel { MushroomViewModel(get()) } // Inyectamos el ViewModel con el caso de uso
}

