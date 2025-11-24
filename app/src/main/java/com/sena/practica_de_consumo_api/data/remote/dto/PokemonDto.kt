package com.sena.practica_de_consumo_api.data.remote.dto

import com.sena.practica_de_consumo_api.domain.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/* Modelo que representa al usuario tal como viene en el JSON de la API
   @JsonClass(generateAdapter = true) para que Moshi codegen genere  el adapter en compilación

   Ajusta los nombres de las propiedades y @json(name = "dsfd" Segun el Json Real de la API
*/

@JsonClass(generateAdapter = true)
data class PokemonDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)

@JsonClass(generateAdapter = true)
data class PokemonListResponseDto(
    @Json(name = "results")
    val results: List<PokemonDto>
)

/* Mapea un Pokemon Dto (Item de la PokeApi al modelo de dominio */
fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        name = name,
        url = url
    )
}

