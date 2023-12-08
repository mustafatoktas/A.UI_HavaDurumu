package com.mustafatoktas.havadurumu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mustafatoktas.havadurumu.databinding.ViewholderGelecekhaftaBinding
import com.mustafatoktas.havadurumu.model.GelecekHaftaAlani

class GelecekHaftaAdapter(val items: ArrayList<GelecekHaftaAlani>) : RecyclerView.Adapter<GelecekAdapterHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GelecekAdapterHolder {
        val binding = ViewholderGelecekhaftaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        context = parent.context
        return GelecekAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: GelecekAdapterHolder, position: Int) {
        holder.binding.txtGun.text = items[position].gun
        holder.binding.txtDurum.text = items[position].durum
        holder.binding.txtMax.text = "${items[position].maxSicaklik}°"
        holder.binding.txtMin.text = "${items[position].minSicaklik}°"

        val drawableKaynakId = holder.itemView.resources.getIdentifier(items[position].resimYolu, "drawable", holder.itemView.context.packageName)

        Glide.with(context).load(drawableKaynakId).into(holder.binding.resim)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

class GelecekAdapterHolder(val binding: ViewholderGelecekhaftaBinding) : RecyclerView.ViewHolder(binding.root) {

}
