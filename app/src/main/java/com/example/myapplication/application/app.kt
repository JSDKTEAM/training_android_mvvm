package com.example.myapplication.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.example.myapplication.di.initKoin
import com.example.myapplication.tools.Contextor

class app : Application() {

    companion object {
        private var instance: app? = null
        fun getInstance(): app {
            return instance!!
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Contextor.getInstance().init(this)
        initKoin(this)
    }
}