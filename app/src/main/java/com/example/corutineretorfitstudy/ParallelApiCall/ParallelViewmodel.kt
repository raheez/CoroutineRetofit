package com.example.corutineretorfitstudy.ParallelApiCall

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corutineretorfitstudy.Data.RetrofitBuilder
import com.example.corutineretorfitstudy.Model.ApiUser
import com.example.corutineretorfitstudy.Utils.Resources
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class ParallelViewmodel : ViewModel() {

    private val _usersList = MutableLiveData<Resources<List<ApiUser>>>()

    init {

    }

    fun fetchUsers() {
        viewModelScope?.launch {
            _usersList.postValue(Resources.loading(null))

            val mTime = measureTimeMillis {

                val mUserResults = async { RetrofitBuilder.apiService.getUsers() }
                val mMoreUserResults = async { RetrofitBuilder.apiService.getMoreUsers() }
                val mList = mutableListOf<ApiUser>()
                mList.addAll(mUserResults.await())
                Log.d("result_a",""+mUserResults.await())


                mList.addAll(mMoreUserResults.await())
                Log.d("result_b",""+mMoreUserResults.await())

                _usersList.postValue(Resources.successs(mList))
            }
            Log.d("parallel_call", "_time_" + mTime)
        }
    }

    fun getUsers(): LiveData<Resources<List<ApiUser>>> {
        return _usersList
    }

}