package com.estefaniasalamanca.formacion.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estefaniasalamanca.formacion.R

class SuperheroAdapter(var superheroeList: List<SuperHeroItemResponse> = emptyList(), private val onItemSelected:(String) -> Unit) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    fun updateList(superheroeList: List<SuperHeroItemResponse>){
        this.superheroeList = superheroeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        return SuperheroViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(viewholder: SuperheroViewHolder, position: Int) {
        viewholder.bind(superheroeList[position], onItemSelected)
    }

    override fun getItemCount() = superheroeList.size

}

