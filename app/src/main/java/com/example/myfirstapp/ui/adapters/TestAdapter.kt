package com.example.myfirstapp.ui.adapters

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.data.room.Word
import com.example.myfirstapp.databinding.RowTestBinding
import javax.inject.Inject


interface DeleteListener {
    fun onDelete(id:Int)
}

class TestAdapter @Inject constructor(
    var context: Activity

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = ArrayList<Word>()
    private lateinit var deleteListener: DeleteListener

    fun initDeleteListener(deleteListener: DeleteListener){
        this.deleteListener = deleteListener
    }

    fun initAdapter(list: ArrayList<Word>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return MyViewHolder(
            com.example.myfirstapp.databinding.RowTestBinding.inflate(context.layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val mHolder = holder as MyViewHolder
        with(mHolder.binding) {
            tv.text = list[position].word
        }

    }

    inner class MyViewHolder(val binding: RowTestBinding) : RecyclerView.ViewHolder(binding.root){

        init {

            binding.btnDelete.setOnClickListener {
                val pos = adapterPosition
                if (pos != -1) {
                    deleteListener.onDelete(list[pos].id)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }
}