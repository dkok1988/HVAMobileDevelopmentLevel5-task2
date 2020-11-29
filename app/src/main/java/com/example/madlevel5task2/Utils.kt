package com.example.madlevel5task2

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {

        fun dateToString(date: Date): String = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(date)

        fun dayMonthYearToCalendar(day: Int, month: Int, year: Int): Calendar {
            return Calendar.getInstance().apply {
                isLenient = false
                set(year, month - 1, day)
            }
        }
    }
}
