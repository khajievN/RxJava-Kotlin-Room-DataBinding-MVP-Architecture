package com.nizzle94.cleankotlinrxarchitecture.mvp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nizzle94.cleankotlinrxarchitecture.mvp.BaseView
import com.nizzle94.cleankotlinrxarchitecture.mvp.Presenter

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
abstract class MvpActivity<V : BaseView, P : Presenter<V>> : AppCompatActivity() {

    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
        presenter.attachView(getMvpView())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        presenter.onDestroy()
    }


    abstract fun createPresenter(): P

    abstract fun getMvpView(): V

}