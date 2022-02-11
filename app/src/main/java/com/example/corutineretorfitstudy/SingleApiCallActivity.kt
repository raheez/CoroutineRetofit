package com.example.corutineretorfitstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.corutineretorfitstudy.databinding.ActivityMainBinding
import com.example.corutineretorfitstudy.databinding.ActivitySingleApiCallBinding

class SingleApiCallActivity : AppCompatActivity() {

    lateinit var mBinding : ActivitySingleApiCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySingleApiCallBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding?.buttonTv?.setOnClickListener {

        }


    }
}