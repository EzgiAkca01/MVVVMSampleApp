package com.ezgiakca.mvvvmsampleapp.util
import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun Context.toast(message:String)
{
  Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show()
{
  this.visibility = View.VISIBLE
}

fun ProgressBar.hide()
{

  this.visibility = View.GONE
}

fun AppCompatActivity.hideKeyboard() {

  val view = this.currentFocus
  if (view != null)
  {
    val imm:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken,0)
  }

}