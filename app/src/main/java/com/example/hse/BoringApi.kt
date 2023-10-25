package com.example.hse

import retrofit2.Call
import retrofit2.http.GET

interface BoringApi {
    @GET("activity")
    fun getActivity(): Call<Activity>
}