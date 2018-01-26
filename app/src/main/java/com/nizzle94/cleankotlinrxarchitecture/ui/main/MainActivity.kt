package com.nizzle94.cleankotlinrxarchitecture.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.nizzle94.cleankotlinrxarchitecture.R
import com.nizzle94.cleankotlinrxarchitecture.adapter.NewsAdapter
import com.nizzle94.cleankotlinrxarchitecture.model.News
import com.nizzle94.cleankotlinrxarchitecture.ui.base.BaseActivity
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView,
    SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {
        presenter.loadTopHeadlines()
    }

    override fun onSuccessData(newsList: List<News>) {
        newsAdapter?.setData(newsList)
    }

    override fun onErrorData() {
    }

    override fun showProgress() {
        swipe_layout.isRefreshing = true
    }

    override fun hideProgress() {
        swipe_layout.isRefreshing = false
    }

    override fun showEmptyView() {
    }

    override fun hideEmptyView() {
    }

    override fun createPresenter(): MainPresenter = presenterProvider.get()
    override fun getMvpView(): MainView = this
    override fun dependencyInject() = app.presenterComponent.inject(this)

    @Inject
    lateinit var presenterProvider: Lazy<MainPresenter>
    private var newsAdapter: NewsAdapter? = null
    private val newsList = ArrayList<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.main_news)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view!!.layoutManager = linearLayoutManager
        newsAdapter = NewsAdapter(newsList, clickListener = {
        })

        recycler_view!!.adapter = newsAdapter
        recycler_view!!.addItemDecoration(
            DividerItemDecoration(
                applicationContext,
                DividerItemDecoration.VERTICAL
            )
        )
        swipe_layout.setOnRefreshListener(this)
        swipe_layout.setColorSchemeResources(
            R.color.colorPrimary,
            R.color.colorPrimary,
            R.color.colorPrimary
        )
        presenter.loadTopHeadlines()

    }
}
