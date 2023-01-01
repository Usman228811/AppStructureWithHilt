package com.example.myfirstapp.ui.activities

import android.content.Intent
import android.os.Bundle
import com.example.myfirstapp.databinding.ActivityMainBinding
import com.example.myfirstapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    @Inject
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {

            btnRoomDb.setOnClickListener {
                startActivity(Intent(mContext, RoomDbTestActivity::class.java))
            }
            btnRetrofit.setOnClickListener {
                startActivity(Intent(mContext, RetrofitTestActivity::class.java))
            }
        }


    }
}