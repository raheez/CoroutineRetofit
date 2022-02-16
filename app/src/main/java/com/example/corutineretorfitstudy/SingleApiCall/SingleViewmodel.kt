package com.example.corutineretorfitstudy.SingleApiCall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.example.corutineretorfitstudy.Data.RetrofitBuilder
import com.example.corutineretorfitstudy.Model.ApiUser
import com.example.corutineretorfitstudy.Utils.Resources
import kotlinx.coroutines.launch

class SingleViewmodel:ViewModel() {


    private val _usersList = MutableLiveData<Resources<List<ApiUser>>>()
    init {

    }

    fun fetchUsers(){

        viewModelScope?.launch {
            _usersList.postValue(Resources.loading(null))
            val mList = RetrofitBuilder.apiService.getUsers()
            _usersList.postValue(Resources.successs(mList))
        }
    }

    fun getUsers() :LiveData<Resources<List<ApiUser>>>{
        return _usersList
    }

}