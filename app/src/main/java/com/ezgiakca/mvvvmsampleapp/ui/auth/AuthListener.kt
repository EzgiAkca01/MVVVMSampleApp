package com.ezgiakca.mvvvmsampleapp.ui.auth

import androidx.lifecycle.LiveData
import okhttp3.ResponseBody

interface AuthListener {
    fun onStarted()
    fun onFailure(message:String)
    fun onSuccess(response: LiveData<String>)
    fun onProgress()
}
