package com.nizzle94.cleankotlinrxarchitecture.di

import android.app.Application
import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
@Module
class AppModule(var application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder()
        .create()

}