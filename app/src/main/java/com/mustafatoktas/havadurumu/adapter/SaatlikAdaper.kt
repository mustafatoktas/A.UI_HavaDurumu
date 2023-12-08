package com.mustafatoktas.havadurumu.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mustafatoktas.havadurumu.databinding.ViewholderSaatlikBinding
import com.mustafatoktas.havadurumu.model.Saatlik

class SaatlikAdapter(val items: ArrayList<Saatlik>) : RecyclerView.Adapter<SaatlikAdapterHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaatlikAdapterHolder {
        val binding = ViewholderSaatlikBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        context = parent.context
        return SaatlikAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: SaatlikAdapterHolder, position: Int) {
        holder.binding.txtSaat.text = items[position].saat
        holder.binding.txtSicaklik.text = "${items[position].sicaklik}°"

        val drawableKaynakId = holder.itemView.resources.getIdentifier(items[position].resimYolu, "drawable", holder.itemView.context.packageName)

        Glide.with(context).load(drawableKaynakId).into(holder.binding.resim)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

class SaatlikAdapterHolder(val binding : ViewholderSaatlikBinding) : RecyclerView.ViewHolder(binding.root) {

}
