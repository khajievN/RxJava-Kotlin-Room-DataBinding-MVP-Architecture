package com.nizzle94.cleankotlinrxarchitecture.ui.base

import android.os.Bundle
import android.support.annotation.StringRes
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.nizzle94.cleankotlinrxarchitecture.App
import com.nizzle94.cleankotlinrxarchitecture.mvp.BaseView
import com.nizzle94.cleankotlinrxarchitecture.mvp.Presenter
import com.nizzle94.cleankotlinrxarchitecture.mvp.activity.MvpActivity

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
abstract class BaseActivity<V : BaseView, P : Presenter<V>> : MvpActivity<V, P>() {

    val app get() = application as App


    override fun onCreate(savedInstanceState: Bundle?) {
        dependencyInject()
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    fun setHomeAsUp() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        if (!super.onSupportNavigateUp()) {
            supportFinishAfterTransition()
        }

        return true
    }

    fun showToast(@StringRes toastMessageRes: Int) {
        Toast.makeText(this, toastMessageRes, Toast.LENGTH_SHORT).show()
    }

    fun showToast(toastMessage: String) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        this.currentFocus?.let {
            it.clearFocus()
            val imm: InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm?.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun showKeyboard(view: View) {
        val imm: InputMethodManager? = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.showSoftInput(view, 0)
    }


    abstract fun dependencyInject()
}