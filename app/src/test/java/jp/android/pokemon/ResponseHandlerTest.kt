package jp.android.pokemon

import jp.android.pokemon.data.utils.ResponseHandler
import jp.android.pokemon.domain.model.PokemonResponse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Response

class ResponseHandlerTest {

    @Test
    fun `handle should return success when response is successful`() {
        val mockResponse = Response.success(PokemonResponse())
        val result = ResponseHandler.handle(mockResponse)
        assertTrue(result.isSuccess)
    }

    @Test
    fun `handle should return failure when response is not successful`() {
        val errorBody = "{\"error\":\"Not Found\"}".toResponseBody("application/json".toMediaTypeOrNull())
        val mockResponse = Response.error<PokemonResponse>(404, errorBody)
        val result = ResponseHandler.handle(mockResponse)
        assertTrue(result.isFailure)
        assertEquals("HTTPエラー: 404 - Not Found - {\"error\":\"Not Found\"}", result.exceptionOrNull()?.message)
    }
}