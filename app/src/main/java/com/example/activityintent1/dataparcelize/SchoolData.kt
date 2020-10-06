package com.example.activityintent1.dataparcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SchoolData(
    var namaUnivAsal:String,
    var namaFakultasAsal:String,
    var namaProdiAsal:String,
    var provinsiUnivAsal:String,
    var kotaUnivAsal:String,
    var alamatUnivAsal:String,
    var kodePosUnivAsal:String,
    var akreditasiUnivAsal:String,
    var nilaiIPK:String,
    var dataParent: ParentData
) : Parcelable