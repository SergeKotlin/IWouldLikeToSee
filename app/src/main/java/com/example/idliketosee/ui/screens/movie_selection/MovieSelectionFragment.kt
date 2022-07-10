package com.example.idliketosee.ui.screens.movie_selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idliketosee.databinding.MovieSelectionScreenFragmentBinding

class MovieSelectionFragment : Fragment() {

    private lateinit var binding: MovieSelectionScreenFragmentBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)

        binding = MovieSelectionScreenFragmentBinding.inflate(inflater, container, false)

        setupRecyclerView() // TODO верно, что в onCreateView??

        return binding.root
    }

    private fun setupRecyclerView() {
        recyclerView = binding.recyclerMovieSelection
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = MovieSelectionRecyclerAdapter(context,  todoMoviesList())
        }
    }

    private fun todoMoviesList(): List<String> { // todo ЗАГЛУШКА
        val data = mutableListOf<String>()
        (0..15).forEach { i -> data.add("$i film") }
        return data
    }

}