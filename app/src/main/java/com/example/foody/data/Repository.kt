package com.example.foody.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
// @ActivityRetainedScope akan melindungi dari perubahan konfigurasi seperti perubahan orientasi layar, perubahan bahasa
class Repository @Inject constructor(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
) {

    val remote = remoteDataSource
    val local = localDataSource
}