package com.mustafatoktas.havadurumu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mustafatoktas.havadurumu.model.Saatlik
import com.mustafatoktas.havadurumu.adapter.SaatlikAdapter
import com.mustafatoktas.havadurumu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewAdapterBagla()
        tiklamaFonksiyonlari()
    }

    private fun tiklamaFonksiyonlari() {
        binding.btnSonrakiGunler.setOnClickListener {
            val intent = Intent(this@MainActivity, FutureActivity::class.java)
            startActivity(intent)
        }
    }

    private fun  recyclerViewAdapterBagla() {
        val items = ArrayList<Saatlik>()

        items.add(Saatlik("13:00", 27, "bulutlu"))
        items.add(Saatlik("14:00", 26, "gunesli"))
        items.add(Saatlik("15:00", 26, "ruzgar"))
        items.add(Saatlik("16:00", 25, "yagmurlu"))
        items.add(Saatlik("17:00", 26, "ruzgar"))

        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val saatlikAdapter = SaatlikAdapter(items)
        binding.recyclerViewMain.adapter = saatlikAdapter
    }
}