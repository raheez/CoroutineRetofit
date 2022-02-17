package com.example.corutineretorfitstudy.Feature1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.corutineretorfitstudy.SingleApiCall.SingleViewmodel
import com.example.corutineretorfitstudy.Utils.Status
import com.example.corutineretorfitstudy.databinding.ActivityFeatureBinding
import com.example.corutineretorfitstudy.databinding.ActivityParallelApiCallBinding

class FeatureOneActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityFeatureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFeatureBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding?.buttonTv?.setOnClickListener {
            Toast.makeText(this,"feature 1",Toast.LENGTH_SHORT)
        }

    }
}