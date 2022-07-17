package com.example.idliketosee.ui.screens.movieCard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieCardViewModel: ViewModel() {
    internal  val movieId: LiveData<Int> = MutableLiveData<Int>() // internal - for observe the click of a movie in MovieSelectionFragment

    private val _movieInfo = MutableLiveData<String>()
    private val movieInfo: LiveData<String> = _movieInfo

    fun downloadMovieInfo(movieId: Int) {
        _movieInfo.postValue("Карточка фильма $movieId") // Предпосылки логики =)
        // TODO + another logic
    }
}