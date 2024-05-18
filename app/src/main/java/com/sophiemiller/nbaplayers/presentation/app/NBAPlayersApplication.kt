package com.sophiemiller.nbaplayers.presentation.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NBAPlayersApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}