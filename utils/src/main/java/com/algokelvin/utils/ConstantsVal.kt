package com.algokelvin.utils

import android.text.format.DateFormat
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

val date: Date = Calendar.getInstance().time

fun getDate(dateFormat: String): String {
    val formatDate = SimpleDateFormat(dateFormat, Locale.getDefault())
    return formatDate.format(date)
}
fun getDay() = DateFormat.format("dd", date).toString()
fun getMonth() = DateFormat.format("MM", date).toString()
fun getYear() = DateFormat.format("yyyy", date).toString()

fun getDateConvert(oldFormat: String, oldDate: String, newFormat: String): String {
    val sdf = SimpleDateFormat(oldFormat, Locale.ENGLISH)
    sdf.timeZone = TimeZone.getTimeZone("UTC")
    val date = sdf.parse(oldDate)
    sdf.timeZone = TimeZone.getDefault()
    sdf.applyPattern(newFormat)
    return sdf.format(date)
}
fun rupiahFormat(amount : String?) : String{
    val formatter = DecimalFormat("#,###")
    val amount1 = amount?.replace(".00","")
    return formatter.format(amount1?.toInt()).toString().replace(",",".")
}