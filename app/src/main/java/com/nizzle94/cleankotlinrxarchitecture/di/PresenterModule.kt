package com.nizzle94.cleankotlinrxarchitecture.di

import com.nizzle94.cleankotlinrxarchitecture.api.NewsApi
import com.nizzle94.cleankotlinrxarchitecture.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
@Module
class PresenterModule {

    @Provides
    fun provideMainPresenter(newsApi: NewsApi) =  MainPresenter(newsApi)

}