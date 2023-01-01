package com.example.myfirstapp.ui.adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.data.api.models.PostsModelItem
import com.example.myfirstapp.databinding.RowRetrofitBinding
import javax.inject.Inject


class RetrofitTestAdapter @Inject constructor(
    var context: Activity

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = ArrayList<PostsModelItem>()

    fun initAdapter(list: ArrayList<PostsModelItem>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            RowRetrofitBinding.inflate(context.layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val mHolder = holder as MyViewHolder
        with(mHolder.binding) {

            list[position].apply {
                tv.text = this.title
                tvBody.text = this.body
            }

        }

    }

    inner class MyViewHolder(val binding: RowRetrofitBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun getItemCount(): Int {
        return list.size
    }
}