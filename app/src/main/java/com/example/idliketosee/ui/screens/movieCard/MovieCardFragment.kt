package com.example.idliketosee.ui.screens.movieCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.idliketosee.R
import com.example.idliketosee.data.model.entities.Movie
import com.example.idliketosee.databinding.MovieScreenFragmentBinding
import kotlinx.android.synthetic.main.movie_screen_fragment.*

// todo Или назвать MovieScreenFragment? Но с такими именами в приложении как бы посадочные страницы для фильмов, а это страница самого фильма
class MovieCardFragment : Fragment() {

    private var _binding: MovieScreenFragmentBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: MovieViewModel by viewModels<MovieViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)

        _binding = MovieScreenFragmentBinding.inflate(inflater, container, false)

        initUiEvents()
//        initViewModel(viewModel)

        return binding.root
    }

    private fun initUiEvents() {
        binding.apply {
            movieBarInfo.setOnClickListener {
                Toast.makeText(context, "Экран фильма", Toast.LENGTH_SHORT).show() // todo ЗАГЛУШКА
            }
        }
    }

    /*private fun initViewModel(viewModel: MovieViewModel) {
    }*/

    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        *//* Обязательно обнуляем _binding в onDestroyView, чтобы избежать утечек и нежелаемого
        поведения. (В Activity ничего похожего делать не требуется) *//*
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getParcelable<Movie>(BUNDLE_EXTRA)
        if (movie != null) binding.apply {
            //TODO ЗАГЛУШКА
            movie_full_image.setBackgroundResource( R.drawable.nature_full_image)
            movieName.text = movie.name
            movieDescription.text = movie.desc
            movieGenre.text = movie.genre
            movieDuration.text = movie.duration
            movieRating.text = movie.rating
            movieReleaseDate.text = movie.release_date
            movieBudget.text = movie.budget
            movieRevenue.text = movie.revenue
            movieAnnouncement.text = movie.announcement
        }
//        setData(weather)
    }

    companion object {
        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): MovieCardFragment {
            val fragment = MovieCardFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}