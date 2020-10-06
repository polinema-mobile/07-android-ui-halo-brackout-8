package com.example.activityintent1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.activityintent1.dataparcelize.ParentData

class ParentDataActivity : AppCompatActivity() {
    private val DATA_PARENT = "DATA_PARENT"

    private lateinit var namaAyah: String
    private var nikAyah: Int = 0
    private lateinit var namaIbu: String
    private var nikIbu: Int = 0
    private lateinit var tanggalLahirAyah: String
    private lateinit var tanggalLahirIbu: String
    private lateinit var alamatParent: String
    private var Rt: Int = 0
    private var Rw: Int = 0
    private lateinit var kodePos: String
    private lateinit var provinsi : String
    private lateinit var kota : String
    private lateinit var phoneOrtu: String
    private lateinit var emailOrtu: String
    private lateinit var pendidikanAyah: String
    private lateinit var pendidikanIbu: String
    private lateinit var pekerjaanAyah: String
    private lateinit var pekerjaanIbu: String

    private lateinit var editTextNamaAyah: EditText
    private lateinit var editTextNikAyah: EditText
    private lateinit var editTextNamaIbu: EditText
    private lateinit var editTextNikIbu: EditText
    private lateinit var editTextLahirAyah: EditText
    private lateinit var editTextLahirIbu: EditText
    private lateinit var editTextAlamat: EditText
    private lateinit var editTextRt: EditText
    private lateinit var editTextRw: EditText
    private lateinit var editTextPostal: EditText
    private lateinit var spinnerProvinsi : Spinner
    private lateinit var spinnerKota : Spinner
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPendidikanAyah: EditText
    private lateinit var editTextPendidikanIbu: EditText
    private lateinit var editTextPekerjaanAyah: EditText
    private lateinit var editTextPekerjaanIbu: EditText
    private lateinit var btnParentToSchool: Button

    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_data)

        setUp()
        loadDataSpinner()

        btnParentToSchool.setOnClickListener {
            intentToSchool()
        }
    }

    private fun setUp() {
        editTextNamaAyah = findViewById(R.id.editTextNamaAyah)
        editTextNikAyah= findViewById(R.id.editTextNikAyah)
        editTextNamaIbu= findViewById(R.id.editTextNamaIbu)
        editTextNikIbu= findViewById(R.id.editTextNikIbu)
        editTextLahirAyah= findViewById(R.id.editTextLahirAyah)
        editTextLahirIbu= findViewById(R.id.editTextLahirIbu)
        editTextAlamat= findViewById(R.id.editTextAlamat)
        editTextRt= findViewById(R.id.editTextRT)
        editTextRw= findViewById(R.id.editTextRW)
        editTextPostal= findViewById(R.id.editTextPostal)
        spinnerProvinsi= findViewById(R.id.spinnerProvinsi)
        spinnerKota= findViewById(R.id.spinnerKota)
        editTextPhone= findViewById(R.id.editTextPhone)
        editTextEmail= findViewById(R.id.editTextEmail)
        editTextPendidikanAyah= findViewById(R.id.editTextPendidikanAyah)
        editTextPendidikanIbu= findViewById(R.id.editTextPendidikanIbu)
        editTextPekerjaanAyah= findViewById(R.id.editTextPekerjaanAyah)
        editTextPekerjaanIbu= findViewById(R.id.editTextPekerjaanIbu)
        btnParentToSchool = findViewById(R.id.btnParentToSchool)

        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }


    private fun loadDataSpinner() {
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataKota)

        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerProvinsi.adapter = adapterProvinsi
        spinnerKota.adapter = adapterKota
    }

    private fun intentToSchool() {
        getDataParent()

        val dataParent = ParentData(
            namaAyah,
            nikAyah,
            namaIbu,
            nikIbu,
            tanggalLahirAyah,
            tanggalLahirIbu,
            alamatParent,
            Rt,
            Rw,
            kodePos,
            provinsi,
            kota,
            phoneOrtu,
            pendidikanAyah,
            pendidikanIbu,
            pekerjaanAyah,
            pekerjaanIbu

        )

        val resultIntent = Intent(this, SchoolDataActivity::class.java)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        startActivity(resultIntent)
    }

    private fun getDataParent() {
        namaAyah = editTextNamaAyah.text.toString()
        nikAyah = editTextNikAyah.text.toString().toInt()
        namaIbu = editTextNamaIbu.text.toString()
        nikIbu = editTextNikIbu.text.toString().toInt()
        tanggalLahirAyah = editTextLahirAyah.text.toString()
        tanggalLahirIbu = editTextLahirIbu.text.toString()
        alamatParent = editTextAlamat.text.toString()
        Rt = editTextRt.text.toString().toInt()
        Rw = editTextRw.text.toString().toInt()
        kodePos = editTextPostal.text.toString()
        provinsi = spinnerProvinsi.selectedItem.toString()
        kota = spinnerKota.selectedItem.toString()
        phoneOrtu = editTextPhone.text.toString()
        emailOrtu = editTextEmail.text.toString()
        pendidikanAyah = editTextPendidikanAyah.text.toString()
        pendidikanIbu = editTextPendidikanIbu.text.toString()
        pekerjaanAyah = editTextPekerjaanAyah.text.toString()
        pekerjaanIbu = editTextPekerjaanIbu.text.toString()
    }
}