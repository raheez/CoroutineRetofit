package com.example.corutineretorfitstudy.ParallelApiCall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.corutineretorfitstudy.SingleApiCall.SingleViewmodel
import com.example.corutineretorfitstudy.Utils.Status
import com.example.corutineretorfitstudy.databinding.ActivityParallelApiCallBinding

class ParallelApiCallActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityParallelApiCallBinding

    val model: ParallelViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityParallelApiCallBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding?.buttonTv?.setOnClickListener {
            model.fetchUsers()
        }

        model.getUsers()?.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {

                    mBinding?.statusTv?.setText("loading")
                }
                Status.SUCCESS -> {
                    mBinding?.statusTv?.setText("success")
                    Log.d("coroutine_test", it.data.toString())
                }
                Status.ERROR -> {
                    mBinding?.statusTv?.setText("error")

                }
            }
        })
    }
}