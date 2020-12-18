package com.example.foody.data

import com.example.foody.data.network.FoodRecipesApi
import com.example.foody.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
// @Inject: meminta dependensi. Dapat digunakan pada constructor, field, atau method
// Untuk mendapatkan dependensi dari komponen, gunakan anotasi @Inject untuk melakukan injeksi kolom
        private val foodRecipesApi: FoodRecipesApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }
}