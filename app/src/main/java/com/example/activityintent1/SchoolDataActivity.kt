package com.example.activityintent1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.activityintent1.dataparcelize.ParentData
import com.example.activityintent1.dataparcelize.PersonalData
import com.example.activityintent1.dataparcelize.SchoolData

class SchoolDataActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"

    private lateinit var namaUnivAsal: String
    private lateinit var namaFakultasAsal: String
    private lateinit var namaProdiAsal: String
    private lateinit var provinsiUnivAsal: String
    private lateinit var kotaUnivAsal: String
    private lateinit var alamatUnivAsal: String
    private lateinit var kodePosUnivAsal: String
    private lateinit var akreditasiUnivAsal: String
    private lateinit var nilaiIPK: String
    private lateinit var dataPribadi: PersonalData
    private lateinit var dataParent: ParentData

    private lateinit var btnGoToResult: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_data)

        setUp()

        btnGoToResult.setOnClickListener {
            intentToResult()
        }
    }

    private fun setUp() {
        btnGoToResult = findViewById(R.id.btnGoToResult)
    }

    private fun intentToResult() {
        val dataSchool = SchoolData(
            namaUnivAsal,
            namaFakultasAsal,
            namaProdiAsal,
            provinsiUnivAsal,
            kotaUnivAsal,
            alamatUnivAsal,
            kodePosUnivAsal,
            akreditasiUnivAsal,
            nilaiIPK,
            dataPribadi,
            dataParent
        )

        val resultIntent = Intent(this, ResultFormActivity::class.java)
        resultIntent.putExtra(DATA_SCHOOL, dataSchool)
        startActivity(resultIntent)
    }
}