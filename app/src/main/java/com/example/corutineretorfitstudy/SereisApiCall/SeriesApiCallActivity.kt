package com.example.corutineretorfitstudy.SereisApiCall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.corutineretorfitstudy.SingleApiCall.SingleViewmodel
import com.example.corutineretorfitstudy.Utils.Status
import com.example.corutineretorfitstudy.databinding.ActivitySeriesApiCallBinding

class SeriesApiCallActivity : AppCompatActivity() {

    lateinit var mBinding: ActivitySeriesApiCallBinding


    val model: SeriesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySeriesApiCallBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding?.buttonTv?.setOnClickListener {
          model.fetchTwoApis()
        }

        model.getUsers()?.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {

                    mBinding?.statusTv?.setText("loading")
                }
                Status.SUCCESS -> {
                    mBinding?.statusTv?.setText("success")
                    Log.d("success_result", it.data.toString())
                }
                Status.ERROR -> {
                    mBinding?.statusTv?.setText("error")

                }
            }


        })

    }
}