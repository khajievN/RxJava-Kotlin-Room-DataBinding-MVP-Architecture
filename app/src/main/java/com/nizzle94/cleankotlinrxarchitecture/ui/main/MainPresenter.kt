package com.nizzle94.cleankotlinrxarchitecture.ui.main

import com.nizzle94.cleankotlinrxarchitecture.api.NewsApi
import com.nizzle94.cleankotlinrxarchitecture.mvp.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
class MainPresenter(var newsApi: NewsApi) : Presenter<MainView>() {


    fun loadTopHeadlines() {
        getView()?.showProgress()
        newsApi.getTopHeadlines()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if (it.isSuccess()) {
                    if (it.isNotEmpty()) {
                        getView()?.hideEmptyView()
                        getView()?.onSuccessData(it.articles)
                    } else {
                        getView()?.showEmptyView()
                    }
                } else {
                    getView()?.onErrorData()
                }
            }, {
                print(it.localizedMessage)
                getView()?.hideProgress()
            }, {
                getView()?.hideProgress()
            })

    }

}