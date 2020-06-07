package com.ubis.pizzastore_20200607

import androidx.appcompat.app.AppCompatActivity

abstract class baseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setValurs()
    abstract fun setEvents()
}