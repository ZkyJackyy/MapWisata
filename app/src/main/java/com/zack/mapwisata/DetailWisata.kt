package com.zack.mapwisata

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailWisata : AppCompatActivity() {

    private lateinit var btnmap : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_wisata)

        val image = intent.getIntExtra("image",0)
        val nama = intent.getStringExtra("nama")
        val deskripsi = intent.getStringExtra("deskripsi")
        val lat = intent.getDoubleExtra("lat",0.0)
        val lang = intent.getDoubleExtra("lang",0.0)


        val txtnama = findViewById<TextView>(R.id.textView2)
        val img = findViewById<ImageView>(R.id.imgWisata)
        val ket = findViewById<TextView>(R.id.txtDetail)


        ket.text = deskripsi
        txtnama.text = nama
        img.setImageResource(image)

        btnmap = findViewById(R.id.btnmap)

        btnmap.setOnClickListener(){
            val intent = Intent(this,MapsActivity::class.java).apply{
                putExtra("lat",lat)
                putExtra("lang",lang)
                putExtra("nama",nama)
            }
            startActivity(intent)

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}