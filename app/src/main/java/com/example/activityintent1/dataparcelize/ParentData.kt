package com.example.activityintent1.dataparcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParentData(
    var namaAyah: String,
    var nikAyah: String,
    var namaIbu: String,
    var nikIbu: String,
    var tanggalLahirAyah: String,
    var tanggalLahirIbu: String,
    var alamatParent: String,
    var phoneOrtu: String,
    var emailOrtu: String,
    var pendidikanAyah: String,
    var pendidikanIbu: String,
    var pekerjaanAyah: String,
    var pekerjaanIbu: String,
    var dataPribadi: PersonalData
) : Parcelable