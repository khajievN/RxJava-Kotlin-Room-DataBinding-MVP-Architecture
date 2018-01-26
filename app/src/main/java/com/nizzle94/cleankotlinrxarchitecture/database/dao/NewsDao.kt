package com.nizzle94.cleankotlinrxarchitecture.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.nizzle94.cleankotlinrxarchitecture.model.News
import io.reactivex.Single

/**
 * Created by Khajiev Nizomjon on 24/01/2018.
 */
@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(news: News)

    @Query("SELECT * FROM news")
    fun getAll(): Single<List<News>>

    @Query("DELETE FROM news")
    fun deleteAll()


}