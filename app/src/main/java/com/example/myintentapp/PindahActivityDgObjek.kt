package com.example.myintentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PindahActivityDgObjek : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah_dg_objek)

        val tv_menerimaObjek: TextView = findViewById(R.id.tv_menerima_objek)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Nama: ${person.name.toString()}, \nEmail: ${person.email.toString()}, \nUmur: ${person.age} Tahun, \nKota: ${person.city.toString()}"
        tv_menerimaObjek.text = text
    }
}