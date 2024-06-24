package com.marco.pocgoogleadmob.core.di

import com.marco.pocgoogleadmob.features.feature_admob.AdmobViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { AdmobViewModel() }
}