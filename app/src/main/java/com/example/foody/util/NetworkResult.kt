package com.example.foody.util


sealed class NetworkResult<T>(
// sealed class digunakan untuk membatasi fitur pewarisan pemrograman berorientasi objek
// Setelah kelas didefinisikan sebagai sealed class, kelas ini tidak dapat diwariskan
        val data: T? = null,
        val message: String? = null
) {

    class Success<T>(data: T?): NetworkResult<T>(data)
    class Error<T>(message: String?, data: T? = null): NetworkResult<T>(data, message)
    class Loading<T>: NetworkResult<T>()
}