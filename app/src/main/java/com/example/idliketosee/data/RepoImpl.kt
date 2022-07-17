package com.example.idliketosee.data

import com.example.idliketosee.domain.Repository
import com.example.idliketosee.data.entities.Movie
import com.example.idliketosee.data.entities.MovieList

class RepoImpl: Repository {
    override fun getMovieListFromServer(): MovieList {
        return MovieList()
    }

    override fun getMovieListFromLocalStorage(): MovieList {
        return MovieList()
    }

    override fun getMovieFromServer(): Movie {
        return Movie()
    }

    override fun getMovieFromLocalStorage(): Movie {
        return Movie()
    }
}