package com.estefaniasalamanca.formacion.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/1602372676894191/search/{name}")
    suspend fun getSuperheroes(@Path("name")superheroName:String): Response<SuperHeroDataResponse>
    @GET("api/1602372676894191/{id}")
    suspend fun  getSuperheroDetail(@Path("id")superheroId:String): Response<SuperHeroDetailResponse>

}