package com.marcokenata.currencyapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marcokenata.currencyapp.R
import com.marcokenata.currencyapp.data.model.User
import com.marcokenata.currencyapp.databinding.ItemLayoutBinding
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val list: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var binding: ItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: ItemLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(user: User) {
            itemView.textViewUserName.text = user.email
            itemView.textViewUserName.text = user.name
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.avatar)
                .into(itemView.imageViewAvatar)
        }
    }

    fun addData(data: List<User>) {
        list.addAll(data)
    }
}