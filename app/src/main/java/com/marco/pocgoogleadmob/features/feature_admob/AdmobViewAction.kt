package com.marco.pocgoogleadmob.features.feature_admob

import android.app.Activity

sealed class AdmobViewAction {

    object AdMob {
        data object LoadInterstitial : AdmobViewAction()
        data class ShowInterstitial(val activity: Activity) : AdmobViewAction()
        data object LoadVideo : AdmobViewAction()
        data class ShowVideo(val activity: Activity) : AdmobViewAction()
        data object LoadBanner : AdmobViewAction()
    }

}