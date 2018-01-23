package com.nizzle94.cleankotlinrxarchitecture.api.result

import com.google.gson.annotations.SerializedName

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
data class BaseResult(
    @SerializedName("status") var status: String,
    @SerializedName("totalResults") var count: Int,
    @SerializedName("articles") var articles: List<NewsResult>
) {
    fun isSuccess(): Boolean = status == "ok"

    fun isNotEmpty(): Boolean = count > 0
}