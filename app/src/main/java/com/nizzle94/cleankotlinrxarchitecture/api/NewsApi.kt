package com.nizzle94.cleankotlinrxarchitecture.api

import com.nizzle94.cleankotlinrxarchitecture.api.result.BaseResult
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
interface NewsApi {

    @GET("/v2/top-headlines?country=us")
    fun getTopHeadlines(): Observable<BaseResult>

}