package com.marco.pocgoogleadmob.features.feature_admob

import android.app.Activity
import android.content.Context

sealed class AdmobViewAction {

    object AdMob {
        data object LoadInterstitial : AdmobViewAction()
        data class ShowInterstitial(val activity: Activity) : AdmobViewAction()
        data class LoadVideo(val context: Context) : AdmobViewAction()
        data class ShowVideo(val activity: Activity) : AdmobViewAction()
        data class LoadBanner(val context: Context) : AdmobViewAction()
    }

}