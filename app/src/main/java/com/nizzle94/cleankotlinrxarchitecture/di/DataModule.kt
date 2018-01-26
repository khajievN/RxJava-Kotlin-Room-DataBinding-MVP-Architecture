package com.nizzle94.cleankotlinrxarchitecture.di

import android.arch.persistence.room.Room
import android.content.Context
import com.nizzle94.cleankotlinrxarchitecture.database.Migrations
import com.nizzle94.cleankotlinrxarchitecture.database.NewsDatabase
import com.nizzle94.cleankotlinrxarchitecture.database.dao.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Khajiev Nizomjon on 24/01/2018.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): NewsDatabase =
        Room.databaseBuilder(context, NewsDatabase::class.java, "news.db")
            .addMigrations(Migrations.MIGRATION_1_2)
            .addMigrations(Migrations.MIGRATION_2_3)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesNewsDao(database: NewsDatabase): NewsDao = database.newsDao()

}