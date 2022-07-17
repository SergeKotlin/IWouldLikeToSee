package com.example.idliketosee.ui.screens.movieSelection.model

import androidx.lifecycle.LiveData

class MovieSelectionContract { // Для удобства разработчика
    enum class MovieSelectionState {
        IDLE, UPLOADED, NO_INTERNET // IDLE - начальное состояние
    }

    interface ViewModelMovieSelection { // Вью-"модель" — описание структуры и состояний
        val screenState: LiveData<MovieSelectionState>
        val screenOrientationPortrait: LiveData<Boolean>
        val selectMovie: LiveData<Int>
        val searchStringMovie: LiveData<String>


        fun onClickMovie (selectedMovie: Int) // Выбор фильма для перехода на экран его описания
        fun onSearchMovie(searchString: String)
    }
}

/* В MVVM направление информации:
как бы вьюшка ходит в презентер;
подписки вместо управляющих методов. */

/* MVP способно напрямую сказать что-то делать вью. А также имеет чёткую логику разделения.
MVVM на подписках и слушателях приучена к отключению view (умеет переживать поворот экрана).
(Личный опыт от VovaFishing: Если портретная ориентация, то MVP. Если необходима работа в двух ориентациях, то MVVM. */