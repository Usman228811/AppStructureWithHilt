package com.example.myfirstapp.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.ui.adapters.TestAdapter
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    @Inject
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var testAdapter: TestAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {


            val list = ArrayList<String>()
            list.add("Usman")
            list.add("Khan")
            list.add("hello")
            list.add("wrod")
            list.add("what")
            list.add("computer")

            for (i in 0..10) {
                list.add("Usman")
                list.add("Khan")
                list.add("hello")
                list.add("wrod")
                list.add("what")
                list.add("computer")
            }

            recView.layoutManager = LinearLayoutManager(context)
            recView.adapter = testAdapter

            testAdapter.initAdapter(list)
        }


    }
}