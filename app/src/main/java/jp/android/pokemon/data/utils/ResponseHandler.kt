package jp.android.pokemon.data.utils

import retrofit2.Response

// 共通のレスポンス処理メソッド
object ResponseHandler {

    fun <T> handle(response: Response<T>): Result<T> {
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Exception("レスポンスの内容が空です"))
        } else {
            val errorBody = response.errorBody()?.string() ?: "エラーレスポンスの内容が空です"
            val errorMessage = "HTTPエラー: ${response.code()} - ${response.message()} - $errorBody"
            Result.failure(Exception(errorMessage))
        }
    }
}