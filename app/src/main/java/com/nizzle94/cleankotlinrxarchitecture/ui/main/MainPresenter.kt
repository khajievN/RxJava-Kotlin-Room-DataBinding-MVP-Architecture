package com.nizzle94.cleankotlinrxarchitecture.ui.main

import com.nizzle94.cleankotlinrxarchitecture.api.NewsApi
import com.nizzle94.cleankotlinrxarchitecture.database.dao.NewsDao
import com.nizzle94.cleankotlinrxarchitecture.model.News
import com.nizzle94.cleankotlinrxarchitecture.mvp.Presenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
class MainPresenter(var newsApi: NewsApi, var newsDao: NewsDao) : Presenter<MainView>() {


    fun loadTopHeadlines() {

        val dbSource = newsDao.getAll()
            .subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.computation())
            .toObservable()
            .flatMap { idList ->
                Observable.just(idList)
            }
            .observeOn(AndroidSchedulers.mainThread())

        val networkResource = newsApi.getTopHeadlines()
            .subscribeOn(Schedulers.computation())
            .observeOn(Schedulers.computation())
            .filter { it.isSuccess() }
            .map {
                val list = it.articles
                newsDao.deleteAll()
                if (it.isNotEmpty()) {
                    list.forEach {
                        newsDao.insert(
                            News(
                                title = it.title ?: "",
                                author = it.author ?: "",
                                publishedAt = it.publishedAt ?: "",
                                image = it.image,
                                description = it.description ?: ""
                            )
                        )
                    }
                }
                list
            }
            .observeOn(AndroidSchedulers.mainThread())

        getView()?.showProgress()
        Observable.concat(dbSource, networkResource)
            .subscribe({
                if (it.isNotEmpty()) {
                    getView()?.onSuccessData(it)
                }
            }, {
                getView()?.hideProgress()
            }, {
                getView()?.hideProgress()
            })
    }

}