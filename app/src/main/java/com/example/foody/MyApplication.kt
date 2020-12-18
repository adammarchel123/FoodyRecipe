package com.example.foody

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
// @HiltAndroidApp adl Anotasi untuk menandai kelas Aplikasi tempat komponen Dagger harus dibuat
class MyApplication: Application() {
}