package jp.android.pokemon.domain.repository

import jp.android.pokemon.data.remote.PokemonApiService
import jp.android.pokemon.data.utils.ResponseHandler
import jp.android.pokemon.domain.model.PokemonDetails
import jp.android.pokemon.domain.model.PokemonResponse
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApiService: PokemonApiService) {

    suspend fun getPokemonList(limit: Int = 20, offset: Int): Result<PokemonResponse> {
        return try {
            val response = pokemonApiService.getPokemonList(limit, offset)
            ResponseHandler.handle(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPokemonDetails(pokemonId: String): Result<PokemonDetails> {
        return try {
            val response = pokemonApiService.getPokemonDetails(pokemonId)
            ResponseHandler.handle(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}