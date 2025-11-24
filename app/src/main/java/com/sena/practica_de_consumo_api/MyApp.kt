package com.sena.practica_de_consumo_api

// Sirve para utilizar los decoradores en modelos, rutas, clases, etc.
// Configuración inicial de hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application()