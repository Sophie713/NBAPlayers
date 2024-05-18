package com.sophiemiller.nbaplayers.presentation.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Set application as Hilt Application for DI purposes
 *
 */
@HiltAndroidApp
class NBAPlayersApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}