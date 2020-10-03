package com.example.activityintent1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.activityintent1.dataparcelize.Mahasiswa

class ResultFormActivity : AppCompatActivity() {
    private val DATA_JENIS = "DATA_JENIS"
    private val DATA_MHS = "DATA_MHS"
    private val DATA_NAMA = "DATA_NAMA"
    private val DATA_NIM = "DATA_NIM"
    private val DATA_DATE = "DATA_DATE"
    private val DATA_KELAMIN = "DATA_KELAMIN"
    private val DATA_JURUSAN = "DATA_JURUSAN"
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_form)

        setUp()
        getData()
        setTextView()
    }

    private fun setUp() {
        textNama = findViewById(R.id.namaValue)
        textNim = findViewById(R.id.nimValue)
        textDob = findViewById(R.id.tglValue)
        textKelamin = findViewById(R.id.jkValue)
        textJurusan = findViewById(R.id.jurusanValue)
    }

    private fun getData() {
        val type = intent.getStringExtra(DATA_JENIS)
        if (type.equals("Parcelable")) {
            val dataMhs = intent.extras?.getParcelable<Mahasiswa>(DATA_MHS)
            nama = dataMhs!!.nama
            nim = dataMhs.nim.toString()
            dob = dataMhs.date
            kelamin = dataMhs.gender
            jurusan = dataMhs.jurusan
        } else {
            nama = intent.getStringExtra(DATA_NAMA).toString()
            nim = intent.getIntExtra(DATA_NIM, 0).toString()
            dob = intent.getStringExtra(DATA_DATE).toString()
            kelamin = intent.getStringExtra(DATA_KELAMIN).toString()
            jurusan = intent.getStringExtra(DATA_JURUSAN).toString()
        }
    }

    private fun setTextView() {
        textNama.text = nama
        textNim.text = nim
        textDob.text = dob
        textKelamin.text = kelamin
        textJurusan.text= jurusan
    }
}