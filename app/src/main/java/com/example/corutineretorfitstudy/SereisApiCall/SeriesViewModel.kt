package com.example.corutineretorfitstudy.SereisApiCall

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corutineretorfitstudy.Data.ApiService
import com.example.corutineretorfitstudy.Data.RetrofitBuilder
import com.example.corutineretorfitstudy.Model.ApiUser
import com.example.corutineretorfitstudy.Utils.Resources
import kotlinx.coroutines.launch
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class SeriesViewModel:ViewModel() {

    private val _usersList = MutableLiveData<Resources<List<ApiUser>>>()

    init {
    }

    fun fetchTwoApis(){

        viewModelScope?.launch {
            _usersList.postValue(Resources.loading(null))
            val time = measureTimeMillis {
                val a = RetrofitBuilder.apiService.getUsers()
                Log.d("result_a",""+a)

                val b = RetrofitBuilder.apiService.getMoreUsers()
                Log.d("result_b",""+b)

                val mApiResult = mutableListOf<ApiUser>()
                mApiResult.addAll(a)
                mApiResult.addAll(b)
                _usersList.postValue(Resources.successs(mApiResult))
                //_usersList.postValue(Resources.successs(b))
            }
            Log.d("total_time_is",""+time)
        }
    }

    fun getUsers():LiveData<Resources<List<ApiUser>>>{
        return _usersList
    }

}