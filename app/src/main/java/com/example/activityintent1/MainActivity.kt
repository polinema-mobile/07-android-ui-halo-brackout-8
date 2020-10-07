package com.example.activityintent1

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.activityintent1.dataparcelize.PersonalData
import java.util.*

class MainActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"

    private lateinit var editTextNama: EditText
    private lateinit var spinnerFakultas: Spinner
    private lateinit var spinnerProdi: Spinner
    private lateinit var spinnerStatus: Spinner
    private lateinit var editTextPassword: EditText
    private lateinit var editTextPasswordConfirm: EditText
    private lateinit var editTextAlasan: EditText
    private lateinit var editTextNik: EditText
    private lateinit var editTextPrestasi: EditText
    private lateinit var editTextTempat: EditText
    private lateinit var editTextDate: EditText
    private lateinit var radioGroupSex: RadioGroup
    private lateinit var radioButtonCheckedSex: RadioButton
    private lateinit var radioGroupNation: RadioGroup
    private lateinit var radioButtonCheckedNation: RadioButton
    private lateinit var spinnerAgama: Spinner
    private lateinit var editTextAlamat: EditText
    private lateinit var editTextRt: EditText
    private lateinit var editTextRw: EditText
    private lateinit var editTextPostal: EditText
    private lateinit var spinnerProvinsi: Spinner
    private lateinit var spinnerKota: Spinner
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var btnPersonalToParent: Button

    private lateinit var dataFakultas: Array<String>
    private lateinit var dataProdi: Array<String>
    private lateinit var dataStatus: Array<String>
    private lateinit var dataAgama: Array<String>
    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()
        loadDataSpinner()

        editTextDate.setOnClickListener {
            datePicker()
        }

        btnPersonalToParent.setOnClickListener {
            intentToParent()
        }
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
        editTextNama = findViewById(R.id.editTextNama)
        spinnerFakultas = findViewById(R.id.spinnerFakultas)
        spinnerProdi = findViewById(R.id.spinnerProdi)
        spinnerStatus = findViewById(R.id.spinnerStatus)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm)
        editTextAlasan = findViewById(R.id.editTextAlasan)
        editTextNik = findViewById(R.id.editTextNik)
        editTextPrestasi = findViewById(R.id.editTextPrestasi)
        editTextTempat = findViewById(R.id.editTextPlace)
        editTextDate = findViewById(R.id.editTextDate)
        radioGroupSex = findViewById(R.id.radioGroupSex)
        radioGroupNation = findViewById(R.id.radioGroupNationality)
        spinnerAgama = findViewById(R.id.spinnerAgama)
        editTextAlamat = findViewById(R.id.editTextAlamat)
        editTextRt = findViewById(R.id.editTextRT)
        editTextRw = findViewById(R.id.editTextRW)
        editTextPostal = findViewById(R.id.editTextPostal)
        spinnerProvinsi = findViewById(R.id.spinnerProvinsi)
        spinnerKota = findViewById(R.id.spinnerKota)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextEmail = findViewById(R.id.editTextEmail)
        btnPersonalToParent = findViewById(R.id.btnPersonalToParent)

        dataFakultas = resources.getStringArray(R.array.dataFakultas)
        dataProdi = resources.getStringArray(R.array.dataProdi)
        dataStatus = resources.getStringArray(R.array.dataStatus)
        dataAgama = resources.getStringArray(R.array.dataAgama)
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterFakultas = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataFakultas)
        val adapterProdi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProdi)
        val adapterStatus = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataStatus)
        val adapterAgama = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataAgama)
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataKota)

        adapterFakultas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterProdi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterStatus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterAgama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFakultas.adapter = adapterFakultas
        spinnerProdi.adapter = adapterProdi
        spinnerStatus.adapter = adapterStatus
        spinnerAgama.adapter = adapterAgama
        spinnerProvinsi.adapter = adapterProvinsi
        spinnerKota.adapter = adapterKota
    }

    private fun datePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val bulan = monthOfYear + 1
                editTextDate.setText("$dayOfMonth/$bulan/$year")
            },
            year,
            month,
            day
        )
        dpd.show()
    }

    private fun radioButtonSelectionSex(): String {
        val selected: Int = radioGroupSex.checkedRadioButtonId
        radioButtonCheckedSex = findViewById(selected)
        return radioButtonCheckedSex.text.toString()
    }

    private fun radioButtonSelectionNation(): String {
        val selected: Int = radioGroupNation.checkedRadioButtonId
        radioButtonCheckedNation = findViewById(selected)
        return radioButtonCheckedNation.text.toString()
    }

    private fun intentToParent() {
        val dataPribadi = PersonalData(
            Nama = editTextNama.text.toString(),
            Fakultas = spinnerFakultas.selectedItem.toString(),
            Prodi = spinnerProdi.selectedItem.toString(),
            Status = spinnerStatus.selectedItem.toString(),
            Password = editTextPassword.text.toString(),
            Alasan = editTextAlasan.text.toString(),
            Nik = editTextNik.text.toString(),
            Prestasi = editTextPrestasi.text.toString(),
            Tempat = editTextTempat.text.toString(),
            Tanggal = editTextDate.text.toString(),
            JenisKelamin = radioButtonSelectionSex(),
            Kewarganegaraan = radioButtonSelectionNation(),
            Agama = spinnerAgama.selectedItem.toString(),
            Rt = editTextRt.text.toString(),
            Rw = editTextRw.text.toString(),
            KodePos = editTextPostal.text.toString(),
            Provinsi = spinnerProvinsi.selectedItem.toString(),
            Kota = spinnerKota.selectedItem.toString(),
            Phone = editTextPhone.text.toString(),
            Email = editTextEmail.text.toString()
        )
        val resultIntent = Intent(this, ParentDataActivity::class.java)
        resultIntent.putExtra(DATA_PRIBADI, dataPribadi)
        startActivity(resultIntent)
    }
}