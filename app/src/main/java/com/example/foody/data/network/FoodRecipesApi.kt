package com.example.foody.data.network

import com.example.foody.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {
// interface berisi deklarasi metode abstrak, serta implementasi metode
// interface tidak dapat menyimpan state

    @GET("/recipes/complexSearch")
    // GET untuk mendapatkan data dari server
    suspend fun getRecipes(
            @QueryMap queries: Map<String, String>
            // QueryMap untuk menambahkan beberapa parameter query ke sebuah permintaan tanpa menentukan nama sebenarnya
    ): Response<FoodRecipe>
}