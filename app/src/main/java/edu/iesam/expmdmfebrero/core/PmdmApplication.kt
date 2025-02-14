package edu.iesam.expmdmfebrero.core

import android.app.Application
import edu.iesam.expmdmfebrero.features.albumes.di.AlbumModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PmdmApplication : Application() { // Corregido el espacio aquí
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PmdmApplication)
            modules(
                AlbumModule
            )
        }
    }
}
