package com.sena.practica_de_consumo_api.data.repository

import com.sena.practica_de_consumo_api.data.PokemonApi
import com.sena.practica_de_consumo_api.data.remote.dto.toDomain
import com.sena.practica_de_consumo_api.domain.model.Pokemon
import com.sena.practica_de_consumo_api.domain.repository.PokemonRepository
import jakarta.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonRepository {
    override suspend fun getPokemon(): List<Pokemon> {
        // Llamamos al endpoint /pokemon
        val response = pokemonApi.getPokemon()

        // Tomamos la lista "results" y la mapeamos al modelo de dominio
        return response.results.map { it.toDomain() }
    }
}
