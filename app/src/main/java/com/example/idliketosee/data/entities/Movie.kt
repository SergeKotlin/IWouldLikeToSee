package com.example.idliketosee.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val name: String = "Название",
    val desc: String = "Зарубежное название",
    val genre: String = "Жанры",
    val duration: String = "Длительность",
    val rating: String = "Рейтинг",
    val release_date: String = "Дата выхода",
    val budget: String = "Бюджет",
    val revenue: String = "Сборы",
    val announcement: String = "Описание фильма",
) : Parcelable