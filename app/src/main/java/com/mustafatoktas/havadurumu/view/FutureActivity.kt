package com.mustafatoktas.havadurumu.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustafatoktas.havadurumu.adapter.GelecekHaftaAdapter
import com.mustafatoktas.havadurumu.databinding.ActivityFutureBinding
import com.mustafatoktas.havadurumu.model.GelecekHaftaAlani

class FutureActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFutureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFutureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewAdapterBagla()
        tiklamaFonksiyonlari()
    }

    private fun tiklamaFonksiyonlari() {

        binding.btnGeri.setOnClickListener {
            finish()
        }
    }

    private fun recyclerViewAdapterBagla() {
        val items = ArrayList<GelecekHaftaAlani>()

        items.add(GelecekHaftaAlani("Salı", "firtina", "Fırtına", 25, 10))
        items.add(GelecekHaftaAlani("Çarşamba", "bulutlu", "Bulutlu", 24, 16))
        items.add(GelecekHaftaAlani("Perşembe", "ruzgarli", "Rüzgarlı", 29, 15))
        items.add(GelecekHaftaAlani("Cuma", "bulutlu_gunesli", "Bulutlu Güneşli", 22, 13))
        items.add(GelecekHaftaAlani("Cumartesi", "gunesli", "Güneşli", 28, 11))
        items.add(GelecekHaftaAlani("Pazar", "yagmurlu", "Yağmurlu", 23, 12))


       binding.recyclerViewFuture.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val gelecekAdapter = GelecekHaftaAdapter(items)
        binding.recyclerViewFuture.adapter = gelecekAdapter
    }
}
