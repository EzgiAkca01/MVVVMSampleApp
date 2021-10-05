package com.ezgiakca.mvvvmsampleapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.ezgiakca.mvvvmsampleapp.data.repository.UserRepository

class AuthViewModel : ViewModel()
{
    var email:String? = null
    var password:String? = null
    var authListener:AuthListener? = null

    fun loginClicked(view: View) {
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty())
        {
            authListener?.onFailure("Failure")
            return
        }

        //to create new model for repository is a bad practice
        val loginResponse = UserRepository().userLogin(email!!,password!!)
        authListener?.onSuccess(loginResponse)

    }
}