package com.example.idliketosee.domain

import com.example.idliketosee.data.entities.Movie
import com.example.idliketosee.data.entities.MovieList

interface Repository {
    fun getMovieListFromServer(): MovieList
    fun getMovieListFromLocalStorage(): MovieList

    fun getMovieFromServer(): Movie
    fun getMovieFromLocalStorage(): Movie
}