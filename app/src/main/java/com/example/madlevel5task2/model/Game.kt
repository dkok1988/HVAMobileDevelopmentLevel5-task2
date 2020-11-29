package com.example.madlevel5task2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
@Parcelize
data class Game(
    var title: String,
    var platform: String,
    var release: Calendar,
    @PrimaryKey var id: Long? = null
) : Parcelable