package com.nizzle94.cleankotlinrxarchitecture.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 24/01/2018.
 */
@Entity(tableName = "news")
data class News constructor(
    var title: String?,
    var author: String?,
    @SerializedName("publishedAt")
    var publishedAt: String?,
    @SerializedName("urlToImage")
    @ColumnInfo(name = "image")
    var image: String = "",
    @SerializedName("description")
    var description: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}