package com.example.foody.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
// @Database Berisi database holder dan berfungsi sebagai main access point untuk koneksi yang mendasari ke data relasional aplikasi Anda yang bertahan
        entities = [RecipesEntity::class],
        version = 1,
        exportSchema = false
)

@TypeConverters(RecipesTypeConverter::class)
abstract class RecipesDatabase: RoomDatabase() {

    abstract fun recipesDao(): RecipesDao
}