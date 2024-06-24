package com.marco.pocgoogleadmob.core.di

import com.marco.pocgoogleadmob.commons.admob.AdMobManager
import org.koin.dsl.module

val commonsModule = module {
    single<AdMobManager> { AdMobManager(get()) }
}