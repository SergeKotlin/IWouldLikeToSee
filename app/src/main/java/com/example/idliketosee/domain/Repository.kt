package com.example.idliketosee.domain

import com.example.idliketosee.data.model.entities.Movie
import com.example.idliketosee.data.model.entities.MovieList

interface Repository {
    fun getMovieListFromServer(): MovieList
    fun getMovieListFromLocalStorage(): List<Movie>

    fun getMovieFromServer(): Movie
    fun getMovieFromLocalStorage(): Movie
}