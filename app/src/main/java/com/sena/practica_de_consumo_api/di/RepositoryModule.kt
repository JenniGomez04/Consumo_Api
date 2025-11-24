package com.sena.practica_de_consumo_api.di

import com.sena.practica_de_consumo_api.data.repository.PokemonRepositoryImpl
import com.sena.practica_de_consumo_api.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

// Modulo de Hilt para enlazar interfaces de repositorios
// Con sus implementaciones concretas

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun providePokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository {
        // Hilt sabe como crear PokemonRepositoryImpl porque tiene @inject en el consumo de Api
        return pokemonRepositoryImpl
    }
}