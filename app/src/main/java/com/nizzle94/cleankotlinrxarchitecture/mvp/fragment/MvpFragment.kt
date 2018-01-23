package com.nizzle94.cleankotlinrxarchitecture.mvp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.nizzle94.cleankotlinrxarchitecture.mvp.BaseView
import com.nizzle94.cleankotlinrxarchitecture.mvp.Presenter

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
abstract class MvpFragment<V : BaseView, P : Presenter<V>> : Fragment() {

    protected lateinit var presenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = createPresenter()
        presenter.attachView(getMvpView())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
        presenter.onDestroy()
    }

    abstract fun createPresenter(): P

    abstract fun getMvpView(): V
}