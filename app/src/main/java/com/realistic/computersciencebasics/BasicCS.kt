package com.realistic.computersciencebasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

import com.realistic.computersciencebasics.ch_list.*

class BasicCS : AppCompatActivity() {

    //ad code var
    private var mInterstitialAd: InterstitialAd? = null
    private val TAG = "AdLoaderMainAtc"


    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_cs)
        MobileAds.initialize(this) { }
        Ads()

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

    fun Introduction(view: View) {
        val Intro  = Intent(this, Ch_Introduction::class.java)
        startActivity(Intro)
    }
    fun Fundamental_Concept(view: View) {
        val Fundamental_Concept : Intent = Intent(this, Ch_FundamentalConcept::class.java)
        startActivity(Fundamental_Concept)

    }
    fun Role_of_Computer(view: View) {
        val Role_of_Computer: Intent = Intent(this, Ch_Role_of_Computer::class.java)
        startActivity(Role_of_Computer)

    }
    fun Computer_System(view: View) {
        val Computer_System: Intent = Intent(this, Ch_computer_system::class.java)
        startActivity(Computer_System)

    }
    fun Programming_Languages(view: View) {
        val Programming_Languages: Intent = Intent(this, Ch_Programming_Languages::class.java)
        startActivity(Programming_Languages)

    }
    fun Hardware_and_Software(view: View) {
        val Hardware_and_Software: Intent = Intent(this, Ch_Hardware_and_Software::class.java)
        startActivity(Hardware_and_Software)
    }
    fun Analog_and_Digital(view: View) {
        val Analog_and_Digital: Intent = Intent(this, Ch_analog_and_digital::class.java)
        startActivity(Analog_and_Digital)

    }
    fun Operating_System(view: View) {
        val Operating_System: Intent = Intent(this, Ch_OS::class.java)
        startActivity(Operating_System)

    }
    fun Internet(view: View) {
        val Internet: Intent = Intent(this, Ch_Internet::class.java)
        startActivity(Internet)

    }
    fun Types_of_Computer(view: View) {
        val Types_of_Computer: Intent = Intent(this, Ch_types_of_computer::class.java)
        startActivity(Types_of_Computer)

    }
    fun Congratulations(view: View) {
        val Congratulations: Intent = Intent(this, Ch_Congratulations::class.java)
        startActivity(Congratulations)

    }
}