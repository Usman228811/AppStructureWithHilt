package com.example.myfirstapp.ui.base

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirstapp.utils.InternetConnection
import com.example.myfirstapp.utils.MyPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    lateinit var context: Activity


    @Inject
    lateinit var pref: MyPref

    @Inject
    lateinit var internetConnection: InternetConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this
    }
}