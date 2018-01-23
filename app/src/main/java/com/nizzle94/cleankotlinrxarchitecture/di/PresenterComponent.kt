package com.nizzle94.cleankotlinrxarchitecture.di

import com.nizzle94.cleankotlinrxarchitecture.ui.main.MainActivity
import dagger.Subcomponent

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
@PresenterScope
@Subcomponent(
    modules = [
        PresenterModule::class
    ]
)
interface PresenterComponent {

    fun inject(mainActivity: MainActivity)
}