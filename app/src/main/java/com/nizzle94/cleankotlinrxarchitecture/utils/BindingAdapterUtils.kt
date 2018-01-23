package com.nizzle94.cleankotlinrxarchitecture.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nizzle94.cleankotlinrxarchitecture.R

/**
 * Created by Khajiev Nizomjon on 23/01/2018.
 */
class BindingAdapterUtils {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun setImageUrl(imageView: ImageView, url: String?) {
            val requestOptions = RequestOptions()
            requestOptions.error(R.drawable.news_placeholder)
            requestOptions.placeholder(R.drawable.news_placeholder)
            Glide.with(imageView.context)
                .load(url)
                .apply(requestOptions)
                .into(imageView)
        }

        @JvmStatic
        @BindingAdapter("formatServerDate")
        fun formateServerDate(textView: TextView, unFormattedDate: String?) {
            if (unFormattedDate != null) {
                val formattedDate = DateUtils.formatStringFromServer(unFormattedDate)
                textView.text = formattedDate
            } else {
                textView.text = ""
            }
        }



    }
}