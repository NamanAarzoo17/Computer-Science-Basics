package com.realistic.computersciencebasics.ch_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.realistic.computersciencebasics.R

class Ch_Programming_Languages : AppCompatActivity() {


    var mInterstitialAd: InterstitialAd? = null
    private val TAG = "ch_programing_lang"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ch_programming_languages)
    }
}