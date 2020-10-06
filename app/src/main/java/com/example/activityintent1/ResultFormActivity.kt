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
        val dataSchool = intent.getParcelableExtra<SchoolData>(DATA_SCHOOL)
        Log.e(DATA_SCHOOL, dataSchool.toString())
        Log.e(DATA_SCHOOL, dataSchool!!.dataParent.toString())
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