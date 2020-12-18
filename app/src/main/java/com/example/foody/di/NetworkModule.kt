package com.example.foody.di

import com.example.foody.util.Constants.Companion.BASE_URL
import com.example.foody.data.network.FoodRecipesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
// @Module memberi tahu Dagger bahwa kelas ini adalah Modul Dagger
// Di sana, Anda dapat menentukan dependensi dengan anotasi @Provides
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    // @Singleton untuk menganotasi ApplicationComponent dan objek yang ingin Anda gunakan kembali di seluruh aplikasi.
    @Provides
    // Modul adalah kelas yang memiliki anotasi @Module dan mendefinisikan metode yang dianotasi dengan anotasi @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                // TimeUnit digunakan untuk menginformasikan metode berbasis waktu bagaimana parameter waktu tertentu harus diinterpretasikan
                .build()
    }

    @Singleton
    // Anotasi @Singleton berarti bahwa Dagger akan membuat dan memelihara satu instance dari kelas yang dianotasi
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(
            okHttpClient: OkHttpClient,
            // OkHttp adalah pustaka pihak ketiga yang dikembangkan oleh Square untuk mengirim dan menerima permintaan jaringan berbasis HTTP
            gsonConverterFactory: GsonConverterFactory
            // GsonConverterFactory adl Konverter yang menggunakan Gson untuk JSON.
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): FoodRecipesApi {
        return retrofit.create(FoodRecipesApi::class.java)
    }
}