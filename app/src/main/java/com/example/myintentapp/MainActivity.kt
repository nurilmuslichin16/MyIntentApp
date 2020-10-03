package com.example.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    companion object {
        private const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindahActivity: Button = findViewById(R.id.btn_pindahActivity)
        btnPindahActivity.setOnClickListener(this)

        val btnPindahActivityDgData: Button = findViewById(R.id.btn_pindahActivityDgData)
        btnPindahActivityDgData.setOnClickListener(this)

        val btnPindahActivityDgObjek: Button = findViewById(R.id.btn_pindahActivityDgObjek)
        btnPindahActivityDgObjek.setOnClickListener(this)

        val btnDialNumber: Button = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        val btnPindahUntukHasil: Button = findViewById(R.id.btn_pindah_untuk_hasil)
        btnPindahUntukHasil.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_hasil)
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
            R.id.btn_dial_number -> {
                val phoneNumber = "085229531170"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_pindah_untuk_hasil -> {
                val pindahUntukHasilIntent = Intent(this@MainActivity, PindahUntukHasilActivity::class.java)
                startActivityForResult(pindahUntukHasilIntent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == PindahUntukHasilActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(PindahUntukHasilActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil: $selectedValue"
            }
        }
    }
}