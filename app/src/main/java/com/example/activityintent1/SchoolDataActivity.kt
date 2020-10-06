package com.example.activityintent1

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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

    private lateinit var editTextnamaUnivAsal: EditText
    private lateinit var editTextnamaFakultasAsal: EditText
    private lateinit var editTextnamaProdiAsal: EditText
    private lateinit var spinnerprovinsiUnivAsal: Spinner
    private lateinit var spinnerkotaUnivAsal: Spinner
    private lateinit var editTextalamatUnivAsal: EditText
    private lateinit var editTextkodePosUnivAsal: EditText
    private lateinit var editTextakreditasiUnivAsal: EditText
    private lateinit var editTextnilaiIPK: EditText

    private lateinit var dataprovinsiUnivAsal: Array<String>
    private lateinit var datakotaUnivAsal: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_data)

        setUp()
        loadDataSpinner()

        btnGoToResult.setOnClickListener {
            intentToResult()
        }
    }

    private fun setUp() {
        editTextnamaUnivAsal = findViewById(R.id.editTextUnivAsal)
        editTextnamaFakultasAsal = findViewById(R.id.editTextFakultasAsal)
        editTextnamaProdiAsal = findViewById(R.id.editTextProdiAsal)
        spinnerprovinsiUnivAsal= findViewById(R.id.spinnerProvinsiUnivAsal)
        spinnerkotaUnivAsal= findViewById(R.id.spinnerKotaUnivAsal)
        editTextalamatUnivAsal = findViewById(R.id.editTextAlamatUnivAsal)
        editTextkodePosUnivAsal = findViewById(R.id.editTextKodePos)
        editTextakreditasiUnivAsal = findViewById(R.id.editTextAkreditasiUnivAsal)
        editTextnilaiIPK = findViewById(R.id.editTextNilaiIPK)
        btnGoToResult = findViewById(R.id.btnGoToResult)

        dataprovinsiUnivAsal = resources.getStringArray(R.array.dataProvinsi)
        datakotaUnivAsal = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataprovinsiUnivAsal)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, datakotaUnivAsal)

        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerprovinsiUnivAsal.adapter = adapterProvinsi
        spinnerkotaUnivAsal.adapter = adapterKota
    }

    private fun intentToResult() {
        getDataSchool()

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

    private fun getDataSchool() {
        namaUnivAsal = editTextnamaUnivAsal.text.toString()
        namaFakultasAsal = editTextnamaFakultasAsal.text.toString()
        namaProdiAsal = editTextnamaProdiAsal.text.toString()
        provinsiUnivAsal = spinnerprovinsiUnivAsal.selectedItem.toString()
        kotaUnivAsal = spinnerkotaUnivAsal.selectedItem.toString()
        alamatUnivAsal = editTextalamatUnivAsal.text.toString()
        kodePosUnivAsal = editTextkodePosUnivAsal.text.toString()
        akreditasiUnivAsal = editTextakreditasiUnivAsal.text.toString()
        nilaiIPK = editTextnilaiIPK.text.toString()
    }
}