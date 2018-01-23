package com.nizzle94.cleankotlinrxarchitecture.ui.main

import com.nizzle94.cleankotlinrxarchitecture.api.result.NewsResult
import com.nizzle94.cleankotlinrxarchitecture.mvp.BaseView

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
interface MainView : BaseView {

    fun onSuccessData(newsList: List<NewsResult>)

    fun onErrorData()

    fun showProgress()

    fun hideProgress()

    fun showEmptyView()

    fun hideEmptyView()

}