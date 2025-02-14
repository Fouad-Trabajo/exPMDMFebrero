package edu.iesam.expmdmfebrero.features.albumes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.expmdmfebrero.databinding.FragmentAlbumBinding
import edu.iesam.expmdmfebrero.features.albumes.presentation.adapter.AlbumAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumFragment : Fragment() {

    private var binding: FragmentAlbumBinding? = null
    private val albumViewModel: AlbumViewModel by viewModel()
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumAdapter = AlbumAdapter {
            // Aquí puedes manejar los clics si es necesario
        }

        binding?.recyclerAlbum?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerAlbum?.adapter = albumAdapter

        albumViewModel.getAlbums()

        albumViewModel.uiState.observe(viewLifecycleOwner, Observer { uiState ->
            when (uiState) {
                is AlbumViewModel.UiState.Loading -> {
                    binding?.progressBar?.visibility = View.VISIBLE
                }

                is AlbumViewModel.UiState.Success -> {
                    binding?.progressBar?.visibility = View.GONE
                    albumAdapter.submitList(uiState.albums)
                }

                is AlbumViewModel.UiState.Error -> {
                    binding?.progressBar?.visibility = View.GONE
                    showError(uiState.exception.message)
                }
            }
        })
    }

    private fun showError(message: String?) {
        // Aquí deberías implementar un mecanismo para mostrar el error, por ejemplo:
        // Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun detailAlbum() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null  // Liberamos la referencia al binding
    }
}

