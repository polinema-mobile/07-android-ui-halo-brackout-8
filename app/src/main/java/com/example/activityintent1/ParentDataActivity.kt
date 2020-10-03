package com.example.activityintent1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.activityintent1.dataparcelize.ParentData
import com.example.activityintent1.dataparcelize.PersonalData

class ParentDataActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"

    private lateinit var namaAyah: String
    private var nikAyah: Int = 0
    private lateinit var namaIbu: String
    private var nikIbu: Int = 0
    private lateinit var tanggalLahirAyah: String
    private lateinit var tanggalLahirIbu: String
    private lateinit var alamatParent: String
    private lateinit var kodePos: String
    private lateinit var phoneOrtu: String
    private lateinit var pendidikanAyah: String
    private lateinit var pendidikanIbu: String
    private lateinit var pekerjaanAyah: String
    private lateinit var pekerjaanIbu: String
    private lateinit var dataPribadi: PersonalData

    private lateinit var btnParentToSchool: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_data)

        setUp()
        getDataPribadi()

        btnParentToSchool.setOnClickListener {
            intentToSchool()
        }
    }

    private fun setUp() {
        btnParentToSchool = findViewById(R.id.btnParentToSchool)
    }

    private fun getDataPribadi() {
        val dataPribadi = intent.getParcelableExtra<PersonalData>(DATA_PRIBADI)
        Log.e(DATA_PRIBADI, dataPribadi.toString())
    }

    private fun intentToSchool() {
        val dataParent = ParentData(
            namaAyah,
            nikAyah,
            namaIbu,
            nikIbu,
            tanggalLahirAyah,
            tanggalLahirIbu,
            alamatParent,
            kodePos,
            phoneOrtu,
            pendidikanAyah,
            pendidikanIbu,
            pekerjaanAyah,
            pekerjaanIbu,
            dataPribadi
        )

        val resultIntent = Intent(this, SchoolDataActivity::class.java)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        startActivity(resultIntent)
    }
}