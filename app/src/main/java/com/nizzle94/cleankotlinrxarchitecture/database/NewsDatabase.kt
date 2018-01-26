package com.nizzle94.cleankotlinrxarchitecture.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.nizzle94.cleankotlinrxarchitecture.database.dao.NewsDao
import com.nizzle94.cleankotlinrxarchitecture.model.News

/**
 * Created by Khajiev Nizomjon on 24/01/2018.
 */

@Database(
    entities = [
        News::class
    ], version = 4
)


abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
}