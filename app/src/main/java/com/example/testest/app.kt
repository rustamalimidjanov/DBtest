package com.example.testest

import android.app.Application

class app: Application() {
    override fun onCreate() {
        super.onCreate()
        NameRepository.initialize(this)
    }
}