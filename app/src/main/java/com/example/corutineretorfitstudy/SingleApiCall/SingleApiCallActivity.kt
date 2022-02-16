package com.example.corutineretorfitstudy.SingleApiCall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.corutineretorfitstudy.Utils.Status
import com.example.corutineretorfitstudy.databinding.ActivityMainBinding
import com.example.corutineretorfitstudy.databinding.ActivitySingleApiCallBinding

class SingleApiCallActivity : AppCompatActivity() {

    lateinit var mBinding: ActivitySingleApiCallBinding

    val model: SingleViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySingleApiCallBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        mBinding?.buttonTv?.setOnClickListener {
            model.fetchUsers()
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
}