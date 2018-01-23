package com.nizzle94.cleankotlinrxarchitecture.api.result

import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
data class NewsResult(
    @SerializedName("source") var source: NewsSource,
    @SerializedName("author") var author: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description: String,
    @SerializedName("url") var url: String,
    @SerializedName("urlToImage") var urlToImage: String,
    @SerializedName("publishedAt") var date: String
)


data class NewsSource(
    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?
)