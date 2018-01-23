package com.nizzle94.cleankotlinrxarchitecture.mvp

import java.lang.ref.WeakReference

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
open class Presenter<V : BaseView> {
    var viewRef: WeakReference<V>? = null

    fun attachView(view: V) {
        viewRef = WeakReference(view)
    }

    fun getView(): V? {
        return viewRef?.get()
    }

    fun detachView() {
        viewRef?.clear()
        viewRef = null
    }

    open fun onDestroy() {
    }
}