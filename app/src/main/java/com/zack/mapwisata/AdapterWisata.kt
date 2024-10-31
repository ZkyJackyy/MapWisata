package com.zack.mapwisata

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zack.mapwisata.model.ModelWisata

class AdapterWisata (
private var listwisata : List<ModelWisata>
): RecyclerView.Adapter<AdapterWisata.WisataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemwisata, parent, false)
        return WisataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listwisata.size
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        val currenItem = listwisata[position]
        holder.img.setImageResource(currenItem.image)
        holder.txtnama.setText(currenItem.nama)
        holder.txtlokasi.setText(currenItem.lokasi)

        holder.itemView.setOnClickListener(){
            val contex = holder.itemView.context
            val intent = Intent(contex,DetailWisata::class.java).apply{
                putExtra("deskripsi",currenItem.keterangan)
                putExtra("nama",currenItem.nama)
                putExtra("image",currenItem.image)
                putExtra("lat",currenItem.latitude)
                putExtra("lang",currenItem.longitude)
            }
            contex.startActivity(intent)
        }

    }

    class WisataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        val txtnama: TextView = itemView.findViewById(R.id.txtnama)
        val txtlokasi: TextView = itemView.findViewById(R.id.txtlokasi)



    }
}