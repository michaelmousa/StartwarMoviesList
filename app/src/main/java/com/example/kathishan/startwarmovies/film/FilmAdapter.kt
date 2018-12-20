package com.example.kathishan.startwarmovies.film



import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kathishan.startwarmovies.R
import kotlinx.android.synthetic.main.item_pass.view.*

class FilmAdapter : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    private val data = arrayListOf<Results>()


    fun setData(items: List<Results>) {
        data.clear()
        data.addAll(items)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pass, parent, false)
        return FilmViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: FilmViewHolder, position: Int) {
        viewHolder.bind(data[position])
    }


    class FilmViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(results: Results) {
            view.tvTitle.text = results.title.toString()

        }

    }
}