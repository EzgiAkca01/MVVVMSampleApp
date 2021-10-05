package com.ezgiakca.mvvvmsampleapp.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

   /* @FormUrlEncoded
    @POST("users")
    fun userLogin(@Field("email") email:String, @Field("password") password:String):Call<ResponseBody>*/

    @GET("users")
    fun userLogin(@Query("email") email:String, @Query("name") password:String):Call<ResponseBody>

    companion object
    {
        operator  fun invoke():MyApi
        {
            return Retrofit.
            Builder().baseUrl("https://gorest.co.in/public/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build().create(MyApi::class.java)
        }
    }

}