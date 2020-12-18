package com.example.foody.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foody.models.FoodRecipe
import com.example.foody.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
// @ Entity - setiap kelas model dengan anotasi ini akan memiliki tabel pemetaan di DB
class RecipesEntity(
        var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    // @PrimaryKey anotasi ini menunjukkan kunci utama entitas
    // jika disetel ke true, maka SQLite akan menghasilkan id unik untuk kolom tersebut
    var id: Int = 0
}