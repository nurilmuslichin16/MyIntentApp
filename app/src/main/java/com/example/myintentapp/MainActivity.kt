package com.example.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.btn_pindahActivity)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahActivityDgData: Button = findViewById(R.id.btn_pindahActivityDgData)
        btnPindahActivityDgData.setOnClickListener(this)

        val btnPindahActivityDgObjek: Button = findViewById(R.id.btn_pindahActivityDgObjek)
        btnPindahActivityDgObjek.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pindahActivity -> {
                val pindahActivity = Intent(this@MainActivity, PindahActivity::class.java)
                startActivity(pindahActivity)
            }
            R.id.btn_pindahActivityDgData -> {
                val pindahActivityDgData = Intent(this@MainActivity, PindahActivityDgData::class.java)
                pindahActivityDgData.putExtra(PindahActivityDgData.EXTRA_NAME, "Nuril Muslichin")
                pindahActivityDgData.putExtra(PindahActivityDgData.EXTRA_AGE, 21)
                startActivity(pindahActivityDgData)
            }
            R.id.btn_pindahActivityDgObjek -> {
                val person = Person(
                    "Nuril Muslichin",
                    21,
                    "nurilmuslichin16@gmail.com",
                    "Kota Pekalongan"
                )

                val pindahActivityDgObjek = Intent(this@MainActivity, PindahActivityDgObjek::class.java)
                pindahActivityDgObjek.putExtra(PindahActivityDgObjek.EXTRA_PERSON, person)
                startActivity(pindahActivityDgObjek)
            }
        }
    }
}