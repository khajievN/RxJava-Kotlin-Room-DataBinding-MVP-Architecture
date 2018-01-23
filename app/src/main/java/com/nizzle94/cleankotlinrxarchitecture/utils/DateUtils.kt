package com.nizzle94.cleankotlinrxarchitecture.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Khajiev Nizomjon on 08/01/2018.
 */
class DateUtils {
    companion object {

        fun formatStringFromServer(unformattedDate: String): String {
            return try {
                val timeZone = TimeZone.getTimeZone("Asia/Calcutta")
                val cal = Calendar.getInstance(timeZone)
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                sdf.calendar = cal
                cal.time = sdf.parse(unformattedDate)
                val date = cal.time
                val newFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
                newFormat.format(date)
            } catch (e: Exception) {
                unformattedDate
            }

        }

    }
}