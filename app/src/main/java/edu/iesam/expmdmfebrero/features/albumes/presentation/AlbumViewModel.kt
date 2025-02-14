package edu.iesam.expmdmfebrero.features.albumes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.expmdmfebrero.features.albumes.domain.Album
import edu.iesam.expmdmfebrero.features.albumes.domain.GetAlbumUseCase
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AlbumViewModel(private val getAlbumUseCase: GetAlbumUseCase) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState


    fun getAlbums() {
        _uiState.value = UiState.Loading  // Seteamos el estado de carga
        viewModelScope.launch {
            try {
                val result = getAlbumUseCase()  // Ejecutamos el caso de uso
                result.onSuccess {
                    _uiState.value = UiState.Success(it)  // Si es exitoso, mostramos los álbumes
                }
                result.onFailure {
                    _uiState.value = UiState.Error(it)  // Si falla, mostramos el error
                }
            } catch (exception: Exception) {
                _uiState.value =
                    UiState.Error(exception)  // Manejamos cualquier error que se produzca
            }
        }
    }


    sealed class UiState {
        data object Loading : UiState()    // Estado cuando está cargando
        data class Success(val albums: List<Album>) : UiState()  // Estado con los datos
        data class Error(val exception: Throwable) : UiState()  // Estado con el error
    }
}
