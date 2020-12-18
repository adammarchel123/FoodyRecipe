package com.example.foody.di

import android.content.Context
import androidx.room.Room
import com.example.foody.data.database.RecipesDatabase
import com.example.foody.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
// @Module memberi tahu Dagger bahwa kelas ini adalah Modul Dagger
// Di sana, Anda dapat menentukan dependensi dengan anotasi @Provides
@InstallIn(ApplicationComponent::class)
// Anda harus menganotasikan modul Hilt dengan @InstallIn untuk memberi tahu Hilt class Android mana yang akan digunakan atau dipasang dalam setiap modul
object DatabaseModule {

    @Singleton
    // kami menggunakan anotasi @Singleton dan memberi tahu Hilt bahwa kelas ini harus hidup selama aplikasi masih hidup
    @Provides
    // @Provides untuk mengidentifikasi implementasi mana yang akan digunakan
    fun provideDatabase(
            @ApplicationContext context: Context
    ) = Room.databaseBuilder(
            context,
            RecipesDatabase::class.java,
            DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: RecipesDatabase) = database.recipesDao()
}