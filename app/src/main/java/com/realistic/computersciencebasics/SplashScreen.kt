package com.realistic.computersciencebasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.core.os.HandlerCompat.postDelayed
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class SplashScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//SPLASH CODE
        val SPLASH_TIMER_OUT = 3000L
        Handler().postDelayed({
            val splash = Intent(this, MainActivity::class.java )
            startActivity(splash)
            finish()
        }, SPLASH_TIMER_OUT)
    }
}