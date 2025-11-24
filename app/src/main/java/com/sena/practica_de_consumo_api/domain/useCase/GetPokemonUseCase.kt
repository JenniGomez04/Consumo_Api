package com.sena.practica_de_consumo_api.domain.useCase

import com.sena.practica_de_consumo_api.domain.model.Pokemon
import com.sena.practica_de_consumo_api.domain.repository.PokemonRepository
import jakarta.inject.Inject

// @Inject constructor para inyectar dependencias

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

// Ejecuta el caso de uso

    // Usamos operador fun invoke para poder llamarlo como getPokemonUseCase

    suspend operator fun invoke(): List <Pokemon> {
        return repository.getPokemon()
    }
}