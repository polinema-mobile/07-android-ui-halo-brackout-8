package com.example.activityintent1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.activityintent1.dataparcelize.SchoolData

class ResultFormActivity : AppCompatActivity() {
    private val DATA_SCHOOL = "DATA_SCHOOL"

    private lateinit var textNama: TextView
    private lateinit var textNim: TextView
    private lateinit var textDob: TextView
    private lateinit var textKelamin: TextView
    private lateinit var textJurusan: TextView
    private lateinit var nama: String
    private lateinit var nim: String
    private lateinit var dob: String
    private lateinit var kelamin: String
    private lateinit var jurusan: String

    private lateinit var schoolNamaUnivAsal: String
    private lateinit var schoolNamaFakultasAsal: String
    private lateinit var schoolNamaProdiAsal: String
    private lateinit var schoolProvinsiUnivAsal: String
    private lateinit var schoolKotaUnivAsal: String
    private lateinit var schoolAlamatUnivAsal: String
    private lateinit var schoolKodePosUnivAsal: String
    private lateinit var schoolAkreditasiUnivAsal: String
    private lateinit var schoolNilaiIPK: String

    private lateinit var parentNamaAyah: String
    private lateinit var parentNikAyah: String
    private lateinit var parentNamaIbu: String
    private lateinit var parentNikIbu: String
    private lateinit var parentTanggalLahirAyah: String
    private lateinit var parentTanggalLahirIbu: String
    private lateinit var parentAlamatParent: String
    private lateinit var parentPhoneOrtu: String
    private lateinit var parentEmailOrtu: String
    private lateinit var parentPendidikanAyah: String
    private lateinit var parentPendidikanIbu: String
    private lateinit var parentPekerjaanAyah: String
    private lateinit var parentPekerjaanIbu: String

    private lateinit var pribadiNama: String
    private lateinit var pribadiFakultas: String
    private lateinit var pribadiProdi: String
    private lateinit var pribadiStatus: String
    private lateinit var pribadiPassword: String
    private lateinit var pribadiAlasan: String
    private lateinit var pribadiNik: String
    private lateinit var pribadiPrestasi: String
    private lateinit var pribadiTempat: String
    private lateinit var pribadiTanggal: String
    private lateinit var pribadiJenisKelamin: String
    private lateinit var pribadiKewarganegaraan: String
    private lateinit var pribadiAgama: String
    private lateinit var pribadiRt: String
    private lateinit var pribadiRw: String
    private lateinit var pribadiKodePos: String
    private lateinit var pribadiProvinsi: String
    private lateinit var pribadiKota: String
    private lateinit var pribadiPhone: String
    private lateinit var pribadiEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_form)

        setUp()
        getData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Light Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Dark Mode")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            else -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUp() {

    }

    private fun getData() {
        val dataSchool = intent.getParcelableExtra<SchoolData>(DATA_SCHOOL)!!
        val dataParent = dataSchool.dataParent
        val dataPribadi = dataSchool.dataParent.dataPribadi

        schoolNamaUnivAsal = dataSchool.namaUnivAsal
        schoolNamaFakultasAsal = dataSchool.namaFakultasAsal
        schoolNamaProdiAsal = dataSchool.namaProdiAsal
        schoolProvinsiUnivAsal = dataSchool.provinsiUnivAsal
        schoolKotaUnivAsal = dataSchool.kotaUnivAsal
        schoolAlamatUnivAsal = dataSchool.alamatUnivAsal
        schoolKodePosUnivAsal = dataSchool.kodePosUnivAsal
        schoolAkreditasiUnivAsal = dataSchool.akreditasiUnivAsal
        schoolNilaiIPK = dataSchool.nilaiIPK

        parentNamaAyah = dataParent.namaAyah
        parentNikAyah = dataParent.nikAyah
        parentNamaIbu = dataParent.namaIbu
        parentNikIbu = dataParent.nikIbu
        parentTanggalLahirAyah = dataParent.tanggalLahirAyah
        parentTanggalLahirIbu = dataParent.tanggalLahirIbu
        parentAlamatParent = dataParent.alamatParent
        parentPhoneOrtu = dataParent.phoneOrtu
        parentEmailOrtu = dataParent.emailOrtu
        parentPendidikanAyah = dataParent.pendidikanAyah
        parentPendidikanIbu = dataParent.pendidikanIbu
        parentPekerjaanAyah = dataParent.pekerjaanAyah
        parentPekerjaanIbu = dataParent.pekerjaanIbu

        pribadiNama = dataPribadi.Nama
        pribadiFakultas = dataPribadi.Fakultas
        pribadiProdi = dataPribadi.Prodi
        pribadiStatus = dataPribadi.Status
        pribadiPassword = dataPribadi.Password
        pribadiAlasan = dataPribadi.Alasan
        pribadiNik = dataPribadi.Nik
        pribadiPrestasi = dataPribadi.Prestasi
        pribadiTempat = dataPribadi.Tempat
        pribadiTanggal = dataPribadi.Tanggal
        pribadiJenisKelamin = dataPribadi.JenisKelamin
        pribadiKewarganegaraan = dataPribadi.Kewarganegaraan
        pribadiAgama = dataPribadi.Agama
        pribadiRt = dataPribadi.Rt
        pribadiRw = dataPribadi.Rw
        pribadiKodePos = dataPribadi.KodePos
        pribadiProvinsi = dataPribadi.Provinsi
        pribadiKota = dataPribadi.Kota
        pribadiPhone = dataPribadi.Phone
        pribadiEmail = dataPribadi.Email

        Log.e(DATA_SCHOOL, dataSchool.toString())
        Log.e(DATA_SCHOOL, dataSchool.dataParent.toString())
        Log.e(DATA_SCHOOL, dataSchool.dataParent.dataPribadi.toString())
    }

//    private fun setTextView() {
//        textNama.text = nama
//        textNim.text = nim
//        textDob.text = dob
//        textKelamin.text = kelamin
//        textJurusan.text= jurusan
//    }
}