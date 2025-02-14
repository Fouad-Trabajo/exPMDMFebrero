package edu.iesam.expmdmfebrero.features.albumes.di

import edu.iesam.expmdmfebrero.features.albumes.data.AlbumDataRepository
import edu.iesam.expmdmfebrero.features.albumes.data.local.mock.AlbumMockLocalDataSource
import edu.iesam.expmdmfebrero.features.albumes.domain.AlbumRepository
import edu.iesam.expmdmfebrero.features.albumes.domain.GetAlbumUseCase
import edu.iesam.expmdmfebrero.features.albumes.presentation.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AlbumModule = module {
    // Proporcionamos la implementación de la interfaz AlbumRepository
    single<AlbumRepository> { AlbumDataRepository(get()) } // Aquí se especifica la interfaz y la implementación

    // Otros servicios y dependencias
    single { AlbumMockLocalDataSource() } // El mock de datos
    single { GetAlbumUseCase(get()) } // El caso de uso que depende del repositorio
    viewModel { AlbumViewModel(get()) } // Inyectamos el ViewModel con el caso de uso
}

