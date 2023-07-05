package com.ankur.retrofitwithroom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankur.retrofitwithroom.databinding.ItemViewBinding

class Adapter(private val context: Context, private val list: List<dataModelItem>):
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        val binding=ItemViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.binding.idTextView.text=currentItem.id.toString()
        holder.binding.title.text=currentItem.title
    }

    override fun getItemCount(): Int {
        return list.size
    }


}