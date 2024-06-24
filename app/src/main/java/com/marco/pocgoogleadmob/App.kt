package com.marco.pocgoogleadmob

import android.app.Application
import com.marco.pocgoogleadmob.core.di.commonsModule
import com.marco.pocgoogleadmob.core.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                presentationModule,
                commonsModule
            )
        }
    }
}