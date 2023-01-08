package com.example.stevdzaretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stevdzaretrofit.R
import com.example.stevdzaretrofit.model.Post
import com.example.stevdzaretrofit.databinding.RowLayoutBinding
//import kotlinx.android.synthetic.main.row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var myList = emptyList<Post>()

    inner class MyViewHolder(val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RowLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.userIdTxt.text = myList[position].userId.toString()
        holder.binding.idTxt.text = myList[position].id.toString()
        holder.binding.titleTxt.text = myList[position].title
        holder.binding.bodyTxt.text = myList[position].body
    }

    fun setData(newList: List<Post>){
        myList = newList
        notifyDataSetChanged()
    }
}