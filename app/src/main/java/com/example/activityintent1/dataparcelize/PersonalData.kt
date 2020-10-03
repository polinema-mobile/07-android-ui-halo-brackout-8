package com.example.activityintent1.dataparcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonalData(
    var Nama: String,
    var Fakultas: String,
    var Prodi: String,
    var Status: String,
    var Password: String,
    var Alasan: String,
    var Nik: Int,
    var Prestasi: String,
    var Tempat: String,
    var Tanggal: String,
    var JenisKelamin: String,
    var Kewarganegaraan: String,
    var Agama: String,
    var Rt: Int,
    var Rw: Int,
    var KodePos: String,
    var Provinsi: String,
    var Kota: String,
    var Phone: String,
    var Email: String
) : Parcelable