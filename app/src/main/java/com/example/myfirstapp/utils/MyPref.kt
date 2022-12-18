package com.example.myfirstapp.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MyPref @Inject constructor(@ApplicationContext val context: Context) {

    private val pref = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)

    var test: String
        get() = pref.getString("test", "")!!
        set(value) = pref.edit().putString("test", value).apply()

}