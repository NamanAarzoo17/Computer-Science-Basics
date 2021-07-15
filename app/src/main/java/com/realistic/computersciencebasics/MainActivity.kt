package com.realistic.computersciencebasics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    // code to open basic CS activity var
    private lateinit var basicCS: CardView

    //ad code var
    private var mInterstitialAd: InterstitialAd? = null
    private val TAG = "AdLoaderMainAtc"

    override fun onBackPressed() {
        super.onBackPressed()
        exitProcess(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MobileAds.initialize(this) { }
        Ads()

        // code to open basic CS activity
        basicCS = findViewById(R.id.basicCS)
        basicCS.setOnClickListener {
            if (mInterstitialAd != null) {
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this)
                    mInterstitialAd?.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdDismissedFullScreenContent() {
                                Log.d(TAG, "Ad was dismissed.")
                                val basicCS = Intent(this@MainActivity, BasicCS::class.java)
                                startActivity(basicCS)
                                finish()
                            }

                            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                                Log.d(TAG, "Ad failed to show.")
                                if (mInterstitialAd != null) {
                                    Ads()
                                }

                            }

                            override fun onAdShowedFullScreenContent() {
                                Log.d(TAG, "Ad showed fullscreen content.")
                                mInterstitialAd = null
                            }
                        }
                }
            }

        }
    }


    //function to load ad
    private fun Ads() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError?.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                }
            })
    }

    fun showAds(view: View) {
        if (mInterstitialAd != null) {
            if (mInterstitialAd != null) {
                mInterstitialAd!!.show(this)
                mInterstitialAd!!.fullScreenContentCallback = object: FullScreenContentCallback() {

                    override fun onAdDismissedFullScreenContent() {
                        Log.d(TAG, "Ad was dismissed\n\n")
                        val basicCS = Intent(this@MainActivity, BasicCS::class.java)
                        startActivity(basicCS)
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError?) {
                        Log.d(TAG, "Ad failed to show")
                        if(mInterstitialAd == null){
                            Ads()
                        }
                    }

                    override fun onAdShowedFullScreenContent() {
                        Log.d(TAG, "Ad showed fullscreen content.")
                        mInterstitialAd = null
                        Ads()
                    }
                }
            }
        }
    }


}

