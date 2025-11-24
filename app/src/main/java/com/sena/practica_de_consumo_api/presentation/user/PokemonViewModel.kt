package com.sena.practica_de_consumo_api.presentation.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.sena.practica_de_consumo_api.domain.useCase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonViewModel (
    private val getPokemonUseCase: GetPokemonUseCase
): ViewModel() {

    // StateFlow mutable interno (solo el ViewModel puede cambiar el estado)
    private val _uiState = MutableStateFlow(PokemonUiState())

    // StateFlow inmutable (solo la UI puede leer el estado)
    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    init {
        // Al crear el ViewModel, cargamos los usuarios automaticamente
        loadPokemon ()
    }

    /* Carga la lista de Pokemon desde el caso de uso
    * */


    fun loadPokemon() {
        viewModelScope.launch {
            // Estado: Cargando
            _uiState.value = _uiState.value.copy(
                isLoadding = true,
                errorMessage = null
            )

            try{
                val pokemons = getPokemonUseCase()

                // Estado: Exito (Cargando pokemones)
                _uiState.value = _uiState.value.copy(
                    isLoadding = false,
                    pokemon = pokemons,
                    errorMessage = null
                )
                } catch (e: Exception) {
                // Estado: Error
            _uiState.value = _uiState.value.copy(
                isLoadding = false,
                errorMessage = e.message ?: "Ocurrio un error al cargar los Pokemon"
            )
            }
        }
    }
}

