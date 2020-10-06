package com.example.activityintent1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
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
    private lateinit var phoneOrtu: String
    private lateinit var emailOrtu: String
    private lateinit var pendidikanAyah: String
    private lateinit var pendidikanIbu: String
    private lateinit var pekerjaanAyah: String
    private lateinit var pekerjaanIbu: String
    private lateinit var dataPribadi: PersonalData

    private lateinit var editTextNamaAyah: EditText
    private lateinit var editTextNikAyah: EditText
    private lateinit var editTextNamaIbu: EditText
    private lateinit var editTextNikIbu: EditText
    private lateinit var editTextLahirAyah: EditText
    private lateinit var editTextLahirIbu: EditText
    private lateinit var editTextAlamat: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPendidikanAyah: EditText
    private lateinit var editTextPendidikanIbu: EditText
    private lateinit var editTextPekerjaanAyah: EditText
    private lateinit var editTextPekerjaanIbu: EditText
    private lateinit var btnParentToSchool: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_data)

        setUp()

        btnParentToSchool.setOnClickListener {
            intentToSchool()
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
        editTextNamaAyah = findViewById(R.id.editTextNamaAyah)
        editTextNikAyah= findViewById(R.id.editTextNikAyah)
        editTextNamaIbu= findViewById(R.id.editTextNamaIbu)
        editTextNikIbu= findViewById(R.id.editTextNikIbu)
        editTextLahirAyah= findViewById(R.id.editTextLahirAyah)
        editTextLahirIbu= findViewById(R.id.editTextLahirIbu)
        editTextAlamat= findViewById(R.id.editTextAlamat)
        editTextPhone= findViewById(R.id.editTextPhone)
        editTextEmail= findViewById(R.id.editTextEmail)
        editTextPendidikanAyah= findViewById(R.id.editTextPendidikanAyah)
        editTextPendidikanIbu= findViewById(R.id.editTextPendidikanIbu)
        editTextPekerjaanAyah= findViewById(R.id.editTextPekerjaanAyah)
        editTextPekerjaanIbu= findViewById(R.id.editTextPekerjaanIbu)
        btnParentToSchool = findViewById(R.id.btnParentToSchool)
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
            phoneOrtu,
            emailOrtu,
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

    private fun getDataParent() {
        namaAyah = editTextNamaAyah.text.toString()
        nikAyah = editTextNikAyah.text.toString().toInt()
        namaIbu = editTextNamaIbu.text.toString()
        nikIbu = editTextNikIbu.text.toString().toInt()
        tanggalLahirAyah = editTextLahirAyah.text.toString()
        tanggalLahirIbu = editTextLahirIbu.text.toString()
        alamatParent = editTextAlamat.text.toString()
        phoneOrtu = editTextPhone.text.toString()
        emailOrtu = editTextEmail.text.toString()
        pendidikanAyah = editTextPendidikanAyah.text.toString()
        pendidikanIbu = editTextPendidikanIbu.text.toString()
        pekerjaanAyah = editTextPekerjaanAyah.text.toString()
        pekerjaanIbu = editTextPekerjaanIbu.text.toString()
        dataPribadi = intent.getParcelableExtra<PersonalData>(DATA_PRIBADI)!!
    }
}