package com.example.opendesa.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.opendesa.Data.Data
import com.example.opendesa.Data.PotensiModelData
import com.example.opendesa.R
import com.example.opendesa.databinding.FragmentPotensiBinding
import com.example.opendesa.databinding.ListPotensiBinding
import com.google.android.material.imageview.ShapeableImageView

class PotensiAdapter(var context: Context, val potensiList: List<Data>) :
    RecyclerView.Adapter<PotensiAdapter.PotensiViewHolder>() {

    inner class PotensiViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        var binding = ListPotensiBinding.bind(view)


        /*val potensiImage: ShapeableImageView= itemView.findViewById(R.id.potensi_image)
        val potensiTitle: TextView= itemView.findViewById(R.id.potensiTitle)
        val potensiDesc: TextView= itemView.findViewById(R.id.potensiDesc)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PotensiViewHolder {
        return PotensiViewHolder(LayoutInflater.from(context).inflate(R.layout.list_potensi,parent,false))
    }

    override fun onBindViewHolder(holder: PotensiViewHolder, position: Int) {
        val currentItem = potensiList[position]

        Glide.with(context).load(
            "file"
        ).thumbnail(Glide.with(context).load(R.drawable.candi_sogo)).into(holder.binding.potensiImage)
        //holder.binding.potensiImage.setImageResource(currentItem.file)
        holder.binding.potensiTitle.text = currentItem.nama
        holder.binding.potensiDesc.text = currentItem.deskripsi


        holder.itemView.setOnClickListener { view ->
            val action = PotensiFragmentDirections.actionPotensiFragmentToPotensiDetailFragment(currentItem)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return potensiList.size
    }
}