package com.example.foody.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
// @Dao bertanggung jawab untuk menentukan metode yang mengakses database
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // @Insert tersebut akan memasukkan parameternya ke dalam database anda
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Query("SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>
}