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
import com.example.idliketosee.data.entities.Movie
import com.example.idliketosee.data.entities.MovieList
import com.example.idliketosee.data.entities.getLocalMovieList
import com.example.idliketosee.databinding.MovieSelectionScreenFragmentBinding
import com.example.idliketosee.ui.screens.movieCard.MovieCardFragment
import com.example.idliketosee.ui.screens.movieCard.MovieCardViewModel
import com.example.idliketosee.ui.screens.movieSelection.model.MovieSelectionViewModel

class MovieSelectionFragment : Fragment(), MovieSelectionRecyclerAdapter.MovieClickListener {

    private lateinit var binding: MovieSelectionScreenFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MovieSelectionRecyclerAdapter
    private val viewModel: MovieSelectionViewModel by viewModels<MovieSelectionViewModel>()
    private val movieCardViewModel: MovieCardViewModel by viewModels<MovieCardViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
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
            adapter = MovieSelectionRecyclerAdapter(object : OnItemViewClickListener {
                override fun onItemViewClick(movie: Movie) {
                    val manager = activity?.supportFragmentManager
                    if (manager != null) {
                        val bundle = Bundle()
                        bundle.putParcelable(MovieCardFragment.BUNDLE_EXTRA, movie)
                        manager.beginTransaction()
                            .add(R.id.content_main_fragment, MovieCardFragment.newInstance(bundle))
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                    }
                }
            },
            getLocalMovieList(),   R.drawable.nature,this@MovieSelectionFragment)
        }
    }

    /*private fun getMoviesList(): List<MovieList> { // todo Deprecated
        val data = mutableListOf<String>()
        getLocalMovieList().forEach { i -> data.add("${i.name}") }
        return data
    }*/

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onMovieClick(view: View?, position: Int) {

//        moveToMovieCardFragment(view, position)
        Toast.makeText(view?.context, "Карточка Фильма ${position+1} сейчас появится", Toast.LENGTH_SHORT).show() // todo ЗАГЛУШКА
    } //todo Deprecated

    private fun moveToMovieCardFragment(view: View?, position: Int) {
        binding.movieSelectionBarInfo.setOnClickListener {
            movieCardViewModel.movieId.observe(this) {
                movieCardViewModel.downloadMovieInfo(it)
            }
        }

        /*this.supportFragmentManager
            ?.beginTransaction()
            ?.replace()*/
    } //todo Deprecated

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }

    override fun onDestroy() {
        adapter.resetListener()
        super.onDestroy()
        /* Обязательно обнуляем чтобы избежать утечек и нежелаемого
        поведения. (В Activity ничего похожего делать не требуется) */
    }

    companion object {
    }
}