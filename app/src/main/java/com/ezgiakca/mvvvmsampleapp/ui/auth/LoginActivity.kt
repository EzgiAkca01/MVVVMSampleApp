package com.ezgiakca.mvvvmsampleapp.ui.auth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.ezgiakca.mvvvmsampleapp.R
import com.ezgiakca.mvvvmsampleapp.databinding.ActivityLoginBinding
import com.ezgiakca.mvvvmsampleapp.util.hide
import com.ezgiakca.mvvvmsampleapp.util.hideKeyboard
import com.ezgiakca.mvvvmsampleapp.util.show
import com.ezgiakca.mvvvmsampleapp.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel // we are going to bind our viewmodel with ui
        viewModel.authListener = this // we are going to bind activity and view model with interface
        println("This is for second commit")
        println("Change 2")
    }

    //Ara yüzde gerçekleşecek değişiklikler (logic) burada kontrol edilecektir.
    override fun onStarted() {
       // binding.progressBar.show()
        binding.progressBar.show()
        hideKeyboard()
        //binding.progressBar.visibility = View.VISIBLE
        toast("Login Started")
    }


    override fun onFailure(message: String) {
        binding.progressBar.hide()
       // binding.progressBar.visibility = View.GONE
        toast(message)
    }

    override fun onSuccess(response: LiveData<String>) {
        response.observe(this,{
            toast(it)
            binding.progressBar.hide()
        })
    }


    override fun onProgress() {
        toast("Login is progressing")
    }

}