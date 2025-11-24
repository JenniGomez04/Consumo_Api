package com.sena.practica_de_consumo_api.domain.repository

import com.sena.practica_de_consumo_api.domain.model.Pokemon

// Obtiene lista de ususarios de la fuente de datos
// Más adelante usaremos la implementación retrofit para llamar a la Api

interface PokemonRepository {
    suspend fun getPokemon(): List<Pokemon>
}