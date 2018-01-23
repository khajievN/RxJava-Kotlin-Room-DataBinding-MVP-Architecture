package com.nizzle94.cleankotlinrxarchitecture

import android.app.Application
import com.nizzle94.cleankotlinrxarchitecture.di.*

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
class App : Application() {

    lateinit var appComponent: AppComponent
    lateinit var presenterComponent: PresenterComponent

    override fun onCreate() {
        super.onCreate()
        val appModule = AppModule(this)
        appComponent = DaggerAppComponent.builder()
            .appModule(appModule)
            .build()

        presenterComponent = appComponent.plus(PresenterModule())
        appComponent.inject(this)
    }

}