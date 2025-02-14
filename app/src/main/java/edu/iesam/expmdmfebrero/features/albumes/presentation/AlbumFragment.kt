package edu.iesam.expmdmfebrero.features.albumes.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.expmdmfebrero.R
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
            findNavController().navigate(R.id.action_AlbumFragment_to_SetaFragment)
        }
        binding?.recyclerAlbum?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerAlbum?.adapter = albumAdapter

        albumViewModel.getAlbums()

        albumViewModel.uiState.observe(viewLifecycleOwner) { uiState ->
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
        }

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            val color = when (menuItem.itemId) {
                R.id.favorite -> {
                    ContextCompat.getColor(requireContext(), R.color.black)
                } //this sobra
                else -> {
                    ContextCompat.getColor(
                        requireContext(),
                        com.google.android.material.R.color.design_default_color_error
                    )
                }
            }

            menuItem.icon?.setTint(color)

            true
        }
    }

    private fun showError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        Log.d("@dev", "mensaje de error: $message")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

