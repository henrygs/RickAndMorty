package com.example.rickandmortyjactpack.ui.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyjactpack.R
import com.example.rickandmortyjactpack.databinding.ItemPersonBinding
import com.example.rickandmortyjactpack.ext.Person
import com.squareup.picasso.Picasso

class HomePersonAdapter(val context: Context): RecyclerView.Adapter<HomePersonAdapter.ViewHolder>(){

    private var persons: List<Person> = arrayListOf()

    fun addPersons(personsApi: List<Person>) {
        persons = personsApi
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemPersonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun find(person: Person) {
            with(binding){
                nameTextView.text = person.name
                Picasso.get().load(person.image).placeholder(R.drawable.rick_and_morty)
                    .error(R.drawable.rick_and_morty).resize(500,0).into(personImageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomePersonAdapter.ViewHolder {
        val binding = ItemPersonBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomePersonAdapter.ViewHolder, position: Int) {
        val person = persons[position]
        holder.find(person)
    }

    override fun getItemCount(): Int {
        return persons.size
    }
}