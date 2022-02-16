package com.example.corutineretorfitstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.corutineretorfitstudy.SereisApiCall.SeriesApiCallActivity
import com.example.corutineretorfitstudy.SingleApiCall.SingleApiCallActivity
import com.example.corutineretorfitstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mBinding :ActivityMainBinding
    val mRaheez = MutableLiveData<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding?.singleTv?.setOnClickListener {
            val mIntent = Intent(this, SingleApiCallActivity::class.java)
            startActivity(mIntent)

        }

        mBinding?.seriesTv?.setOnClickListener {
            val mIntent = Intent(this, SeriesApiCallActivity::class.java)
            startActivity(mIntent)

        }
    }
}