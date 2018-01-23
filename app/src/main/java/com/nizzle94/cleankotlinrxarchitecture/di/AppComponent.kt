package com.nizzle94.cleankotlinrxarchitecture.di

import com.nizzle94.cleankotlinrxarchitecture.App
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
@Singleton
@Component(
    modules =
    [
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun plus(presenterModule: PresenterModule): PresenterComponent

    fun inject(app: App)
}