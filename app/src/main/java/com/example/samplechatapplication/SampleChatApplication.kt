package com.example.samplechatapplication

import android.app.Application
import timber.log.Timber

class SampleChatApplication : Application() {

    val container by lazy { Container() }

    override fun onCreate() {
        super.onCreate()

        setUpTimber()
    }

    // Timberのセットアップ
    private fun setUpTimber() {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}