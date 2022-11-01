package com.example.kids

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.kids.utils.SessionManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AppApplication: Application() {
    private val TAG = AppApplication::class.simpleName
    companion object {
        lateinit var instance: Application
        lateinit var sessionManager: SessionManager

    }

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        instance = this
        sessionManager = SessionManager(applicationContext)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

    }
    override fun onTerminate() {
        super.onTerminate()
    }


}