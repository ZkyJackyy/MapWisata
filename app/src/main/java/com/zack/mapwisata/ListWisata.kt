package com.zack.mapwisata

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zack.mapwisata.model.ModelWisata

class ListWisata : AppCompatActivity() {
    private lateinit var RecyclerView: RecyclerView
    private lateinit var Adaptermenu: AdapterWisata
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        val menu = listOf(
            ModelWisata(R.drawable.jamgadang, "Jam Gadang bukittinggi", "sumbar","Jam Gadang adalah menara jam yang menjadi penanda atau ikon Kota Bukittinggi Sumatera Barat Indonesia. Menara jam ini menjulang setinggi 27 meter dan diresmikan pembangunannya pada 25 Juli 1927",
                    -0.3049441760037679,
                100.36948795756079),
            ModelWisata(R.drawable.ulu, "Ulun danu Beratan Bedugul", "bali","Pura Ulun Danu Bratan, Pura Ulun Danu Beratan atau Bratan Pura merupakan sebuah pura dan candi air besar di Bali, Indonesia - candi utama air lainnya menjadi Pura Ulun Danu Batur. Kompleks candi ini terletak di tepi barat laut Danau Bratan di pegunungan dekat Bedugul, Kabupaten Tabanan",
                -8.275021434769968,
                115.16680193649081),
            ModelWisata(R.drawable.pgr, "Istano Basa Pagaruyung", "Tanah Datar","Istano basa pagaruyung terletak di kabupaten tanah datar tepatnya di pagaruyung",
                -0.4712613424028126,
                100.62141018518649)

        )

        RecyclerView = findViewById(R.id.rvmenu)
        RecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager
            .VERTICAL,false)

        Adaptermenu = AdapterWisata(menu)
        RecyclerView.adapter =Adaptermenu



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}