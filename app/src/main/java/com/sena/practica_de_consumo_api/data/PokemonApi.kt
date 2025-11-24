package com.sena.practica_de_consumo_api.data

import com.sena.practica_de_consumo_api.data.remote.dto.PokemonListResponseDto
import com.sena.practica_de_consumo_api.domain.model.Pokemon
import retrofit2.http.GET


/* Interface de Retrofit que define los endpoints de la API de usuarios
  la base URL se configura en el NetworkModule
  Aqui solo definimos las rutas relativas
*/

interface PokemonApi {
    /* Trea todos los Endpoints
    * Ajusta la ruta del @get segun tu api real
    * Si tu enpoint es http://localhost:3000/pokemon -> usamos Pokemon
    * si es http://localhost:3000/api/pokemon -> usamos "api/pokemon"
    */


    @GET("Pokemon")
    suspend fun getPokemon(): PokemonListResponseDto
}
