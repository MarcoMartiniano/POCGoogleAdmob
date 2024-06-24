package com.marco.pocgoogleadmob.commons.admob

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class AdMobManager(private val context: Context) {
    // Variable to hold the interstitial ad
    private var mInterstitialAd: InterstitialAd? = null

    // Ad unit ID for banner test
    private val adBannerTestUnitId = "ca-app-pub-3940256099942544/9214589741"

    // Initialize AdMob
    init {
        MobileAds.initialize(context) {
            Log.d("AdMob", "AdMob initialized")
        }
    }

    // Create an ad request
    private var adRequest = AdRequest.Builder().build()

    // Function to load an interstitial ad
    fun loadInterstitialAd(
        onAdFailedToLoad: (LoadAdError) -> Unit = {},
        onAdLoaded: () -> Unit = {},
    ) {
        // Load the interstitial ad with specified ad unit ID and ad request
        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                // Called when ad fails to load
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    mInterstitialAd = null
                    onAdFailedToLoad.invoke(adError)
                }

                // Called when ad is loaded successfully
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    onAdLoaded.invoke()
                }
            })
    }

    // Function to show the interstitial ad
    fun showInterstitialAd(
        activity: Activity,
        onAdClicked: () -> Unit = {},
        onAdDismissedFullScreenContent: () -> Unit = {},
        onAdImpression: () -> Unit = {},
        onAdShowedFullScreenContent: () -> Unit = {},
    ) {
        // Check if interstitial ad is loaded
        mInterstitialAd?.let { ad ->
            // Set full-screen content callback for ad events
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                    // Called when a click is recorded for an ad.
                    onAdClicked.invoke()
                }

                override fun onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    mInterstitialAd = null
                    // Load a new ad for next time
                    loadInterstitialAd()
                    onAdDismissedFullScreenContent.invoke()
                }

                override fun onAdImpression() {
                    // Called when an impression is recorded for an ad.
                    onAdImpression.invoke()
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    onAdShowedFullScreenContent.invoke()
                }
            }
            // Show the interstitial ad
            ad.show(activity)
        } ?: run {
            // Log message if ad wasn't ready
            Log.d("AdMobManager", "The interstitial ad wasn't ready yet.")
        }
    }

    // Function to load a banner ad
    fun loadBannerAd(context: Context): AdView {
        // Create and return an AdView configured with ad size and unit ID
        return AdView(context).apply {
            setAdSize(AdSize.BANNER)
            adUnitId = adBannerTestUnitId
            loadAd(AdRequest.Builder().build())
        }
    }
}