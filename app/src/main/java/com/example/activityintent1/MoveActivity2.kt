package com.example.activityintent1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoveActivity2(
    var nama: String,
    var nim: Int,
    var date: String,
    var gender: String,
    var jurusan: String
) : Parcelable