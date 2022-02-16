package com.example.corutineretorfitstudy.Utils

data class Resources<out T>(val status: Status,val data : T?,val message:String?) {
    companion object {

        fun<T> successs(data : T?): Resources<T> {
            return Resources(Status.SUCCESS,data,null)
        }

        fun<T> error(data : T?):Resources<T>{
            return Resources(Status.ERROR,data,null)
        }

        fun<T> loading(data : T?):Resources<T>{
            return Resources(Status.LOADING,data,null)
        }

    }
}