package com.estefaniasalamanca.formacion.superheroapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.estefaniasalamanca.formacion.databinding.ActivitySuperHeroListBinding
import com.estefaniasalamanca.formacion.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {
    private lateinit var  binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit =getRetrofit()
        initUI()
    }
    private fun initUI(){
        binding.searchView.setOnQueryTextListener(object: androidx.appcompat.widget.SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false

        })
        adapter = SuperheroAdapter {navigateToDetail(it)}
        binding.rvSuperHeroes.setHasFixedSize(true)
        binding.rvSuperHeroes.layoutManager =LinearLayoutManager(this)
        binding.rvSuperHeroes.adapter = adapter
    }

    private fun searchByName(query: String?) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse: Response<SuperHeroDataResponse> =
                retrofit.create(ApiService::class.java).getSuperheroes(query.toString())
            if (myResponse.isSuccessful){
                val response: SuperHeroDataResponse? =myResponse.body()
                if(response !=null){
                    Log.i("aristidevs", response.toString() )
                    runOnUiThread {
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible = false
                    }

                }
                Log.i("aristidevs", "Funciona :)" )
            }else{
                Log.i("aristidevs", "No funciona :(" )
            }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }
    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)
    }

}