package com.example.myfirstapp.utils

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.example.myfirstapp.R


fun showToast(context: Activity, msg: String) {

    try {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    } catch (_: java.lang.Exception) {

    }
}

fun myLog(msg: String) {

    Log.d("cvv", msg)
}

fun showToast(context: Activity, msg: Int) {

    try {
        Toast.makeText(context, context.getString(msg), Toast.LENGTH_SHORT).show()
    } catch (_: java.lang.Exception) {

    }
}