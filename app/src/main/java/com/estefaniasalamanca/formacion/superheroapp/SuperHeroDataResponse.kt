package com.estefaniasalamanca.formacion.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
//@SerializedName("results-for") val resultsFor:String,
    @SerializedName("results") val superheroes: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val superheroName: String,
    @SerializedName("image") val superheroImage: SuperHeroImageResponse
)
data class SuperHeroImageResponse(@SerializedName("url") val url:String)