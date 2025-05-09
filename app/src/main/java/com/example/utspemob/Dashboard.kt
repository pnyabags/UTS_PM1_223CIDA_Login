package com.example.utspemob

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val itemList = listOf(
            ItemList("10 Rekomendasi Mie Ayam Bandung Terenak, Wajib Coba!",
                "Mulai dari yang legendaris hingga gerobak kaki lima Sc: https://www.orami.co.id/magazine/mie-ayam-bandung",
                "https://cnc-magazine.oramiland.com/parenting/images/mie-ayam-bandung.width-800.format-webp.webp"),
            ItemList("122 Resep Mie Ayam Lengkap Enak dan Mudah",
                "Aneka olahan mie ayam lezat. Cara memasak resep ayam kecap mie ayam, mie ayam abang abang, minyak mie ayam, mie ayam wonogiri, kuah mie ayam.",
                "https://cove-blog-id.sgp1.cdn.digitaloceanspaces.com/cove-blog-id/2024/07/mie-ayam-bandung.jpg"),
            ItemList("10 Mie Ayam Enak di Bandung Paling Favorit beserta Alamatnya",
                "Jalan-jalan ke Bandung tapi bingung dimana bisa makan mie ayam yang enak? Tenang saja! Mamikos telah menyiapkan beberapa rekomendasinya di bawah ini. SC: https://mamikos.com/info/mie-ayam-enak-di-bandung-gnr/#goog_rewarded",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzps-cIuW03K0kDx_dZIDvll4KoFQBgokx2Q&s")
        )
        val adapter = AdapterList(itemList)
        recyclerView.adapter = adapter
    }
}