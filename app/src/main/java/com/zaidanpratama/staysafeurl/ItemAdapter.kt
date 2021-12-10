package com.zaidanpratama.staysafeurl

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val itemList: ArrayList<ListItem>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener : onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_recyler,parent,false)
        return ItemViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.number.text = (currentItem.number)
        holder.title.text = currentItem.title
        holder.body.text = currentItem.body
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ItemViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val title : TextView = itemView.findViewById(R.id.title)
        val number : TextView = itemView.findViewById(R.id.number)
        val body : TextView = itemView.findViewById(R.id.body)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}