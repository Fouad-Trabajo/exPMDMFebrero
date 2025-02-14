package edu.iesam.expmdmfebrero.features.mushroom.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.expmdmfebrero.databinding.FragmentMushroomBinding
import edu.iesam.expmdmfebrero.features.mushroom.presentation.adapter.MushroomAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MushroomFragment : Fragment() {

    private var binding: FragmentMushroomBinding? = null
    private val mushroomViewModel: MushroomViewModel by viewModel()
    private lateinit var mushroomAdapter: MushroomAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMushroomBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mushroomAdapter = MushroomAdapter {
        }
        binding?.recyclerSetas?.layoutManager = LinearLayoutManager(context)
        binding?.recyclerSetas?.adapter = mushroomAdapter

        mushroomViewModel.getAlbums()

        mushroomViewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is MushroomViewModel.UiState.Loading -> {
                    binding?.progressBar?.visibility = View.VISIBLE
                }

                is MushroomViewModel.UiState.Success -> {
                    binding?.progressBar?.visibility = View.GONE
                    mushroomAdapter.submitList(uiState.albums)
                }

                is MushroomViewModel.UiState.Error -> {
                    binding?.progressBar?.visibility = View.GONE
                    showError(uiState.exception.message)
                }
            }
        }

        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun showError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        Log.d("@dev", "mensaje de error de la view: $message")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

