package com.example.idliketosee.ui.screens.movieSelection.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idliketosee.data.model.RepoImpl
import com.example.idliketosee.ui.screens.movieSelection.model.MovieSelectionContract

class MovieSelectionViewModel: ViewModel(), MovieSelectionContract.ViewModelMovieSelection {
    /* В Mutable LiveData можно отправлять-менять значение.
         Во вью ожидается обычная LiveData (чтобы вью её не трогала),
         ну а мы кладём Mutable LiveData (и только мы знаем об этом) - избегая т.о теневых полей. */
    override val liveDataToObserve = MutableLiveData<MovieSelectionContract.MovieSelectionState>()
    override val repository = RepoImpl()

    override val screenOrientationPortrait = MutableLiveData<Boolean>() // todo Future
    override val searchStringMovie = MutableLiveData<String>() // todo Future

    override val selectMovie = MutableLiveData<Int>() // Нужно ли? todo

    fun getLiveData() = liveDataToObserve

    override fun getMovieListFromLocalSource() { // Имитирует запрос к БД (или ещё какому-то источнику данных в приложении)
        repository.getMovieListFromLocalStorage()
    }

    override fun onSearchMovie(searchString: String) { // todo Future
        searchStringMovie.postValue(searchString)
    }

    override fun onClickMovie(selectedMovie: Int) {
        selectMovie.postValue(selectedMovie)
        // TODO + another logic
    } // Нужно ли? todo


}