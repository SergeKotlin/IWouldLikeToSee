package com.example.idliketosee.ui.screens.movieSelection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idliketosee.R
import com.example.idliketosee.databinding.MovieSelectionScreenFragmentBinding

class MovieSelectionFragment : Fragment(), MovieSelectionRecyclerAdapter.MovieClickListener {

    private lateinit var binding: MovieSelectionScreenFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private val viewModel: MovieSelectionViewModel by viewModels<MovieSelectionViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)

        binding = MovieSelectionScreenFragmentBinding.inflate(inflater, container, false)

        setupRecyclerView() // TODO верно, что в onCreateView??
        initUiEvents()
        initViewModel(viewModel)

        return binding.root
    }

    private fun setupRecyclerView() {
        recyclerView = binding.recyclerMovieSelection
        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )
            adapter = MovieSelectionRecyclerAdapter(toDoMoviesList(),   R.drawable.nature,
                this@MovieSelectionFragment)
        }
    }

    private fun toDoMoviesList(): List<String> { // todo ЗАГЛУШКА
        val data = mutableListOf<String>()
        (1..15).forEach { i -> data.add("$i film") }
        return data
    }

    override fun onMovieClick(view: View?, position: Int) {
        Toast.makeText(view?.context, "Карточка Фильма ${position+1} скоро появится", Toast.LENGTH_SHORT).show() // todo ЗАГЛУШКА
    }

    private fun initUiEvents() {
        binding.apply {
           movieSelectionBarInfo.setOnClickListener {
                Toast.makeText(context, "Экран выбора фильмов", Toast.LENGTH_SHORT).show() // todo ЗАГЛУШКА

               /*val position = recyclerView.adapter?.getItemId(1)?.toInt() // todo ЗАГЛУШКА
               viewModel.onClickMovie( position?: 1 )*/
            }
        }
    }

    private fun initViewModel(viewModel: MovieSelectionViewModel) {
    }
}