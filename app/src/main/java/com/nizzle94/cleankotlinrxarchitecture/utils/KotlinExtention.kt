package com.nizzle94.cleankotlinrxarchitecture.utils

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Khajiev Nizomjon on 12/12/2017.
 */

fun ViewGroup.inflate(layoutId: Int): View {
    return LayoutInflater.from(context).inflate(layoutId, this, false)
}

fun Context.getLayoutInflater() =
    getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

fun <T : ViewDataBinding> View.bind() = DataBindingUtil.bind<T>(this) as T

fun <T : ViewDataBinding> ViewGroup.bind(layoutId: Int): T {
    return DataBindingUtil.inflate(getLayoutInflater(), layoutId, this, false)
}

private fun ViewGroup.getLayoutInflater(): LayoutInflater? {
    return LayoutInflater.from(context)
}

