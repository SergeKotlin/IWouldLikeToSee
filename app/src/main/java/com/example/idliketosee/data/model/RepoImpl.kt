package com.example.idliketosee.data.model

import com.example.idliketosee.domain.Repository
import com.example.idliketosee.data.model.entities.Movie
import com.example.idliketosee.data.model.entities.MovieList
import com.example.idliketosee.data.model.entities.getLocalMovieList

class RepoImpl: Repository {
    override fun getMovieListFromServer(): MovieList {
        return MovieList()
    }

    override fun getMovieListFromLocalStorage(): List<Movie> {
        return getLocalMovieList()
    }

    override fun getMovieFromServer(): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorage(): Movie {
        return Movie()
    }
}