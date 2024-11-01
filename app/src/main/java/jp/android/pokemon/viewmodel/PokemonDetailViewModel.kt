package jp.android.pokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jp.android.pokemon.domain.usecase.GetPokemonDetailsUseCase
import jp.android.pokemon.ui.state.PokemonDetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokemonDetailUiState>(PokemonDetailUiState.Loading)
    val uiState: StateFlow<PokemonDetailUiState> = _uiState

    fun fetchPokemonDetails(pokemonId: String) {
        viewModelScope.launch {
            _uiState.value = PokemonDetailUiState.Loading
            val result = getPokemonDetailsUseCase(pokemonId)
            result.fold(
                onSuccess = { response ->
                    _uiState.value = PokemonDetailUiState.Success(response)
                },
                onFailure = { throwable ->
                    _uiState.value = PokemonDetailUiState.Error(throwable.message ?: "An error occurred")
                }
            )
        }
    }
}