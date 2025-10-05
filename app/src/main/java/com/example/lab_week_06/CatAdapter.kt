package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list for storing all the list data
    private val cats = mutableListOf<CatModel>()

    // Function to set the mutable list
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // Notify the adapter that there's a data change in the mutable list
        notifyDataSetChanged()
    }

    // onCreateViewHolder instantiates the view holder itself
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }

    // Returns the number of items in the list
    override fun getItemCount() = cats.size

    // Binds each data to each layout view
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // The holder parameter stores our previously created ViewHolder
        // The holder.bindData function is declared in the CatViewHolder
        holder.bindData(cats[position])
    }
}