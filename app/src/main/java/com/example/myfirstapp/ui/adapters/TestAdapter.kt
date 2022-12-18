package com.example.myfirstapp.ui.adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.databinding.RowTestBinding
import javax.inject.Inject

class TestAdapter @Inject constructor(
    var context: Activity

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = ArrayList<String>()

    fun initAdapter(list: ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            RowTestBinding.inflate(context.layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val mHolder = holder as MyViewHolder
        with(mHolder.binding) {
            tv.text = list[position]
        }

    }

    inner class MyViewHolder(val binding: RowTestBinding) : RecyclerView.ViewHolder(binding.root)


    override fun getItemCount(): Int {
        return list.size
    }
}