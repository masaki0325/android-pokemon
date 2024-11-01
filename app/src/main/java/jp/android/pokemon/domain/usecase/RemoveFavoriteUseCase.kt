package jp.android.pokemon.domain.usecase

import jp.android.pokemon.data.model.FavoritePokemon
import jp.android.pokemon.domain.repository.FavoritePokemonRepository
import javax.inject.Inject

class RemoveFavoriteUseCase @Inject constructor(
    private val repository: FavoritePokemonRepository
) {
    suspend fun invoke(favoritePokemon: FavoritePokemon) {
        repository.delete(favoritePokemon)
    }
}