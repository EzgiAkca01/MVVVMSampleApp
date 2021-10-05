package com.ezgiakca.mvvvmsampleapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ezgiakca.mvvvmsampleapp.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    fun userLogin(email:String,password:String):LiveData<String>
    {
        val loginResponse = MutableLiveData<String>()
        //This is very bad practice because our User Repository is dependent to MyApi interface tightly right now
        //Instead of creating MyApi we should inject here
        MyApi().userLogin(email,password).enqueue(object :Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.isSuccessful)
                {
                    loginResponse.value = response.body().toString()

                }else
                {
                    loginResponse.value = response.errorBody().toString()

                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                loginResponse.value = t.localizedMessage
            }

        })
        return loginResponse
    }

}