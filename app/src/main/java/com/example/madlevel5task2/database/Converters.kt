package com.example.madlevel5task2.database

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun calendarFromTimestamp(value: Long?): Calendar? {
        return value?.let { Calendar.getInstance().apply { time = Date(value) } }
    }

    @TypeConverter
    fun calendarToTimestamp(calendar: Calendar?): Long? {
        return calendar?.time?.time
    }
}