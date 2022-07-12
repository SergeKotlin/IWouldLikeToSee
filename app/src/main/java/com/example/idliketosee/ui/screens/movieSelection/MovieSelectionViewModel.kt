package com.example.idliketosee.ui.screens.movieSelection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieSelectionViewModel: ViewModel(), MovieSelectionContract.ViewModelMovieSelection {
    /* В Mutable LiveData можно отправлять-менять значение.
         Во вью ожидается обычная LiveData (чтобы вью её не трогала),
         ну а мы кладём Mutable LiveData (и только мы знаем об этом) - избегая т.о теневых полей. */
    override val screenState =  MutableLiveData<MovieSelectionContract.MovieSelectionState>() // todo Future
    override val screenOrientationPortrait = MutableLiveData<Boolean>() // todo Future
    override val selectMovie = MutableLiveData<Int>()
    override val searchStringMovie = MutableLiveData<String>()

    override fun onClickMovie(selectedMovie: Int) {
        selectMovie.postValue(selectedMovie)
        // TODO + another logic
    }

    override fun onSearchMovie(searchString: String) {
        searchStringMovie.postValue(searchString)
        // TODO + another logic
    }
}