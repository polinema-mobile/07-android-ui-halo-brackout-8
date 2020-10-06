package com.example.activityintent1.dataparcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParentData(
    var namaAyah: String,
    var nikAyah: Int,
    var namaIbu: String,
    var nikIbu: Int,
    var tanggalLahirAyah: String,
    var tanggalLahirIbu: String,
    var alamatParent: String,
    var Rt : Int,
    var Rw : Int,
    var kodePos: String,
    var provinsi: String,
    var kota: String,
    var phoneOrtu: String,
    var pendidikanAyah: String,
    var pendidikanIbu: String,
    var pekerjaanAyah: String,
    var pekerjaanIbu: String

) : Parcelable