package com.example.idliketosee.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieList(
    val movie: Movie = Movie(),
    val movieList: List<Movie> = listOf(movie)
) : Parcelable

fun getLocalMovieList(): List<Movie> {
    return listOf(
        Movie("Заметочник"),
        Movie("Социальная сеть"),
        Movie("Погода"),
        Movie("Кинопоиск"),
        Movie("Посадочная страница"),
        Movie("Диалоговые окна"),
        Movie("Из Сибири можно"),
        Movie("По всей стране"),
        Movie("Международная биржа"),
        Movie("Современность")
    )
}