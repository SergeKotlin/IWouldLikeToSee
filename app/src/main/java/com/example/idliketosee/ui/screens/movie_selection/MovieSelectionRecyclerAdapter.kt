package com.example.idliketosee.ui.screens.movie_selection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.idliketosee.R

internal class MovieSelectionRecyclerAdapter(context: Context?, private val movies: List<String>) : // В адаптере описывается способ связи между данными и компонентом
    RecyclerView.Adapter<MovieSelectionRecyclerAdapter.MovieSelectionViewHolder>(){

//    private val movies: List<String>
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    inner class MovieSelectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){ // Используемые компоненты из макета для отдельного элемента списка
        // TODO View.OnClickListener {} and "override...onClick" for itemView
        internal val movieImage: View
        internal val movieInfo: TextView

        init {
            movieImage = itemView.findViewById(R.id.movie_image)
            movieInfo = itemView.findViewById(R.id.movie_info)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSelectionViewHolder {
        val itemView = inflater.inflate(R.layout.movie_selection_item, parent, false)
        return MovieSelectionViewHolder(itemView)
        /* Нужно указать id макета для отдельного элемента списка и вернуть объект класса ViewHolder.
         Если на экране можно отобразить 9 элементов списка, RecyclerView создаст 11-12 элементов (с запасом).
         Каким большим не был бы список - все данные будут размещаться в 11-12 элементах, менясь при прокрутке. */
    }

    override fun onBindViewHolder(holder: MovieSelectionViewHolder, position: Int) { // Связываем используемые текстовые метки с данными
        val info = movies[position]
        holder.movieImage.setBackgroundResource(R.drawable.nature) // todo ЗАГЛУШКА
        holder.movieInfo.text = info
        /* Параметр position отвечает за id в списке, по которому можно получить нужные данные. */
    }

    override fun getItemCount(): Int { // Возвращает количество элементов списка.
        return movies.size
        /* Адаптеру нужно знать, сколько элементов предоставить компоненту, чтобы распределить ресурсы
        и подготовиться к отображению на экране.
        Обычно данные однотипны, например, список строк. Можно просто вычислить и передать его длину. */
    }

}